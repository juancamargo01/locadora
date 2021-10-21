package com.juancamargo.locadora.repository;

import com.juancamargo.locadora.model.entity.Locacoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocacoesRepository extends JpaRepository<Locacoes,Long> {
}
