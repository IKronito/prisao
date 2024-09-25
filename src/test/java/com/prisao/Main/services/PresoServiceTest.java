package com.prisao.Main.services;

import com.prisao.Main.entities.PresoEntity;
import com.prisao.Main.repositories.PresoRepository;
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

public class PresoServiceTest {

    @Mock
    private PresoRepository presoRepository;

    @InjectMocks
    private PresoService presoService;

    public PresoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void savePresoTest() {
        PresoEntity presoEntity = new PresoEntity();
        when(presoRepository.save(any(PresoEntity.class))).thenReturn(presoEntity);

        PresoEntity savedPreso = presoService.savePreso(presoEntity);
        Assertions.assertNotNull(savedPreso);
        verify(presoRepository, times(1)).save(presoEntity);
    }

    @Test
    void findAllPresosTest() {
        List<PresoEntity> list = new ArrayList<>();
        when(presoRepository.findAll()).thenReturn(list);

        List<PresoEntity> result = presoService.findAllPresos();
        Assertions.assertEquals(list, result);
        verify(presoRepository, times(1)).findAll();
    }

    @Test
    void findByIdPresoTest() {
        PresoEntity presoEntity = new PresoEntity();
        when(presoRepository.findById(1L)).thenReturn(Optional.of(presoEntity));

        PresoEntity foundPreso = presoService.findByIdPreso(1L);
        Assertions.assertNotNull(foundPreso);
        verify(presoRepository, times(1)).findById(1L);
    }

    @Test
    void findByIdPresoNotFoundTest() {
        when(presoRepository.findById(1L)).thenReturn(Optional.empty());

        Assertions.assertThrows(RuntimeException.class, () -> {
            presoService.findByIdPreso(1L);
        });
    }

    @Test
    void updatePresoTest() {
        PresoEntity existingPreso = new PresoEntity();
        existingPreso.setNome("Nome");
        existingPreso.setCpf("12345678900");

        PresoEntity updatedPreso = new PresoEntity();
        updatedPreso.setNome("Novo Nome");
        updatedPreso.setCpf("09876543211");

        when(presoRepository.findById(1L)).thenReturn(Optional.of(existingPreso));
        when(presoRepository.save(existingPreso)).thenReturn(existingPreso);

        PresoEntity result = presoService.updatePreso(1L, updatedPreso);
        Assertions.assertNotNull(result);
        Assertions.assertEquals(existingPreso.getNome(), "Novo Nome");
        verify(presoRepository, times(1)).findById(1L);
        verify(presoRepository, times(1)).save(existingPreso);
    }

    @Test
    void deletePresoTest() {
        doNothing().when(presoRepository).deleteById(1L);
        presoService.deletePreso(1L);
        verify(presoRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteAllPresosTest() {
        doNothing().when(presoRepository).deleteAll();
        presoService.deleteAllPresos();
        verify(presoRepository, times(1)).deleteAll();
    }
}
