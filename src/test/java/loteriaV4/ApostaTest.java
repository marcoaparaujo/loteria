package loteriaV4;

import java.util.Arrays;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ApostaTest {

    @Test
    public void testApostaValida() {
        Aposta aposta = new Aposta(Arrays.asList(12, 15, 21, 36, 45, 54));
        assertEquals(Arrays.asList(12, 15, 21, 36, 45, 54), aposta.getNumeros());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApostaInvalidaPoucosNumeros() {
        new Aposta(Arrays.asList(05, 12, 25, 32, 44));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApostaInvalidaMuitosNumeros() {
        new Aposta(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApostaInvalidaNumeroInvalidoInferior() {
        new Aposta(Arrays.asList(05, 12, 25, 32, 44, 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApostaInvalidaNumeroInvalidoSuperior() {
        new Aposta(Arrays.asList(05, 12, 25, 32, 44, 61));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApostaInvalidaNumerosRepetidos() {
        new Aposta(Arrays.asList(05, 12, 25, 32, 44, 44));
    }
}
