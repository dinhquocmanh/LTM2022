import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.net.Socket;

public class TCP_912 {
    public static void main(String[] args) {
        try {
            // khoi tao socket, reader, writer
            Socket socket = new Socket("10.170.40.202",1108);
            BufferedReader reader = new BufferedReader(socket.getInputStream());
            BufferedWriter writer = new BufferedWriter(socket.getOutputStream());

            // send msv
            String msv = "B18DCCN393;912";
            writer.write(msv);
            writer.newLine();
            writer.flush();
            
            // receive debai
            String debai = reader.readLine();
            System.println("Received" + debai);

            // xu ly du lieu
            String chuoi1 = ""; //ki tu va so
            String chuoi2 = ""; //ki tu dac biet

            for(int i=0;i<debai.length();i++){
                char c = debai.charAt(i);
                if (Character.isAlphabetic(c) | Character.isDigit(c)){
                    // kiem tra trung lap
                    int found = 0;
                    for(int j=0;j<chuoi1.length();j++){
                        char d = ketchuoi1.charAt(j);
                        if (d==c){
                            found = 1;
                        }
                    }
                    if (found == 0){
                        chuoi1+=c;
                    }
                }else{
                    // xu ly ki tu dacbiet
                    int found = 0;
                    for(int j=0;j<chuoi2.length();j++){
                        char d = chuoi2.charAt(j);
                        if (d==c){
                            found = 1;
                        }
                    }
                    if (found == 0){
                        chuoi2+=c;
                    }
                }
            }

            writer.write(chuoi1);
            writer.write(chuoi2);

            reader.close();
            writer.close();
            socket.close();

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}   
