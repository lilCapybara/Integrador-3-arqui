package org.example.Services;

import jakarta.persistence.EntityNotFoundException;
import org.example.Entities.Carrera;
import org.example.Entities.Estudiante;
import org.example.Entities.Inscripcion;
import org.example.Repositories.CarreraRepository;
import org.example.Repositories.EstudianteRepository;
import org.example.Repositories.InscripcionRepository;
import org.example.dto.InscripcionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private CarreraRepository carreraRepository;

    @Transactional
    public void matricularEstudiante(Integer idEstudiante, Integer idCarrera, Integer antiguedad, Integer anioInscripcion) {
        Estudiante estudiante = estudianteRepository.findById(idEstudiante).orElse(null);
        Carrera carrera = carreraRepository.findById(idCarrera).orElse(null);

        if (estudiante == null || carrera == null) {
            throw new EntityNotFoundException("Estudiante o Carrera no encontrados");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudiante(estudiante);
        inscripcion.setCarrera(carrera);
        inscripcion.setAntiguedad(antiguedad);
        inscripcion.setAnioInscripcion(anioInscripcion);
        inscripcion.setGraduado(false);

        inscripcionRepository.save(inscripcion);
    }

    public List<InscripcionDTO> obtenerInscripcionesPorEstudiante(Integer idEstudiante) {
        return inscripcionRepository.findInscripcionesByEstudianteId(idEstudiante);
    }

}
