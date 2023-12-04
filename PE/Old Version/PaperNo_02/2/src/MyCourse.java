
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyCourse implements ICourse {

    @Override
    public void f1(List<Course> a, int st) {
        
        if (st == 1)
            Collections.sort(a, new Comparator<Course>() {
                @Override
                public int compare(Course o1, Course o2) {
                    if (o1.getFee() == o2.getFee()) return o1.getName().compareTo(o2.getName());
                    return Double.compare(o1.getFee(), o2.getFee());
                }
            });
        else
        {
            for (int i = 0; i < a.size(); i++)
            {
                if (a.get(i).getFee() <= 120) a.remove(i);
            }
        }
    }

    @Override
    public int f2(List<Course> a, double fee) {
        int count = 0;
        for(Course c : a){
            if(c.getFee() >= fee)
                count++;
        }
        return count;
    }
}
