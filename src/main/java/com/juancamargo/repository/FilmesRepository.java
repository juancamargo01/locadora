package com.juancamargo.repository;

import com.juancamargo.locadora.model.entity.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmesRepository extends JpaRepository<Filmes,Long> {
}
