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
    private Double penalizacion;
    private double capacidadTotal;

    public SolucionMochila(double capacidadTotal, double delta) {
        this.capacidadTotal = capacidadTotal;
        this.delta = delta;
    }

    /**
     * Crea una copia de la solucion recibida
     * @param solucion
     */
    public SolucionMochila(SolucionMochila solucion) {
        super();
        this.capacidadTotal = solucion.capacidadTotal;
        this.delta = solucion.delta;
        for (Objeto objeto : solucion.objetos) {
            this.agregarObjeto(objeto);
        }
    }

    public double getCosto() {
        calcularPenalizacion();
        double sumatoriaValor = 0;
        for (Objeto objeto : objetos) {
            sumatoriaValor = sumatoriaValor + objeto.getValor();
        }

        return sumatoriaValor * penalizacion;
    }

    private void calcularPenalizacion() {
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

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for (Objeto objeto : objetos) {
            buffer.append(objeto.getNombre() + ",");
        }
        return buffer.toString() + "; costo = " + getCosto();
    }
}
