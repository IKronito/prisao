import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import com.prisao.Main.entities.VisitaEntity;
import org.junit.jupiter.api.Test;

class VisitaEntityTest {

    @Test
    void testVisitaEntityFields() {
        VisitaEntity visita = new VisitaEntity();
        visita.setVisitante("Maria Oliveira");
        LocalDateTime visitaDate = LocalDateTime.of(2024, 9, 25, 10, 30);
        visita.setDataHoraVisita(visitaDate);

        assertEquals("Maria Oliveira", visita.getVisitante());
        assertEquals(visitaDate, visita.getDataHoraVisita());
    }
}
