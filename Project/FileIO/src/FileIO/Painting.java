
package FileIO;

import Interface.Utility;
import java.util.Scanner;

public class Painting extends Item {
    private int height, width;
    private boolean isWatercolour, isFramed;

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
    public void output()
    {
        super.output();
        System.out.print(";" + height);
        System.out.print(";" + width);
        System.out.print(";" + (isWatercolour ? "1" : "0"));
        System.out.println(";" + (isFramed ? "1" : "0"));
    }
    
    @Override
    public void input(Scanner sc)
    {
        super.input(sc);
        Utility ul = new Utility();
        height = ul.getInt(sc, "Enter the height (from 1-100): ", 1, 100);
        width = ul.getInt(sc, "Enter the width (from 1-100): ", 1, 100);
        isWatercolour = ul.getInt(sc, "isWatercolour? (1-true, 0-false): ", 0, 1) == 1;
        isFramed = ul.getInt(sc, "isFramed? (1-true, 0-false): ", 0, 1) == 1;       
    }
    
    @Override
    public String toString()
    {
        return "P;" + super.toString() + height + ";" + width + ";" + (isWatercolour? 1: 0) + ";" + (isFramed? 1: 0);
    }
}
