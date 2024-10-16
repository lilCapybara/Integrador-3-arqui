package org.example.Repositories;

import org.example.Entities.Inscripcion;
import org.example.dto.InscripcionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {
    @Query("SELECT new org.example.dto.InscripcionDTO(i.idInscripcion, e.nombre, e.apellido, c.nombreCarrera, i.antiguedad, i.anioInscripcion, i.graduado) " +
            "FROM Inscripcion i " +
            "JOIN i.estudiante e " +
            "JOIN i.carrera c " +
            "WHERE e.idEstudiante = :idEstudiante")
    List<InscripcionDTO> findInscripcionesByEstudianteId(@Param("idEstudiante") Integer idEstudiante);


}

