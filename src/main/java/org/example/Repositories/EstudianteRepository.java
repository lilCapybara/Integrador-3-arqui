package org.example.Repositories;

import org.example.Entities.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    // c) Obtener todos los estudiantes ordenados por nombre
    List<Estudiante> findAllByOrderByNombreAsc();

    // c) Obtener todos los estudiantes ordenados por edad
    List<Estudiante> findAllByOrderByEdadAsc();

    // d) Obtener estudiante por libreta universitaria
    Estudiante findByLibretaUniversitaria(int libretaUniversitaria);

    // e) Obtener estudiantes por género
    List<Estudiante> findByGenero(String genero);
}
