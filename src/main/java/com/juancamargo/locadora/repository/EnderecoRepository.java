package com.juancamargo.locadora.repository;

import com.juancamargo.locadora.model.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
