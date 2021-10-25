package com.juancamargo.locadora.repository;

import com.juancamargo.locadora.model.entity.Ator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtoreRepository extends JpaRepository<Ator, Long> {
}
