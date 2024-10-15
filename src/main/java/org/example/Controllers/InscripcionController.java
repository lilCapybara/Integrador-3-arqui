package org.example.Controllers;

import jakarta.persistence.EntityNotFoundException;
import org.example.Entities.Carrera;
import org.example.Entities.Estudiante;
import org.example.Entities.Inscripcion;
import org.example.Services.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    // b) Matricular estudiante en una carrera
    @PostMapping("/matricular")
    public ResponseEntity<String> matricularEstudiante(@RequestBody Map<String, Integer> request) {
        Integer idEstudiante = request.get("idEstudiante");
        Integer idCarrera = request.get("idCarrera");
        Integer antiguedad = request.get("antiguedad");
        Integer anioInscripcion = request.get("anioInscripcion");

        try {
            inscripcionService.matricularEstudiante(idEstudiante, idCarrera, antiguedad, anioInscripcion);
            return ResponseEntity.ok("Estudiante matriculado con éxito");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al matricular al estudiante: " + e.getMessage());
        }
    }
    @GetMapping("/inscripcionesXEstudiante/{idEstudiante}")
    public ResponseEntity<List<Inscripcion>> listarIncripcionesPorEstudiante(@PathVariable Integer idEstudiante) {
        List<Inscripcion> inscripciones = inscripcionService.listarIncripcionesPorEstudiante(idEstudiante);
        return ResponseEntity.ok(inscripciones);
    }

    @GetMapping("/inscriptosXCarrera/{idCarrera}")
    public ResponseEntity<List<Inscripcion>> listarIncripcionesPorCarrera(@PathVariable Integer idCarrera) {
        List<Inscripcion> inscripciones = inscripcionService.listarIncripcionesPorCarrera(idCarrera);
        return ResponseEntity.ok(inscripciones);
    }
}

