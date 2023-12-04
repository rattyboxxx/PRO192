
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ratty
 */
public class MyPen implements IPen {
    
    public int count(String a) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'A') {
                ++count;
            }
        }
        return count;
    }

    @Override
    public int f1(List<Pen> t) {
        int count = 0;
        for (Pen p: t) {
            if (count(p.getName()) >= 2) {
                ++count;
            }
        }
        return count;
    }

    @Override
    public void f2(List<Pen> t) {
        int min_price = 99999, min_pos = 99999;
        for (int i = 0; i < t.size(); i++) {
            Pen p = t.get(i);
            if (p.getPrice() % 2 == 1 && p.getPrice() < min_price) {
                min_price = p.getPrice();
                min_pos = i;
            }
        }
        if (min_pos != 99999) {
            t.remove(min_pos);
        }
    }

    @Override
    public void f3(List<Pen> t) {
        for (int i = 2; i < 7; i++) {
            for (int j = 2; j < 6; j++) {
                Pen a1 = t.get(j), a2 = t.get(j+1);
                if (a1.getName().equals(a2.getName())) {
                    if (a1.getPrice() < a2.getPrice()) {
                        Collections.swap(t, j, j+1);
                    }
                }
                else if (a1.getName().compareTo(a2.getName()) > 0) {
                    Collections.swap(t, j, j+1);
                }
            }
        }
    }
    
}
