
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CarManagement implements ICar {
    Scanner sc = new Scanner(System.in);
    ArrayList<Car> listCar = new ArrayList<>();

    @Override
    public void updatePhone(Car car) {
        if (listCar.isEmpty()) return;
        for (Car c: listCar) {
            if (c.getColor().equals(car.getColor()) && c.getCarId() == car.getCarId()) {
                if (c.getName().equalsIgnoreCase(car.getName())) {
                    System.out.println("Duplicated name!");
                    break;
                }
                else {
                    c.setName(car.getName());
                    System.out.println("Updated successfully!");
                }
            }
        }
    }

    @Override
    public void printCarList() {
        Collections.sort(listCar);
        
        if (listCar.isEmpty()) return;
        listCar.stream().forEach((c) -> {
            System.out.println(c);
        });
    }
}
