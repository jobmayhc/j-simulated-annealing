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

    private List<Punto> ruta;

    public SolucionViajero() {
        ruta = new ArrayList<Punto>();
    }

    /**
     * Crea una copia de la solucion recibida
     * @param solucion
     */
    public SolucionViajero(SolucionViajero solucion) {
        ruta = new ArrayList<Punto>();
        for (Punto punto : solucion.ruta) {
            this.agregarPunto(punto);
        }
    }

    public void agregarPunto(Punto punto) {
        ruta.add(punto);
    }

    /**
     * Obtiene el costo de esta solucion
     * @return el costo de la solucion
     */
    public double getCosto() {
        double costo = 0;
        if (!ruta.isEmpty()) {
            Punto anterior = ruta.get(0);
            for (Punto punto : ruta) {
                costo += punto.getCostoA(anterior);
                anterior = punto;
            }

            //Sumar el costo del ultimo punto al punto inicial
            costo += anterior.getCostoA(ruta.get(0));

        }
        return costo;
    }

    /**
     * intercambia 2 puntos en esta solucion.
     * @param posicion1
     * @param posicion2
     */
    public void intercambiar(int posicion1, int posicion2) {
        Punto temporal = ruta.get(posicion1);
        ruta.set(posicion1, ruta.get(posicion2));
        ruta.set(posicion2, temporal);
    }

    /**
     * mueve un punto de la solucion
     * @param posicionInicial posicion de origen dentro de la solucion
     * @param destino posicion destino dentro de la solucion
     */
    public void mover(int posicionInicial, int destino) {
        Punto punto = ruta.get(posicionInicial);
        ruta.remove(posicionInicial);
        ruta.add(destino, punto);
    }

    public boolean contiene(Punto punto) {
        return ruta.contains(punto);
    }

    public List<Punto> getRuta() {
        return ruta;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Punto punto : ruta) {
            buffer.append(punto.getNombre() + ";");
        }
        return buffer.toString() + "; Costo: " + getCosto();
    }
}
