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

    @Query(value="select idmascota,nombre, anho, sexo,descripcion,raza_otros as 'raza' from mascota m\n" +
            "join raza_especie r on m.raza_especie_idraza = r.idraza\n" +
            "join cuenta c on m.cuenta_idcuenta = c.idcuenta\n" +
            "where LOWER(m.sexo) like %?1% or LOWER(r.descripcion) like %?1% " +
            "or LOWER(m.raza_otros) like %?1% or LOWER(c.correo) like %?1%",nativeQuery = true)
    List<MascotasDTO> listarMascotasSearch(String search);

    @Query(value="select * from mascota m" +
            "where m.nombre like %?1% ",nativeQuery = true)
    List<Mascota> listarMascotasxNombre(String name);



    @Query(value="SELECT * FROM mascota where cuenta_idcuenta like %?1%",nativeQuery = true)
    List<Mascota> listarMascota(int id);
}
