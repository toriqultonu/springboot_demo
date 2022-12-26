package com.koshailimited.springbootdemoproject.SoketProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {

    public static void main(String args[]){

        try {
            Socket s = new Socket("localhost", 6666);

            System.out.println("Client is ready");
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String ms = scanner.next();
            dout.writeUTF(ms);
            dout.flush();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String msg = dis.readUTF().toString();
            System.out.println("Msg from server: "+msg);
            s.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
