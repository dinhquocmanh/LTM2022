/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai4ws;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author dmanh
 */
public class Bai4WS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        bai4ws.ProductS_Service service = new bai4ws.ProductS_Service();
        bai4ws.ProductS port = service.getProductSPort();
        Product debai  = port.getProduct("B18DCCN393");
        System.out.println("get product: "+ debai.id +";"+ debai.code);
        
        // UDP 
        // khai bao cac thu
        try{
            DatagramSocket datagramSocket = new DatagramSocket();
            byte[] readBuffer = new byte[1024];
            byte[] writeBuffer = null;

            // lay thong tin phia nguoi nhan
            InetAddress host = InetAddress.getByName("203.162.10.109");
            int portt = 2208;
            // tao ra datagram packet sau do gui du lieu di
            String codeid = debai.id +";"+ debai.code;
            writeBuffer = codeid.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(writeBuffer, writeBuffer.length, host, portt);
            datagramSocket.send(sendPacket);
            System.out.println("sent Code va id udp: " + codeid);

            // nhan du lieu tra ve tu server
            DatagramPacket receivePacket = new DatagramPacket(readBuffer, readBuffer.length);
            datagramSocket.receive(receivePacket);

            // In ra man hinh
            String line = new String(receivePacket.getData());
            System.out.println("Received udp: " + line);
            int giamgia=0;
            for(int i=0; i<line.length();i++){
                char c = line.charAt(i);
                if (Character.isDigit(c)){
                    giamgia=giamgia+ Character.getNumericValue(c);
                }
            }
            
            System.out.println("giam gia: "+giamgia);
            
            // gui ket qua len ws
            debai.setDiscount(giamgia);
            debai.setDiscountCode(line);
            boolean res = port.order(debai);
            System.out.println("ketqua: "+res);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static Product getProduct(java.lang.String studentCode) {
        bai4ws.ProductS_Service service = new bai4ws.ProductS_Service();
        bai4ws.ProductS port = service.getProductSPort();
        return port.getProduct(studentCode);
    }

    private static boolean order(bai4ws.Product product) {
        bai4ws.ProductS_Service service = new bai4ws.ProductS_Service();
        bai4ws.ProductS port = service.getProductSPort();
        return port.order(product);
    }
    
}
