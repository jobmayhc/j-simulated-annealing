/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package problema.mochila;

/**
 *
 * @author jhon.arevalo
 */
/**
 * @(#)TabuTSP.java
 *
 *
 * @author
 * @version 1.00 2009/8/7
 */
import java.io.*;

class SAMochila2 {

    static int xactual[];
    static int v[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    static int c[] = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
    static int xnuevo[];
    static int xmejor[];
    static int C = 50;
    static int del, sumpesos = 0;

    public static void main(String args[]) {

        double T0, T, factual, fnuevo, delta;

        int n, i, j, m, pos;
        double y[];

        System.out.print("Por favor digite el numero de temperaturas diferentes: ");
        n = 200;

        System.out.print("Por favor digite el numero de iteraciones con la misma temperatura: ");
        m = 1000;

        System.out.print("Por favor digite la temperatura inicial: ");
        T0 = 10;

        for (i = 0; i < 25; i++) {
            sumpesos = sumpesos + c[i];
        }

        del = Math.min(C, Math.abs(sumpesos - C));

        /*Se inicia de manera aleatoria una solucion actual*/
        xactual = new int[25];
        for (i = 0; i < 25; i++) {
            if (Math.random() <= 0.5) {
                xactual[i] = 0;
            } else {
                xactual[i] = 0;
            }
        }


        factual = f(xactual);
        T = T0;

        xmejor = new int[25];
        asignarvaloresmejor();

        y = new double[n];
        xnuevo = new int[25];

        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {

                asignarvaloresnuevo();

                //Se genera el vecino
                pos = (int) Math.floor(Math.random() * 25);
                if (xnuevo[pos] == 0) {
                    xnuevo[pos] = 1;
                } else {
                    xnuevo[pos] = 0;
                }

                fnuevo = f(xnuevo);
                delta = fnuevo - factual;

                if (delta > 0) { /*si la nueva solucion es mejor que la actual*/
                    asignarvaloresactual();
                    factual = fnuevo;
                    if (f(xmejor) < factual) {
                        asignarvaloresmejor();
                    }
                } else {

                    if (Math.random() <= Math.exp(delta / T)) {
                        asignarvaloresactual();
                        factual = fnuevo;
                    }

                }
            }
            T = T0 / (i + 1);
            y[i] = factual;
        }

        System.out.println("  Mejor x: ");

        for (i = 0; i < 25; i++) {
            System.out.print("  " + xmejor[i]);
        }

        System.out.print(" Mejor f: " + f(xmejor));

        try {
            File outFile = new File("archivoSalida.txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
            for (i = 0; i < n; i++) {
                writer.write("" + y[i]);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println(e);
            System.exit(1);
        }
    }

    static public double f(int x[]) {
        double valor = 0, px, temp;
        int i, r1 = 0;

        for (i = 0; i < 25; i++) {
            valor = valor + v[i] * x[i];
            r1 = r1 + c[i] * x[i];
        }

        temp = (double) Math.abs(r1 - C) / (double) del;
        px = (1 - temp);

        return (valor * px);
    }

    static public void asignarvaloresmejor() {
        int i;
        for (i = 0; i < 25; i++) {
            xmejor[i] = xactual[i];
        }
    }

    static public void asignarvaloresactual() {
        int i;
        for (i = 0; i < 25; i++) {
            xactual[i] = xnuevo[i];
        }
    }

    static public void asignarvaloresnuevo() {
        int i;
        for (i = 0; i < 25; i++) {
            xnuevo[i] = xactual[i];
        }
    }
}
