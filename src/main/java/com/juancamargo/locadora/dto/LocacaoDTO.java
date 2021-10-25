package com.juancamargo.locadora.dto;

import com.juancamargo.locadora.model.entity.Cliente;
import com.juancamargo.locadora.model.entity.Filme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocacaoDTO {

    private  Long id ;

    private Cliente cliente;

    private List<Filme> filme;

    private LocalDate dataInicioLocacao;

    private LocalDate dataEntregaLocacao;

    private BigDecimal valorLocacaoDiaria;

    private BigDecimal valorLocacaoTotal;
}
