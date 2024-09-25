import static org.junit.jupiter.api.Assertions.assertEquals;

import com.prisao.Main.entities.AgenteEntity;
import org.junit.jupiter.api.Test;

class AgenteEntityTest {

    @Test
    void testAgenteEntityFields() {
        AgenteEntity agente = new AgenteEntity();
        agente.setNome("João Silva");
        agente.setCpf("12345678900");
        agente.setDataNasc("1990-01-01");
        agente.setTelefone("987654321");
        agente.setCargo("Supervisor");

        assertEquals("João Silva", agente.getNome());
        assertEquals("12345678900", agente.getCpf());
        assertEquals("1990-01-01", agente.getDataNasc());
        assertEquals("987654321", agente.getTelefone());
        assertEquals("Supervisor", agente.getCargo());
    }
}
