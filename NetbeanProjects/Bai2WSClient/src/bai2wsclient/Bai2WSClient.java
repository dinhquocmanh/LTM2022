/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2wsclient;

/**
 *
 * @author dmanh
 */
public class Bai2WSClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        bai2wsclient.NumberS_Service service = new bai2wsclient.NumberS_Service();
        bai2wsclient.NumberS port = service.getNumberSPort();
        
        String debai = port.getNumber("B18DCCN416");
        System.out.println(debai);
        
        // xu ly chuoi
        int id = Integer.parseInt(debai.split(";")[0]);
        String numbers = debai.split(";")[1];
        String arr_numbers_in_string[] = numbers.split(",");
        int[] arr_numbers_in_int = new int[100];
        int imax = 0;
        
        for(int i=0; i<arr_numbers_in_string.length;i++){
            int x = Integer.parseInt(arr_numbers_in_string[i]);
            arr_numbers_in_int[i] = x;
            imax = i;
        }
        
        int solonnhat = arr_numbers_in_int[0];
        for(int i=0;i<=imax;i++){
            //System.out.println(arr_numbers_in_int[i]);
            if (arr_numbers_in_int[i] > solonnhat){
                solonnhat = arr_numbers_in_int[i];
            }
        }
        
        System.out.println("So lon nhat: "+ solonnhat);
        
        // gui ket qua
        port.greatestNumber(id,Integer.toString(solonnhat));
        System.out.println("Da gui ket qua");
    }

    private static String getNumber(java.lang.String studentCode) {
        bai2wsclient.NumberS_Service service = new bai2wsclient.NumberS_Service();
        bai2wsclient.NumberS port = service.getNumberSPort();
        return port.getNumber(studentCode);
    }

    private static boolean greatestNumber(int reqId, java.lang.String greatestNumber) {
        bai2wsclient.NumberS_Service service = new bai2wsclient.NumberS_Service();
        bai2wsclient.NumberS port = service.getNumberSPort();
        return port.greatestNumber(reqId, greatestNumber);
    }
    
}
