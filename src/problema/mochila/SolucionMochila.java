/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.mochila;

import java.util.ArrayList;
import simulacion.simulatedAnnealing.Solucion;

/**
 *
 * @author John Arevalo
 */
public class SolucionMochila implements Solucion {

    private ArrayList<Objeto> objetos = new ArrayList<Objeto>();
    private double delta;
    private double penalizacion;
    private double capacidadTotal;

    public SolucionMochila(double capacidadTotal) {
        this.capacidadTotal = capacidadTotal;
    }

    /**
     * Crea una copia de la solucion recibida
     * @param solucion
     */
    public SolucionMochila(SolucionMochila solucion, double capacidadTotal) {
        super();
        this.capacidadTotal = capacidadTotal;
        for (Objeto objeto : solucion.objetos) {
            this.agregarObjeto(objeto);
        }
        calcularPenalizacion();
    }

    public double getCosto() {
        double sumatoriaValor = 0;
        for (Objeto objeto : objetos) {
            sumatoriaValor = sumatoriaValor + objeto.getValor();
        }

        return sumatoriaValor * penalizacion;
    }

    public void calcularPenalizacion() {
        double sumatoriaCosto = 0;
        for (Objeto objeto : objetos) {
            sumatoriaCosto = sumatoriaCosto + objeto.getCosto();
        }
        penalizacion = 1 - Math.abs(sumatoriaCosto - capacidadTotal) / delta;
    }

    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    /**
     * Intercambia el objeto recibido, si está en la mochila lo saca, sino existe
     * lo ingresa
     * @param objeto el objeto a intercambiar
     */
    public void intercambiar(Objeto objeto) {
        if (objetos.contains(objeto)) {
            objetos.remove(objeto);
        } else {
            objetos.add(objeto);
        }

    }
}
