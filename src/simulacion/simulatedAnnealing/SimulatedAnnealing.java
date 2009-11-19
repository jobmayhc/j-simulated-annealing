/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.simulatedAnnealing;

import java.util.ArrayList;

/**
 *
 * @author John Arevalo
 */
public class SimulatedAnnealing {

    /**
     * se reduce de acuerdo a:
     * <code>temperatura = temperatura / iteracion</code>
     */
    public static final int REDUCCION_POR_ITERACION = 1;
    /**
     * se reduce de acuerdo a:
     * <code>temperatura = ALFA * temperatura</code>
     * con una constante <code>ALFA</code> cercano a 1
     */
    public static final int REDUCCION_POR_FACTOR = 2;
    /**
     * se reduce de acuerdo a:
     * <code>temperatura = temperatura / (1 + BETA * temperatura)</code>
     * con una constante <code>BETA</code> cercano a cero
     */
    public static final int REDUCCION_POR_COCIENTE = 3;
    public static final int MINIMIZACION = 1;
    public static final int MAXIMIZACION = 2;
    private double alfa = 0.9999;
    private double beta = 0.01;
    private double delta;
    private Solucion solucionActual;
    private Solucion mejorSolucion;
    private Solucion solucionVecina;
    private int iteracionesDiferenteTemperatura;
    private int iteracionesMismaTemperatura;
    private int esquemaReduccion;
    private EsquemaVecindad vecindad;
    private double temperatura;
    private double temperaturaInicial;
    private int tipoProblema;
    private ArrayList<OyenteAnnealing> oyentes;

    public SimulatedAnnealing() {

        oyentes = new ArrayList<OyenteAnnealing>();
    }

    /**
     * Limpia todos los parametros
     */
    public void reset() {
        delta = 0.0;
        solucionActual = null;
        mejorSolucion = null;
        solucionVecina = null;
        iteracionesDiferenteTemperatura = 0;
        iteracionesMismaTemperatura = 0;
        esquemaReduccion = 0;
        vecindad = null;
        temperatura = 0.0;
        temperaturaInicial = 0.0;
        tipoProblema = 0;
        alfa = 0;
        beta = 0;
    }

    public void setEsquemaVecindad(EsquemaVecindad vecindad) {
        this.vecindad = vecindad;
    }

    public int getTipoProblema() {
        return tipoProblema;
    }

    /**
     * define si es un ejecicio para buscar el costo más alto o el más bajo
     * los parametros validos son {@link #MAXIMIZACION} o {@link #MAXIMIZACION}
     * por omision se toma MINIMIZACION
     * @see #MAXIMIZACION
     * @see #MINIMIZACION
     * @param tipoProblema
     */
    public void setTipoProblema(int tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public int getEsquemaReduccion() {
        return esquemaReduccion;
    }

    public void setEsquemaReduccion(int esquemaReduccion) {
        this.esquemaReduccion = esquemaReduccion;
    }

    public double getTemperatura() {
        return temperatura;
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

    public void setTemperatura(double temperatura) {
        temperaturaInicial = temperatura;
        this.temperatura = temperatura;
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

    public void agregarOyente(OyenteAnnealing oyente) {
        if (!oyentes.contains(oyente)) {
            oyentes.add(oyente);
        }
    }

    public Solucion getSolucion() {
        return mejorSolucion;
    }

    /**
     * Ejecuta el algoritmo para obtener la mejor Solucion
     * @param solucionInicial la solucion con la que inicia el algoritmo
     */
    public void ejecutar(Solucion solucionInicial) {
        solucionActual = solucionInicial;
        mejorSolucion = solucionActual;

        for (int i = 0; i < iteracionesDiferenteTemperatura; i++) {
            for (int j = 0; j < iteracionesMismaTemperatura; j++) {
                solucionVecina = vecindad.getVecino(solucionActual);
                delta = solucionVecina.getCosto() - solucionActual.getCosto();
                if (tipoProblema == MAXIMIZACION) {
                    maximizar();
                } else {
                    minimizar();
                }
            }
            dispararEvento(solucionActual, i);
            reducir(i);
        }
    }

    /**
     * reduce la temperatura de acuerdo al esquema de reduccion seleccionado.
     *
     * @param iteracion si utiliza el esquema {@link #REDUCCION_POR_ITERACION}
     */
    private void reducir(double iteracion) {
        switch (esquemaReduccion) {
            case REDUCCION_POR_COCIENTE:
                temperatura = temperatura / (1 + beta * temperatura);
                break;
            case REDUCCION_POR_FACTOR:
                temperatura = alfa * temperatura;
                break;
            case REDUCCION_POR_ITERACION:
                temperatura = temperaturaInicial / iteracion;
                break;
        }
    }

    private void minimizar() {
        if (delta < 0) {
            solucionActual = solucionVecina;
            if (solucionActual.getCosto() < mejorSolucion.getCosto()) {
                mejorSolucion = solucionActual;
            }
        } else {
            if (Math.random() < Math.exp(-delta / temperatura)) {
                solucionActual = solucionVecina;
            }
        }
    }

    private void maximizar() {
        if (delta > 0) {
            solucionActual = solucionVecina;
            if (solucionActual.getCosto() > mejorSolucion.getCosto()) {
                mejorSolucion = solucionActual;
            }
        } else {
            if (Math.random() < Math.exp(delta / temperatura)) {
                solucionActual = solucionVecina;
            }
        }
    }

    private void dispararEvento(Solucion solucion, int iteracion) {
        for (OyenteAnnealing oyente : oyentes) {
            oyente.cambioSolucionActual(solucion, iteracion);
        }
    }
}
