package com.example.lab3grupo4.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lab3grupo4.entity.Responsable;

import java.util.List;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable,Integer> {
}
