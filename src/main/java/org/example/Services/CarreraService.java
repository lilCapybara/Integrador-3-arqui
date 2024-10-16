package org.example.Services;

import org.example.Entities.Carrera;
import org.example.Repositories.CarreraRepository;
import org.example.dto.CarreraDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public Carrera darDeAltaCarrera(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    public List<CarreraDTO> listarCarreras() {
        return carreraRepository.findAllCarreras();
    }

    // g) Listar carreras por cantidad de inscriptos
    public List<CarreraDTO> listarCarrerasPorInscriptos(){
        return carreraRepository.findCarrerasByCantidadInscriptos();
    }

    // h) Generar reporte
    public List<Object[]> generarReporte(){
        return carreraRepository.generarReporte();
    }
}

