package org.example.Controllers;

import org.example.Entities.Carrera;
import org.example.Entities.Estudiante;
import org.example.Entities.Inscripcion;
import org.example.Services.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    // b) Matricular estudiante en una carrera
    @PostMapping("/matricular")
    public ResponseEntity<String> matricularEstudiante(Estudiante estudiante, Carrera carrera, int antiguedad, int anioInscripcion) {

        inscripcionService.matricularEstudiante(estudiante, carrera, antiguedad, anioInscripcion);

        return ResponseEntity.ok("Estudiante matriculado con éxito");
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

