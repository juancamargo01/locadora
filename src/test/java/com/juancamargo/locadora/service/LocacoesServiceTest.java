package com.juancamargo.locadora.service;


import com.juancamargo.locadora.model.entity.Ator;
import com.juancamargo.locadora.model.entity.Cliente;
import com.juancamargo.locadora.model.entity.Endereco;
import com.juancamargo.locadora.model.entity.Filme;

import com.juancamargo.locadora.model.enumeration.Estados;
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

    private Filme filmeMock(){
        LocalDate data ;
        data = LocalDate.of(2019,10,2);

        List<Ator> atores = new ArrayList<>();
        Ator ator = new Ator(1L,"nome1",25,"personagem1");
        atores.add(ator);
        Ator ator1 = new Ator(2L,"nome2",25,"personagem2");
        atores.add(ator1);

        Filme filme = new Filme(1L, "Meu malvado favorito", data, 9.0, 8.0, true, atores);

        return filme;
    }

    private Cliente clienteMock(){
        Endereco endereco = new Endereco(1L, Estados.GO,"Goiania"," ","127","17578787");
        Cliente cliente = new Cliente(1L,"Chico Silva",25,endereco);

        return cliente;
    }


    @Test
    void verificaSefilmeEstaDisponivelTeste() {

        Filme filme =filmeMock();
        Boolean verificacaoDisponibilidade = locacoesService.verificaSefilmeEstaDisponivel(filme);
        assertEquals(true,verificacaoDisponibilidade);

    }

    @Test
    void devolvefilmeLocadoteste() {
    }

    @Test
    void locarNovoFilmeteste() {
    }

    @Test
    void verificaDatateste(Filme filme) {
    }
}