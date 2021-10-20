package com.juancamargo.repository;

import com.juancamargo.locadora.model.entity.Locacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacoesRepository extends JpaRepository<Locacoes,Long> {
}
