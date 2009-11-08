/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.interfaz;

import javax.swing.SwingWorker;
import simulacion.simulatedAnnealing.Ejercicio;
import simulacion.simulatedAnnealing.OyenteAnnealing;
import simulacion.simulatedAnnealing.Solucion;

/**
 *
 * @author John Arevalo
 */
public class TareaEjecutar extends SwingWorker<Void, Void> {

    private Ejercicio ejercicio;

    public TareaEjecutar(Ejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    @Override
    protected Void doInBackground() throws Exception {
        ejercicio.agregarOyente(new OyenteAnnealing() {

            public void cambioSolucionActual(Solucion solucion, int iteracion) {
                setProgress(iteracion);
            }
        });
        ejercicio.resolver();

        return null;
    }
}
