/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.interfaz;

/**
 *
 * @author edilson
 */
public class Arco {

    private double costo;

    Arco(double costo) {
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
