/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loteriaV5;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteio implements ISorteio {

    private static final int MAIOR_NUMERO_SORTEIO = 59; // subtrair 1 ao limite

    private  List<Integer> numeros;

    public Sorteio(int qtdeNumeros) {
        this.numeros = sortear (qtdeNumeros);
    }
    
    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }

    public List<Integer> getNumeros() {
        return this.numeros;
    }

    private List<Integer> sortear(int qtdeNumeros) {
        List<Integer> sorteados = new ArrayList<>();
        int numeroSorteado;
        while (sorteados.size() < qtdeNumeros) {
            numeroSorteado = new Random().nextInt(MAIOR_NUMERO_SORTEIO) + 1;
            if (!sorteados.contains(numeroSorteado)) {
                sorteados.add(numeroSorteado);
            }
        }
        return sorteados;
    }
}
