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
public class Painting extends Item{
    private int height;
    private int width;
    private boolean isWatercolour;
    private boolean isFramed;
    Utility ut = new Utility();
    
    public Painting() {
    }

    public Painting(int value, String creator, int height, int width, boolean isWatercolour, boolean isFramed) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWatercolour = isWatercolour;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isIsWatercolour() {
        return isWatercolour;
    }

    public void setIsWatercolour(boolean isWatercolour) {
        this.isWatercolour = isWatercolour;
    }

    public boolean isIsFramed() {
        return isFramed;
    }

    public void setIsFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }

    @Override
    public void input(Scanner sc){
        super.input(sc);
        this.height = ut.getInt(sc, "Enter height (1-100):", 1, 100);
        this.width = ut.getInt(sc, "Enter width (1-100):", 1, 100);
        this.isWatercolour = ut.getInt(sc, "Enter isWatercolour (1-true, 0-false):", 0, 1)==1;
        this.isFramed = ut.getInt(sc, "Enter isFramed (1-true, 0-false):", 0, 1)==1;
    }
    
    public void output(){
        super.output();
        System.out.println("Height: "+height);
        System.out.println("Width: "+width);
        if(isWatercolour){
            System.out.println("isWatercolour: Yes");
        }else{
            System.out.println("isWatercolour: No");
        }
        if(isFramed){
            System.out.println("isFramed: Yes");
        }else{
            System.out.println("isFramed: No");
        }
    }
}
