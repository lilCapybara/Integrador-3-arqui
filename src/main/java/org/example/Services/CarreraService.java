package org.example.Services;

import org.example.Entities.Carrera;
import org.example.Repositories.CarreraRepository;
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

    public List<Carrera> listarCarreras() {
        return carreraRepository.findAll();
    }

    public List<Carrera> listarCarrerasPorInscriptos(){
        return carreraRepository.findCarrerasByCantidadInscriptos();
    }
}

