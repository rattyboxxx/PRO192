
public class Carpet {
    private String maker;
    private int size;

    public Carpet() {
    }

    public Carpet(String maker, int size) {
        this.maker = maker;
        this.size = size;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        return maker + ", " + size;
    }
}
