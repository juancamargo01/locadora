package com.juancamargo.locadora.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TBL_LOCACOES")
@Data
public class Locacoes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LOCACOES")
    private  Long id ;

    private Cliente cliente;

    private Filmes filme;

    private LocalDate dataInicioLocacao;

    private LocalDate dataEntregaLocacao;

    private BigDecimal valorLocacaoDiaria;

    private BigDecimal valorLocacaoTotal;
}
