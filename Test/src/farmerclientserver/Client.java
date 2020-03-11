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
import java.net.Socket;
    
/**
 *
 * @author Harry
 */
public class Client {
    public static void main(String args[])throws Exception
    {
        Socket s = new Socket("localhost",3333);
        
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(isr);
        String s1="",s2="";
        /*The code is written  in such a way that the client will be the first to ping
        then client will wait for the server to respond it is just like synchronous communication*/
        while(!s1.equals("stop"))
        {
            s2=stdin.readLine();
            dos.writeUTF(s2);
            dos.flush();
            s1=dis.readUTF();
            System.out.println("Server : "+s1);
            
            
            
        }
        dos.close();
        s.close();
    }
}
