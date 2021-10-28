package com.juancamargo.locadora.dto;

import com.juancamargo.locadora.model.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;

    @Size(min = 2, max = 255, message = "Deve conter entre 2 e 255 caracteres")
    @NotBlank(message = "Este Campo nao pode ser vazio")
    private String nomeCompleto;

    @NotNull(message = "Não pode ser nulo")
    private Integer idade;

    private Endereco endereco;


}
