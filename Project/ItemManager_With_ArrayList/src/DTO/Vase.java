/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Utility.Utility;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Vase extends Item{
    private int height;
    private String material;
    Utility ut = new Utility();
    
    public Vase() {
    }

    public Vase(int value, String creator,int height, String material) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    @Override
    public void input(Scanner sc)
    {
        super.input(sc);
        this.height = ut.getInt(sc, "Enter height (1-100):", 1, 100);
        this.material = ut.getString(sc, "Enter material (not empty):", false, "");
    }

    @Override
    public String toString() {
        return "V;"+super.toString()+";"+height+";"+material;
    }
    
    
}
