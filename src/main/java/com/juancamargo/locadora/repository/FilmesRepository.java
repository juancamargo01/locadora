package com.juancamargo.locadora.repository;

import com.juancamargo.locadora.model.entity.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FilmesRepository extends JpaRepository<Filmes,Long> {
}
