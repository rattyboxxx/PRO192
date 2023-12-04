
public class Car implements Comparable {
    private int carId;
    private String name, color;

    public Car() {
    }

    public Car(int carId, String name, String color) {
        this.carId = carId;
        this.name = name;
        this.color = color;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return "(" + carId + ", " + name + ", " + color + ")";
    }

    @Override
    public int compareTo(Object o) {
        if (carId == ((Car)o).carId) return name.compareTo(((Car)o).name);
        return carId - ((Car)o).carId;
    }
}
