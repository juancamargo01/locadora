package com.juancamargo.locadora.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "TBL_CLIENTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private  Long id ;

    @Size(min = 2, max = 255, message = "Deve conter entre 2 e 255 caracteres")
    @Column(name = "NOME_COMPLETO_CLIENTE", length = 255)
    @NotBlank(message = "Este Campo nao pode ser vazio")
    private String nomeCompleto;

    @NotNull(message = "Não pode ser nulo")
    @Column(name = "IDADE_CLIENTE")
    private Integer idade;


    @OneToOne
    @JoinColumn(name = "ENDERECO_CLIENTE")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private Endereco endereco;
}
