package com.juancamargo.locadora.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "Campo nao informado")
    @Size(min = 2, max = 255, message = "Deve conter entre 2 e 255 caracteres")
    @Column(name = "NOME_ATOR")
    private String nomeAtor;

    @NotNull(message = "Não pode ser nulo")
    @Column(name = "ATOR_IDADE")
    private Integer idade;

    @NotBlank(message = "Campo nao informado")
    @Size(min = 2, max = 255, message = "Deve conter entre 2 e 255 caracteres")
    @Column(name = "NOME_PERSONAGEM",length = 255)
    private String nomeDoPersonagem;
}
