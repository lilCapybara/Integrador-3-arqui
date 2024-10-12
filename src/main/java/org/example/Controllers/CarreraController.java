package org.example.Controllers;

import org.example.Entities.Carrera;
import org.example.Services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @PostMapping("/agregarCarrera")
    public ResponseEntity<Carrera> darDeAltaCarrera(@RequestBody Carrera carrera) {
        Carrera nuevaCarrera = carreraService.darDeAltaCarrera(carrera);
        return ResponseEntity.ok(nuevaCarrera);
    }

    @GetMapping("/listarCarreras")
    public ResponseEntity<List<Carrera>> listarCarreras() {
        List<Carrera> carreras = carreraService.listarCarreras();
        return ResponseEntity.ok(carreras);
    }

    @GetMapping("getCarrerasByInscriptos")
    public ResponseEntity<List<Carrera>> listarCarrerasPorInscriptos(){
        List<Carrera> carreras = carreraService.listarCarrerasPorInscriptos();
        return ResponseEntity.ok(carreras);
    }
}

