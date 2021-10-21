package com.juancamargo.locadora.model.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TBL_LOCACOES")
@Data
public class Locacoes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LOCACOES")
    private  Long id ;

    @OneToOne
    @JoinColumn(name = "CLIENTE_LOCACOES")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Cliente cliente;


    @OneToMany
    @JoinColumn(name = "FILME_LOCACOES")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private List<Filmes> filme;

    @Column(name = "DATA_INICIO_LOCACOES")
    private LocalDate dataInicioLocacao;

    @Column(name = "DATA_ENTREGA_LOCACOES")
    private LocalDate dataEntregaLocacao;

    @Column(name = "VALOR_DIARIA_LOCACOES")
    private BigDecimal valorLocacaoDiaria;

    @Column(name = "VALOR_TOTAL_LOCACOES")
    private BigDecimal valorLocacaoTotal;
}
