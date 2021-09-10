package loteriaV4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ApostaTest {

    @Test
    public void testApostaValida() {
        Aposta aposta = new Aposta(Arrays.asList(12, 15, 21, 36, 45, 54));
        assertEquals(Arrays.asList(12, 15, 21, 36, 45, 54), aposta.getNumeros());
    }

    @Test
    public void testApostaInvalidaPoucosNumeros() {
        try {
            new Aposta(Arrays.asList(05, 12, 25, 32, 44));
            fail();
        }
        catch(IllegalArgumentException e) {
            assertEquals("A aposta abaixo da mínima", e.getMessage());
        }
    }

    @Test
    public void testApostaInvalidaMuitosNumeros() {
        try {
            new Aposta(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
            fail();
        }
        catch(IllegalArgumentException e) {
            assertEquals("A aposta acima da máxima", e.getMessage());
        }
    }

    @Test
    public void testApostaInvalidaNumeroInvalidoInferior() {
        try {
            new Aposta(Arrays.asList(05, 12, 25, 32, 44, 0));
            fail();
        }
        catch(IllegalArgumentException e) {
            assertEquals("Número fora do limite", e.getMessage());
        }
    }

    @Test
    public void testApostaInvalidaNumeroInvalidoSuperior() {
        try {
            new Aposta(Arrays.asList(05, 12, 25, 32, 44, 61));
            fail();
        }
        catch(IllegalArgumentException e) {
            assertEquals("Número fora do limite", e.getMessage());
        }
    }

    @Test
    public void testApostaInvalidaNumerosRepetidos() {
        try {
            new Aposta(Arrays.asList(05, 12, 25, 32, 44, 44));
            fail();
        }
        catch(IllegalArgumentException e) {
            assertEquals("Número duplicado", e.getMessage());
        }
    }
}
