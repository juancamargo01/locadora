package com.juancamargo.locadora.service;

import com.juancamargo.locadora.model.entity.Filmes;
import com.juancamargo.locadora.model.entity.Locacoes;
import com.juancamargo.locadora.repository.ClienteRepositoty;
import com.juancamargo.locadora.repository.FilmesRepository;
import com.juancamargo.locadora.repository.LocacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LocacoesService {

    @Autowired
    LocacoesRepository locacoesRepository;

    @Autowired
    FilmesRepository filmesRepository;

    @Autowired
    ClienteRepositoty clienteRepositoty;



    public Boolean verificaSefilmeEstaDisponivel(Filmes filme){

        return filme.getEstaLocado();
    }


    //TODO implementar a devolução de um filme
    /*public Locacoes locacoes devolvefilmeLocado(Locacoes locacoes, Long idFilme){
        locacoes.getFilme(List<Filmes>filme);

        return locacoesRepository;
    }*/

    //TODO implementar se o cliente tem  filmes locados
   /* public Locacoes verificaseClienteTemFilmes(Locacoes locacoes){
        Long id = locacoes.getId();
        return locacoesRepository.deleteById(id);
    }*/

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
