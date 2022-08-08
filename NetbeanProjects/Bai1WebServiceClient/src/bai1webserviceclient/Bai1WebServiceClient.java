/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1webserviceclient;

/**
 *
 * @author dmanh
 */
public class Bai1WebServiceClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CalcServiceImplementorService service = new CalcServiceImplementorService();
        CalcServiceImplementor port = service.getCalcServiceImplementorPort();
        System.out.printf("The sum of 2 and 3 is %d\n", port.sum(2, 3));
        System.out.printf("The product of 2 and 3 is %d\n", port.prod(2, 3));
    }

    private static int prod(int arg0, int arg1) {
        bai1webserviceclient.CalcServiceImplementorService service = new bai1webserviceclient.CalcServiceImplementorService();
        bai1webserviceclient.CalcServiceImplementor port = service.getCalcServiceImplementorPort();
        return port.prod(arg0, arg1);
    }

    private static int sum(int arg0, int arg1) {
        bai1webserviceclient.CalcServiceImplementorService service = new bai1webserviceclient.CalcServiceImplementorService();
        bai1webserviceclient.CalcServiceImplementor port = service.getCalcServiceImplementorPort();
        return port.sum(arg0, arg1);
    }

}
