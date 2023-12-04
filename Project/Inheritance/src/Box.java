public class Box extends Rectangle {
    private int height;

    public Box() {
        super();
    }

    public Box(int length, int width, int height) {
        super(length, width);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    @Override
    public void display() {
        System.out.println("It is a box");
    }
    
    @Override
    public String toString() {
        String msg = "";
        msg += super.toString();
        msg += "\nHeight: "+ height;
        return msg;
    }
    
    
}
