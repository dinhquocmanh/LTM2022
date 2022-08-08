
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

            Socket socket = new Socket("203.162.10.109", 2208);
            // Data input stream
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            //System.out.println("Enter MSV:");
            String st = "B18DCCN416;915";
            out.write(st.getBytes());
            out.flush();
            System.out.println("Sent MSV:" + st);

            String debai = in.readUTF();
            int S = in.readInt();
            System.out.println("Received de bai: " + debai);
            System.out.println("S: " + S);
            
            // xu ly du lieu:
            Bai5TCP bai5 = new Bai5TCP();
            String ketqua = bai5.MaHoa(debai,S);    
            System.out.println(ketqua);
            
            out.write(ketqua.getBytes());
            out.flush();
            System.out.println("Sent Ket qua: "+ketqua);
            

            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    public String MaHoa(String debai, int s){
            String P = debai;
            String C = "";
            for(int i = 0;i<P.length();i++)
                  C += (char) ('A' + (P.charAt(i) - 'A' + s) % 26);
            return C;
      }
}
