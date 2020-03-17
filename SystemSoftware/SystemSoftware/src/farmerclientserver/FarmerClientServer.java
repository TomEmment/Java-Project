/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmerclientserver;

/**
 *
 * @author Thoma
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import java.util.Random; 


public class FarmerClientServer {

    public static void main(String[] args) {
      /*
      InitializeFiles("Station1.txt",12);
      InitializeFiles("Station2.txt",12);
      InitializeFiles("Station3.txt",12);
      InitializeFiles("Station4.txt",12);
         */
      LogInScreen Instance = new LogInScreen();
      Instance.setVisible(true);
            
    
    }
    public static void InitializeFiles(String FileName, int Length)
    {
        int Start =8;
        int Start1 = 37;
        int Start2 = 20;
        int Start3 = 60;
        int Randomizer;
        int temp;
        
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
    System.out.println("Data Initilized");
    }
}