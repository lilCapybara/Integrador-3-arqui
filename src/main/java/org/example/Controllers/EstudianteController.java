package org.example.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.Services.*;
import org.example.Entities.*;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    // a) Dar de alta un estudiante
    @PostMapping("/agregarEstudiante")
    public ResponseEntity<Estudiante> darDeAlta(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.insertarEstudiante(estudiante);
        return ResponseEntity.ok(nuevoEstudiante);
    }


    // c) Recuperar todos los estudiantes con ordenamiento
    @GetMapping("/getEstudiantesByEdad")
    public List<Estudiante> listarEstudiantesOrdenadosPorEdad() {
        return estudianteService.obtenerEstudiantesOrdenadosPorEdad();
    }

    @GetMapping("/listarEstudiantes")
    public ResponseEntity<List<Estudiante>> obtenerTodosEstudiantes(@RequestParam(defaultValue = "nombre") String ordenarPor) {
        List<Estudiante> estudiantes = estudianteService.obtenerTodosEstudiantes(ordenarPor);
        return ResponseEntity.ok(estudiantes);
    }

    // d) Recuperar un estudiante por libreta universitaria
    @GetMapping("/getEstudianteByLibreta/{libretaUniversitaria}")
    public ResponseEntity<Estudiante> obtenerEstudiantePorLibreta(@PathVariable int libretaUniversitaria) {
        Estudiante estudiante = estudianteService.obtenerPorLibreta(libretaUniversitaria);
        return ResponseEntity.ok(estudiante);
    }

    // e) Recuperar estudiantes por género
    @GetMapping("/getEstudiantesByGenero/{genero}")
    public ResponseEntity<List<Estudiante>> obtenerPorGenero(@PathVariable String genero) {
        List<Estudiante> estudiantes = estudianteService.obtenerPorGenero(genero);
        return ResponseEntity.ok(estudiantes);
    }
}
