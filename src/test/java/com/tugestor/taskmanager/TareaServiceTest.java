package com.tugestor.taskmanager;

import com.tugestor.taskmanager.model.Tarea;
import com.tugestor.taskmanager.repository.TareaRepository;
import com.tugestor.taskmanager.service.TareaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TareaServiceTest {

    @InjectMocks
    private TareaService tareaService;

    @Mock
    private TareaRepository tareaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarTareas() {
        when(tareaRepository.findAll()).thenReturn(Arrays.asList(new Tarea(), new Tarea()));
        assertEquals(2, tareaService.listarTareas().size());
        verify(tareaRepository, times(1)).findAll();
    }

    @Test
    void testCrearTarea() {
        Tarea tarea = new Tarea();
        tarea.setTitulo("Nueva tarea");
        when(tareaRepository.save(tarea)).thenReturn(tarea);

        Tarea resultado = tareaService.crearTarea(tarea);

        assertNotNull(resultado);
        assertEquals("Nueva tarea", resultado.getTitulo());
        verify(tareaRepository, times(1)).save(tarea);
    }

    @Test
    void testObtenerTarea() {
        Tarea tarea = new Tarea();
        tarea.setId(1L);
        when(tareaRepository.findById(1L)).thenReturn(Optional.of(tarea));

        Tarea resultado = tareaService.obtenerTarea(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
    }

    @Test
    void testEliminarTarea() {
        tareaService.eliminarTarea(1L);
        verify(tareaRepository, times(1)).deleteById(1L);
    }
}
