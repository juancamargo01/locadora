package com.juancamargo.locadora.service;

import com.juancamargo.locadora.model.entity.Cliente;
import com.juancamargo.locadora.model.entity.Filmes;
import com.juancamargo.locadora.repository.ClienteRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import javax.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteService {

    @Autowired
    ClienteRepositoty clienteRepositoty;

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

    public ResponseEntity<String> salvarFilmes(@Valid Cliente filme){
        clienteRepositoty.save(filme);
        return ResponseEntity.ok("Cliente cadastrado com sucesso =>\" + cliente.toString()");
    }

    public ResponseEntity<String> DeleteFilmePeloId(Long id){
        clienteRepositoty.deleteById(id);
        return ResponseEntity.ok("Cliente deletado com sucesso");
    }

    public ResponseEntity<Filmes> buscarFilmePeloId(Long id){
        clienteRepositoty.findAllById(id);

        return ResponseEntity.ok();
    }

    public ResponseEntity<String> buscarTodosFilmes(List<Cliente> filme){

        return null;
    }

}
