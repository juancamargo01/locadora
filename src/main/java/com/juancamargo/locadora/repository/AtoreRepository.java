package com.juancamargo.locadora.repository;

import com.juancamargo.locadora.model.entity.Atores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtoreRepository extends JpaRepository<Atores, Long> {
}
