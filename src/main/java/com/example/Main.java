//server
package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server avviato");
        ServerSocket ser1 = new ServerSocket(3000);// apre una porta 
       
        do{
            Socket socket = ser1.accept(); // aspetta la connessione , restituisce una socket ;
            System.out.println("un client si è collegato");

            MioThread t  = new MioThread(socket);
            t.start();
        }while(true);
        

    }
}