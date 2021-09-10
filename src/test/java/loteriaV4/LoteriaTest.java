package loteriaV4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class LoteriaTest {

    @Test
    public void testCalcularPremio_venceSena() {
        Sorteio sorteio = new Sorteio();
        sorteio.setNumeros(Arrays.asList(03, 14, 21, 32, 47, 55));
        Loteria loteria = new Loteria();
        Aposta aposta = new Aposta(Arrays.asList(03, 14, 21, 32, 47, 55));
        assertEquals(1000.00, loteria.calcularPremio(aposta, sorteio, 1000.00), 0.0);
    }

    @Test
    public void testCalcularPremio_venceQuina() {
        Sorteio sorteio = new Sorteio();
        sorteio.setNumeros(Arrays.asList(03, 14, 21, 32, 47, 55));
        Loteria loteria = new Loteria();
        Aposta aposta = new Aposta(Arrays.asList(04, 14, 21, 32, 47, 55));
        assertEquals(200.00, loteria.calcularPremio(aposta, sorteio, 1000.00), 0.0);
    }

    @Test
    public void testCalcularPremio_venceQuadra() {
        Sorteio sorteio = new Sorteio();
        sorteio.setNumeros(Arrays.asList(03, 14, 21, 32, 47, 55));
        Loteria loteria = new Loteria();
        Aposta aposta = new Aposta(Arrays.asList(04, 15, 21, 32, 47, 55));
        assertEquals(50.00, loteria.calcularPremio(aposta, sorteio, 1000.00),0.0);
    }

    @Test
    public void testCalcularPremio_perde() {
        Sorteio sorteio = new Sorteio();
        sorteio.setNumeros(Arrays.asList(03, 14, 21, 32, 47, 55));
        Loteria loteria = new Loteria();  
        Aposta aposta = new Aposta(Arrays.asList(04, 15, 22, 32, 47, 55));
        assertEquals(0.00, loteria.calcularPremio(aposta, sorteio, 1000.00), 0.0);
    }

    @Test
    public void testCalcularPremio_apostaNula() {
        try {
            Loteria loteria = new Loteria();
            loteria.calcularPremio(null, new Sorteio(), 1000.00);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Aposta inválida", e.getMessage());
        }
    }
    
    @Test
    public void testCalcularPremio_sorteioNulo() {
        try {
            Loteria loteria = new Loteria();
            loteria.calcularPremio(new Aposta(Arrays.asList(04, 15, 22, 32, 47, 55)), null, 1000.00);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Sorteio inválido", e.getMessage());
        }
    }

}
