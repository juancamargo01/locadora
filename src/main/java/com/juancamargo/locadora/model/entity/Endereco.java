package com.juancamargo.locadora.model.entity;

import com.juancamargo.locadora.model.enumeration.Estados;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TBL_ENDERECO")
@Data
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENDERECO")
    private  Long id ;

    @Column(name = "ESTADO_ENDERECO")
    private Estados estado;

    @Column(name = "CIDADE_ENDERECO")
    private String cidade;

    @Column(name = "COMPLEMENTO_ENDERECO")
    private String complemento;

    @Column(name = "NUMERO_ENDERECO")
    private Integer numero;

    @Column(name = "CEP_ENDERECO")
    private String cep;
}
