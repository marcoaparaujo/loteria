package loteriaV1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loteria {

    public double calcularPremio(List<Integer> numerosApostados, double premioTotal) {
        List<Integer> numerosValidos = new ArrayList<>();
        for (Integer apostado : numerosApostados) {
            if (apostado < 1 || apostado > 60) {
                return 0.0; // inválido
            }
            if (numerosValidos.contains(apostado)) {
                return 0.0; // repetido
            }
            numerosValidos.add(apostado);
        }

        if (numerosValidos.size() >= 6 && numerosValidos.size() <= 15) {
            List<Integer> numerosSorteados = new ArrayList<>();
            int numeroSorteado;
            while (numerosSorteados.size() < 6) {
                numeroSorteado = new Random().nextInt(59) + 1;
                if (!numerosSorteados.contains(numeroSorteado)) {
                    numerosSorteados.add(numeroSorteado);
                }
            }

            int acertos = 0;
            for (Integer apostado : numerosApostados) {
                if (numerosSorteados.contains(apostado)) {
                    acertos++;
                }
            }

            if (acertos == 6) {
                return premioTotal; // Sena = 100%
            } else if (acertos == 5) {
                return premioTotal * 0.2; // Quina = 20%
            } else if (acertos == 4) {
                return premioTotal * 0.05; // Quadra = 5%
            }
        }
        return 0.0;
    }
}
