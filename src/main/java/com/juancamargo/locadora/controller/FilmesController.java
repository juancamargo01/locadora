package com.juancamargo.locadora.controller;

import com.juancamargo.locadora.dto.ClienteDTO;
import com.juancamargo.locadora.dto.FilmeDTO;
import com.juancamargo.locadora.model.entity.Filme;

import com.juancamargo.locadora.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/filme")
public class FilmesController {

    @Autowired
    private FilmeService filmeService;


    @GetMapping
    public List<Filme> buscaTodosFilmes(){

        return  filmeService.buscarTodosFilmes();
    }

    @GetMapping(path = {"/id"})
    public Filme buscaFilmePorId(@PathVariable Long id){

        return  filmeService.buscarFilmePeloId(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> adicionarFilmes(@RequestBody FilmeDTO filmeDTO){

         filmeService.salvarFilme(filmeDTO);

        return ResponseEntity.ok("Filme cadastrado com sucesso =>" + filmeDTO.toString());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> atualizarFilme ( @PathVariable Long id ,@RequestBody @Valid FilmeDTO filmeDTO){
        filmeService.atualizarFilme(filmeDTO,id);
        return ResponseEntity.ok("Cliente Atualizado");

    }

    @DeleteMapping(path = "/{id}")
    public String excluirFilmePorId(@PathVariable Long id){

        Filme filme = filmeService.buscarFilmePeloId(id);
        filmeService.deletarFilmePeloId(id);
        String mensage = "filme"+ filme.getNomeDoFilme() + "deletado com sucesso";

        return mensage ;
    }
}
