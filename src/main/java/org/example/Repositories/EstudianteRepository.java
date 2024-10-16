package org.example.Repositories;

import org.example.Entities.Estudiante;
import org.example.dto.EstudianteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    // c) Obtener todos los estudiantes ordenados por nombre
    @Query("SELECT new org.example.dto.EstudianteDTO(e.idEstudiante, e.nombre, e.apellido, e.edad, e.genero, e.documento, e.ciudadResidencia, e.libretaUniversitaria) FROM Estudiante e ORDER BY e.nombre ASC")
    List<EstudianteDTO> findAllByOrderByNombreAsc();

    // c) Obtener todos los estudiantes ordenados por edad
    @Query("SELECT new org.example.dto.EstudianteDTO(e.idEstudiante, e.nombre, e.apellido, e.edad, e.genero, e.documento, e.ciudadResidencia, e.libretaUniversitaria) FROM Estudiante e ORDER BY e.edad ASC")
    List<EstudianteDTO> findAllByOrderByEdadAsc();

    // d) Obtener estudiante por libreta universitaria
    @Query("SELECT new org.example.dto.EstudianteDTO(e.idEstudiante, e.nombre, e.apellido, e.edad, e.genero, e.documento, e.ciudadResidencia, e.libretaUniversitaria) FROM Estudiante e WHERE e.libretaUniversitaria = :libretaUniversitaria")
    EstudianteDTO findOneByLibretaUniversitaria(@Param("libretaUniversitaria") int libretaUniversitaria);


    // e) Obtener estudiantes por género
    @Query("SELECT new org.example.dto.EstudianteDTO(e.idEstudiante, e.nombre, e.apellido, e.edad, e.genero, e.documento, e.ciudadResidencia, e.libretaUniversitaria) FROM Estudiante e WHERE e.genero = :genero")
    List<EstudianteDTO> findByGenero(@Param("genero") String genero);


    // g) Obtener estudiantes por carrera y ciudad
    @Query("SELECT new org.example.dto.EstudianteDTO(e.idEstudiante, e.nombre, e.apellido, e.edad, e.genero, e.documento, e.ciudadResidencia, e.libretaUniversitaria) " +
            "FROM Estudiante e JOIN e.inscripciones i JOIN i.carrera c " +
            "WHERE c.nombreCarrera = :nombreCarrera AND e.ciudadResidencia = :ciudad")
    List<EstudianteDTO> findByCarreraAndCiudad(@Param("nombreCarrera") String nombreCarrera, @Param("ciudad") String ciudad);




}
