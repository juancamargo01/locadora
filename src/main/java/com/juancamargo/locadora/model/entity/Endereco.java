package com.juancamargo.locadora.model.entity;

import com.juancamargo.locadora.model.enumeration.Estados;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "TBL_ENDERECO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENDERECO")
    private  Long id ;


    @Column(name = "ESTADO_ENDERECO")
    @Enumerated(EnumType.STRING)
    private Estados estado;

    @Column(name = "CIDADE_ENDERECO")
    @NotBlank(message = "Este Campo nao pode ser vazio")
    private String cidade;

    @Column(name = "COMPLEMENTO_ENDERECO")
    @NotBlank(message = "Este Campo nao pode ser vazio")
    @Size(min = 2, max = 255, message = "Deve conter entre 2 e 255 caracteres")
    private String complemento;

    @Column(name = "NUMERO_ENDERECO")
    @NotBlank(message = "Este Campo nao pode ser vazio")
    private String numero;

    @Column(name = "CEP_ENDERECO")
    @NotBlank(message = "Este Campo nao pode ser vazio")
    private String cep;
}
