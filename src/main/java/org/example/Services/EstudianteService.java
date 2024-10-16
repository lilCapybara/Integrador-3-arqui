package org.example.Services;


import org.example.Repositories.EstudianteRepository;
import org.example.dto.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.example.Services.*;
import org.example.Entities.*;
import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    // a) Dar de alta un estudiante
    @Transactional
    public Estudiante insertarEstudiante(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }


    // c) Obtener todos los estudiantes con ordenamiento
    public List<EstudianteDTO> obtenerEstudiantesOrdenadosPorEdad() {
        return estudianteRepository.findAllByOrderByEdadAsc();
    }

    public List<EstudianteDTO> obtenerTodosEstudiantes(String ordenarPor) {
        if (ordenarPor.equals("nombre")) {
            return estudianteRepository.findAllByOrderByNombreAsc();
        }
            return estudianteRepository.findAllByOrderByEdadAsc();

    }

    // d) Obtener estudiante por libreta universitaria
    public EstudianteDTO obtenerPorLibreta(int libretaUniversitaria) {
        return estudianteRepository.findOneByLibretaUniversitaria(libretaUniversitaria);
    }

    // e) Obtener estudiantes por género
    public List<EstudianteDTO> obtenerPorGenero(String genero) {
        return estudianteRepository.findByGenero(genero);
    }

    // g) Obtener estudiantes por carrera y ciudad
    public List<EstudianteDTO> obtenerPorCarreraYCiudad(String nombreCarrera, String ciudadResidencia){
        return estudianteRepository.findByCarreraAndCiudad(nombreCarrera,ciudadResidencia);
    }
}
