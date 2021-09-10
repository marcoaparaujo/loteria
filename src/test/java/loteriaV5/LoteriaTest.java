package loteriaV5;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class LoteriaTest {

    @Test
    void deveVencerSena() {
        List<Integer> sorteados = Arrays.asList(03, 14, 21, 32, 47, 55);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Loteria loteria = new Loteria();
        Aposta aposta = new Aposta(Arrays.asList(03, 14, 21, 32, 47, 55));
        assertEquals(1000.00, loteria.calcularPremio(aposta, sorteioMock, 1000.00), 0.0);
    }

    @Test
    void deveVencerQuina() {
        List<Integer> sorteados = Arrays.asList(03, 14, 21, 32, 47, 55);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Loteria loteria = new Loteria();
        Aposta aposta = new Aposta(Arrays.asList(04, 14, 21, 32, 47, 55));
        assertEquals(200.00, loteria.calcularPremio(aposta, sorteioMock, 1000.00),0.0);
    }

    @Test
    void deveVencerQuadra() {
        List<Integer> sorteados = Arrays.asList(03, 14, 21, 32, 47, 55);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Loteria loteria = new Loteria();
        Aposta aposta = new Aposta(Arrays.asList(04, 15, 21, 32, 47, 55));
        assertEquals(50.00, loteria.calcularPremio(aposta, sorteioMock, 1000.00), 0.0);
    }

    @Test
    void devePerder() {
        List<Integer> sorteados = Arrays.asList(03, 14, 21, 32, 47, 55);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Loteria loteria = new Loteria();
        Aposta aposta = new Aposta(Arrays.asList(04, 15, 22, 32, 47, 55));
        assertEquals(0.00, loteria.calcularPremio(aposta, sorteioMock, 1000.00), 0.0);
    }

    @Test
    void deveVerificarApostaNula() {
        try {
            Loteria loteria = new Loteria();
            loteria.calcularPremio(null, new Sorteio(6), 1000.00);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Aposta inválida", e.getMessage());
        }
    }

    @Test
    void deveVerificarSorteioNulo() {
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
