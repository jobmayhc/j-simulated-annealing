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
public class EsquemaMochila {

    private ArrayList<Objeto> objetos;
    private String nombre;
    private String comentario;
    private double capacidad;
    /**
     * min (C, (sumatoria C sub j) - C)
     * -1 es que no ha sido definida
     */
    private double delta = 0;

    public EsquemaMochila() {
        objetos = new ArrayList<Objeto>();
    }

    public ArrayList<Objeto> getObjetos() {
        return objetos;
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

    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getDelta() {
        return delta;
    }

    private void calcularDelta() {
        delta = 0;
        double sumatoriaCosto = 0;
        for (Objeto objeto : objetos) {
            sumatoriaCosto = sumatoriaCosto + objeto.getCosto();
        }
        delta = Math.min(capacidad, sumatoriaCosto);
    }

    @SuppressWarnings("unchecked")
    public Solucion getSolucionAleatoria() {
        calcularDelta();
        SolucionMochila solucionAleatoria = new SolucionMochila(capacidad, delta);

        for (Objeto objeto : objetos) {
            if (Math.random() <= 0.5) {
                solucionAleatoria.agregarObjeto(objeto);
            }
        }

        return solucionAleatoria;
    }
}
