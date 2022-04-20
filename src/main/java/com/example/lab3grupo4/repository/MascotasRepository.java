package com.example.lab3grupo4.repository;

import com.example.lab3grupo4.dto.MascotasDTO;
import com.example.lab3grupo4.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotasRepository extends JpaRepository<Mascota,Integer>{
    @Query(nativeQuery = true, value = "SELECT idmascota,nombre, anho, sexo,descripcion,raza_otros as 'raza' FROM mascota m INNER JOIN raza_especie r ON r.idraza = m.raza_especie_idraza")
    List<MascotasDTO> mascotasConRaza();
}
