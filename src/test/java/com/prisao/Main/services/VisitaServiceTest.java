package com.prisao.Main.services;

import com.prisao.Main.entities.VisitaEntity;
import com.prisao.Main.repositories.VisitaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class VisitaServiceTest {

    @Mock
    private VisitaRepository visitaRepository;

    @InjectMocks
    private VisitaService visitaService;

    public VisitaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveVisitaTest() {
        VisitaEntity visitaEntity = new VisitaEntity();
        when(visitaRepository.save(any(VisitaEntity.class))).thenReturn(visitaEntity);

        VisitaEntity savedVisita = visitaService.saveVisita(visitaEntity);
        Assertions.assertNotNull(savedVisita);
        verify(visitaRepository, times(1)).save(visitaEntity);
    }

    @Test
    void findAllVisitasTest() {
        List<VisitaEntity> list = new ArrayList<>();
        when(visitaRepository.findAll()).thenReturn(list);

        List<VisitaEntity> result = visitaService.findAllVisitas();
        Assertions.assertEquals(list, result);
        verify(visitaRepository, times(1)).findAll();
    }

    @Test
    void findByIdVisitaTest() {
        VisitaEntity visitaEntity = new VisitaEntity();
        when(visitaRepository.findById(1L)).thenReturn(Optional.of(visitaEntity));

        VisitaEntity foundVisita = visitaService.findByIdVisita(1L);
        Assertions.assertNotNull(foundVisita);
        verify(visitaRepository, times(1)).findById(1L);
    }

    @Test
    void findByIdVisitaNotFoundTest() {
        when(visitaRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> {
            visitaService.findByIdVisita(1L);
        });
    }

    @Test
    void deleteVisitaTest() {
        doNothing().when(visitaRepository).deleteById(1L);
        visitaService.deleteVisita(1L);
        verify(visitaRepository, times(1)).deleteById(1L);
    }
}
