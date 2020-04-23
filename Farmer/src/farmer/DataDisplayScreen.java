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
    int[][] data = new int[5][200];
    int Instance = 0;
    String Choice = "";
    String username, address = "localhost";
    ArrayList<String> users = new ArrayList();
    int port = 2222;
    Boolean isConnected = false;
    
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new DataDisplayScreen.IncomingReader());
         IncomingReader.start();
    }
/**
 * 
     * Creates new form DataDisplayScreen
     */
    public DataDisplayScreen() {
        initComponents();
        InitialMatrix();
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
        Stop = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        VariableXData = new javax.swing.JTextArea();
        VariableX = new javax.swing.JComboBox<>();
        VariableY = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        VariableYData = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ChartPannel = new javax.swing.JPanel();
        ContactServer = new javax.swing.JButton();
        StationChoice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        UpdateChart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ActiveStations = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Stop.setActionCommand("Stop");
        Stop.setLabel("Stop");
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });

        VariableXData.setColumns(20);
        VariableXData.setRows(5);
        jScrollPane2.setViewportView(VariableXData);

        VariableX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tempreature", "Humidity", "soilPH", "WindSpeed" }));
        VariableX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VariableXActionPerformed(evt);
            }
        });

        VariableY.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tempreature", "Humidity", "soilPH", "WindSpeed" }));

        VariableYData.setColumns(20);
        VariableYData.setRows(5);
        jScrollPane3.setViewportView(VariableYData);

        jLabel2.setText("Variable Y:");

        jLabel1.setText("Variable X:");

        javax.swing.GroupLayout ChartPannelLayout = new javax.swing.GroupLayout(ChartPannel);
        ChartPannel.setLayout(ChartPannelLayout);
        ChartPannelLayout.setHorizontalGroup(
            ChartPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );
        ChartPannelLayout.setVerticalGroup(
            ChartPannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
        );

        ContactServer.setText("Contact Server");
        ContactServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactServerActionPerformed(evt);
            }
        });

        StationChoice.setText("WeatherStation1");

        jLabel3.setText("Station Choice:");

        UpdateChart.setText("Update Chart");
        UpdateChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateChartActionPerformed(evt);
            }
        });

        ActiveStations.setColumns(20);
        ActiveStations.setRows(5);
        jScrollPane1.setViewportView(ActiveStations);

        jLabel4.setText("Active Stations:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ContactServer, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(UpdateChart, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(StationChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(61, 61, 61)
                        .addComponent(VariableX, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(VariableY, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(75, 75, 75)
                        .addComponent(ChartPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(172, 172, 172))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(VariableX, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(VariableY, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(StationChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UpdateChart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ContactServer, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ChartPannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 935, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed

    }//GEN-LAST:event_StopActionPerformed

    private void VariableXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VariableXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VariableXActionPerformed

    private void ContactServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactServerActionPerformed
       Gatherdata();
  
    }//GEN-LAST:event_ContactServerActionPerformed

    private void UpdateChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateChartActionPerformed
                printTextField(VariableX.getSelectedIndex(),VariableY.getSelectedIndex() );
        LineChart_AWT(VariableX.getSelectedItem().toString(), VariableY.getSelectedItem().toString() );      // TODO add your handling code here:
    }//GEN-LAST:event_UpdateChartActionPerformed

private int[][]  InitialMatrix() {  //Change this to a data request from server
      
       
    int x = data[0].length - 1;
    while(x>=0){
        data[0][x] = 0;
        data[1][x] = 0;
        data[2][x] = 0;
        data[3][x] = 0;
        data[4][x] = 0;
        x=x-1;
    }
    
        System.out.println("Matrix Intitilized");
    return data; 
   }   

  private int[][]  Update(String Data) {  //Change this to a data request from server
    int i = 7;   
    int x = Data.length()-1;
    int Variable = 0;
    int Position = 0;
    char tempCharacter;
    String tempString = "";
    while(i<=x){
        tempCharacter = Data.charAt(i);
        if(tempCharacter == ','){
            data[Variable][Position] = Integer.parseInt(tempString);
            tempString ="";
            Position = Position + 1;
        }
        else if(tempCharacter == ':'){
            i = i + 2;
            tempString = "";
            Variable = Variable + 1;
            Position = 0;
        }
        else{
             tempString = tempString + tempCharacter;
             }
        i=i+1;
    }

    return data; 
   }    

    
   private int[][]  Gatherdata() {  //Change this to a data request from server
        try     
            {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                Choice = StationChoice.getText();
                writer.println("ClientRequest;");
                writer.flush(); 
                writer.println("Connect;FarmerJohn");
                writer.flush(); 
                writer.println("DataRequest;"+Choice);
                writer.flush(); 
                isConnected = true; 
            } 
            catch (IOException ex) 
            {
                System.out.println("Cannot Connect! Try Again. \n");
            }
            
            ListenThread();     
    return data; 
   }
   
   public void LineChart_AWT(String VariableX, String VariableY ) {
       String chartTitle = VariableX + " Vs " + VariableY;
      JFreeChart lineChart = ChartFactory.createScatterPlot(
         chartTitle,
         VariableX,VariableY,
         createDataset(VariableX,VariableY));
         
        
            
           ChartPannel.setLayout(new java.awt.BorderLayout());
            
            ChartPanel CP = new ChartPanel(lineChart);
            
            ChartPannel.add(CP,BorderLayout.CENTER);
                    ChartPannel.validate();
      
      
   }

   private XYDataset createDataset(String X, String Y ) {
    XYSeriesCollection dataset = new XYSeriesCollection();

    //Boys (Age,weight) series
    XYSeries series1 = new XYSeries(X+" Vs "+Y);
    int x = 0;
    while( data[VariableX.getSelectedIndex()][x] != 0)
    {
        series1.add(data[VariableX.getSelectedIndex()][x], data[VariableY.getSelectedIndex()][x]);
        x = x +1;
    }
 

    dataset.addSeries(series1);
    


    return dataset;
   }
    
    public void printTextField(int VariableX, int VariableY) {
    int x = 0;
    int Data;
    int Data1;
    String Printable = "";
    String Printable1 = "";
    
    while(data[VariableX][x]>0){
        Data = data[VariableX][x];

        Printable = Printable + ", " + Integer.toString(Data);
        Data1 = data[VariableY][x];

        Printable1 = Printable1 + ", " + Integer.toString(Data1);            
        x = x+1;
    }
    VariableXData.setText(Printable);
    VariableYData.setText(Printable1);
    }      

   public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream, Done = "DataSending", ClientList="ClientList";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(";");

                     if (data[0].equals(Done)) 
                     {
                         Update(data[1]);
                     } 
                     else if (data[0].equals(ClientList)) 
                     {
                         ActiveStations.setText("");
                         int x = data[1].length();
                         int i = 0;
                         String Station = "";
                         char tempCharacter;
                         while (i<=x){
                                tempCharacter = data[1].charAt(i);
                                if (tempCharacter == ',')
                                {
                                ActiveStations.append(Station);
                                ActiveStations.append("\n");
                                Station = "";
                                }
                                else
                                {
                                    Station = Station + tempCharacter;
                                }
                                i = i+1;
                         }

                     } 
                     
                }
           }catch(IOException ex) { }
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
                new DataDisplayScreen().setVisible(true);
          }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ActiveStations;
    private javax.swing.JPanel ChartPannel;
    private javax.swing.JButton ContactServer;
    private javax.swing.JTextField StationChoice;
    private java.awt.Button Stop;
    private javax.swing.JButton UpdateChart;
    private javax.swing.JComboBox<String> VariableX;
    private javax.swing.JTextArea VariableXData;
    private javax.swing.JComboBox<String> VariableY;
    private javax.swing.JTextArea VariableYData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
