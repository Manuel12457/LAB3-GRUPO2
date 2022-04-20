package com.example.lab3grupo4.repository;

import com.example.lab3grupo4.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiciosRepository extends JpaRepository<Servicio, Integer> {
}
