/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycalcws;
import javax.jws.WebMethod;
import javax.jws.WebService;
/**
 *
 * @author dmanh
 */
@WebService
public interface CalcServiceInterface {
    @WebMethod
    int sum(int x, int y);
    @WebMethod
    int prod(int x, int y);
}
