public class Rectangle implements IShape{
    private int length;
    private int width;

    public Rectangle() {
    }

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    
    public void display() {
        IShape.display();
        print();
        System.out.println("It is a rectangle");      
    }
    
    @Override
    public void print()
    {
        System.out.println("Print of rectangle");
    }
    
    @Override
    public String toString() {
        String msg = "";
        msg += "Length: " + length;
        msg += "\nWidth: " + width;
        return msg;
    }
    
    @Override
    public double perimeter()
    {
        return 2 * (length + width);
    }

    @Override
    public double are() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
