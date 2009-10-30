/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import org.openide.util.Exceptions;
import problema.viajero.EsquemaViajero;
import problema.viajero.vecindad.AleatorioDoble;
import simulacion.simulatedAnnealing.EsquemaVecindad;
import simulacion.simulatedAnnealing.SimulatedAnnealing;

/**
 *
 * @author John Arevalo
 */
public class Configuracion implements Serializable {

    private int esquemaReduccion;
    private Class vecindadViajero;
    private int vecindadMochila;
    private double capacidadMochila;
    private double temperaturaInicial;
    private int iteracionesDiferenteTemperatura;
    private int iteracionesMismaTemperatura;
    private double alfa;
    private double beta;

    public Configuracion() {
        //valores por omision
        vecindadViajero = AleatorioDoble.class;
        capacidadMochila = 50;
        temperaturaInicial = 10;
        iteracionesMismaTemperatura = 200;
        iteracionesDiferenteTemperatura = 1000;
        alfa = 0.99;
        beta = 0.001;
        esquemaReduccion = SimulatedAnnealing.REDUCCION_POR_ITERACION;


    }

    public double getCapacidadMochila() {
        return capacidadMochila;
    }

    public void setCapacidadMochila(double capacidadMochila) {
        this.capacidadMochila = capacidadMochila;
    }

    public int getEsquemaReduccion() {
        return esquemaReduccion;
    }

    public void setEsquemaReduccion(int esquemaReduccion) {
        this.esquemaReduccion = esquemaReduccion;
    }

    public int getIteracionesDiferenteTemperatura() {
        return iteracionesDiferenteTemperatura;
    }

    public void setIteracionesDiferenteTemperatura(int iteracionesDiferenteTemperatura) {
        this.iteracionesDiferenteTemperatura = iteracionesDiferenteTemperatura;
    }

    public int getIteracionesMismaTemperatura() {
        return iteracionesMismaTemperatura;
    }

    public void setIteracionesMismaTemperatura(int iteracionesMismaTemperatura) {
        this.iteracionesMismaTemperatura = iteracionesMismaTemperatura;
    }

    public double getTemperaturaInicial() {
        return temperaturaInicial;
    }

    public void setTemperaturaInicial(double temperaturaInicial) {
        this.temperaturaInicial = temperaturaInicial;
    }

    public int getVecindadMochila() {
        return vecindadMochila;
    }

    public void setVecindadMochila(int vecindadMochila) {
        this.vecindadMochila = vecindadMochila;
    }

    public Class getVecindadViajero() {
        return vecindadViajero;
    }

    public void setVecindadViajero(Class vecindadViajero) {
        this.vecindadViajero = vecindadViajero;
    }

    public double getAlfa() {
        return alfa;
    }

    public void setAlfa(double alfa) {
        this.alfa = alfa;
    }

    public double getBeta() {
        return beta;
    }

    public void setBeta(double beta) {
        this.beta = beta;
    }

    @SuppressWarnings("unchecked")
    public EsquemaVecindad crearEsquemaVecindad(EsquemaViajero viajero) {
        try {
            Constructor constructor = vecindadViajero.getConstructor(EsquemaViajero.class);
            return (EsquemaVecindad) constructor.newInstance(viajero);
        } catch (Exception ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }
}
