/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.io.Serializable;
import simulacion.simulatedAnnealing.EsquemaVecindad;

/**
 *
 * @author jhon.arevalo
 */
public class Configuracion implements Serializable {

    private int esquemaReduccion;
    private Class vecindadViajero;
    private int vecindadMochila;
    private double capacidadMochila;
    private double temperaturaInicial;
    private int iteracionesDiferenteTemperatura;
    private int iteracionesMismaTemperatura;

    public Configuracion() {
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

    public EsquemaVecindad crearEsquemaViajero() {
        return null;
    }
}
