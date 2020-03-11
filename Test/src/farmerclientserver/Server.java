/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmerclientserver;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Harry
 */
public class Server {
    public static void main(String args[])throws Exception
    {
        try (ServerSocket ss = new ServerSocket(3333)) {
            Socket s = ss.accept();/*Establish connection*/
            DataInputStream dis = new DataInputStream(s.getInputStream());
            /*DataInputStream is used for reading primitive data types and function
            getInputStream for obtaining the appended data to the socket
            */
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);
            String s1="",s2="";
            while(!s1.equals("stop")){
                s1=dis.readUTF();
                System.out.println("Client : " +s1);
                s2=stdin.readLine();
                dos.writeUTF(s2);
                dos.flush();
                
                
            }   dis.close();
            s.close();
        } /*Establish connection*/
        
        
        
        
    }
    
}
