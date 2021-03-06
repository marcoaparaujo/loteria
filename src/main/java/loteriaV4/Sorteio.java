/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loteriaV4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sorteio {

    private static final int QTDE_NUMEROS_SORTEIO = 6;
    private static final int MAIOR_NUMERO_SORTEIO = 59; // subtrair 1 ao limite

    private  List<Integer> numeros;

    public Sorteio() {
        this.numeros = new ArrayList<Integer>();
    }

    public List<Integer> getNumeros() {
        return this.numeros;
    }

    public void setNumeros(List<Integer> numeros) {
        this.numeros = numeros;
    }

    private List<Integer> sortear() {
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
}
