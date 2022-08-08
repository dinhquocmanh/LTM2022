
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dmanh
 */
public class TCPClient {

    public static void main(String[] args) {
        try {

            Socket socket = new Socket("127.0.0.1", 6789);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            Scanner s = new Scanner(System.in);
            System.out.println("Enter a line:");
            String st = s.nextLine();
            System.out.println("Sent:" + st);
            out.println(st);
            out.flush();

            String line = reader.readLine();
            System.out.println("Received: " + line);

            reader.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
