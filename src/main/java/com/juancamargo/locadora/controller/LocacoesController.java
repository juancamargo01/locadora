package com.juancamargo.locadora.controller;

import com.juancamargo.locadora.dto.LocacaoDTO;
import com.juancamargo.locadora.model.entity.Locacoes;
import com.juancamargo.locadora.service.LocacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/locacoes")
public class LocacoesController {

    @Autowired
    private LocacoesService locacoesService;

    @GetMapping
    public List<Locacoes> buscaTodosLocacoes(){

        return  locacoesService.buscarTodosLocacoes();
    }

    @GetMapping(path = {"/id"})
    public Locacoes buscalocacaoPorId(@PathVariable Long id){

        return  locacoesService.buscarLocacaoPeloId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> adicionarLocacao(@RequestBody LocacaoDTO locacaoDTO){

        locacoesService.salvarLocacao(locacaoDTO);
        return ResponseEntity.ok("Filme cadastrado com sucesso =>" + locacaoDTO.toString());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<String> atualizarLocacao( @PathVariable Long id ,@RequestBody @Valid LocacaoDTO locacaoDTO){
        locacoesService.atualizarLocacao(locacaoDTO,id);
        return ResponseEntity.ok("Cliente Atualizado");

    }

    @DeleteMapping(path = "/{id}")
    public String excluirLocacaoPorId(@PathVariable Long id){

        Locacoes locacao = locacoesService.buscarLocacaoPeloId(id);
        locacoesService.DeleteLocacaoPeloId(id);
        String mensage = "filme"+ locacao + "deletado com sucesso";

        return mensage ;
    }
}
