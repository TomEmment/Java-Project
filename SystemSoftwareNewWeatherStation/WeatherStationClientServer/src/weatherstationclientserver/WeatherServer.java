/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstationclientserver;


import static farmerclientserver.DataDisplayScreen.s;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Thoma
 */
public class WeatherServer {
        static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
        public WeatherServer(String Message) {

            System.out.println("WeatherStation Created");
        GenerateData(Message);
  
    
    }
        public void GenerateData(String File){

  

        List<String> Userdata = new ArrayList<String>();
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

         try{

        s = new Socket("127.0.0.1",1201); //here the IP address is local address because client and server are on the same computer
        din = new DataInputStream(s.getInputStream());
        dout = new DataOutputStream(s.getOutputStream()); 
        String UserdataFinal = String.join(",", Userdata);
        
        
        dout.writeUTF(UserdataFinal);
        din.close();
    
    }
    catch(Exception e){
       System.out.println("Station had Error Connection to Server");
    }


}
}