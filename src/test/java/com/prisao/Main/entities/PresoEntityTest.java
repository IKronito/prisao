import static org.junit.jupiter.api.Assertions.assertEquals;

import com.prisao.Main.entities.PresoEntity;
import org.junit.jupiter.api.Test;

class PresoEntityTest {

    @Test
    void testPresoEntityFields() {
        PresoEntity preso = new PresoEntity();
        preso.setNome("Carlos Souza");
        preso.setCpf("98765432100");
        preso.setDataNasc("1985-05-20");
        preso.setCrime("Roubo");
        preso.setSentenca("10 anos");

        assertEquals("Carlos Souza", preso.getNome());
        assertEquals("98765432100", preso.getCpf());
        assertEquals("1985-05-20", preso.getDataNasc());
        assertEquals("Roubo", preso.getCrime());
        assertEquals("10 anos", preso.getSentenca());
    }
}
