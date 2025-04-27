package com.tugestor.taskmanager.service;

import com.tugestor.taskmanager.model.Tarea;
import com.tugestor.taskmanager.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea obtenerTarea(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    public Tarea actualizarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}
