/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.simulatedAnnealing;

import java.io.File;
import java.util.ArrayList;
import simulacion.Configuracion;

/**
 *
 * @author John Arevalo
 */
public abstract class Ejercicio implements OyenteAnnealing {

    protected Configuracion configuracion;
    protected SimulatedAnnealing algoritmo;
    private ArrayList<Double> historicoSolucion;

    public Ejercicio() {
        historicoSolucion = new ArrayList<Double>();
    }

    /**
     * Carga un archivo de datos sobre el ejercicio actual
     * @param archivo el archivo a cargar
     * @throws AnnealingException si existe un error al cargar el archivo
     */
    public abstract void cargarArchivo(File archivo) throws AnnealingException;

    public void resolver() {
        historicoSolucion.clear();
        ejecutarAlgoritmo();
    }

    protected abstract void ejecutarAlgoritmo();

    public abstract Solucion getSolucionAleatoria();

    public Solucion getMejorSolucion() {
        return algoritmo.getSolucion();
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    public void cambioSolucionActual(Solucion solucion, int iteracion) {
        historicoSolucion.add(solucion.getCosto());
    }

    public ArrayList<Double> getHistoricoSolucion() {
        return historicoSolucion;
    }

    public void agregarOyente(OyenteAnnealing oyente) {
        algoritmo.agregarOyente(oyente);
    }
}
