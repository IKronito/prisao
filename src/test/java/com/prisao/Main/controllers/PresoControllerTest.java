package com.prisao.Main.controllers;

import com.prisao.Main.entities.CelaEntity;
import com.prisao.Main.entities.PresoEntity;
import com.prisao.Main.services.CelaService;
import com.prisao.Main.services.PresoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PresoControllerTest {

    @InjectMocks
    private PresoController presoController;

    @Mock
    private PresoService presoService;

    @Mock
    private CelaService celaService;

    private PresoEntity preso;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        CelaEntity cela = new CelaEntity();
        cela.setId(1L);
        preso = new PresoEntity(1L, "Nome do Preso", "123.456.789-00", "01/01/1990", "Crime", "Sentença", null, cela, new ArrayList<>());
    }

    @Test
    public void testSavePreso() {
        when(celaService.findByIdCela(any(Long.class))).thenReturn(preso.getCela()); // Simula que a cela existe
        when(presoService.savePreso(any(PresoEntity.class))).thenReturn(preso);

        ResponseEntity<PresoEntity> response = presoController.savePreso(preso);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(preso, response.getBody());
    }

    @Test
    public void testFindAllPresos() {
        when(presoService.findAllPresos()).thenReturn(Collections.singletonList(preso));

        ResponseEntity<List<PresoEntity>> response = presoController.findAllPresos();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testFindByIdPreso() {
        when(presoService.findByIdPreso(1L)).thenReturn(preso);

        ResponseEntity<PresoEntity> response = presoController.findByIdPreso(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(preso, response.getBody());
    }

    @Test
    public void testUpdatePreso() {
        when(presoService.updatePreso(eq(1L), any(PresoEntity.class))).thenReturn(preso);

        ResponseEntity<PresoEntity> response = presoController.updatePreso(1L, preso);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(preso, response.getBody());
    }

    @Test
    public void testDeletePreso() {
        doNothing().when(presoService).deletePreso(1L);

        ResponseEntity<Void> response = presoController.deletePreso(1L);
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    public void testDeleteAllPresos() {
        doNothing().when(presoService).deleteAllPresos();

        ResponseEntity<Void> response = presoController.deleteAllPresos();
        assertEquals(204, response.getStatusCodeValue());
    }
}
