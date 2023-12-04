
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) {
        ArrayList ar = new ArrayList();
        
        ar.add(new Student("A", 20));
        
        ar.add(new Student("C", 20));
        ar.add(new Student("D", 20));
        ar.add(new Student("E", 20));
        ar.add(new Student("E", 17));
        ar.add(new Student("B", 20));
        
        ar.stream().forEach((o) -> {
            System.out.println(o);
        });
    }
    
}
