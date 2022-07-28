/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Model implements Serializable{
    private int type;
    private int a, b;

    public Model() {
    }

    public Model(int type, int a, int b) {
        this.type = type;
        this.a = a;
        this.b = b;
    }

    
    
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    
    
}
