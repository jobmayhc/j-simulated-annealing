/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.simulatedAnnealing;

import java.io.File;
import simulacion.Configuracion;

/**
 *
 * @author John Arevalo
 */
public interface Ejercicio {

    /**
     * Carga un archivo de datos sobre el ejercicio actual
     * @param archivo el archivo a cargar
     * @throws AnnealingException si existe un error al cargar el archivo
     */
    public void cargarArchivo(File archivo) throws AnnealingException;

    public void setConfiguracion(Configuracion configuracion);

    public void ejecutar();

    public Solucion getSolucionAleatoria();

    public Solucion getMejorSolucion();

    public Configuracion getConfiguracion();
}
