
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dmanh
 */
public class TCPServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2208);
            System.out.println("Listening...");
            while (true) {
                Socket socket = serverSocket.accept();

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                String line = reader.readLine();
                System.out.println("New sinh vien: " + line);

                String chuoikitu = "abc123@@@###";
                String kituthuong = "abc123";
                String kitudacbiet = "@@@###";

                out.write(chuoikitu);
                System.out.println("Sent to client: " + chuoikitu);
                out.newLine();
                out.flush();

                String result1 = reader.readLine();
                System.out.println("Sinh vien response 1: " + result1);
                String result2 = reader.readLine();
                System.out.println("Sinh vien response 2: " + result2);

                if (result1.equals(kituthuong) && result2.equals(kitudacbiet)) {
                    System.out.println("Correct!!");
                } else {
                    System.out.println("Sai roi!!");
                }

                reader.close();
                out.close();
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
