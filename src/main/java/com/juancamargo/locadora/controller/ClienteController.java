package com.juancamargo.locadora.controller;

import com.juancamargo.locadora.model.entity.Cliente;
import com.juancamargo.locadora.repository.ClienteRepositoty;
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



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    @Autowired
    private ClienteRepositoty clienteRepositoty;




    @GetMapping
    public List<Cliente> buscaTodosClientes(){

        return  clienteRepositoty.findAll();
    }

    @GetMapping(path = {"/id"})
    public Cliente buscaClientePorId(@PathVariable Long id){

        return clienteRepositoty.getById(id) ;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> adicionarcliente (@RequestBody  @Valid Cliente cliente){
        clienteRepositoty.save(cliente);
        return ResponseEntity.ok("Cliente cadastrado com sucesso =>" + cliente.toString());
    }

    @DeleteMapping(path = "/{id}")
    public String excluirClientePorId(@PathVariable Long id){

        Optional<Cliente> filme = clienteRepositoty.findById(id);
        clienteRepositoty.deleteById(id);
        String mensagem = "Cliente"+ filme.get().getNomeCompleto() + "deletado com sucesso";

        return mensagem ;
    }

}
