package org.example.Repositories;

import org.example.Entities.Carrera;
import org.example.dto.CarreraDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera,Integer> {

    @Query("SELECT new org.example.dto.CarreraDTO(c.idCarrera, c.nombreCarrera) FROM Carrera c")
    List<CarreraDTO> findAllCarreras();

    // g) Listar carreras por cantidad de inscriptos
    @Query("SELECT new org.example.dto.CarreraDTO(c.idCarrera, c.nombreCarrera) " +
            "FROM Inscripcion i " +
            "JOIN i.carrera c " +
            "GROUP BY c.idCarrera, c.nombreCarrera " +
            "ORDER BY COUNT(i) DESC")
    List<CarreraDTO> findCarrerasByCantidadInscriptos();


    // h)Generar reporte
    @Query("SELECT c.nombreCarrera, i.anioInscripcion, " +
            "COUNT(i) AS cantidadInscriptos, " +
            "SUM(CASE WHEN i.graduado = true THEN 1 ELSE 0 END) AS cantidadEgresados " +
            "FROM Inscripcion i " +
            "JOIN i.carrera c " +
            "GROUP BY c.nombreCarrera, i.anioInscripcion " +
            "ORDER BY c.nombreCarrera ASC, i.anioInscripcion ASC")
    public List<Object[]> generarReporte();

}
