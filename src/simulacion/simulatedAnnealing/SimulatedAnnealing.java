/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.simulatedAnnealing;

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
    public static final double ALFA = 0.93;
    public static final double BETA = 0.07;
    private double delta;
    Solucion solucionActual;
    Solucion mejorSolucion;
    Solucion solucionVecina;
    private int iteracionesDiferenteTemperatura;
    private int iteracionesMismaTemperatura;
    private int esquemaReduccion;
    EsquemaVecindad vecindad;
    private double temperatura;

    /**
     * Ejecuta el algoritmo para obtener la mejor Solucion
     */
    public void ejecutar() {
        mejorSolucion = solucionActual;
        double aleatorio;
        for (int i = 0; i < iteracionesDiferenteTemperatura; i++) {
            for (int j = 0; j < iteracionesMismaTemperatura; j++) {
                solucionVecina = vecindad.getVecino(solucionActual);
                delta = solucionVecina.getCosto() - solucionActual.getCosto();
                if (delta < 0) {
                    solucionActual = solucionVecina;
                    if (solucionActual.getCosto() < mejorSolucion.getCosto()) {
                        mejorSolucion = solucionActual;
                    }
                } else {
                    aleatorio = Math.random();
                    if (aleatorio < Math.exp(delta / temperatura)) {
                        solucionActual = solucionVecina;
                    }
                }

            }
            reducir(i);
        }
    }

    public int getEsquemaReduccion() {
        return esquemaReduccion;
    }

    public void setEsquemaReduccion(int esquemaReduccion) {
        this.esquemaReduccion = esquemaReduccion;
    }

    /**
     * reduce la temperatura de acuerdo al esquema de reduccion seleccionado.
     *
     * @param iteracion si utiliza el esquema {@link #REDUCCION_POR_ITERACION}
     */
    private void reducir(double iteracion) {
        switch (esquemaReduccion) {
            case REDUCCION_POR_COCIENTE:
                temperatura = temperatura / (1 + BETA * temperatura);
                break;
            case REDUCCION_POR_FACTOR:
                temperatura = ALFA * temperatura;
                break;
            case REDUCCION_POR_ITERACION:
                temperatura = temperatura / iteracion;
                break;
        }
    }
}
