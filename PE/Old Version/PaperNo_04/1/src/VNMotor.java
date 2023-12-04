
public class VNMotor extends Motor {

    String series;

    public VNMotor() {
    }

    public VNMotor(String brandName, String series, double price) {
        super.brandName = brandName;
        super.price = price;
        this.series = series;
    }

    /*Complete the below function for second test case*/
    public double getSalePrice() {
        if (price < 3000) return 0.95 * price;
        return 0.9 * price;
    }

    @Override
    public String toString() {
        return brandName + "\t" + series + "\t" + price;
    }

}
