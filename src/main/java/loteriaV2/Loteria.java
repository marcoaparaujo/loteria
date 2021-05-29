package loteriaV2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loteria {

    public static final int NUM_ACERTOS_SENA = 6;
    public static final int NUM_ACERTOS_QUINA = 5;
    public static final int NUM_ACERTOS_QUADRA = 4;
    public static final double PERC_PREMIO_SENA = 1.0;
    public static final double PERC_PREMIO_QUINA = 0.2;
    public static final double PERC_PREMIO_QUADRA = 0.05;
    private static final int APOSTA_MINIMA = 6;
    private static final int APOSTA_MAXIMA = 15;
    private static final int MENOR_NUMERO = 1;
    private static final int MAIOR_NUMERO = 60;
    private static final int MAIOR_NUMERO_SORTEIO = 59; // subtrair 1 ao limite
    private static final int QTDE_NUMEROS_SORTEIO = 6;

    public double calcularPremio(List<Integer> apostados, double premioTotal) {
        if (!validarAposta(apostados)) {
            return 0.0;
        }
        List<Integer> sorteados = sortearNumeros();
        long acertos = calcularAcertos(apostados, sorteados);

        if (acertos == NUM_ACERTOS_SENA) {
            return premioTotal * PERC_PREMIO_SENA;
        } else if (acertos == NUM_ACERTOS_QUINA) {
            return premioTotal * PERC_PREMIO_QUINA;
        } else if (acertos == NUM_ACERTOS_QUADRA) {
            return premioTotal * PERC_PREMIO_QUADRA;
        } else {
            return 0.0;
        }
    }

    private boolean validarAposta(List<Integer> numerosApostados) {
        if (numerosApostados.size() < APOSTA_MINIMA || numerosApostados.size() > APOSTA_MAXIMA) {
            return false;
        }
        List<Integer> numerosValidos = new ArrayList<>();
        for (Integer apostado : numerosApostados) {
            if (apostado < MENOR_NUMERO || apostado > MAIOR_NUMERO) {
                return false; // inválido
            }
            if (numerosValidos.contains(apostado)) {
                return false; // repetido
            }
            numerosValidos.add(apostado);
        }
        return true;
    }

    private List<Integer> sortearNumeros() {
        List<Integer> sorteados = new ArrayList<>();
        int numeroSorteado;
        while (sorteados.size() < QTDE_NUMEROS_SORTEIO) {
            numeroSorteado = new Random().nextInt(MAIOR_NUMERO_SORTEIO) + 1;
            if (!sorteados.contains(numeroSorteado)) {
                sorteados.add(numeroSorteado);
            }
        }
        return sorteados;
    }

    private int calcularAcertos(List<Integer> apostados, List<Integer> sorteados) {
        int acertos = 0;
        for (Integer apostado : apostados) {
            if (sorteados.contains(apostado)) {
                acertos++;
            }
        }
        return acertos;
    }
}
