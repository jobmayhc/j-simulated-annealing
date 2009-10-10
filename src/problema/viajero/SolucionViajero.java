/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.viajero;

import java.util.ArrayList;
import java.util.List;
import simulacion.simulatedAnnealing.Solucion;

/**
 *
 * @author John Arevalo
 */
public class SolucionViajero implements Solucion {

    List<Punto> ruta;

    public SolucionViajero() {
        ruta = new ArrayList<Punto>();
    }

    public void agregarPunto(Punto punto) {
        ruta.add(punto);
    }

    public double getCosto() {
        double costo = 0;
        Punto anterior = ruta.get(0);
        for (Punto punto : ruta) {
            costo += punto.getCostoA(anterior);
            anterior = punto;
        }

        return costo;
    }
}
