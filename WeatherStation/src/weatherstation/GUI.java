/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.net.*;
import java.io.*;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Thoma
 */
public class GUI extends javax.swing.JFrame {

    String username ="WeatherStation1", address = "localhost";
    ArrayList<String> users = new ArrayList();
    int port = 2222;
    int dataLength = 12;
    Boolean isConnected = false;
    String data = "";
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    String StaticData="Nottigham,GPS,FIELDNAME,POSITION,CROP";
    String TimeData;
    String TempreatureData;
    String HumidityData;
    String SoilPHData;
    String WindSpeedData;
    int Active = 1;
    
    //--------------------------//
    
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }
    
    public GUI() {
        initComponents();
        CreateData(dataLength);
            try 
            {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println("Connect;"+username+";"+StaticData);
                writer.flush(); 
                writer.println("Data;"+username+";" +TimeData +";" +TempreatureData+";" +HumidityData+";" +SoilPHData+";" +WindSpeedData);
                writer.flush(); 
                StationNotification.append("Data Sent");
                isConnected = true; 
            } 
            catch (Exception ex) 
            {
                StationNotification.append("Cannot Connect! Try Again. \n");
                
            }
            
            ListenThread();
            while (true){
                GenerateData(username+".txt");
                try
                {
                    TimeUnit.SECONDS.sleep(1);;
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
        
     
    }
    public void CreateData(int Length)
    {
        int Start =10;
        int Start1 = 30;
        int Start2 = 4;
        int Start3 = 30;
        int Randomizer;
        int temp;
        Random rand = new Random();
        while (Length>=0)
        {
        if (Length!=0)
        {
        TimeData = TimeData + java.time.LocalTime.now()+",";
        }else{
           
        }       
         Randomizer = rand.nextInt(20);
        temp = Start + Randomizer;       
        if (Length!=0)
        {
        TempreatureData = TempreatureData + Integer.toString(temp)+",";
        }else{
            TempreatureData = TempreatureData + Integer.toString(temp);
        }
         Randomizer = rand.nextInt(35);
        temp = Start1 + Randomizer;
        if (Length!=0)
        {
        HumidityData = HumidityData + Integer.toString(temp)+",";
        }else{
            HumidityData = HumidityData + Integer.toString(temp);
        }       
         Randomizer = rand.nextInt(4);
        temp = Start2 + Randomizer;
        if (Length!=0)
        {
        SoilPHData = SoilPHData + Integer.toString(temp)+",";
        }else{
            SoilPHData = SoilPHData + Integer.toString(temp);
        }       
        Randomizer = rand.nextInt(40);
        temp = Start3 + Randomizer;
        if (Length!=0)
        {
        WindSpeedData = WindSpeedData + Integer.toString(temp)+",";
        }else{
            WindSpeedData = WindSpeedData + Integer.toString(temp);
        }      
        Length=Length-1;
        }
    }
public void GenerateData(String File){
        CreateData(1);
        StationNotification.append("Data Collected");
        if (Active == 1)
                {
                   SendData(); 
                }
        }

        
public void SendData(){
        
            try {
               writer.println("Data;"+username +";" +TempreatureData+";" +HumidityData+";" +SoilPHData+";" +WindSpeedData);
               StationNotification.append("Data Sent");
               writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                StationNotification.append("Data was not sent. \n");
            }
        }                                     
    public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream, Connected = "Active", Deactivated ="Deactivated";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(";");

                 if (data[0].equals(Connected)) 
                     {
                          Active = 1;
                         }
                      
                else if (data[0].equals(Deactivated)) 
                     {
                          Active = 0;
                         }
                     } 
           }catch(IOException ex) { }
           {
               
        }
    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        StationNotification = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StationNotification.setColumns(20);
        StationNotification.setRows(5);
        jScrollPane1.setViewportView(StationNotification);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea StationNotification;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
