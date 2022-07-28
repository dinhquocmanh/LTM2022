
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dmanh
 */
public class UPDServer {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(8079);
            byte[] readBuffer = new byte[1024];
            byte[] writeBuffer = null;

            System.out.println("Server listenningg..");
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(readBuffer, readBuffer.length);
                datagramSocket.receive(receivePacket);

                String line = new String(receivePacket.getData());
                System.out.println("Received: " + line);
                writeBuffer = line.toUpperCase().getBytes();
                InetAddress host = receivePacket.getAddress();
                int port = receivePacket.getPort();

                DatagramPacket sendPacket = new DatagramPacket(writeBuffer, writeBuffer.length, host, port);
                datagramSocket.send(sendPacket);
                System.out.println("sent: " + line.toUpperCase());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
