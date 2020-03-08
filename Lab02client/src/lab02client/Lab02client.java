/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import static java.lang.System.in;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Lab02client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",2019);
        InputStream clientIn = client.getInputStream();
        OutputStream clientOut = client.getOutputStream();
        
         
       Scanner userInput = new Scanner(System.in);
       
       System.out.println("Podaj typ operacji: ");
       
       String token1 = userInput.next();
       
       System.out.println("Podaj argument 1: ");
       
       String token2 = userInput.next();
       
       System.out.println("Podaj argument 2: ");
       String token3 = userInput.next();
       
       String string = token1+" "+token2+" "+token3;
      
       PrintStream printClientOut = new PrintStream(clientOut);
       printClientOut.println(string);
       
 
      
       
       BufferedReader clIn = new BufferedReader(new InputStreamReader(clientIn));
       String res = clIn.readLine();
       
       
       System.out.println(res);
       
      
    }
    
}
