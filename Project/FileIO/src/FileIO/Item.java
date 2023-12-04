
package FileIO;

import Interface.Utility;
import java.util.Scanner;

public class Item {
    private int value;
    private String creator;
    
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

    public void input(Scanner sc) {
        Utility ul = new Utility();
        value = ul.getInt(sc, "Enter the value (from 1-100): ", 1, 100);
        creator = ul.getString(sc, "Enter the creator", false, "");
    }

    public void output() {
        System.out.print(";" + value + ";" + creator);
    }
    
    @Override
    public String toString()
    {
        return value + ";" + creator + ";";
    }
}
