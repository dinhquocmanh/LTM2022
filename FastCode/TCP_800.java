import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
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
 * @author 
 */
// ma hoa
public class Bai5TCP {

    public static void main(String[] args) {
        try {

            Socket socket = new Socket("10.170.46.222", 1107);
            // Data input stream
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            //System.out.println("Enter MSV:");
            String st = "B18DCCN393;800";
            out.write(st.getBytes());
            out.flush();
            System.out.println("Sent MSV:" + st);

            int a = in.readInt();
            int b = in.readInt();
            System.out.println("Received A: " + a);
            System.out.println("B: " + b);
            
            // xu ly du lieu:
            int tong = a+b;
            int tich = a*b;
            
            out.writeUTF(tong);
            out.writeUTF(tich);
            out.flush();
            System.out.println("Sent Ket qua: ");     

            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    

}
