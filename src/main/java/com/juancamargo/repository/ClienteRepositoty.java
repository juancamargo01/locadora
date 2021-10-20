package com.juancamargo.repository;

import com.juancamargo.locadora.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositoty extends JpaRepository<Cliente,Long> {
}
