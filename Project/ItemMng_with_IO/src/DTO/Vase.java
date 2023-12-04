
package DTO;

import Utility.Utility;
import java.util.Scanner;

public class Vase extends Item{
    private int height;
    private String material;
    Utility ul = new Utility();
    
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
    public void output()
    {
        System.out.print("V;");
        super.output();
        System.out.println(";" + height + ";" + material);
    }
    
    @Override
    public void input(Scanner sc)
    {
        super.input(sc);
        this.height = ul.getInt(sc, "Enter height (1-100):", 1, 100);
        this.material = ul.getString(sc, "Enter material (not empty):", false, "");
    }
}
