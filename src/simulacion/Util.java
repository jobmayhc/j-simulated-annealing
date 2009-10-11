/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

/**
 *
 * @author edilson
 */
public class Util {

    /**
     * genera un numero alatorio entre 0 y el limite incluido
     * @param limite
     * @return
     */
    public static int generarAleatorio(int limite) {
        return (int) Math.floor(Math.random() * limite);
    }
}
