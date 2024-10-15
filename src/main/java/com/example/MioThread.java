package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MioThread extends Thread{
    private Socket socket;
        
    
    public MioThread(Socket socket) {
            this.socket = socket;
    }

    @Override
    public void run() {

        try {
            String input;
            String sceltaInput;
            boolean errore = false;
            boolean uscita = false;
            String ans = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            do{
                input = in.readLine();
                if (input.equals("exit")){
                    System.out.println("chiusura");
                    break;
                }
                    
                sceltaInput = in.readLine();

                System.out.println("String input: " + input);
                System.out.println(" scelta input " + sceltaInput);
                

                switch (sceltaInput){

                    case "1":
                       ans = input.toUpperCase();
                        out.writeBytes(ans + "\n");
                        break;
                    
                    case "2":
                        ans = input.toLowerCase();
                        out.writeBytes(ans + "\n");
                        break;
                    
                    case "3":
                        System.out.println("scelta 3");
                        ans = new StringBuilder(input).reverse().toString();
                        out.writeBytes(ans + "\n");
                        break;
                    
                    case "4":
                        System.out.println("scelta 4");
                        int tmp = input.length();
                        out.writeBytes(tmp + "\n") ;                    
                        break;
                    
                   
                                               
                    default:
                        System.out.println("valore input errato");
                        errore = true;
                }
                
            }while(true);
            
            socket.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}