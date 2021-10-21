package com.juancamargo.locadora.service;

import com.juancamargo.locadora.model.entity.Filme;
import com.juancamargo.locadora.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;

import java.util.List;

public class FilmeService {

    @Autowired
    FilmesRepository filmesRepository;



    public ResponseEntity<String> salvarFilmes( Filme filme){
        filmesRepository.save(filme);
        return ResponseEntity.ok("Cliente cadastrado com sucesso =>\" + cliente.toString()");
    }

    public ResponseEntity<String> DeleteFilmePeloId(@Valid Long id){
        filmesRepository.deleteById(id);
        return ResponseEntity.ok("Cliente deletado com sucesso");
    }

    public ResponseEntity<Filme> buscarFilmePeloId(Long id){
        filmesRepository.findAllById(id);

        return ResponseEntity.;
    }

    public ResponseEntity<String> buscarTodosFilmes(List<Filme> filme){

        return null;
    }
}
