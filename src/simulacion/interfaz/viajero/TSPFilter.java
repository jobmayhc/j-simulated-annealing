/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.interfaz.viajero;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import simulacion.Util;

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

        String extension = Util.getExtension(f);
        return extension != null && extension.equalsIgnoreCase("tsp");
    }

    @Override
    public String getDescription() {
        return "Archivos TSP(Agente Viajero)";
    }
}
