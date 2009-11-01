/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.simulatedAnnealing;

/**
 *
 * @author John Arevalo
 */
public class AnnealingException extends Exception {

    public AnnealingException(String mensaje) {
        super(mensaje);
    }

    public AnnealingException() {
    }

    public AnnealingException(Throwable arg0) {
        super(arg0);
    }
}
