package com.juancamargo.locadora.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_CLIENTE")
@Data
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private  Long id ;

    @Column(name = "NOME_COMPLETO_CLIENTE", length = 255, nullable = false)
    private String nomeCompleto;

    @Column(name = "IDADE_CLIENTE")
    private Integer idade;

    @Column(name="ENDERECO_CLIENTE")
    private Endereco endereco;
}
