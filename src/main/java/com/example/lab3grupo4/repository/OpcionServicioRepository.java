package com.example.lab3grupo4.repository;

import com.example.lab3grupo4.entity.OpcionServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpcionServicioRepository extends JpaRepository<OpcionServicio, Integer> {
}
