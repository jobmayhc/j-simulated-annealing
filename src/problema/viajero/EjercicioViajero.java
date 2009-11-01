/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.viajero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.openide.util.Exceptions;
import simulacion.Configuracion;
import simulacion.simulatedAnnealing.AnnealingException;
import simulacion.simulatedAnnealing.Ejercicio;
import simulacion.simulatedAnnealing.EsquemaVecindad;
import simulacion.simulatedAnnealing.SimulatedAnnealing;
import simulacion.simulatedAnnealing.Solucion;

/**
 *
 * @author John Arevalo
 */
public class EjercicioViajero implements Ejercicio {

    private EsquemaViajero viajero;
    private Configuracion configuracion;
    private SimulatedAnnealing algoritmo;

    public EjercicioViajero(File archivo) throws AnnealingException {
        configuracion = new Configuracion();
        cargarArchivo(archivo);
    }

    public void cargarArchivo(File archivo) throws AnnealingException {
        FileReader lectorArchivo = null;
        try {
            viajero = new EsquemaViajero();
            lectorArchivo = new FileReader(archivo);
            BufferedReader flujoLectura = new BufferedReader(lectorArchivo);
            String linea = null;
            String[] partesLinea;
            Punto punto;
            while ((linea = flujoLectura.readLine()) != null) {
                linea = linea.replaceAll("\\s+", " ");
                punto = new Punto();
                try {
                    partesLinea = linea.trim().split(" ");
                    punto.setNombre(partesLinea[0]);
                    punto.x = Double.parseDouble(partesLinea[1]);
                    punto.y = Double.parseDouble(partesLinea[2]);
                    viajero.agregarPunto(punto);
                } catch (Exception exc) {
                    System.err.println(exc.getMessage());
                }
            }
        } catch (Exception ex) {
            throw new AnnealingException(ex);
        } finally {
            try {
                lectorArchivo.close();
            } catch (IOException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public void ejecutar() {
        EsquemaVecindad esquemaVecindad = configuracion.crearEsquemaVecindad(viajero);

        algoritmo = new SimulatedAnnealing(esquemaVecindad);
        algoritmo.setTipoProblema(SimulatedAnnealing.MINIMIZACION);
        algoritmo.setEsquemaReduccion(configuracion.getEsquemaReduccion());
        algoritmo.setIteracionesDiferenteTemperatura(configuracion.getIteracionesDiferenteTemperatura());
        algoritmo.setIteracionesMismaTemperatura(configuracion.getIteracionesMismaTemperatura());
        algoritmo.setTemperatura(configuracion.getTemperaturaInicial());
        algoritmo.ejecutar(viajero.getSolucionAleatoria());
    }

    public Solucion getSolucionAleatoria() {
        return viajero.getSolucionAleatoria();
    }

    public Solucion getMejorSolucion() {
        return algoritmo.getSolucion();
    }

    public EsquemaViajero getViajero() {
        return viajero;
    }

    public void setViajero(EsquemaViajero viajero) {
        this.viajero = viajero;
    }
}
