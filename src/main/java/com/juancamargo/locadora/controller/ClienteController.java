package com.juancamargo.locadora.controller;

import com.juancamargo.locadora.model.entity.Cliente;
import com.juancamargo.locadora.repository.ClienteRepositoty;
import com.juancamargo.locadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> buscaTodosClientes(){
    }

    @GetMapping(path = {"/id"})
    public Cliente buscaClientePorId(@PathVariable Long id){

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> adicionarcliente (@RequestBody  @Valid Cliente cliente){

    }

    @DeleteMapping(path = "/{id}")
    public String excluirClientePorId(@PathVariable Long id){

    }

}
