package finalserver;

import java.io.*;
import java.net.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Server extends javax.swing.JFrame 
{
   ArrayList clientOutputStreams;
   ArrayList<String> users;

   public class ClientHandler implements Runnable	
   {
       BufferedReader reader;
       Socket sock;
       PrintWriter client;
       String[] DataStorage = new String[]{"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"};
       public ClientHandler(Socket clientSocket, PrintWriter user) 
       {
            client = user;
            try 
            {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            }
            catch (IOException ex) 
            {
                System.out.println("Unexpected error... \n");
            }

       }

       @Override
       public void run() 
       {
            String message, Data = "Data", Login = "Login", Request ="DataRequest";
            String[] data;
            char temp;
            int Position;
            String Sending;
            String Present;
         

            try 
            {
                while ((message = reader.readLine()) != null) 
                {
                   System.out.println("Received: " + message + "\n");
                    data = message.split(";");
                    

                    if (data[0].equals(Data)) 
                    {
                        temp = data[1].charAt(data[1].length()-1);

                        Position = Integer.parseInt(String.valueOf(temp));
                        System.out.println(data[2]);
                        SendMessage("DataSending;"+data[2]);
                        DataStorage[Position] = data[2];


                    } 
                    else if (data[0].equals(Login)) 
                    {
                       Present = Log_in(data[1],data[2]);
                       System.out.println(Present);
                       SendMessage(Present);

                    } 
                    else if (data[0].equals(Request)) 
                    {
                        SendMessage("DataRequest;");

                    }                     
                    else 
                    {
                        System.out.println("No Conditions were met. \n");
                    }
                } 
             } 
             catch (IOException | NumberFormatException ex) 
             {
                System.out.println("Lost a connection. \n");

             } 
	} 
    }

    public Server() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_start = new javax.swing.JButton();
        b_end = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat - Server's frame");
        setName("server"); // NOI18N
        setResizable(false);

        b_start.setText("START");
        b_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_startActionPerformed(evt);
            }
        });

        b_end.setText("END");
        b_end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_endActionPerformed(evt);
            }
        });

        jButton1.setText("SEE ALL THE DATA under construction");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_start, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_end, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jButton1)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b_start)
                .addGap(18, 18, 18)
                .addComponent(b_end)
                .addGap(125, 125, 125)
                .addComponent(jButton1)
                .addContainerGap(174, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_endActionPerformed
        try 
        {
            Thread.sleep(5000);                 //5000 milliseconds is five second.
        } 
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        
        System.out.println("Server stopping... \n");
        
    }//GEN-LAST:event_b_endActionPerformed

    private void b_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_startActionPerformed
        Thread starter = new Thread(new ServerStart());
        starter.start();
        
    }//GEN-LAST:event_b_startActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() {
                new Server().setVisible(true);
            }
        });
    }
        public static String Log_in(String Username, String Password){
        List<String> Userdata;
        Userdata = GetUsers();
        int size = Userdata.size()-1;
        String Present = "Unsuccesfull";
        while (size >= 1){
            System.out.println(Userdata.get(size-1));
            System.out.println(Username);
            if ((Userdata.get(size).equals(Password))&&(Userdata.get(size-1).equals(Username))){
                Present = "Succesfull";
                System.out.println("User found");
            }
            size = size -2;
        }
        if ("Unsuccesfull".equals(Present)){
            System.out.println("Not User");
        }
        return Present;
    }
        
       /*
    public static boolean New_User(String Username, String Password,String New_Username, String New_Password){
        boolean Present ;
        Present = Log_in(Username, Password);
        if(Present){
            AddUser(New_Username, New_Password);
            return true;
        }else{
            System.out.println("Could not add new user");
            return false;
        }
    }
    public static void AddUser(String New_Username, String New_Password){
        boolean User_Already_Present = Log_in(New_Username, New_Password);
        if (User_Already_Present){
            System.out.println("Unable to add new user as already exists");
        }
        else{
        try{
            FileWriter fout = new FileWriter("Admin.txt",true);
            BufferedWriter x = new BufferedWriter(fout);
            PrintWriter pout = new PrintWriter(x);
            pout.println(New_Username);
            pout.println(New_Password);
            pout.close();
            x.close();
            fout.close();
            System.out.println("New User added!");
        }
        catch(IOException e){
            System.out.println("Error opening file");
        }
    }
        
    }
*/
        
public void SendMessage(String message) 
    {
	Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) 
        {
            try 
            {
                PrintWriter writer = (PrintWriter) it.next();
		writer.println(message);
                writer.flush();

            } 
            catch (Exception ex) 
            {
		System.out.println("Error telling everyone. \n");
            }
        } 
    }
    public static List<String> GetUsers(){
        List<String> Userdata = new ArrayList<>();
        try{
            Path path = Paths.get("Admin.txt");
            Scanner scanner = new Scanner(path);
            System.out.println("Read text file using Scanner");
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
        return Userdata;
    }
    public class ServerStart implements Runnable 
    {
        @Override
        public void run() 
        {
            clientOutputStreams = new ArrayList();
            users = new ArrayList();  

            try 
            {
                ServerSocket serverSock = new ServerSocket(2222);

                while (true) 
                {
                    System.out.println("1");
				Socket clientSock = serverSock.accept();
                                System.out.println("2");
				PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
				clientOutputStreams.add(writer);
				Thread listener = new Thread(new ClientHandler(clientSock, writer));
				listener.start();
				System.out.println("Got a connection. \n");
                }
            }
            catch (IOException ex)
            {
                System.out.println("Error making a connection. \n");
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_end;
    private javax.swing.JButton b_start;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
