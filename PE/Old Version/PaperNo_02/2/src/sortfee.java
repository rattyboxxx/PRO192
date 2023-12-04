
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 叫我Ratty
 */
public class sortfee implements Comparator<Course> {

    @Override
    public int compare(Course o1, Course o2) {
        if (o1.getFee() == o2.getFee()) return o1.getName().compareTo(o2.getName());
        return Double.compare(o1.getFee(), o2.getFee());
    }
    
}
