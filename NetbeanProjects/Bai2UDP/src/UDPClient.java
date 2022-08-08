
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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

public class UDPClient {

    public static void main(String[] args) {
        try {
            // scan input
            //String msv = "B18DCCN393;932";

            // khai bao cac thu
            DatagramSocket datagramSocket = new DatagramSocket();
            byte[] readBuffer = new byte[1024];
            byte[] writeBuffer = null;

            // lay thong tin phia nguoi nhan
            InetAddress host = InetAddress.getByName("203.162.10.109");
            int port = 2208;

            // tao ra datagram packet sau do gui du lieu di
            Product937 msv = new Product937();
            writeBuffer = msv.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(writeBuffer, writeBuffer.length, host, port);
            datagramSocket.send(sendPacket);
            System.out.println("sent msv: " + msv);

            // nhan du lieu tra ve tu server
            DatagramPacket receivePacket = new DatagramPacket(readBuffer, readBuffer.length);
            datagramSocket.receive(receivePacket);

            // In ra man hinh
            String line = new String(receivePacket.getData());
            System.out.println("Received: " + line);
            
            // chuan hoa chuoi
            String ketqua = "";
            String requestId = line.split(";")[0];
            String data = line.split(";")[1];
            data = data.toLowerCase();
            
            for(int i=0;i<data.length();i++){
                char c = data.charAt(i);
                
                if (i==0){
                    ketqua += Character.toUpperCase(c);
                } else if(Character.isAlphabetic(c)  ){
                    char b = data.charAt(i-1);
                    if(b == ' '){
                        ketqua +=" "+ Character.toUpperCase(c);
                    }else{
                        ketqua += c;
                    }    
                }
            }
            ketqua = requestId+';'+ketqua;
            // tao ra datagram packet sau do gui du lieu di
            writeBuffer = ketqua.getBytes();
            DatagramPacket ketquaPacket = new DatagramPacket(writeBuffer, writeBuffer.length, host, port);
            datagramSocket.send(ketquaPacket);
            System.out.println("sent ketqua: " + ketqua);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
