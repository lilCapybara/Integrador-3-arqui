package org.example.Repositories;

import org.example.Entities.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera,Integer> {

    // g) Listar carreras por cantidad de inscriptos
    @Query("SELECT c.nombreCarrera, COUNT(i) AS inscriptos " +
            "FROM Inscripcion i " +
            "JOIN i.carrera c " +
            "GROUP BY c.nombreCarrera " +
            "ORDER BY COUNT(i) DESC")
    public List<Carrera> findCarrerasByCantidadInscriptos();

    // h)Generar reporte
    @Query( "SELECT c.nombreCarrera, i.anioInscripcion, e.nombre, e.apellido, " +
            "CASE WHEN i.graduado = true THEN 'Graduado' ELSE 'No graduado' END AS estado " +
            "FROM Inscripcion i " +
            "JOIN i.carrera c " +
            "JOIN i.estudiante e " +
            "ORDER BY c.nombreCarrera ASC, i.anioInscripcion ASC, e.apellido ASC, e.nombre ASC")
    public List<Object[]>generarReporte();
}
