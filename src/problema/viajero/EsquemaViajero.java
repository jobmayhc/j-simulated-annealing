/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.viajero;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author John Arevalo
 */
public class EsquemaViajero {

    private ArrayList<Punto> puntos;
    private String nombre;
    private String comentario;

    public EsquemaViajero() {
        puntos = new ArrayList<Punto>();
    }

    public ArrayList<Punto> getPuntos() {
        return puntos;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarPunto(Punto punto) {
        puntos.add(punto);
    }

    @SuppressWarnings("unchecked")
    public SolucionViajero getSolucionAleatoria() {
        SolucionViajero solucionAleatoria = new SolucionViajero();
        ArrayList<Punto> rutaAleatoria = (ArrayList<Punto>) puntos.clone();

        Collections.shuffle(rutaAleatoria);
        for (Punto punto : rutaAleatoria) {
            solucionAleatoria.agregarPunto(punto);
        }

        return solucionAleatoria;
    }
}
