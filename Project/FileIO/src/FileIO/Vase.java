
package FileIO;

import Interface.Utility;
import java.util.Scanner;

public class Vase extends Item {
    private int height;
    private String material;

    public Vase() {
    }

    public Vase(int value, String creator, int height, String material) {
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
        super.output();
        System.out.print(";" + height);
        System.out.println(";" + material);
    }
    
    @Override
    public void input(Scanner sc)
    {
        Utility ul = new Utility();
        super.input(sc);
        height = ul.getInt(sc, "Enter the height (from 1-100): ", 1, 100);
        material = ul.getString(sc, "Enter the material", false, "");
    }
    
    @Override
    public String toString()
    {
        return "V" + ";" + super.toString() + height + ";" + material;
    }
}

