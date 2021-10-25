package com.juancamargo.locadora.service;


import com.juancamargo.locadora.model.entity.Ator;
import com.juancamargo.locadora.model.entity.Filme;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocacoesServiceTest {

    @Autowired
    FilmeService filmeService;

    @Autowired
    LocacoesService locacoesService;

    @Test
    void verificaSefilmeEstaDisponivelTeste() {

        LocalDate data ;
        data = LocalDate.of(2019,10,2);

        List<Ator> atores = new ArrayList<>();
        Ator ator = new Ator(1L,"nome1",25,"personagem1");
        atores.add(ator);
        Ator ator1 = new Ator(2L,"nome2",25,"personagem2");
        atores.add(ator1);


        Filme filme = new Filme(1L, "Meu malvado favorito", data, 9.0, 8.0, true, atores);

        Boolean verificacaoDisponibilidade = locacoesService.verificaSefilmeEstaDisponivel(filme);

        assertEquals(true,verificacaoDisponibilidade);

    }

    @Test
    void devolvefilmeLocado() {
    }

    @Test
    void locarNovoFilme() {
    }

    @Test
    void verificaData(Filme filme) {
    }
}