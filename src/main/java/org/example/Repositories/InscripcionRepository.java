package org.example.Repositories;

import org.example.Entities.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {
    List<Inscripcion> findByEstudianteIdEstudiante(Integer idEstudiante);

    List<Inscripcion> findByCarreraIdCarrera(Integer idCarrera);
}

