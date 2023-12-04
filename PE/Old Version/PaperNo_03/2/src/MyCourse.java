 
import java.util.*;

public class MyCourse implements ICourse { 

     
    @Override
    public void f1(List<Course> a, int st) {
        if (st == 1)
        {
            Collections.sort(a, new Comparator<Course>(){
                @Override
                public int compare(Course o1, Course o2) {
                    if (o1.getFee() == o2.getFee()) return o1.getName().compareTo(o2.getName());
                    return Double.compare(o1.getFee(), o2.getFee());
                }
            });
        }
        else
        {
            Collections.sort(a, new Comparator<Course>(){
                @Override
                public int compare(Course o1, Course o2) {
                    if (o1.getName().toLowerCase().equals(o2.getName().toLowerCase())) return Double.compare(o1.getFee(), o2.getFee());
                    return o2.getName().compareToIgnoreCase(o1.getName());
                } 
            });
        }
                    
    }
    

    @Override
    public int f2(List<Course> a, double fee) {
        int sum = 0;
        for (Course c: a)
        {
            if (c.getFee() >= fee) sum++;
        }
        return sum;
    }
     
}
