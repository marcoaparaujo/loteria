package loteriaV3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class LoteriaTest {

    @Test
    public void testCalcularPremio_apostaInvalidaNumeroInvalidoInferior() {
        try {
            Loteria loteria = new Loteria();
            List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44, 0);
            loteria.validarAposta(apostados);
            fail();
        }
        catch(IllegalArgumentException e) {
            assertEquals("Número fora do limite", e.getMessage());
        }
    }

    @Test
    public void testCalcularPremio_apostaInvalidaNumeroInvalidoSuperior() {
        try {
            Loteria loteria = new Loteria();
            List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44, 61);
            loteria.validarAposta(apostados);
            fail();
        }
        catch(IllegalArgumentException e) {
            assertEquals("Número fora do limite", e.getMessage());
        }
    }

    @Test
    public void testCalcularPremio_apostaInvalidaNumerosRepetidos() {
        try {
            Loteria loteria = new Loteria();
            List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44, 44);
            loteria.validarAposta(apostados);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Número duplicado", e.getMessage());
        }
    }

    @Test
    public void testCalcularPremio_apostaInvalidaPoucosNumeros() {
        try {
            Loteria loteria = new Loteria();
            List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44);
            loteria.validarAposta(apostados);
            fail();
        }
        catch(IllegalArgumentException e) {
            assertEquals("A aposta abaixo da mínima", e.getMessage());
        }
    }

    @Test
    public void testCalcularPremio_apostaInvalidaMuitosNumeros() {
        try {
            Loteria loteria = new Loteria();
            List<Integer> apostados = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
            loteria.validarAposta(apostados);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("A aposta acima da máxima", e.getMessage());
        }
    }

    @Test
    public void testCalcularPremio_venceSena() {
        List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44, 51);
        List<Integer> sorteados = Arrays.asList(05, 12, 25, 32, 44, 51);
        Loteria loteria = new Loteria();
        assertEquals(1000.0, loteria.calcularPremio(apostados, sorteados, 1000.0), 0.0);
    }

    @Test
    public void testCalcularPremio_venceQuina() {
        List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44, 51);
        List<Integer> sorteados = Arrays.asList(05, 12, 25, 32, 44, 59);
        Loteria loteria = new Loteria();
        assertEquals(200.0, loteria.calcularPremio(apostados, sorteados, 1000.0), 0.0);
    }

    @Test
    public void testCalcularPremio_venceQuadra() {
        List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44, 51);
        List<Integer> sorteados = Arrays.asList(05, 12, 25, 32, 49, 59);
        Loteria loteria = new Loteria();
        assertEquals(50.0, loteria.calcularPremio(apostados, sorteados, 1000.0), 0.0);
    }

    @Test
    public void testCalcularPremio_perde() {
        List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44, 51);
        List<Integer> sorteados = Arrays.asList(05, 12, 25, 39, 49, 59);
        Loteria loteria = new Loteria();
        assertEquals(0.0, loteria.calcularPremio(apostados, sorteados, 1000.0), 0.0);
    }

}