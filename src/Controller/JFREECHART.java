/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author zack
 */

///This class is used to the creation of chart 
public class JFREECHART {

  
    /// chart for the number of sales by flightd 
    public void ghraph(JTable tab) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        System.out.print(tab.getRowCount());

        for (int i = 0; i < tab.getRowCount(); i++) {
            dataset.addValue(0, (String) tab.getModel().getValueAt(i, 2), " ");
        }

        for (int i = 0; i < tab.getRowCount(); i++) {
            dataset.incrementValue((int) tab.getModel().getValueAt(i, 3) * (int) tab.getModel().getValueAt(i, 4), (String) tab.getModel().getValueAt(i, 2), " ");
        }

        boolean legendtrue;
        JFreeChart chart = ChartFactory.createBarChart("Totales sales by Flights ", "Flights", "Price", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartFrame frame = new ChartFrame("Sales by Flights", chart);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(580, 500);

    }

    //// chart the best destination 
    public void ghraph2(JTable tab) throws Exception {

        DefaultPieDataset dataset = new DefaultPieDataset();
        String tabo[] = new String[tab.getRowCount()];

        for (int i = 0; i < tab.getRowCount(); i++) {
            tabo[i] = (String) tab.getModel().getValueAt(i, 2);
        }

        for (int i = 0; i < tab.getRowCount(); i++) {
            String sql = "SELECT * FROM `flights` WHERE `FLIGHT NO.` LIKE '" + (String) tab.getModel().getValueAt(i, 2) + "' ";
            String depart = new ConnexionSQL().requetetoString(sql, "DESTINATION");
            dataset.setValue(depart, counter(tabo, (String) tab.getModel().getValueAt(i, 2)));

        }

        JFreeChart chart = ChartFactory.createPieChart("Best seller", (PieDataset) dataset);

        ChartFrame frame = new ChartFrame("Best seller", chart);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(580, 500);

    }

    int counter(String tab[], String txt) {
        int cmp = 0;

        for (String tab1 : tab) {
            if (tab1.equals(txt)) {
                cmp++;
            }
        }

        return cmp;
    }

}
