package com.juancamargo.locadora.dto;

import com.juancamargo.locadora.model.entity.Ator;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class FilmeDTO {


    private Long id;

    private String nomeDoFilme;

    private LocalDate dataLancamento;

    private Double notaDosUsuarios;

    private Double notaDaCritica;

    private Boolean estaLocado;

    private List<Ator> ator;

}
