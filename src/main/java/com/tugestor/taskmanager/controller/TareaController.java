package com.tugestor.taskmanager.controller;

import com.tugestor.taskmanager.model.Tarea;
import com.tugestor.taskmanager.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
@CrossOrigin(origins = "*")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<Tarea> listar() {
        return tareaService.listarTareas();
    }

    @PostMapping
    public Tarea crear(@RequestBody Tarea tarea) {
        return tareaService.crearTarea(tarea);
    }

    @GetMapping("/{id}")
    public Tarea obtener(@PathVariable Long id) {
        return tareaService.obtenerTarea(id);
    }

    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Long id, @RequestBody Tarea tarea) {
        tarea.setId(id);
        return tareaService.actualizarTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
    }
}
