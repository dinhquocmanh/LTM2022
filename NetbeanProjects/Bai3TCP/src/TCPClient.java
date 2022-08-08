
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

            Socket socket = new Socket("127.0.0.1", 2208);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            Scanner s = new Scanner(System.in);
            System.out.println("Enter MSV:");
            String st = s.nextLine();
            out.write(st);
            out.newLine();
            out.flush();
            System.out.println("Sent MSV:" + st);

            String debai = reader.readLine();
            System.out.println("Received de bai: " + debai);
            
            // xu ly du lieu:
            String kituthuong = "";
            String kitudacbiet = "";
            for(int i=0;i<debai.length();i++){
                char c = debai.charAt(i);
                if(Character.isDigit(c) || Character.isAlphabetic(c)){
                    kituthuong += c;
                }else{
                    kitudacbiet += c;
                }
            }
            
            out.write(kituthuong);
            out.newLine();
            out.flush();
            
            out.write(kitudacbiet);
            out.newLine();
            out.flush();
            System.out.println("Sent Ket qua");
            

            reader.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
