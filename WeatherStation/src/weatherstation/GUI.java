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
    List<String> UserList = new ArrayList<>();
    int port = 2222;
    int Done = 0;
    Boolean isConnected = false;
    String data = "";
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    //String Data= "Nottigham,GPS,FIELDNAME,POSITION,CROP";
    String StaticData = "Nottigham,GPS,FIELDNAME,POSITION,CROP";
    int lineNum = 15;
    String TimeData = "";
    String TempreatureData = "";
    String HumidityData = "";
    String SoilPHData = "";
    String WindSpeedData = "";
    int Active = 0;
    
    //--------------------------//
    
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }
    
    public GUI() {
        initComponents();
        CreateData(8);
        getStaticData();
            try 
            {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println("InitialConnect;"+username+";"+StaticData);
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
                    TimeUnit.SECONDS.sleep(5);;
                }
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
            }
        
     
    }
    
    public void getStaticData(){
        //get the length of the file
        // Read random line of file
        //generate random number
        

        Random rand = new Random(); // random number between 0 and line num
        int randNum = rand.nextInt(lineNum);
        int i = 0;
        try{
            FileReader readfile = new FileReader("staticData.txt");
            BufferedReader readBuffer = new BufferedReader(readfile);

			String line = readBuffer.readLine();
	while (line != null) {
            if(i==randNum){
                  StaticData = line;
            }
                line = readBuffer.readLine();
                i = i +1;
			}
        }catch(IOException e){
        }
        String lnNum = Integer.toString(randNum);
        username = "WeatherStaion"+lnNum;

    }
    
    public void CreateData(int Length)
    {
        int Start =20;
        int Start1 = 50;
        int Start2 = 6;
        int Start3 = 30;
        int Randomizer;
        int temp;
        Random rand = new Random();
        while (Length>=0)
        {

        TimeData = TimeData + java.time.LocalTime.now()+",";
     
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
               writer.println("Data"+ ";" +TimeData +";" +TempreatureData+";" +HumidityData+";" +SoilPHData+";" +WindSpeedData);
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

            String stream, Connected = "Active", Deactivated ="Deactivated",List="ClientList";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(";");

                 if (data[0].equals(Connected))
                 {
                     if (data[1].equals(username))
                             
                     {
                          writer.println("Information;"+username+";"+StaticData);
                          writer.flush(); 
                          Active = 1;
                          while (true){
                            GenerateData();
                            try
                            {
                                TimeUnit.SECONDS.sleep(5);;
                            }
                            catch(InterruptedException ex)
                            {
                                Thread.currentThread().interrupt();
                            }
                            }
                             }
                 }
                else if (data[0].equals(Deactivated)) 
                {
                     if (data[1].equals(username))
                             
                     {
                          Active = 0;
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
