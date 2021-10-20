package com.juancamargo.locadora.controller;

import com.juancamargo.locadora.model.entity.Cliente;
import com.juancamargo.locadora.model.entity.Filmes;
import com.juancamargo.repository.ClienteRepositoty;
import com.juancamargo.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepositoty clienteRepositoty;




    @GetMapping
    public List<Cliente> buscaTodosClientes(){

        return  clienteRepositoty.findAll();
    }

    @GetMapping(path = {"/id"})
    public Cliente buscaClientePorId(@PathVariable Long id){

        return  clienteRepositoty.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionarcliente(@RequestBody Cliente cliente){

        return clienteRepositoty.save(cliente);
    }

    @DeleteMapping(path = "/{id}")
    public String excluirClientePorId(@PathVariable Long id){

        Optional<Cliente> filme = clienteRepositoty.findById(id);
        clienteRepositoty.deleteById(id);
        String mensagem = "Cliente"+ filme.get().getNomeCompleto() + "deletado com sucesso";

        return mensagem ;
    }

}
