/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.mochila.vecindad;

import problema.mochila.EsquemaMochila;
import problema.mochila.SolucionMochila;
import simulacion.Util;
import simulacion.simulatedAnnealing.EsquemaVecindad;
import simulacion.simulatedAnnealing.Solucion;

/**
 *
 * @author John Arevalo
 */
public class IntercambioObjeto implements EsquemaVecindad {

    EsquemaMochila mochila;

    public Solucion getVecino(Solucion solucionActual) {
        SolucionMochila nuevaSolucion = new SolucionMochila((SolucionMochila) solucionActual,
                mochila.getCapacidad());
        // Ubicar el objeto aleatoriamente e intercambiarlo en la solucion
        int aleatorio = Util.generarAleatorio(mochila.getObjetos().size() - 1);
        nuevaSolucion.intercambiar(mochila.getObjetos().get(aleatorio));
        return nuevaSolucion;
    }

    public String getDescripcion() {
        return "Intercambia un objeto en la mochila, si esta dentro lo saca, si esta fuera lo ingresa";
    }
}
