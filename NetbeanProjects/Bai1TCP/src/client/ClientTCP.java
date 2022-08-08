/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ClientTCP {
    private static int DEFAULT_PORT = 9999;
    private static String HOST_NAME = "localhost";
    public static void main(String[] args) {
        MENU();
    }
    
    public static void MENU() {
        try {
            Socket client = new Socket(HOST_NAME, DEFAULT_PORT);
            OutputStream outputStream = client.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            
            InputStreamReader isr = new InputStreamReader(client.getInputStream());
            BufferedReader objectInputStream = new BufferedReader(isr);
            Scanner sc =new Scanner(System.in);
            while(true) {
                System.out.println("1. Plus");            
                System.out.println("2. Minus");
                System.out.println("3. Divide");
                System.out.println("4. Multiply");
                int choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 4) {
                    System.out.print("A: ");
                    int a = Integer.parseInt(sc.nextLine());
                    System.out.print("B: ");
                    int b = Integer.parseInt(sc.nextLine());
                    Model model = new Model(choice, a, b);
                    objectOutputStream.writeObject(model);
                    String result = null;
                    while(true) {
                        result = objectInputStream.readLine();
                        if (result == null) {
                            continue;
                        }
                        System.out.println("Result: " + result);
                        break;
                    }
                }
            }
        }
        catch (Exception e) {
            
        }
    }
}
