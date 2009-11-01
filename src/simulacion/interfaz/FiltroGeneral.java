/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.interfaz;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import simulacion.Util;

/**
 *
 * @author John Arevalo
 */
public class FiltroGeneral extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Util.getExtension(f);
        return extension != null &&
                (extension.equalsIgnoreCase("knp") || extension.equalsIgnoreCase("tsp"));
    }

    @Override
    public String getDescription() {
        return "Todos los archivos válidos (*.knp, *.tsp)";
    }
}
