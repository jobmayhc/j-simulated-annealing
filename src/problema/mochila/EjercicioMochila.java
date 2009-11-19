/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.mochila;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.openide.util.Exceptions;
import problema.mochila.vecindad.IntercambioObjeto;
import simulacion.simulatedAnnealing.AnnealingException;
import simulacion.simulatedAnnealing.Ejercicio;
import simulacion.simulatedAnnealing.SimulatedAnnealing;
import simulacion.simulatedAnnealing.Solucion;

/**
 *
 * @author John Arevalo
 */
public class EjercicioMochila extends Ejercicio {

    private EsquemaMochila mochila;

    public EjercicioMochila(File archivo) throws AnnealingException {
        cargarArchivo(archivo);
    }

    public void cargarArchivo(File archivo) throws AnnealingException {

        mochila = new EsquemaMochila();
        FileReader lectorArchivo = null;
        BufferedReader flujoLectura;
        String linea = null;
        Objeto objeto;
        String[] partesLinea;

        try {
            lectorArchivo = new FileReader(archivo);
            flujoLectura = new BufferedReader(lectorArchivo);

            while ((linea = flujoLectura.readLine()) != null) {
                objeto = new Objeto();
                try {
                    partesLinea = linea.split(" ");
                    objeto.setNombre(partesLinea[0]);
                    objeto.setCosto(Double.parseDouble(partesLinea[1]));
                    objeto.setValor(Double.parseDouble(partesLinea[2]));
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
                mochila.agregarObjeto(objeto);
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
        mochila.setCapacidad(configuracion.getCapacidadMochila());

        //Evaluar si la mochila tiene capacidad para todos los objetos
        if (configuracion.getCapacidadMochila() > mochila.getSumatoriaCosto()) {
            algoritmo.setIteracionesDiferenteTemperatura(0);
            algoritmo.ejecutar(mochila.getSolucionConTodos());
        } else {
            algoritmo.reset();
            algoritmo.setEsquemaVecindad(new IntercambioObjeto(mochila));
            algoritmo.setTipoProblema(SimulatedAnnealing.MAXIMIZACION);
            algoritmo.setEsquemaReduccion(configuracion.getEsquemaReduccion());
            algoritmo.setIteracionesDiferenteTemperatura(configuracion.getIteracionesDiferenteTemperatura());
            algoritmo.setIteracionesMismaTemperatura(configuracion.getIteracionesMismaTemperatura());
            algoritmo.setTemperatura(configuracion.getTemperaturaInicial());
            algoritmo.setAlfa(configuracion.getAlfa());
            algoritmo.setBeta(configuracion.getBeta());
            algoritmo.ejecutar(mochila.getSolucionAleatoria());
        }
    }

    public Solucion getSolucionAleatoria() {
        return mochila.getSolucionAleatoria();
    }

    public EsquemaMochila getMochila() {
        return mochila;
    }
}
