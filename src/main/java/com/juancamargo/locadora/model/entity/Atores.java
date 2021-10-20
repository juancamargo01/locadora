package com.juancamargo.locadora.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_ATORES")
@Data
public class Atores implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ATOR")
    private  Long id ;

    @Column(name = "NOME_ATOR",length = 255, nullable = false)
    private String nomeAtor;

    @Column(name = "ATOR_IDADE")
    private Integer idade;

    @Column(name = "NOME_PERSONAGEM",length = 255)
    private String nomeDoPersonagem;
}
