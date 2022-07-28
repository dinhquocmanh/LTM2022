/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class ServerTCP implements Calculator_inf {

    private static int DEFAULT_PORT = 9999;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(DEFAULT_PORT);
            Socket client = ss.accept();

            System.out.println("Connected");
            InputStream inputStream = client.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            OutputStream outputStream = client.getOutputStream();
            PrintWriter objectOutputStream = new PrintWriter(outputStream);
            try {
                while (true) {
                    Model data = null;
                    while (true) {
                        data = (Model) objectInputStream.readObject();
                        if (data == null) {
                            continue;
                        }
                        System.out.println("Receive");
                        int result = 0;
                        switch (data.getType()) {
                            case 1:
                                result = data.getA() + data.getB();
                                break;
                            case 2:
                                result = data.getA() - data.getB();
                                break;
                            case 3:
                                result = data.getA() / data.getB();
                                break;
                            case 4:
                                result = data.getA() * data.getB();
                                break;
                        }
                        System.out.println("Result: " + result);
                        objectOutputStream.println(result + "");
                        objectOutputStream.flush();
                        data = null;
                        break;
                    }
                }
            } catch (Exception e) {

            }

//            Thread thread;
//            thread = new Thread() {
//                @Override
//                public void run() {
//                    
//            };
//            thread.start();
        } catch (Exception e) {
        }
    }

    @Override
    public int plus(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }
}
