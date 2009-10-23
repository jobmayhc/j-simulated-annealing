/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.viajero;

/**
 *
 * @author John Arevalo
 */
public class Punto {

    public double x;
    public double y;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }

    /**
     * Calcula el costo desde este punto a un destino recibido
     * @param destino el destino
     * @return el costo entre este punto y el destino
     */
    public double getCostoA(Punto destino) {
        return Math.sqrt(Math.pow(this.x - destino.x, 2) +
                Math.pow(this.y - destino.y, 2));
    }
}
