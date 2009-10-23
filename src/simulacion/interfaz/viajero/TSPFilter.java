/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.interfaz.viajero;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author microsoft
 */
public class TSPFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = getExtension(f);
        return extension != null && extension.equalsIgnoreCase("tsp");
    }

    @Override
    public String getDescription() {
        return "Archivos TSP(Agente Viajero)";
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
