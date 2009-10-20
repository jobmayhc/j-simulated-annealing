/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.viajero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author John Arevalo
 */
public class HandlerViajero {

    public static EsquemaViajero cargar(File archivo) throws Exception {
        EsquemaViajero esquema = new EsquemaViajero();
        FileReader lectorArchivo = new FileReader(archivo);
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
                esquema.agregarPunto(punto);
            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }

        }
        return esquema;
    }
}
