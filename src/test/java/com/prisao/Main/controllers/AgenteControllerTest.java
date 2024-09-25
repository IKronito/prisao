package com.prisao.Main.controllers;

import com.prisao.Main.entities.AgenteEntity;
import com.prisao.Main.services.AgenteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class AgenteControllerTest {

    @InjectMocks
    private AgenteController agenteController;

    @Mock
    private AgenteService agenteService;

    private AgenteEntity agente;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // Ajuste a instância conforme o construtor da sua classe AgenteEntity
        agente = new AgenteEntity(1L, "Nome Agente", "Cargo Agente", "Departamento", "Contato", "Endereço", Collections.emptyList());
    }

    @Test
    public void testSaveAgente() {
        when(agenteService.saveAgente(any(AgenteEntity.class))).thenReturn(agente);
        ResponseEntity<AgenteEntity> response = agenteController.saveAgente(agente);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(agente, response.getBody());
    }

    @Test
    public void testFindAllAgentes() {
        when(agenteService.findAllAgentes()).thenReturn(Collections.singletonList(agente));
        ResponseEntity<List<AgenteEntity>> response = agenteController.findAllAgentes();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testFindByIdAgente() {
        when(agenteService.findByIdAgente(1L)).thenReturn(agente);
        ResponseEntity<AgenteEntity> response = agenteController.findByIdAgente(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(agente, response.getBody());
    }

    @Test
    public void testFindByCargoAgente() {
        when(agenteService.findByCargoAgente("Cargo Agente")).thenReturn(Collections.singletonList(agente));
        ResponseEntity<List<AgenteEntity>> response = agenteController.findByCargoAgente("Cargo Agente");
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testUpdateAgente() {
        when(agenteService.updateAgente(eq(1L), any(AgenteEntity.class))).thenReturn(agente);
        ResponseEntity<AgenteEntity> response = agenteController.updateAgente(1L, agente);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(agente, response.getBody());
    }

    @Test
    public void testDeleteAgente() {
        doNothing().when(agenteService).deleteAgente(1L);
        ResponseEntity<Void> response = agenteController.deleteAgente(1L);
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    public void testDeleteAllAgentes() {
        doNothing().when(agenteService).deleteAllAgentes();
        ResponseEntity<Void> response = agenteController.deleteAllAgentes();
        assertEquals(204, response.getStatusCodeValue());
    }
}
