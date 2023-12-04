
package Interface;

import FileIO.Item;
import java.util.Comparator;

public class sortByValue implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getValue() - o2.getValue();
    }
    
}
