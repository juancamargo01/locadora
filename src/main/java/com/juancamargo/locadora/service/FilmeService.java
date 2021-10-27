package com.juancamargo.locadora.service;

import com.juancamargo.locadora.dto.ClienteDTO;
import com.juancamargo.locadora.dto.FilmeDTO;
import com.juancamargo.locadora.model.entity.Cliente;
import com.juancamargo.locadora.model.entity.Filme;
import com.juancamargo.locadora.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    FilmesRepository filmesRepository;

    public List<Filme> buscarTodosFilmes() {
        return filmesRepository.findAll();
    }


    public FilmeDTO salvarFilme(FilmeDTO filmeDTO) {

        Filme filme = filmesRepository.save(montaFilme(filmeDTO));

        return new FilmeDTO(filme.getId(),
                        filme.getNomeDoFilme(),
                        filme.getDataLancamento(),
                        filme.getNotaDosUsuarios(),
                        filme.getNotaDaCritica(),
                        filme.getEstaLocado(),
                        filme.getAtor());
    }

    public FilmeDTO atualizarFilme(FilmeDTO filmeDTO, Long id) {
        Filme novoFilme = buscarFilmePeloId(id);
        novoFilme.setNomeDoFilme(filmeDTO.getNomeDoFilme());
        novoFilme.setDataLancamento(filmeDTO.getDataLancamento());
        novoFilme.setNotaDosUsuarios(filmeDTO.getNotaDosUsuarios());
        novoFilme.setNotaDaCritica(filmeDTO.getNotaDaCritica());
        novoFilme.setEstaLocado(filmeDTO.getEstaLocado());
        novoFilme.setAtor(filmeDTO.getAtor());

        Filme filme= filmesRepository.save(novoFilme);

        return new FilmeDTO(novoFilme.getId(),
                novoFilme.getNomeDoFilme(),
                novoFilme.getDataLancamento(),
                novoFilme.getNotaDosUsuarios(),
                novoFilme.getNotaDaCritica(),
                novoFilme.getEstaLocado(),
                novoFilme.getAtor());
    }

    public Boolean deletarFilmePeloId(Long id) {
        try {
            if( buscarFilmePeloId(id) != null) {
                filmesRepository.deleteById(id);
                return true;
            }
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return false;
        }
        return null;
    }

    public Filme buscarFilmePeloId(Long id) {
        Optional<Filme> filme = filmesRepository.findById(id);

        if (filme.isPresent()) {
            return filmesRepository.findById(id).get();
        }
        return null;

    }

    public List<Filme> buscarTodosFilmes(List<Filme> filme) {
        return filmesRepository.findAll();
    }

    public FilmeDTO atualizarfilme (FilmeDTO filmeDTO){
        return salvarFilme(filmeDTO);

    }

    private Filme montaFilme(FilmeDTO filmeDTO){

        return new Filme(filmeDTO.getId(),
                        filmeDTO.getNomeDoFilme(),
                        filmeDTO.getDataLancamento(),
                        filmeDTO.getNotaDosUsuarios(),
                        filmeDTO.getNotaDaCritica(),
                        filmeDTO.getEstaLocado(),
                        filmeDTO.getAtor());
    }


}
