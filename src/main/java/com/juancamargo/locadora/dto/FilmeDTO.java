package com.juancamargo.locadora.dto;

import com.juancamargo.locadora.model.entity.Atores;
import org.hibernate.annotations.Cascade;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

public class FilmeDTO {



    private String nomeDoFilme;


    private LocalDate dataLancamento;


    private Double notaDosUsuarios;


    private Double notaDaCritica;

  
    private Boolean estaLocado;


    @Column(name = "ATORES")
    @OneToMany
    @JoinColumn(name = "TBL_FILME")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private List<Atores> ator;
}
