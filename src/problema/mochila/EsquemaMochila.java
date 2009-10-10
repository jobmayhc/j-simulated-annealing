/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.mochila;

import java.util.ArrayList;

/**
 *
 * @author John Arevalo
 */
public class EsquemaMochila {

    private ArrayList<Objeto> objetos;
    private String nombre;
    private String comentario;
    private double capacidad;

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

    public void getCosto() {
    }
}
