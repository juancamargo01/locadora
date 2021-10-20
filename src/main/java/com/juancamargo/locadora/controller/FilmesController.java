package com.juancamargo.locadora.controller;

import com.juancamargo.locadora.model.entity.Filmes;
import com.juancamargo.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atores")
public class FilmesController {

    @Autowired
    private FilmesRepository filmesRepository;


    @GetMapping
    public List<Filmes> buscaTodosFilmes(){

        return  filmesRepository.findAll();
    }

    @GetMapping(path = {"/id"})
    public Filmes buscaFilmePorId(@PathVariable Long id){

        return  filmesRepository.getById(id);
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Filmes adicionarFilmes(@RequestBody Filmes filme){

        return filmesRepository.save(filme);
    }

    @DeleteMapping(path = "/{id}")
    public String excluirFilmePorId(@PathVariable Long id){

        Optional<Filmes> filme = filmesRepository.findById(id);
        filmesRepository.deleteById(id);
        String mensage = "filme"+ filme.get().getNomeDoFilme() + "deletado com sucesso";

        return mensage ;
    }
}