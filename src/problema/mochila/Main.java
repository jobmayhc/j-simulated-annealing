/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.mochila;

import simulacion.simulatedAnnealing.SimulatedAnnealing;
import simulacion.simulatedAnnealing.Solucion;

/**
 *
 * @author edilson
 */
public class Main {

    public static void main(String arg[]) {
        SimulatedAnnealing algoritmo = new SimulatedAnnealing(null);
        algoritmo.setIteracionesDiferenteTemperatura(1000);
        algoritmo.setIteracionesMismaTemperatura(200);
        algoritmo.ejecutar(null);
        Solucion solucion = algoritmo.getSolucion();
        System.out.println("solucion:" + solucion);
    }
}
