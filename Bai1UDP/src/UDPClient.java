
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
            Scanner s = new Scanner(System.in);
            System.out.println("Enter a line:");
            String st = s.nextLine();

            // khai bao cac thu
            DatagramSocket datagramSocket = new DatagramSocket();
            byte[] readBuffer = new byte[1024];
            byte[] writeBuffer = null;

            // lay thong tin phia nguoi nhan
            InetAddress host = InetAddress.getByName("localhost");
            int port = 8079;

            // tao ra datagram packet sau do gui du lieu di
            writeBuffer = st.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(writeBuffer, writeBuffer.length, host, port);
            datagramSocket.send(sendPacket);
            System.out.println("sent: " + st);

            // nhan du lieu tra ve tu server
            DatagramPacket receivePacket = new DatagramPacket(readBuffer, readBuffer.length);
            datagramSocket.receive(receivePacket);

            // In ra man hinh
            String line = new String(receivePacket.getData());
            System.out.println("Received: " + line);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
