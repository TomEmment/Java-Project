/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmer;
//import static javaserver.Server1.din;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Thoma
 */
public class DataDisplayScreen extends javax.swing.JFrame {
    
    int Instance = 0;
    String Choice = "";
    String username, address = "localhost";
    ArrayList<String> users = new ArrayList();
    int port = 2222;
    Boolean isConnected = false;
    
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    String StaticData;
    String TimeData;
    String TempreatureData = "TempreatureData:";
    String HumidityData = "HumidityData:";
    String SoilPHData = "SoilPHData:";
    String WindSpeedData = "WindSpeedData:";    
    
 
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new DataDisplayScreen.IncomingReader());
         IncomingReader.start();
    }
/**
 * 
     * Creates new form DataDisplayScreen
     */
    public DataDisplayScreen(String Station) {
        initComponents();
        try     
            {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println("Connect;FarmerJohn");
                writer.flush(); 
                writer.println("DataRequest;"+Station);
                writer.flush(); 
                isConnected = true; 
            } 
            catch (IOException ex) 
            {
                System.out.println("Cannot Connect! Try Again. \n");
            }
            
            ListenThread(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DisplayTempreatureData = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        DisplaySoilPHData = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ChartPannel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        WeatherStationData = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        DisplayHumidityData = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DisplayWindSpeedData = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        VariableX = new javax.swing.JComboBox<>();
        VariableY = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DisplayTempreatureData.setColumns(20);
        DisplayTempreatureData.setRows(5);
        jScrollPane2.setViewportView(DisplayTempreatureData);

        DisplaySoilPHData.setColumns(20);
        DisplaySoilPHData.setRows(5);
        jScrollPane3.setViewportView(DisplaySoilPHData);

        jLabel2.setText("Humidity Data:");

        jLabel1.setText("Tempreature Data:");

        javax.swing.GroupLayout ChartPannelLayout = new javax.swing.GroupLayout(ChartPannel);
        ChartPannel.setLayout(ChartPannelLayout);
        ChartPannelLayout.setHorizontalGroup(
            ChartPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        ChartPannelLayout.setVerticalGroup(
            ChartPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        WeatherStationData.setColumns(20);
        WeatherStationData.setRows(5);
        jScrollPane5.setViewportView(WeatherStationData);

        jLabel5.setText("Station information:");

        DisplayHumidityData.setColumns(20);
        DisplayHumidityData.setRows(5);
        jScrollPane6.setViewportView(DisplayHumidityData);

        jLabel3.setText("SoilPH Data:");

        DisplayWindSpeedData.setColumns(20);
        DisplayWindSpeedData.setRows(5);
        jScrollPane4.setViewportView(DisplayWindSpeedData);

        jLabel4.setText("Wind Speed Data");

        VariableX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tempreature", "Humidity", "SoilPH", "WIndSpeed" }));

        VariableY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tempreature", "Humidity", "SoilPH", "WIndSpeed" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                                .addComponent(ChartPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(181, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(VariableX, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(VariableY, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(VariableY)
                            .addComponent(VariableX))
                        .addGap(76, 76, 76)
                        .addComponent(ChartPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
   
   
   public void LineChart_AWT( ) {
       
       String chartTitle = "Time Plot";
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Time","Variable",
         createDataset());
         
        
            
           ChartPannel.setLayout(new java.awt.BorderLayout());
            
            ChartPanel CP = new ChartPanel(lineChart);
            
            ChartPannel.add(CP,BorderLayout.CENTER);
                    ChartPannel.validate();
      
      
   }
   private DefaultCategoryDataset createDataset() {
       
       
      int VarX = VariableX.getSelectedIndex();
      int VarY = VariableY.getSelectedIndex();
      DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
      
      
      switch (VarX){
          case 0:
            switch (VarY){
                case 0:
                    line_chart_dataset = ChopData(TempreatureData, TempreatureData);
                case 1:
                    line_chart_dataset = ChopData(TempreatureData, HumidityData);
                case 2:
                    line_chart_dataset = ChopData(TempreatureData, SoilPHData);
                case 3:
                    line_chart_dataset = ChopData(TempreatureData, WindSpeedData);                    
            }              
          case 1:
            switch (VarY){
                case 0:
                    line_chart_dataset = ChopData(HumidityData, TempreatureData);
                case 1:
                    line_chart_dataset = ChopData(HumidityData, HumidityData);
                case 2:
                    line_chart_dataset = ChopData(HumidityData, SoilPHData);
                case 3:
                    line_chart_dataset = ChopData(HumidityData, WindSpeedData); 
            }                
          case 2:
            switch (VarY){
                case 0:
                   line_chart_dataset =  ChopData(SoilPHData, TempreatureData);
                case 1:
                    line_chart_dataset = ChopData(SoilPHData, HumidityData);
                case 2:
                    line_chart_dataset = ChopData(SoilPHData, SoilPHData);
                case 3:
                    line_chart_dataset = ChopData(SoilPHData, WindSpeedData); 
            }                
          case 3:
            switch (VarY){
                case 0:
                    line_chart_dataset = ChopData(WindSpeedData, TempreatureData);
                case 1:
                    line_chart_dataset = ChopData(WindSpeedData, HumidityData);
                case 2:
                    line_chart_dataset = ChopData(WindSpeedData, SoilPHData);
                case 3:
                    line_chart_dataset = ChopData(WindSpeedData, WindSpeedData); 
            }        
      }

      
    return line_chart_dataset;
   }
 
 
 private DefaultCategoryDataset ChopData(String VarX, String VarY) {
     DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
     
     String[] InitialXdata;
     String[] InitialYdata;
     String[] Xdata;
     String[] Ydata;
     String[] TimeDisplayData;
     String VariableXName;
     String VariableYName;
     int Position = 0;
     int Amount;
     
     InitialXdata = VarX.split(":");
     InitialYdata = VarY.split(":");
     VariableXName = InitialXdata[0];
     VariableYName = InitialYdata[0];
     Xdata = InitialXdata[1].split(",");
     Ydata = InitialYdata[1].split(",");
     TimeDisplayData = TimeData.split(",");
     
     Amount = Xdata.length-15;
     
     while (Position<12)
     {
      line_chart_dataset.addValue( Integer.parseInt(Xdata[Position]), VariableXName , TimeDisplayData[Position] );
      line_chart_dataset.addValue( Integer.parseInt(Ydata[Position]), VariableYName , TimeDisplayData[Position] );
      Amount = Amount + 1;
      Position = Position +1;
              }
     return line_chart_dataset;
 }
 
 
 
 
    public void printTextField() {
     DisplayHumidityData.setText(TempreatureData);
    DisplaySoilPHData.setText(HumidityData);
    DisplayTempreatureData.setText(SoilPHData);
    DisplayWindSpeedData.setText(WindSpeedData);

    }
   public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream, Done = "DataSending", Done1 ="StaticData";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(";");
                     if (data[0].equals(Done)) 
                     {
                        TimeData = TimeData + data[1];
                        TempreatureData = TempreatureData +data[2];
                        HumidityData = HumidityData + data[3];
                        SoilPHData = SoilPHData + data[4];
                        WindSpeedData = WindSpeedData + data[5]; 
                        printTextField();
                        LineChart_AWT( );
                     } 
                     else if (data[0].equals(Done1)) 
                     {
                        StaticData = data[1];
                        WeatherStationData.append(StaticData);
                     } 
                     else
                     {
                         System.out.println("No conditions met");
                     }
                     
                }
           }catch(IOException ex) { 
           System.out.println("Error reciving message from server");
           }
        }
    }
    
 

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataDisplayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataDisplayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataDisplayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataDisplayScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataDisplayScreen("WeatherStation1").setVisible(true);
          }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ChartPannel;
    private javax.swing.JTextArea DisplayHumidityData;
    private javax.swing.JTextArea DisplaySoilPHData;
    private javax.swing.JTextArea DisplayTempreatureData;
    private javax.swing.JTextArea DisplayWindSpeedData;
    private javax.swing.JComboBox<String> VariableX;
    private javax.swing.JComboBox<String> VariableY;
    private javax.swing.JTextArea WeatherStationData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
}
