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
            String ans = "";
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            do{
                input = in.readLine();
                if (input.equals("exit")){
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
                        
                        ans = new StringBuilder(input).reverse().toString();
                        out.writeBytes(ans + "\n");
                        break;
                    
                    case "4":
                        
                        int tmp = input.length();
                        out.writeBytes(tmp + "\n") ;                    
                        break;
                  

                    default:
                    System.out.println("ERRORE");
                        String errore = "!";
                        out.writeBytes(errore + "\n");
                        break;
                       
                }
                
            }while(true);
            
            socket.close();
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}