/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.net.*;
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Thoma
 */
public class GUI extends javax.swing.JFrame {

    
    String username ="WeatherStation8", address = "localhost";
    List<String> UserList = new ArrayList<>();
    int port = 2222;
    int Done = 0;
    Boolean isConnected = false;
    String data = "";
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    //String Data= "Nottigham,GPS,FIELDNAME,POSITION,CROP";
    String StaticData = "Manchester-West,583-928,Stan,W,Wheat";
     int lineNum = 15;
    String TimeData = "";
    String TempreatureData = "";
    String HumidityData = "";
    String SoilPHData = "";
    String WindSpeedData = "";
    String Nitorgen;
    String ActiveFarmer = "None";
    int Active = 0;
    int Sleep =10;
    
    //--------------------------//
    
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }
    
    public GUI() {
        initComponents();
        CreateData(10);
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
                GenerateData();
                try
                {
                    TimeUnit.SECONDS.sleep(Sleep);;
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
        
     
    }
    
 
    
    public void CreateData(int Length)
    {
        int Start =20;
        int Start1 = 50;
        int Start2 = 6;
        int Start3 = 30;
        int Randomizer;
        int temp;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Random rand = new Random();
        while (Length>=0)
        {
    
        date = new Date();
        TimeData = TimeData + formatter.format(date)+",";
     
         Randomizer = -2 + rand.nextInt(4);
        temp = Start + Randomizer;       

        TempreatureData = TempreatureData + Integer.toString(temp)+",";

         Randomizer = - 6 + rand.nextInt(12);
        temp = Start1 + Randomizer;

        HumidityData = HumidityData + Integer.toString(temp)+",";
      
         Randomizer = -1 + rand.nextInt(2);
        temp = Start2 + Randomizer;

        SoilPHData = SoilPHData + Integer.toString(temp)+",";
     
        Randomizer = -10 + rand.nextInt(20);
        temp = Start3 + Randomizer;

        WindSpeedData = WindSpeedData + Integer.toString(temp)+",";
      
        Length=Length-1;
        }
    }
public void GenerateData(){
        CreateData(1);
        StationNotification.append("Data Collected");
        if (Active == 1)
                {
                   SendData(); 
                }
        }

        
public void SendData(){
            try {
               writer.println("Data"+ ";" +TimeData +";" +TempreatureData+";" +HumidityData+";" +SoilPHData+";" +WindSpeedData+";"+ActiveFarmer);
               writer.flush(); // flushes the buffer
               StationNotification.append("Data Sent");
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
            String[] temp;
            Random rand = new Random();

            String stream, Connected = "Active", Deactivated ="Deactivated",Field="FieldPull";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(";");

                 if (data[0].equals(Connected))
                 {
                     if (Active != 1)
                     {
                     if (data[1].equals(username))
                             
                     {
                         ActiveFarmer = data[3];
                         Nitorgen = Integer.toString(rand.nextInt(4));
                          writer.println("Information;"+username+";"+StaticData+";"+Nitorgen+";"+data[3]);
                          writer.flush(); 
                          Active = 1;
                          GenerateData();
                          Sleep = Integer.parseInt(data[2]);
                             }
                 }
                     else
                     {
                          writer.println("ConnectionError;"+ActiveFarmer+";"+data[3]);
                          writer.flush();                          
                     }
                 }
                else if (data[0].equals(Deactivated)) 
                {
                     if (data[1].equals(username))
                             
                     {
                          Active = 0;
                         }
                       }
              else if (data[0].equals(Field)) 
                {

                   temp = StaticData.split(",");
                   if (temp[2].equals(data[1]))
                   {
                          writer.println("FieldData;"+username+","+temp[3]+";"+data[2]);
                          writer.flush();                        
                   }

                       }
                }
                       
                
                }
           catch(IOException ex) { 
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
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
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
