/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.simulatedAnnealing;

/**
 *
 * @author John Arevalo
 */
public interface EsquemaVecindad {

    /**
     * obtiene una solucion vecina utilizando este esquema de vecindad
     * @param solucionActual
     * @return
     */
    public Solucion getVecino(Solucion solucionActual);

    /**
     * describe la política de selección de este esquema de vecindad
     * @return
     */
    public String getDescripcion();
}
