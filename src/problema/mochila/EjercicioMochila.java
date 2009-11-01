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
import simulacion.Configuracion;
import simulacion.simulatedAnnealing.AnnealingException;
import simulacion.simulatedAnnealing.Ejercicio;
import simulacion.simulatedAnnealing.Solucion;

/**
 *
 * @author edilson
 */
public class EjercicioMochila implements Ejercicio {

    private EsquemaMochila mochila;
    private Configuracion configuracion;

    public EjercicioMochila(File archivo) throws AnnealingException {
        configuracion = new Configuracion();
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

    public void ejecutar() {
    }

    public Solucion getSolucionAleatoria() {
        return mochila.getSolucionAleatoria();
    }

    public void setConfiguracion(Configuracion configuracion) {
        this.configuracion = configuracion;
    }

    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public Solucion getMejorSolucion() {
        return null;
    }


}
