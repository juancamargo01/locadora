package com.juancamargo.locadora.service;

import com.juancamargo.locadora.model.entity.Filmes;
import com.juancamargo.locadora.model.entity.Locacoes;
import com.juancamargo.locadora.repository.ClienteRepositoty;
import com.juancamargo.locadora.repository.FilmesRepository;
import com.juancamargo.locadora.repository.LocacoesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LocacoesService {

    @Autowired
    LocacoesRepository locacoesRepository;

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

    public ResponseEntity<String> salvarFilmes(Locacoes locacoes){
        locacoesRepository.save(locacoes);
        return ResponseEntity.ok("Cliente cadastrado com sucesso =>\" + cliente.toString()");
    }

    public ResponseEntity<String> DeleteFilmePeloId(Long id){
        locacoesRepository.deleteById(id);
        return ResponseEntity.ok("Cliente deletado com sucesso");
    }

    public ResponseEntity<Filmes> buscarFilmePeloId(Long id){
        locacoesRepository.findAllById(id);

        return ResponseEntity.;
    }

    public ResponseEntity<String> buscarTodosFilmes(List<Locacoes> locacoes){

        return null;
    }





    public Boolean verificaSefilmeEstaDisponivel(Filmes filme){

        return filme.getEstaLocado();
    }


    //TODO implementar a devolução de um filme
    /*public Locacoes locacoes devolvefilmeLocado(Locacoes locacoes, Long idFilme){
        locacoes.getFilme(List<Filmes>filme);

        return locacoesRepository;
    }*/

    //TODO implementar se o cliente tem  filmes locados
   /* public Locacoes verificaseClienteTemFilmes(Locacoes locacoes){
        Long id = locacoes.getId();
        return locacoesRepository.deleteById(id);
    }*/

    public String verificaData(Locacoes locacoes){
        String message = "Data Valida";
        if(locacoes.getDataInicioLocacao().isBefore(locacoes.getDataEntregaLocacao())) {
             message = "A Data de entrega nao pode ser menor q data de locação";

        }else if (locacoes.getDataInicioLocacao().isAfter(LocalDate.now())) {
             message = "A Data de locação nao pode ser menor que a data atual";
        }

        return message;

    }



}
