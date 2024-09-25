import static org.junit.jupiter.api.Assertions.assertEquals;

import com.prisao.Main.entities.CelaEntity;
import org.junit.jupiter.api.Test;

class CelaEntityTest {

    @Test
    void testCelaEntityFields() {
        CelaEntity cela = new CelaEntity();
        cela.setNumero("A1");
        cela.setDescricao("Cela de segurança máxima");
        cela.setCapacidade(2);
        cela.setLocalizacao("Bloco A");

        assertEquals("A1", cela.getNumero());
        assertEquals("Cela de segurança máxima", cela.getDescricao());
        assertEquals(2, cela.getCapacidade());
        assertEquals("Bloco A", cela.getLocalizacao());
    }
}
