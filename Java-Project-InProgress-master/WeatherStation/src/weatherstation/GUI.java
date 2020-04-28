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

/**
 *
 * @author Thoma
 */
public class GUI extends javax.swing.JFrame {

    String username, address = "localhost";
    ArrayList<String> users = new ArrayList();
    int port = 2222;
    int dataLength = 12;
    Boolean isConnected = false;
    String data = "";
    Socket sock;
    BufferedReader reader;
    PrintWriter writer;
    
    //--------------------------//
    
    public void ListenThread() 
    {
         Thread IncomingReader = new Thread(new IncomingReader());
         IncomingReader.start();
    }
    
    public GUI() {
        initComponents();
        username = StationChoice.getText();
        InitializeFiles(username+".txt",dataLength);
        data = GenerateData(username+".txt");
    }
    public static void InitializeFiles(String FileName, int Length)
    {
        int Start =8;
        int Start1 = 37;
        int Start2 = 20;
        int Start3 = 60;
        int Randomizer;
        int temp;
        char Station  = FileName.charAt(14);
        String StationRef = Character.toString(Station);
        String Data0 = ":0:";
        String Data1 = ":1:";
        String Data2 = ":2:";
        String Data3 = ":3:";
        Random rand = new Random();
        

        while (Length>=0)
        {
        Randomizer = rand.nextInt(10);
        temp = Start + Randomizer;
        if (Length!=0)
        {
        Data0 = Data0 + Integer.toString(temp)+",";
        }else{
            Data0 = Data0 + Integer.toString(temp);
        }
         Randomizer = rand.nextInt(15);
        temp = Start1 + Randomizer;
        if (Length!=0)
        {
        Data1 = Data1 + Integer.toString(temp)+",";
        }else{
            Data1 = Data1 + Integer.toString(temp);
        }       
         Randomizer = rand.nextInt(20);
        temp = Start2 + Randomizer;
        if (Length!=0)
        {
        Data2 = Data2 + Integer.toString(temp)+",";
        }else{
            Data2 = Data2 + Integer.toString(temp);
        }       
        Randomizer = rand.nextInt(25);
        temp = Start3 + Randomizer;
        if (Length!=0)
        {
        Data3 = Data3 + Integer.toString(temp)+",";
        }else{
            Data3 = Data3 + Integer.toString(temp);
        }      
        Length=Length-1;
        }
        try{
        PrintWriter writer = new PrintWriter(FileName);
        writer.print("");
        writer.close();
        }        
        catch(IOException e){
            System.out.println("Error opening file");
        }  
        try{
            FileWriter fout = new FileWriter(FileName,true);
            BufferedWriter x = new BufferedWriter(fout);
            PrintWriter pout = new PrintWriter(x);

            pout.println(":"+StationRef+":");
            pout.println(Data0);
            pout.println(Data1);
            pout.println(Data2);
            pout.println(Data3);
            pout.close();
            x.close();
            fout.close();
        }
        catch(IOException e){
            System.out.println("Error opening file");
        }    
    }
        public String GenerateData(String File){
        List<String> Userdata = new ArrayList<>();
        try{
            Path path = Paths.get(File);
            Scanner scanner = new Scanner(path);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                    Userdata.add(line);              

            }
            scanner.close();
            System.out.println("Data collected");
        }
        catch(IOException e){
            System.out.println("Error opening file");
        }
        String UserdataFinal = String.join(",", Userdata);
        return UserdataFinal;
        }
public void SendData(){
        username = StationChoice.getText();
            try {
               writer.println("Data;" + username + ";" + data);
               writer.flush(); // flushes the buffer
            } catch (Exception ex) {
                System.out.println("Data was not sent. \n");
            }
        }                                     
    public class IncomingReader implements Runnable
    {
        @Override
        public void run() 
        {
            String[] data;
            String stream, Message = "DataRequest";

            try 
            {
                while ((stream = reader.readLine()) != null) 
                {
                     data = stream.split(";");

                     if (data[0].equals(Message)) 
                     {
                         if (data[1].equals(username)){
                          SendData();
                         }
                     } 
                }
           }catch(IOException ex) { }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        AdressChoice = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PortChoice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        StationChoice = new javax.swing.JTextField();
        Update = new javax.swing.JButton();
        Upload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Address:");

        AdressChoice.setText("localhost");
        AdressChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdressChoiceActionPerformed(evt);
            }
        });

        jLabel2.setText("Port:");

        PortChoice.setText("2222");

        jLabel3.setText("Station Identifier:");

        StationChoice.setText("WeatherStation1");
        StationChoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StationChoiceActionPerformed(evt);
            }
        });

        Update.setText("Update Data");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        Upload.setText("Send Data");
        Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(StationChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(PortChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AdressChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(AdressChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(PortChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StationChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Update, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdressChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdressChoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AdressChoiceActionPerformed

    private void StationChoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StationChoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StationChoiceActionPerformed

    private void UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadActionPerformed
        if (isConnected == false) 
        {
            username = StationChoice.getText();
            address = AdressChoice.getText();
            port = Integer.parseInt(PortChoice.getText());
            StationChoice.setEditable(false);

            try 
            {
                sock = new Socket(address, port);
                InputStreamReader streamreader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(streamreader);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println("Connect;"+username);
                writer.flush(); 
                writer.println("Data;"+username +";" +data);
                writer.flush(); 
                isConnected = true; 
            } 
            catch (Exception ex) 
            {
                System.out.println("Cannot Connect! Try Again. \n");
                StationChoice.setEditable(true);
            }
            
            ListenThread();
            
        } else if (isConnected == true) 
        {
            SendData();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_UploadActionPerformed

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        username = username = StationChoice.getText()+".txt";
        InitializeFiles(username,dataLength);
        data = GenerateData(username);
    }//GEN-LAST:event_UpdateActionPerformed

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
    private javax.swing.JTextField AdressChoice;
    private javax.swing.JTextField PortChoice;
    private javax.swing.JTextField StationChoice;
    private javax.swing.JButton Update;
    private javax.swing.JButton Upload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
