
public class Scholarship {
    private int percent;
    private double mark;

    public Scholarship() {
    }

    public Scholarship(int percent, double mark) {
        this.percent = percent;
        this.mark = mark;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
    
    @Override
    public String toString() {
        return percent + "%: " + mark;
    }
}
