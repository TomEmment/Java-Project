/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstationclientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Harry
 */

public class WeatherStation {

    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    
    WeatherStation(List<String> Files){

    }
    
    //Define all of the methods
    //Set all of the methods
    //Updating each variable
    

 

    public void main(String args[])throws Exception
    {
        String Message ="";
          try (ServerSocket ss = new ServerSocket(1202)) {
            Socket s = ss.accept();
            while (!Message.equals("exit")){
                Message = din.readUTF();
            }
            //Read Message
            //First Letter = File, Second Variuable X, Third Variable Y
            System.out.println("Test3");
            String NewMessage ="";
            NewMessage = getDataX() +getDataY(); 
            dout.writeUTF(NewMessage);
            
            
          }
          
          catch(Exception e){
              
          }
              
         
          
    }
  public String getDataX(){
         
       String VariableX = "12,23,5,43,7,8";
       return VariableX;
    }   
   public String getDataY(){
         
       String VariableY = "13,45,76,56,65";
       return VariableY;
    }   
}
