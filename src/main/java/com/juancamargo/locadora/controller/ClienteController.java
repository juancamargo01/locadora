package com.juancamargo.locadora.controller;

import com.juancamargo.locadora.dto.ClienteDTO;
import com.juancamargo.locadora.model.entity.Cliente;
import com.juancamargo.locadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> buscaTodosClientes(){
        return clienteService.buscarTodosCliente();
    }

    @GetMapping(path = {"/id"})
    public Cliente buscaClientePorId(@PathVariable Long id){
       return clienteService.buscarClientePeloId(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> adicionarcliente (@RequestBody ClienteDTO cliente){
        clienteService.salvarCliente(cliente);
        return ResponseEntity.ok("Cliente Cadastrado");

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> excluirClientePorId(@PathVariable Long id){

           return clienteService.deletarClientePeloId(id) ?
                   ResponseEntity.ok("Cliente deletado com Sucesso") :
                   ResponseEntity.ok("Erro nao pode ser deletado");
    }

}
