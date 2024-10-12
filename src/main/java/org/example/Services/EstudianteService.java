package org.example.Services;


import org.example.Repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.example.Services.*;
import org.example.Entities.*;
import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // a) Dar de alta un estudiante
    public Estudiante insertarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }


    // c) Obtener todos los estudiantes con ordenamiento
    public List<Estudiante> obtenerTodosEstudiantes(String ordenarPor) {
        if (ordenarPor.equals("nombre")) {
            return estudianteRepository.findAllByOrderByNombreAsc();
        } else if (ordenarPor.equals("edad")) {
            return estudianteRepository.findAllByOrderByEdadAsc();
        } else {
            return estudianteRepository.findAll();
        }
    }

    // d) Obtener estudiante por libreta universitaria
    public Estudiante obtenerPorLibreta(int libretaUniversitaria) {
        return estudianteRepository.findByLibretaUniversitaria(libretaUniversitaria);
    }

    // e) Obtener estudiantes por género
    public List<Estudiante> obtenerPorGenero(String genero) {
        return estudianteRepository.findByGenero(genero);
    }
}
