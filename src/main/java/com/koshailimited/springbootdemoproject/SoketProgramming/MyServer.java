package com.koshailimited.springbootdemoproject.SoketProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void main(String args[]){

        try {
            ServerSocket ss = new ServerSocket(6666);

            System.out.println("Server is ready, waiting for client");

            Socket s = ss.accept();

            System.out.println("Client connected");

            DataInputStream dis = new DataInputStream(s.getInputStream());
            String msg = dis.readUTF().toString();
            System.out.println("Msg from client: "+msg);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String ms = scanner.next();
            dout.writeUTF(ms);
            dout.flush();

        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
