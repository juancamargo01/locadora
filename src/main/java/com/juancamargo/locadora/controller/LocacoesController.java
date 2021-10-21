package com.juancamargo.locadora.controller;

import com.juancamargo.locadora.model.entity.Locacoes;
import com.juancamargo.locadora.repository.LocacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locacoes")
public class LocacoesController {

    @Autowired
    private LocacoesRepository locacoesRepository;

    @GetMapping
    public List<Locacoes> buscaTodosLocacoes(){

        return  locacoesRepository.findAll();
    }

    @GetMapping(path = {"/id"})
    public Locacoes buscalocacaoPorId(@PathVariable Long id){

        return  locacoesRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> adicionarLocacao(@RequestBody Locacoes locacao){

         locacoesRepository.save(locacao);
        return ResponseEntity.ok("Filme cadastrado com sucesso =>" + locacao.toString());
    }

    @DeleteMapping(path = "/{id}")
    public String excluirLocacaoPorId(@PathVariable Long id){

        Optional<Locacoes> locacao = locacoesRepository.findById(id);
        locacoesRepository.deleteById(id);
        String mensage = "filme"+ locacao + "deletado com sucesso";

        return mensage ;
    }
}
