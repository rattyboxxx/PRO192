
public class VNCar extends Car {
    private int series;

    public VNCar() {
    }

    public VNCar(int series) {
        this.series = series;
    }

    public VNCar(String name, double price, int series) {
        super(name, price);
        this.series = series;
    }
    
    public double getSalePrice() {
        // if series < 300 -> return price + 0.1 * price
        // else -> return price
        
        // return series < 300 ? 1.1 * getPrice() : getPrice();
        double inc = 0;
        if (series < 300) {
            inc = 0.1 * getPrice();
        }
        return getPrice() + inc;
    }
}
