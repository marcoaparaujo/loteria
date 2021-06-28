package loteriaV5;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

public class LoteriaTest {

    @Test
    public void testCalcularPremio_venceSena() {
        List<Integer> sorteados = Arrays.asList(03, 14, 21, 32, 47, 55);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Loteria loteria = new Loteria();
        Aposta aposta = new Aposta(Arrays.asList(03, 14, 21, 32, 47, 55));
        assertEquals(1000.00, loteria.calcularPremio(aposta, sorteioMock, 1000.00), 0.0);
    }

    @Test
    public void testCalcularPremio_venceQuina() {
        List<Integer> sorteados = Arrays.asList(03, 14, 21, 32, 47, 55);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Loteria loteria = new Loteria();
        Aposta aposta = new Aposta(Arrays.asList(04, 14, 21, 32, 47, 55));
        assertEquals(200.00, loteria.calcularPremio(aposta, sorteioMock, 1000.00),0.0);
    }

    @Test
    public void testCalcularPremio_venceQuadra() {
        List<Integer> sorteados = Arrays.asList(03, 14, 21, 32, 47, 55);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Loteria loteria = new Loteria();
        Aposta aposta = new Aposta(Arrays.asList(04, 15, 21, 32, 47, 55));
        assertEquals(50.00, loteria.calcularPremio(aposta, sorteioMock, 1000.00), 0.0);
    }

    @Test
    public void testCalcularPremio_perde() {
        List<Integer> sorteados = Arrays.asList(03, 14, 21, 32, 47, 55);
        ISorteio sorteioMock = createMock(ISorteio.class);
        expect(sorteioMock.getNumeros()).andReturn(sorteados);
        replay(sorteioMock);
        Loteria loteria = new Loteria();
        Aposta aposta = new Aposta(Arrays.asList(04, 15, 22, 32, 47, 55));
        assertEquals(0.00, loteria.calcularPremio(aposta, sorteioMock, 1000.00), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularPremio_apostaNula() {
        Loteria loteria = new Loteria();
        loteria.calcularPremio(null, new Sorteio(6), 1000.00);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCalcularPremio_sorteioNulo() {
        Loteria loteria = new Loteria();
        loteria.calcularPremio(new Aposta(Arrays.asList(04, 15, 22, 32, 47, 55)), null, 1000.00);
    }

}
