package com.example.lab3grupo4.repository;

import com.example.lab3grupo4.entity.RazaEspecie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RazaRepository extends JpaRepository<RazaEspecie, Integer> {
}
