
public class SpecCarpet extends Carpet {
    private int color;

    public SpecCarpet() {
    }

    public SpecCarpet(int color) {
        this.color = color;
    }

    public SpecCarpet(String maker, int size, int color) {
        super(maker, size);
        this.color = color;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + color;
    }
    
    public void setData() {
        // input: maker
        String maker = super.getMaker();
        String dau = maker.substring(0, 2);
        String duoi = maker.substring(4);
        String newMaker = dau + "HOA" + duoi;
        super.setMaker(newMaker);
    }
    
    public int getValue() {
        //return (super.getSize() < 6) ? color + 5 : color + 7;
        if (super.getSize() < 6) {
            return color + 5;
        }
        else return color + 7;
    }
}
 