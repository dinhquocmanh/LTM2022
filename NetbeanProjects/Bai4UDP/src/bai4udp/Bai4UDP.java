/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4udp;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author dmanh
 */
public class Bai4UDP {

     public static void main(String[] args) {
        try {
            Socket client = new Socket("203.162.10.109", 2209);
            // khai bao
            DataOutputStream outToServer = null;
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
            System.out.println("Connected");    
            
            // send file
            Customer938 msv = new Customer938();
            msv.setCode("B18DCCN393");
            
            oos.writeObject(msv);
            oos.flush();
            System.out.println("Send msv package");
            
            // receive de bai
            Customer938 debai = (Customer938) ois.readObject();
            System.out.println("Received debai package");
//            System.out.println("ID: "+ debai.getId());
//            System.out.println("Name: "+ debai.getName());
//            System.out.println("Quantity: "+ debai.getQuantity());
//            
//            // xu ly du lieu
//            String name_temp = "";
//            String soluong_temp = "";
//            for (int i=0; i< debai.getName().split(" ").length;i++){
//                name_temp = debai.getName().split(" ")[i] + name_temp;
//            }
//            debai.setName(name_temp);
//            String id_str = Integer.toString(debai.getQuantity());
//            for (int i=0; i< id_str.length() ;i++){
//                char c = id_str.charAt(i);
//                soluong_temp = c + soluong_temp;
//            }
//            debai.setQuantity(Integer.parseInt(soluong_temp));
//            System.out.println("Converted!!!");
//            System.out.println("ID: "+ debai.getId());
//            System.out.println("Name: "+ debai.getName());
//            System.out.println("Quantity: "+ debai.getQuantity());
//            
//            // gui lai file
//            oos.writeObject(debai);
//            System.out.println("Send bailam package");
            
            // close connection
            outToServer.close();
            ois.close();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
