public class Circle implements IShape{
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }
    
    @Override
    public double perimeter()
    {
        return 2 * IShape.pi * radius;
    }

    @Override
    public double are() {
        return IShape.pi * radius * radius;
    }
}
