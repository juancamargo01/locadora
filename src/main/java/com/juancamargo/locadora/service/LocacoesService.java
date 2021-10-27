package com.juancamargo.locadora.service;

import com.juancamargo.locadora.dto.LocacaoDTO;
import com.juancamargo.locadora.model.entity.Filme;
import com.juancamargo.locadora.model.entity.Locacoes;
import com.juancamargo.locadora.repository.FilmesRepository;
import com.juancamargo.locadora.repository.LocacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LocacoesService {

    @Autowired
    LocacoesRepository locacoesRepository;

    FilmesRepository filmesRepository;



    public LocacaoDTO salvarLocacao(LocacaoDTO locacaoDTO){
        Locacoes locacoes =locacoesRepository.save(montaLocacao(locacaoDTO));
        locacoesRepository.save(locacoes);
        return new LocacaoDTO(locacoes.getId(),
                            locacoes.getCliente(),
                            locacoes.getFilme(),
                            locacoes.getDataInicioLocacao(),
                            locacoes.getDataEntregaLocacao(),
                            locacoes.getValorLocacaoDiaria(),
                            locacoes.getValorLocacaoTotal());
    }

    public Boolean DeleteLocacaoPeloId(Long id){
        try {
            if(buscarLocacaoPeloId(id) != null) {
                locacoesRepository.deleteById(id);
                return true;
            }
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return false;
        }
        return null;
    }

    public Locacoes buscarLocacaoPeloId(Long id){
        Optional<Locacoes> locacao = locacoesRepository.findById(id);

        if (locacao.isPresent()) {
            return locacoesRepository.findById(id).get();
        }
        return null;
    }

    public List<Locacoes> buscarTodosLocacoes(){

        if(locacoesRepository != null){
           return  locacoesRepository.findAll();

        }
        return null;
    }


    public Boolean verificaSefilmeEstaDisponivel(Filme filme){

     return filme.getEstaLocado();
    }

    private Locacoes montaLocacao(LocacaoDTO locacaoDTO){

        return new Locacoes(locacaoDTO.getId(),
                locacaoDTO.getCliente(),
                locacaoDTO.getFilme(),
                locacaoDTO.getDataInicioLocacao(),
                locacaoDTO.getDataEntregaLocacao(),
                locacaoDTO.getValorLocacaoDiaria(),
                locacaoDTO.getValorLocacaoTotal());
    }

    public LocacaoDTO atualizarLocacao(LocacaoDTO locacaoDTO, Long id) {
        Locacoes novaLocacao = buscarLocacaoPeloId(id);
        novaLocacao.setCliente(locacaoDTO.getCliente());
        novaLocacao.setFilme(locacaoDTO.getFilme());
        novaLocacao.setDataInicioLocacao(locacaoDTO.getDataInicioLocacao());
        novaLocacao.setDataEntregaLocacao(locacaoDTO.getDataEntregaLocacao());
        novaLocacao.setValorLocacaoTotal(locacaoDTO.getValorLocacaoTotal());

        Locacoes locacoes= locacoesRepository.save(novaLocacao);

        return new LocacaoDTO(novaLocacao.getId(),
                novaLocacao.getCliente(),
                novaLocacao.getFilme(),
                novaLocacao.getDataInicioLocacao(),
                novaLocacao.getDataEntregaLocacao(),
                novaLocacao.getValorLocacaoDiaria(),
                novaLocacao.getValorLocacaoTotal());
    }



    public Boolean devolvefilmeLocado(Locacoes locacoes, Long idFilme){
        if(locacoesRepository.getById(locacoes.getId()).getFilme().isEmpty()){
            return false;
        }

        locacoesRepository.getById(locacoes.getId()).getFilme().remove(idFilme);

        return true;
    }

    public Boolean locarNovoFilme(Locacoes locacoes, Filme idFilme){
        if(verificaSefilmeEstaDisponivel(idFilme)){
            locacoesRepository.getById(locacoes.getId()).getFilme().add(idFilme);
            return true;
        }
        return false;
    }



    public String verificaData(Locacoes locacoes){
        String message = "Data Valida";
        if(locacoes.getDataInicioLocacao().isBefore(locacoes.getDataEntregaLocacao())) {
             message = "A Data de entrega nao pode ser menor q data de locação";

        }else if (locacoes.getDataInicioLocacao().isAfter(LocalDate.now())) {
             message = "A Data de locação nao pode ser menor que a data atual";
        }

        return message;

    }



}
