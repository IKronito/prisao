import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.prisao.Main.entities.AgenteEntity;
import com.prisao.Main.repositories.AgenteRepository;
import com.prisao.Main.services.AgenteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class AgenteServiceTest {

    @Mock
    private AgenteRepository agenteRepository;

    @InjectMocks
    private AgenteService agenteService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAgenteById() {
        AgenteEntity agente = new AgenteEntity();
        agente.setId(1L);
        agente.setNome("João Silva");

        when(agenteRepository.findById(1L)).thenReturn(Optional.of(agente));

        AgenteEntity result = agenteService.findByIdAgente(1L);

        assertEquals("João Silva", result.getNome());
        verify(agenteRepository, times(1)).findById(1L);
    }

    @Test
    void testFindAgenteByIdNotFound() {
        when(agenteRepository.findById(2L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            agenteService.findByIdAgente(2L);
        });

        assertEquals("Agente não encontrado", exception.getMessage());
        verify(agenteRepository, times(1)).findById(2L);
    }

    @Test
    void testCreateAgente() {
        AgenteEntity agente = new AgenteEntity();
        agente.setNome("João Silva");

        when(agenteRepository.save(any(AgenteEntity.class))).thenReturn(agente);

        AgenteEntity createdAgente = agenteService.saveAgente(agente);

        assertEquals("João Silva", createdAgente.getNome());
        verify(agenteRepository, times(1)).save(agente);
    }

    @Test
    void testUpdateAgente() {
        AgenteEntity existingAgente = new AgenteEntity();
        existingAgente.setId(1L);
        existingAgente.setNome("João Silva");
        existingAgente.setCpf("12345678900");

        AgenteEntity updatedAgente = new AgenteEntity();
        updatedAgente.setNome("Carlos Pereira");
        updatedAgente.setCpf("98765432100");

        when(agenteRepository.findById(1L)).thenReturn(Optional.of(existingAgente));
        when(agenteRepository.save(any(AgenteEntity.class))).thenReturn(existingAgente);

        AgenteEntity result = agenteService.updateAgente(1L, updatedAgente);

        assertEquals("Carlos Pereira", result.getNome());
        assertEquals("98765432100", result.getCpf());
        verify(agenteRepository, times(1)).findById(1L);
        verify(agenteRepository, times(1)).save(existingAgente);
    }

    @Test
    void testUpdateAgenteNotFound() {
        AgenteEntity updatedAgente = new AgenteEntity();
        updatedAgente.setNome("Carlos Pereira");

        when(agenteRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            agenteService.updateAgente(1L, updatedAgente);
        });

        assertEquals("Agente não encontrado", exception.getMessage());
        verify(agenteRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteAgente() {
        Long idToDelete = 1L;

        doNothing().when(agenteRepository).deleteById(idToDelete);
        agenteService.deleteAgente(idToDelete);

        verify(agenteRepository, times(1)).deleteById(idToDelete);
    }

    @Test
    void testDeleteAllAgentes() {
        doNothing().when(agenteRepository).deleteAll();
        agenteService.deleteAllAgentes();

        verify(agenteRepository, times(1)).deleteAll();
    }

    @Test
    void testFindAllAgentes() {
        AgenteEntity agente1 = new AgenteEntity();
        agente1.setNome("João Silva");

        AgenteEntity agente2 = new AgenteEntity();
        agente2.setNome("Carlos Souza");

        when(agenteRepository.findAll()).thenReturn(Arrays.asList(agente1, agente2));

        List<AgenteEntity> result = agenteService.findAllAgentes();

        assertEquals(2, result.size());
        assertEquals("João Silva", result.get(0).getNome());
        assertEquals("Carlos Souza", result.get(1).getNome());
        verify(agenteRepository, times(1)).findAll();
    }

    @Test
    void testFindByCargoAgente() {
        AgenteEntity agente1 = new AgenteEntity();
        agente1.setNome("João Silva");
        agente1.setCargo("Supervisor");

        AgenteEntity agente2 = new AgenteEntity();
        agente2.setNome("Carlos Souza");
        agente2.setCargo("Supervisor");

        when(agenteRepository.findByCargo("Supervisor")).thenReturn(Arrays.asList(agente1, agente2));

        List<AgenteEntity> result = agenteService.findByCargoAgente("Supervisor");

        assertEquals(2, result.size());
        assertEquals("João Silva", result.get(0).getNome());
        assertEquals("Carlos Souza", result.get(1).getNome());
        verify(agenteRepository, times(1)).findByCargo("Supervisor");
    }

    @Test
    void testFindByCargoAgenteNotFound() {
        when(agenteRepository.findByCargo("Inexistente")).thenReturn(Arrays.asList());

        List<AgenteEntity> result = agenteService.findByCargoAgente("Inexistente");

        assertEquals(0, result.size());
        verify(agenteRepository, times(1)).findByCargo("Inexistente");
    }
}
