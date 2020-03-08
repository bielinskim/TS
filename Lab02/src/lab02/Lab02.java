package lab02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Student
 */
public class Lab02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        ServerSocket server = new ServerSocket(2019);
        while(true){
        Socket socket = server.accept();
        
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
       PrintStream res = new PrintStream(out);
       
       BufferedReader brIn = new BufferedReader(new InputStreamReader(in));
       String req = brIn.readLine();
       
       String[] tokens = req.split(" ");
       
       String operation = tokens[0];
       float test =0;
       if("+".equals(operation)) {
           test = Float.parseFloat(tokens[1]) + Float.parseFloat(tokens[2]);
           System.out.println(test);
       }
           
       if("-".equals(operation)) {
            test = Float.parseFloat(tokens[1]) - Float.parseFloat(tokens[2]);
       }
           
       if("*".equals(operation)) {
            test = Float.parseFloat(tokens[1]) * Float.parseFloat(tokens[2]);
       }
           
       if("/".equals(operation)) {
            test = Float.parseFloat(tokens[1]) / Float.parseFloat(tokens[2]);
       }
       
        PrintStream printClientOut = new PrintStream(out);
       printClientOut.println(test);
       
       socket.close();
        }
        
    }
    
}
