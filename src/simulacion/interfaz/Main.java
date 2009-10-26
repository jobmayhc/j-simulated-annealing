/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Main.java
 *
 * Created on 16/09/2009, 12:22:59 PM
 */
package simulacion.interfaz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.netbeans.api.visual.widget.Widget;
import org.openide.util.Exceptions;
import problema.mochila.EsquemaMochila;
import problema.mochila.HandlerMochila;
import problema.viajero.HandlerViajero;
import problema.viajero.EsquemaViajero;
import problema.viajero.Punto;
import problema.viajero.SolucionViajero;
import problema.viajero.vecindad.AleatorioDoble;
import simulacion.interfaz.viajero.TSPFilter;
import simulacion.simulatedAnnealing.EsquemaVecindad;
import simulacion.simulatedAnnealing.OyenteAnnealing;
import simulacion.simulatedAnnealing.SimulatedAnnealing;
import simulacion.simulatedAnnealing.Solucion;

/**
 *
 * @author John Arevalo
 * @author Jenny Bernal
 *
 */
public class Main extends javax.swing.JFrame implements OyenteAnnealing {

    /** Creates new form Main */
    private File archivo;
    private FileWriter registro;
    private EsquemaViajero viajero;
    private EsquemaVecindad esquemaVecindad;
    private SimulatedAnnealing algoritmo;
    private EsquemaMochila mochila;
    private GrafoViajeroScene grafoViajero;

    public Main() throws IOException {
        grafoViajero = new GrafoViajeroScene();
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAbrirViajero = new javax.swing.JMenuItem();
        menuAbrirMochila = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Algoritmos de Simulacion");
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simulacion/interfaz/imagenes/abrirarchivo.png"))); // NOI18N
        jButton1.setToolTipText("Abrir Archivo...");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/simulacion/interfaz/imagenes/ejecutar.png"))); // NOI18N
        jButton2.setToolTipText("Ejecutar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(jToolBar1, gridBagConstraints);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(jPanel3);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        jMenu1.setText("Archivo");

        menuAbrirViajero.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuAbrirViajero.setText("Abrir Archivo...");
        menuAbrirViajero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirViajeroActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbrirViajero);

        menuAbrirMochila.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        menuAbrirMochila.setText("Abrir Mochila...");
        menuAbrirMochila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAbrirMochilaActionPerformed(evt);
            }
        });
        jMenu1.add(menuAbrirMochila);

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        menuSalir.setText("Salir");
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(menuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edicion");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("ejecutar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAbrirViajeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirViajeroActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new TSPFilter());
        fileChooser.showOpenDialog(this);
        if ((archivo = fileChooser.getSelectedFile()) == null) {
            return;
        }
        try {
            viajero = HandlerViajero.cargar(archivo);
            dibujarNodos();

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar el archivo:" + ex.getMessage(),
                    "Error en carga",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuAbrirViajeroActionPerformed

    private void dibujarNodos() {

        //TODO: implementar zoom
        Widget nodo;
        for (Punto punto : viajero.getPuntos()) {
            nodo = grafoViajero.addNode(punto);
            nodo.setPreferredLocation(viajero.trasladar(punto, jPanel3.getBounds()));
        }

        jPanel3.add(grafoViajero.createView(), java.awt.BorderLayout.CENTER);
    }

    private void dibujarSolucion() {

        SolucionViajero solucionViajero = (SolucionViajero) algoritmo.getSolucion();
        Punto anterior = solucionViajero.getRuta().get(0);
        Arco arco;
        for (Punto punto : solucionViajero.getRuta()) {
            arco = new Arco(anterior.getCostoA(punto));
            grafoViajero.addEdge(arco);
            grafoViajero.setEdgeSource(arco, anterior);
            grafoViajero.setEdgeTarget(arco, punto);
            anterior = punto;
        }
        arco = new Arco(anterior.getCostoA(solucionViajero.getRuta().get(0)));
        grafoViajero.addEdge(arco);
        grafoViajero.setEdgeSource(arco, anterior);
        grafoViajero.setEdgeTarget(arco, solucionViajero.getRuta().get(0));
    }

    public void cambioSolucionActual(Solucion solucion) {
        try {
            registro.write(NumberFormat.getInstance().format(solucion.getCosto()) + "\n");
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuAbrirMochilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAbrirMochilaActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        if ((archivo = fileChooser.getSelectedFile()) == null) {
            return;
        }
        try {
            mochila = HandlerMochila.cargar(archivo);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cargar el archivo:" + ex.getMessage(),
                    "Error en carga",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuAbrirMochilaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        esquemaVecindad = new AleatorioDoble(viajero);
        try {
            registro = new FileWriter(File.createTempFile("tsp", ".tmp"));
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        algoritmo = new SimulatedAnnealing(esquemaVecindad);
        algoritmo.setOyente(this);
        algoritmo.setTipoProblema(SimulatedAnnealing.MINIMIZACION);
        algoritmo.setEsquemaReduccion(SimulatedAnnealing.REDUCCION_POR_ITERACION);
        algoritmo.setIteracionesDiferenteTemperatura(1000);
        algoritmo.setIteracionesMismaTemperatura(200);
        algoritmo.setTemperatura(10);
        algoritmo.ejecutar(viajero.getSolucionAleatoria());

        try {
            registro.flush();
            registro.close();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

        dibujarSolucion();
        System.out.println("Mejor Solucion" + algoritmo.getSolucion());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        menuAbrirViajeroActionPerformed(evt);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jMenuItem1ActionPerformed(evt);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception exc) {
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem menuAbrirMochila;
    private javax.swing.JMenuItem menuAbrirViajero;
    private javax.swing.JMenuItem menuSalir;
    // End of variables declaration//GEN-END:variables
}
