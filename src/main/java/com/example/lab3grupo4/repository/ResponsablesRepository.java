package com.example.lab3grupo4.repository;

import com.example.lab3grupo4.entity.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsablesRepository extends JpaRepository <Responsable, Integer> {
}
