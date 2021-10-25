package com.juancamargo.locadora.dto;

import com.juancamargo.locadora.model.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;

    private String nomeCompleto;

    private Integer idade;

    private Endereco endereco;
}
