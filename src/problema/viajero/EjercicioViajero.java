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
import simulacion.simulatedAnnealing.AnnealingException;
import simulacion.simulatedAnnealing.Ejercicio;
import simulacion.simulatedAnnealing.EsquemaVecindad;
import simulacion.simulatedAnnealing.SimulatedAnnealing;
import simulacion.simulatedAnnealing.Solucion;

/**
 *
 * @author John Arevalo
 */
public class EjercicioViajero extends Ejercicio {

    private EsquemaViajero viajero;

    public EjercicioViajero(File archivo) throws AnnealingException {
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

    public void ejecutarAlgoritmo() {
        EsquemaVecindad esquemaVecindad = configuracion.crearEsquemaVecindad(viajero);

        algoritmo.reset();

        algoritmo.setEsquemaVecindad(esquemaVecindad);
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

    public EsquemaViajero getViajero() {
        return viajero;
    }

    public void setViajero(EsquemaViajero viajero) {
        this.viajero = viajero;
    }
}
