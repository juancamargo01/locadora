package com.juancamargo.locadora.repository;

import com.juancamargo.locadora.model.entity.Atores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtoreRepository extends JpaRepository<Atores, Long> {
}
