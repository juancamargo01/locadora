package com.juancamargo.locadora.service;

import com.juancamargo.locadora.model.entity.Filmes;
import com.juancamargo.locadora.repository.FilmesRepository;
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

public class FilmeService {

    @Autowired
    FilmesRepository filmesRepository;

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

    public ResponseEntity<String> salvarFilmes( Filmes filme){
        filmesRepository.save(filme);
        return ResponseEntity.ok("Cliente cadastrado com sucesso =>\" + cliente.toString()");
    }

    public ResponseEntity<String> DeleteFilmePeloId(@Valid Long id){
        filmesRepository.deleteById(id);
        return ResponseEntity.ok("Cliente deletado com sucesso");
    }

    public ResponseEntity<Filmes> buscarFilmePeloId(Long id){
        filmesRepository.findAllById(id);

        return ResponseEntity.;
    }

    public ResponseEntity<String> buscarTodosFilmes(List<Filmes> filme){

        return null;
    }
}
