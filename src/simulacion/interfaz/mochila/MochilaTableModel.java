/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacion.interfaz.mochila;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import problema.mochila.EjercicioMochila;
import problema.mochila.Objeto;
import problema.mochila.SolucionMochila;

/**
 *
 * @author John Arevalo
 */
public class MochilaTableModel extends AbstractTableModel {

    EjercicioMochila ejercicio;
    private String[] titulos;

    public MochilaTableModel(EjercicioMochila ejercicio) {
        this.ejercicio = ejercicio;
        titulos = new String[4];
        titulos[0] = "Nombre";
        titulos[1] = "Costo";
        titulos[2] = "Valor";
        titulos[3] = "En Mochila?";
    }

    public int getRowCount() {
        return ejercicio.getMochila().getObjetos().size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return titulos[columnIndex];
    }

    public int getColumnCount() {
        return titulos.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        SolucionMochila solucion = (SolucionMochila) ejercicio.getMejorSolucion();
        ArrayList<Objeto> objetos = ejercicio.getMochila().getObjetos();
        if (getColumnName(columnIndex).equals("Nombre")) {
            return objetos.get(rowIndex).getNombre();
        } else if (getColumnName(columnIndex).equals("Costo")) {
            return objetos.get(rowIndex).getCosto();
        } else if (getColumnName(columnIndex).equals("Valor")) {
            return objetos.get(rowIndex).getValor();
        } else if (getColumnName(columnIndex).equals("En Mochila?")) {
            return new Boolean(solucion.contiene(objetos.get(rowIndex)));
        } else {
            return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (getColumnName(columnIndex).equals("En Mochila?")) {
            return Boolean.class;
        } else {
            return super.getColumnClass(columnIndex);
        }
    }
}
