package loteriaV3;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LoteriaTest {

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularPremio_apostaInvalidaNumeroInvalidoInferior() {
        Loteria loteria = new Loteria();
        List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44, 0);
        loteria.validarAposta(apostados);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularPremio_apostaInvalidaNumeroInvalidoSuperior() {
        Loteria loteria = new Loteria();
        List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44, 61);
        loteria.validarAposta(apostados);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularPremio_apostaInvalidaNumerosRepetidos() {
        Loteria loteria = new Loteria();
        List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44, 44);
        loteria.validarAposta(apostados);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularPremio_apostaInvalidaPoucosNumeros() {
        Loteria loteria = new Loteria();
        List<Integer> apostados = Arrays.asList(05, 12, 25, 32, 44);
        loteria.validarAposta(apostados);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalcularPremio_apostaInvalidaMuitosNumeros() {
        Loteria loteria = new Loteria();
        List<Integer> apostados = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        loteria.validarAposta(apostados);
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


@Test
public void testCalcularPremio_numeroApostadoDuplicado2() {
  try {
      List<Integer> apostados = Arrays.asList(5, 6, 7, 4, 9, 10, 10);
      Loteria loteria = new Loteria();
      loteria.validarAposta(apostados);
      fail();
  } catch (IllegalArgumentException e) {
      assertEquals("Número duplicado", e.getMessage());
  }
}

}