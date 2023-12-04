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
public class Item implements IIo{
    protected int value;
    protected String creator;
    Utility ut = new Utility();
    public Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public void input(Scanner sc) {
        this.value = ut.getInt(sc, "Enter value (1-100):", 1, 100);
        this.creator = ut.getString(sc, "Enter creator (not empty):", false, "");
    }

    @Override
    public void output() {
        System.out.println("Value: "+value);
        System.out.println("Creator: "+creator);
    }
    
}
