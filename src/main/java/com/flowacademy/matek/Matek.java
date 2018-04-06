package com.flowacademy.matek;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Matek {
    private int szam;

    public Matek(int szam) {
        this.szam = szam;
    }

    public int getSzam() {
        return szam;
    }

    public void setSzam(int szam) {
        this.szam = szam;
    }

    public static int faktorialis(Matek szam) {
        int eredmeny = 1;
        for (int i = 1; i <= szam.getSzam(); i++) {
            eredmeny *= i;
        }
        return eredmeny;
    }

    public static int fibonacciTombos(Matek szam) {
        int[] tomb = new int[szam.getSzam()+1];
        tomb[0] = 0;
        tomb[1] = 1;
        for (int i = 2; i <= szam.getSzam(); i++) {
            tomb[i] = tomb[i-1] + tomb[i-2];
        }
        return tomb[szam.getSzam()];
    }

    public static int fibonacciRekurziv(int szam) {
        if(szam == 0)
            return 0;
        else if(szam == 1) {
            return 1;
        } else
            return fibonacciRekurziv(szam - 1) + fibonacciRekurziv(szam - 2);
    }

    public static void showChart(JFreeChart chart) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Charts");

                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                ChartPanel cp = new ChartPanel(chart);

                frame.getContentPane().add(cp);
            }
        });
    }

    public static void drawDiagram(double[][] data) {
        // Diagram elkeszitese
        final XYDataset ds = createDataset();
        JFreeChart chart = createChart(ds);

        LogarithmicAxis xAxis = new LogarithmicAxis("Adatmennyiség (db)");

        XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis(xAxis);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer)plot.getRenderer();
        renderer.setSeriesShapesVisible(0, true);

        // Diagram megjelenitese
        showChart(chart);
    }

    public static double[][] fibonacciChart(int szam) {
        double[][] matrix = new double[2][szam+1];
        double futasIdo = 0;
        for (int i = 0; i <= szam; i++) {
            for (int j = 0; j <= 20; j++) {
                long startTime = System.currentTimeMillis();
                matrix[0][i] = fibonacciRekurziv(i);
                long endTime = System.currentTimeMillis();
                matrix[1][i] = (endTime - startTime);
                futasIdo += matrix[1][i];
            }
            matrix[1][i] = futasIdo/20;
        }
        return matrix;
    }

    public static ArrayList<Integer> integerArrayListFeltolto(int meret) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < meret; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public static LinkedList<Integer> integerLinkedListFeltolto(int meret) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < meret; i++) {
            linkedList.add(i);
        }
        return linkedList;
    }

    public static int[] integerArrayFeltolto(int meret) {
        int[] tomb = new int[meret];
        for (int i = 0; i < meret; i++) {
            tomb[i] = i;
        }
        return tomb;
    }

    public static HashSet<Integer> integerHashSetFeltolto(int meret) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < meret; i++) {
            hashSet.add(i);
        }
        return hashSet;
    }

    public static double[][] kollekciokFeltolteseArray(int meret) {
        int matrixMeret = (int)(Math.log10(meret)+1);
        double[][] matrix = new double[2][matrixMeret];
        int j = 0;
        for (int i = 1; i <= meret; i *= 10) {
            matrix[0][j] = i;
            long startTime = System.currentTimeMillis();
            integerArrayFeltolto(i);
            long endTime = System.currentTimeMillis();
            matrix[1][j] = (endTime - startTime);
            j++;
        }
        return matrix;
    }

    public static double[][] kollekciokFeltolteseArrayList(int meret) {
        int matrixMeret = (int)(Math.log10(meret)+1);
        double[][] matrix = new double[2][matrixMeret];
        int j = 0;
        for (int i = 1; i <= meret; i *= 10) {
            matrix[0][j] = i;
            long startTime = System.currentTimeMillis();
            integerArrayListFeltolto(i);
            long endTime = System.currentTimeMillis();
            matrix[1][j] = (endTime - startTime);
            j++;
        }
        return matrix;
    }

    public static double[][] kollekciokFeltolteseLinkedList(int meret) {
        int matrixMeret = (int)(Math.log10(meret)+1);
        double[][] matrix = new double[2][matrixMeret];
        int j = 0;
        for (int i = 1; i <= meret; i *= 10) {
            matrix[0][j] = i;
            long startTime = System.currentTimeMillis();
            integerLinkedListFeltolto(i);
            long endTime = System.currentTimeMillis();
            matrix[1][j] = (endTime - startTime);
            j++;
        }
        return matrix;
    }

    public static double[][] kollekciokFeltolteseHashSet(int meret) {
        int matrixMeret = (int)(Math.log10(meret)+1);
        double[][] matrix = new double[2][matrixMeret];
        int j = 0;
        for (int i = 1; i <= meret; i *= 10) {
            matrix[0][j] = i;
            long startTime = System.currentTimeMillis();
            integerHashSetFeltolto(i);
            long endTime = System.currentTimeMillis();
            matrix[1][j] = (endTime - startTime);
            j++;
        }
        return matrix;
    }

    public static void main(String[] args) {

        drawDiagram(kollekciokFeltolteseArray(1000000));
        drawDiagram(kollekciokFeltolteseArrayList(1000000));
        drawDiagram(kollekciokFeltolteseLinkedList(1000000));
        drawDiagram(kollekciokFeltolteseHashSet(1000000));



        //drawDiagram(fibonacciChart(5));

        /*Matek ketto = new Matek(2);
        Matek harom = new Matek(3);
        Matek ot = new Matek(5);
        Matek tizenot = new Matek(15);
        Matek negyvenot = new Matek(45);

        System.out.println("2! = " + faktorialis(ketto));
        System.out.println("3! = " + faktorialis(harom));
        System.out.println("5! = " + faktorialis(ot));

        System.out.println();
        System.out.println(fibonacciTombos(negyvenot));

        System.out.println();
        long startTime = System.currentTimeMillis();
        System.out.println(fibonacciRekurziv(30));
        long endTime = System.currentTimeMillis();
        System.out.println("Futási idő: " + (endTime - startTime)/1000);*/
    }

    public static XYDataset createDataset() {

        final XYSeries series1 = new XYSeries("Array");
        for(int i=0; i<kollekciokFeltolteseArray(1000000).length; i++) {
            for(int j=0; j<kollekciokFeltolteseArray(1000000)[i].length; j++) {
                series1.add(kollekciokFeltolteseArray(1000000)[0][i], kollekciokFeltolteseArray(1000000)[i][j]);
            }
        }


        final XYSeries series2 = new XYSeries("ArrayList");
        for(int i=0; i<kollekciokFeltolteseArrayList(1000000).length; i++) {
            for(int j=0; j<kollekciokFeltolteseArrayList(1000000)[i].length; j++) {
                series1.add(kollekciokFeltolteseArrayList(1000000)[0][i], kollekciokFeltolteseArrayList(1000000)[i][j]);
            }
        }

        final XYSeries series3 = new XYSeries("LinkedList");
        for(int i=0; i<kollekciokFeltolteseLinkedList(1000000).length; i++) {
            for(int j=0; j<kollekciokFeltolteseLinkedList(1000000)[i].length; j++) {
                series1.add(kollekciokFeltolteseLinkedList(1000000)[0][i], kollekciokFeltolteseLinkedList(1000000)[i][j]);
            }
        }

        final XYSeries series4 = new XYSeries("HashSet");
        for(int i=0; i<kollekciokFeltolteseHashSet(1000000).length; i++) {
            for(int j=0; j<kollekciokFeltolteseHashSet(1000000)[i].length; j++) {
                series1.add(kollekciokFeltolteseHashSet(1000000)[0][i], kollekciokFeltolteseHashSet(1000000)[i][j]);
            }
        }

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);
        dataset.addSeries(series4);

        return dataset;

    }

    public static JFreeChart createChart(final XYDataset dataset) {

        // create the chart...
        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Line Chart Demo 6",      // chart title
                "X",                      // x axis label
                "Y",                      // y axis label
                dataset,                  // data
                PlotOrientation.VERTICAL,
                true,                     // include legend
                true,                     // tooltips
                false                     // urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

//        final StandardLegend legend = (StandardLegend) chart.getLegend();
        //      legend.setDisplaySeriesShapes(true);

        // get a reference to the plot for further customisation...
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        //    plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);
        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.

        return chart;

    }

}
