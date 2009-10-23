/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.mochila;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author John Arevalo
 */
public class HandlerMochila {

    public static EsquemaMochila cargar(File archivo) throws Exception {
        EsquemaMochila esquema = new EsquemaMochila();
        FileReader lectorArchivo = new FileReader(archivo);
        BufferedReader flujoLectura = new BufferedReader(lectorArchivo);
        String linea = null;
        String[] partesLinea;
        Objeto objeto;
        //Leyendo la capacidad en la primera fila
        /*linea = flujoLectura.readLine();
        try {
            esquema.setCapacidad(Double.parseDouble(
                    linea.split(" ")[1]));
        } catch (Exception exc) {
            exc.printStackTrace();
        }*/

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
            esquema.agregarObjeto(objeto);
        }
        return esquema;
    }
}
