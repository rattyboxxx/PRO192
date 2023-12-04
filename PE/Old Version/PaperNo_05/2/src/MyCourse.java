
import java.util.*;

public class MyCourse implements ICourse {

    @Override
    public void f1(List<Course> a, int st) {
        if (st == 1) {
            Collections.sort(a);
        } else {
            Collections.sort(a, new sortByName());
        }
    }
    
    class sortByName implements Comparator<Course> {

        @Override
        public int compare(Course o1, Course o2) {
            return o2.name.compareTo(o1.name);
        }
    }

    @Override
    public int f2(List<Course> a, double fee) {
        int count = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).fee >= fee) {
                count++;
            }
        }
        return count;
    }
}
