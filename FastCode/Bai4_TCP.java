
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
public class Bai4TCP {

    public static void main(String[] args) {
        try {

            Socket socket = new Socket("203.162.10.109", 2208);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //Scanner s = new Scanner(System.in);
            //System.out.println("Enter MSV:");
            String st = "B18DCCN393;915";
            out.write(st);
            out.newLine();
            out.flush();
            System.out.println("Sented MSV:" + st);

            String debai = reader.readLine();
            System.out.println("Received: " + debai);
            
            // xu ly du lieu:
            String ketqua = "";
            for(int i=0;i<debai.length();i++){
                char c = debai.charAt(i);
                if(Character.isAlphabetic(c)){
                    int found = 0;
                    for(int j=0;j<ketqua.length();j++){
                        char d = ketqua.charAt(j);
                        if(d==c){
                            found = 1;
                        }
                    }
                    if(found == 0){
                        ketqua+=c;
                    }
                }
            }
            
            out.write(ketqua);
            out.newLine();
            out.flush();
            System.out.println("Ket qua: "+ketqua);
            
            reader.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
