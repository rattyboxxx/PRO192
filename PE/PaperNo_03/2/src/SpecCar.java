/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ratty
 */
public class SpecCar extends Car {
    private int type;

    public SpecCar() {
    }

    public SpecCar(int type) {
        this.type = type;
    }

    public SpecCar(String maker, int price, int type) {
        super(maker, price);
        this.type = type;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + type;
    }
    
    public void setData() {
        // lấy ra giá trị ban đầu của maker và price
        // -> maker = getMaker(), price = getPrice()
        // thêm chuỗi XZ vào đầu maker, thêm 20 vào price
        // maker = "XZ" + maker, price = 20 + price
        // set giá trị mới vào đối tượng
        // setMaker(maker), setPrice(price)
        
        String maker = super.getMaker();
        int price = super.getPrice();
        maker = "XZ" + maker;
        price = 20 + price;
        super.setMaker(maker);
        super.setPrice(price);
    }   
    
    public int getValue() {
        
    }
}
