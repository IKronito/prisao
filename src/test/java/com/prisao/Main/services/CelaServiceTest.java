package com.prisao.Main.services;

import com.prisao.Main.entities.CelaEntity;
import com.prisao.Main.repositories.CelaRepository;
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

public class CelaServiceTest {

    @Mock
    private CelaRepository celaRepository;

    @InjectMocks
    private CelaService celaService;

    public CelaServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCelaTest() {
        CelaEntity celaEntity = new CelaEntity();
        celaEntity.setNumero("1A");
        celaEntity.setDescricao("Descrição da cela");
        celaEntity.setCapacidade(5);
        celaEntity.setLocalizacao("Localização da cela");

        when(celaRepository.save(any(CelaEntity.class))).thenReturn(celaEntity);

        CelaEntity savedCela = celaService.saveCela(celaEntity);
        Assertions.assertNotNull(savedCela);
        Assertions.assertEquals("1A", savedCela.getNumero());
        verify(celaRepository, times(1)).save(celaEntity);
    }

    @Test
    void findAllCelulasTest() {
        List<CelaEntity> list = new ArrayList<>();
        when(celaRepository.findAll()).thenReturn(list);

        List<CelaEntity> result = celaService.findAllCelulas();
        Assertions.assertEquals(list, result);
        verify(celaRepository, times(1)).findAll();
    }

    @Test
    void findByIdCelaTest() {
        CelaEntity celaEntity = new CelaEntity();
        celaEntity.setNumero("1A");
        when(celaRepository.findById(1L)).thenReturn(Optional.of(celaEntity));

        CelaEntity foundCela = celaService.findByIdCela(1L);
        Assertions.assertNotNull(foundCela);
        Assertions.assertEquals("1A", foundCela.getNumero());
        verify(celaRepository, times(1)).findById(1L);
    }

    @Test
    void findByIdCelaNotFoundTest() {
        when(celaRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> {
            celaService.findByIdCela(1L);
        });
    }

    @Test
    void updateCelaTest() {
        CelaEntity existingCela = new CelaEntity();
        existingCela.setNumero("1A");
        existingCela.setDescricao("Descrição da cela");
        existingCela.setCapacidade(5);
        existingCela.setLocalizacao("Localização da cela");

        CelaEntity updatedCela = new CelaEntity();
        updatedCela.setNumero("2B");
        updatedCela.setDescricao("Nova descrição");
        updatedCela.setCapacidade(10);
        updatedCela.setLocalizacao("Nova localização");

        when(celaRepository.findById(1L)).thenReturn(Optional.of(existingCela));
        when(celaRepository.save(existingCela)).thenReturn(existingCela);

        CelaEntity result = celaService.updateCela(1L, updatedCela);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("2B", result.getNumero());
        verify(celaRepository, times(1)).findById(1L);
        verify(celaRepository, times(1)).save(existingCela);
    }

    @Test
    void deleteCelaTest() {
        doNothing().when(celaRepository).deleteById(1L);
        celaService.deleteCela(1L);
        verify(celaRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteAllCelulasTest() {
        doNothing().when(celaRepository).deleteAll();
        celaService.deleteAllCelulas();
        verify(celaRepository, times(1)).deleteAll();
    }
}
