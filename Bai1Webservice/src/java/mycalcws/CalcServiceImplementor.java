/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycalcws;

import javax.jws.WebService;

/**
 *
 * @author dmanh
 */
@WebService
public class CalcServiceImplementor implements CalcServiceInterface{
    @Override
    public int sum(int x, int y){
        return x+y;
    }
    
    @Override
    public int prod(int x, int y){
        return x*y;
    }
}
