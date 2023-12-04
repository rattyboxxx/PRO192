/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ratty
 */
public class SpecPen extends Pen {
    private int price;

    public SpecPen() {
    }

    public SpecPen(int price) {
        this.price = price;
    }

    public SpecPen(String name, String color, int price) {
        super(name, color);
        this.price = price;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + price;
    }
    
    public void setData() {
        super.setName(super.getName() + price);
    }
    
    public int getValue() {
        if (super.getColor().contains("Y") || super.getColor().contains("O")) {
            return price;
        }
        return price * 2;
    }
}
