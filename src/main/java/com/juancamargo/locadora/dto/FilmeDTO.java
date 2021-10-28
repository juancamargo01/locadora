package com.juancamargo.locadora.dto;

import com.juancamargo.locadora.model.entity.Ator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDTO {


    private Long id;

    @NotBlank(message = "Este Campo nao pode ser vazio")
    @Size(min = 2, max = 255, message = "Deve conter entre 2 e 255 caracteres")
    private String nomeDoFilme;

    private LocalDate dataLancamento;

    private Double notaDosUsuarios;

    private Double notaDaCritica;

    private Boolean estaLocado;

    private List<Ator> ator;

}
