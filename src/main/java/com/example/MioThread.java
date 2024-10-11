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
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            do{
                input = in.readLine();
                System.out.println("String input: " + input);
        
                String ans = input.toUpperCase();
                out.writeBytes(ans + "\n");
                if(input.equals("!"))break;
            }while(true);
            
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}