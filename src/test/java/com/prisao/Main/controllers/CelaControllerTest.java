package com.prisao.Main.controllers;

import com.prisao.Main.entities.CelaEntity;
import com.prisao.Main.services.CelaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CelaControllerTest {

    @InjectMocks
    private CelaController celaController;

    @Mock
    private CelaService celaService;

    private CelaEntity cela;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        cela = new CelaEntity(1L, "Descrição", 10, "Localização");
    }

    @Test
    public void testSaveCela() {
        when(celaService.saveCela(any(CelaEntity.class))).thenReturn(cela);
        ResponseEntity<CelaEntity> response = celaController.saveCela(cela);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(cela, response.getBody());
    }

    @Test
    public void testFindAllCelulas() {
        when(celaService.findAllCelulas()).thenReturn(Collections.singletonList(cela));
        ResponseEntity<List<CelaEntity>> response = celaController.findAllCelulas();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, response.getBody().size());
    }

    @Test
    public void testUpdateCela() {
        when(celaService.updateCela(eq(1L), any(CelaEntity.class))).thenReturn(cela);
        ResponseEntity<CelaEntity> response = celaController.updateCela(1L, cela);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(cela, response.getBody());
    }

    @Test
    public void testDeleteCela() {
        doNothing().when(celaService).deleteCela(1L);
        ResponseEntity<Void> response = celaController.deleteCela(1L);
        assertEquals(204, response.getStatusCodeValue());
    }
}
