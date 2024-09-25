package com.prisao.Main.controllers;

import com.prisao.Main.entities.PresoEntity;
import com.prisao.Main.entities.VisitaEntity;
import com.prisao.Main.services.VisitaService;
import com.prisao.Main.services.PresoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List; // Importando List

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class VisitaControllerTest {

    @InjectMocks
    private VisitaController visitaController;

    @Mock
    private VisitaService visitaService;

    @Mock
    private PresoService presoService;

    private VisitaEntity visita;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        PresoEntity preso = new PresoEntity();
        preso.setId(1L);

        visita = new VisitaEntity(1L, "Nome Visitante", LocalDateTime.now(), preso);
    }

    @Test
    public void testSaveVisita() {
        when(presoService.findByIdPreso(any(Long.class))).thenReturn(visita.getPreso()); // Simula que o preso existe
        when(visitaService.saveVisita(any(VisitaEntity.class))).thenReturn(visita);

        ResponseEntity<VisitaEntity> response = visitaController.saveVisita(visita);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(visita, response.getBody());
    }

    @Test
    public void testFindAllVisitas() {
        when(visitaService.findAllVisitas()).thenReturn(Collections.singletonList(visita));

        ResponseEntity<List<VisitaEntity>> response = visitaController.findAllVisitas();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testFindByIdVisita() {
        when(visitaService.findByIdVisita(1L)).thenReturn(visita);

        ResponseEntity<VisitaEntity> response = visitaController.findByIdVisita(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(visita, response.getBody());
    }

    @Test
    public void testDeleteVisita() {
        doNothing().when(visitaService).deleteVisita(1L);

        ResponseEntity<Void> response = visitaController.deleteVisita(1L);
        assertEquals(204, response.getStatusCodeValue());
    }

}
