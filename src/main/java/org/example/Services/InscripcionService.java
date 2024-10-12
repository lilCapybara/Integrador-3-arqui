package org.example.Services;

import org.example.Entities.Carrera;
import org.example.Entities.Estudiante;
import org.example.Entities.Inscripcion;
import org.example.Repositories.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Transactional
    public void matricularEstudiante(Estudiante estudiante, Carrera carrera, int antiguedad, int anioInscripcion) {
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setEstudiante(estudiante);
        inscripcion.setCarrera(carrera);
        inscripcion.setAntiguedad(antiguedad);
        inscripcion.setAnioInscripcion(anioInscripcion);
        inscripcion.setGraduado(false);

        inscripcionRepository.save(inscripcion);
    }

    public List<Inscripcion> listarIncripcionesPorEstudiante(Integer idEstudiante) {
        return inscripcionRepository.findByEstudianteIdEstudiante(idEstudiante);
    }

    public List<Inscripcion> listarIncripcionesPorCarrera(Integer idCarrera) {
        return inscripcionRepository.findByCarreraIdCarrera(idCarrera);
    }
}
