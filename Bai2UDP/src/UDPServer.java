
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
public class UDPServer {

    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(2208);
            byte[] readBuffer = new byte[1024];
            byte[] writeBuffer = null;

            System.out.println("Server listenningg..");
            while (true) {
                // khoi tao datagram packet de nhan du lieu
                DatagramPacket receivePacket = new DatagramPacket(readBuffer, readBuffer.length);
                datagramSocket.receive(receivePacket);

                // nhan ma sinh vien gui ve
                String line = new String(receivePacket.getData());
                System.out.println("New sinh vien: " + line);

                // Gui de bai cho sinh vien
                String debai = "1234;this is a very longgg sentence!";
                writeBuffer = debai.getBytes();

                // port cua client vua nay
                InetAddress host = receivePacket.getAddress();
                int port = receivePacket.getPort();

                // gui de bai cho client    
                DatagramPacket sendPacket = new DatagramPacket(writeBuffer, writeBuffer.length, host, port);
                datagramSocket.send(sendPacket);
                System.out.println("sent de bai: " + debai);

                //han bai lam tu sinh vien
                datagramSocket.receive(receivePacket);
                String bailam = new String(receivePacket.getData());
                System.out.println("Bai lam cua sinh vien: " + bailam);

                // Doi chieu voi ket qua:
                String ketquadung = "This Is A Very Longg Sentence!";
                if (bailam.equals(ketquadung)) {
                    System.out.println("Correct!");

                } else {
                    System.out.println("Sai roi!");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
