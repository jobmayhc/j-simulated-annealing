/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.viajero.vecindad;

import problema.viajero.EsquemaViajero;
import problema.viajero.SolucionViajero;
import simulacion.Util;
import simulacion.simulatedAnnealing.EsquemaVecindad;
import simulacion.simulatedAnnealing.Solucion;

/**
 * Se escoge aleatoriamente un punto y se intercambia con la siguiente en la
 * solucion actual
 * @author John Arevalo
 */
public class ArcoAleatorio implements EsquemaVecindad {

    private EsquemaViajero esquemaViajero;

    public ArcoAleatorio(EsquemaViajero esquemaViajero) {
        this.esquemaViajero = esquemaViajero;
    }

    public Solucion getVecino(Solucion solucionActual) {

        //Se realiza una copia de la solucionActual
        SolucionViajero nuevaSolucion = new SolucionViajero((SolucionViajero) solucionActual);

        //Seleccionar un arco aleatorio
        int aleatorio = Util.generarAleatorio(esquemaViajero.getPuntos().size() - 1);
        int anterior = normalizar(aleatorio - 1);
        int siguiente = normalizar(aleatorio + 1);
        int aleatorio2 = Util.generarAleatorio(esquemaViajero.getPuntos().size() - 1);
        //Buscar el otro arco que no sea adyacente
        while (aleatorio2 == aleatorio || aleatorio2 == anterior || aleatorio2 == siguiente) {
            aleatorio2 = Util.generarAleatorio(esquemaViajero.getPuntos().size() - 1);
        }

        //Hacer el intercambio de Arcos entre el aleatorio2 y el arco siguiente del aleatorio1
        nuevaSolucion.mover(aleatorio2, siguiente);
        return nuevaSolucion;
    }

    /**
     * hace que la posicion recibida se comporte de manera circular. Si recibe un valor mayor
     * a la longitud de la solucion retornara 0, si es menor a 0 retornará la última posición
     * en otro caso retornará el mismo valor recibido.
     * @param posicion la posicion a normalizar
     * @return el valor normalizado
     */
    private int normalizar(int posicion) {
        if (posicion < 0) {
            return esquemaViajero.getPuntos().size() - 1;
        } else if (posicion >= esquemaViajero.getPuntos().size()) {
            return 0;
        } else {
            return posicion;
        }
    }

    public String getDescripcion() {
        return "Escoge aleatoriamente 2 arcos no adyacentes en la " +
                "solución actual y los intercambia entre sí";
    }
}
