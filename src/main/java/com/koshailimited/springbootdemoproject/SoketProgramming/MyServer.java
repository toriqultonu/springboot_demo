package com.koshailimited.springbootdemoproject.SoketProgramming;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;
import java.net.Socket;

public class MyServer {
    public static void main(String args[]){

        try {
            ServerSocket ss = new ServerSocket(1234);

            System.out.println("Server is ready, waiting for client");

            Socket s = ss.accept();

            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(s.getInputStream());

            System.out.println(dis.r);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
