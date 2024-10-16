package org.example.Controllers;

import org.example.dto.EstudianteDTO;
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

    // c) Recuperar todos los estudiantes por edad
    @GetMapping("/getEstudiantesByEdad")
    public List<EstudianteDTO> listarEstudiantesOrdenadosPorEdad() {
        return estudianteService.obtenerEstudiantesOrdenadosPorEdad();
    }

    @GetMapping("/listarEstudiantes")
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosEstudiantes(@RequestParam(defaultValue = "nombre") String ordenarPor) {
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodosEstudiantes(ordenarPor);
        return ResponseEntity.ok(estudiantes);
    }

    // d) Recuperar un estudiante por libreta universitaria
    @GetMapping("/getEstudianteByLibreta/{libretaUniversitaria}")
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorLibreta(@PathVariable int libretaUniversitaria) {
        EstudianteDTO estudiante = estudianteService.obtenerPorLibreta(libretaUniversitaria);
        return ResponseEntity.ok(estudiante);
    }

    // e) Recuperar estudiantes por género
    @GetMapping("/getEstudiantesByGenero/{genero}")
    public ResponseEntity<List<EstudianteDTO>> obtenerPorGenero(@PathVariable String genero) {
        List<EstudianteDTO> estudiantes = estudianteService.obtenerPorGenero(genero);
        return ResponseEntity.ok(estudiantes);
    }

    // g) Recuperar estudiantes por carrera y ciudad
    @GetMapping("/getEstudiantesByCarreraAndCiudad/{nombreCarrera}/{ciudadResidencia}")
    public ResponseEntity<List<EstudianteDTO>> obtenerPorCarreraYCiudad(@PathVariable String nombreCarrera, @PathVariable String ciudadResidencia){
        List<EstudianteDTO> estudiantes = estudianteService.obtenerPorCarreraYCiudad(nombreCarrera,ciudadResidencia);
        return ResponseEntity.ok(estudiantes);
    }
}
