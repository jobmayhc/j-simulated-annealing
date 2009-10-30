/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion;

import java.io.File;

/**
 *
 * @author John Arevalo
 */
public class Util {

    /**
     * genera un numero alatorio entre 0 y el limite incluido
     * @param limite
     * @return
     */
    public static int generarAleatorio(int limite) {
        return (int) Math.floor(Math.random() * limite);
    }

    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }
}
