package com.koshailimited.springbootdemoproject.SoketProgramming;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MyClient {

    public static void main(String args[]){

        try {
            Socket s = new Socket("localhost", 1234);

            System.out.println("Client is ready");
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeChars("hello server");
            dout.flush();
            s.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }
}
