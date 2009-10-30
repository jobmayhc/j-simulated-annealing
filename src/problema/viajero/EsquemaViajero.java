/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.viajero;

import java.awt.Point;
import java.awt.Rectangle;
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

    private double getMinX() {
        double minX = puntos.get(0).x;
        for (Punto punto : puntos) {
            if (minX > punto.x) {
                minX = punto.x;
            }
        }
        return minX;
    }

    private double getAncho() {
        double maxX = puntos.get(0).x;
        for (Punto punto : puntos) {
            if (maxX < punto.x) {
                maxX = punto.x;
            }
        }
        return maxX - getMinX();
    }

    private double getMinY() {
        double minY = puntos.get(0).y;
        for (Punto punto : puntos) {
            if (minY > punto.y) {
                minY = punto.y;
            }
        }
        return minY;
    }

    private double getAlto() {
        double maxY = puntos.get(0).y;
        for (Punto punto : puntos) {
            if (maxY < punto.y) {
                maxY = punto.y;
            }
        }
        return maxY - getMinY();
    }

    public Rectangle getSistemaCoordenadas() {
        return new Rectangle((int) getMinX(), (int) getMinY(), (int) getAncho(), (int) getAlto());
    }

    public Point trasladar(Punto punto, Rectangle limites) {
        double razonX = (punto.x - getMinX()) / getAncho();
        double razonY = (punto.y - getMinY()) / getAlto();
        return new Point((int) ((limites.width - 80) * razonX), (int) ((limites.height - 80) * razonY));
    }
}
