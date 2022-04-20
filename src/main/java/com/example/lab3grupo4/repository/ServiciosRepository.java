package com.example.lab3grupo4.repository;

import com.example.lab3grupo4.dto.ServiciosxMascoDto;
import com.example.lab3grupo4.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ServiciosRepository extends JpaRepository<Servicio, Integer> {

    @Query(value = "select m.idmascota,m.anho, s.hora_inicio as 'horainicio', s.duracion as 'duracion', r.nombre as 'responsable',\n" +
            "s.entrega as 'entrega', m.nombre as 'nombre', o.descripcion as 'descripcion'\n" +
            "from servicio s\n" +
            "inner join opcion_servicio os on (s.idservicio = os.servicio_idservicio)\n" +
            "inner join opcion o on (os.opcion_idopcion = o.idopcion)\n" +
            "inner join mascota m on (s.mascota_idmascota = m.idmascota)\n" +
            "inner join responsable r on (s.responsable_idresponsable = r.idresponsable)\n" +
            "where s.mascota_idmascota = ?1 " +
            "order by o.descripcion asc;",nativeQuery = true)
    List<ServiciosxMascoDto> listaServiciosxMascota (Integer mascid);
}
