package com.koshailimited.springbootdemoproject.SoketProgramming;

import javax.naming.ldap.SortKey;

public class Socket {

    String IPA;
    int PortN;

    public void Accept(){
        System.out.println("Hello");
    }

    public Socket(String IPA, int portN) {
        this.IPA = IPA;
        this.PortN = portN;
    }

    public static void main(String args[]){

        Socket socket = new Socket("Tonu", 3297);

        socket.Accept();
    }
}
