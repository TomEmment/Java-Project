<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmerclientserver;
import java.awt.Color;  
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.XYPlot;  
import org.jfree.data.xy.XYDataset;  
import org.jfree.data.xy.XYSeries;  
import org.jfree.data.xy.XYSeriesCollection;  
  
public class Plot_Data extends JFrame {  
  private static final long serialVersionUID = 6294689542092367723L;  
  public Plot_Data(String title, String variable, int Data[][], int Instance) {  
    super(title);  
  
    // Create dataset  
    XYDataset dataset = createDataset(variable, Data, Instance);  
  
    // Create chart  
    JFreeChart chart = ChartFactory.createScatterPlot(  
        variable+" Vs time",   
        "Time", variable, dataset); 
    // Create Panel  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private XYDataset createDataset(String variable, int Data[][], int Instance) {  
    XYSeriesCollection dataset = new XYSeriesCollection();  
    XYSeries series1 = new XYSeries(variable);  
    int x = 1;
    while(Data[Instance][x]!=0){
        series1.add(Data[0][x], Data[Instance][x]); 
        x=x+1;
    }

    dataset.addSeries(series1);  
    return dataset;  
  }  
  public static void main(String[] args) {  
      
  }  
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmerclientserver;
import java.awt.Color;  
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import javax.swing.WindowConstants;  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.XYPlot;  
import org.jfree.data.xy.XYDataset;  
import org.jfree.data.xy.XYSeries;  
import org.jfree.data.xy.XYSeriesCollection;  
  
public class Plot_Data extends JFrame {  
  private static final long serialVersionUID = 6294689542092367723L;  
  public Plot_Data(String title, String variable, int Data[][], int Instance) {  
    super(title);  
  
    // Create dataset  
    XYDataset dataset = createDataset(variable, Data, Instance);  
  
    // Create chart  
    JFreeChart chart = ChartFactory.createScatterPlot(  
        variable+" Vs time",   
        "Time", variable, dataset); 
    // Create Panel  
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  private XYDataset createDataset(String variable, int Data[][], int Instance) {  
    XYSeriesCollection dataset = new XYSeriesCollection();  
    XYSeries series1 = new XYSeries(variable);  
    int x = 1;
    while(Data[Instance][x]!=0){
        series1.add(Data[0][x], Data[Instance][x]); 
        x=x+1;
    }

    dataset.addSeries(series1);  
    return dataset;  
  }  
  public static void main(String[] args) {  
      
  }  
>>>>>>> cf0a3da96527a02432215eb7683348b4a649592b
}  