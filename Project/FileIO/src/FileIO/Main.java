
package FileIO;

import Interface.Utility;
import Interface.sortByValue;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ItemList il = new ItemList(), ul = new ItemList();
        ul.loadFromFile("Input.txt", il);
        int choice;
        do
        {
            System.out.println("----------");
            System.out.println("1. Add a new Vase");
            System.out.println("2. Add a new Painting");
            System.out.println("3. Display all items");
            System.out.println("4. Update item by index");
            System.out.println("5. Remove item by index");
            System.out.println("6. Display Vase items");
            System.out.println("7. Display Painting items");
            System.out.println("8. Sort items by ascending value");
            System.out.println("9. Exit");
            System.out.println("----------");
            Utility u = new Utility();
            choice = u.getInt(sc, "Enter your choice (1-9): ", 1, 9);
            Item item;
            int index;
            switch (choice)
            {
                case 1:
                    item = new Vase();
                    item.input(sc);
                    il.add(item);
                    System.out.println("Done!");
                    break;
                case 2:
                    item = new Painting();
                    item.input(sc);
                    il.add(item);
                    System.out.println("Done!");
                    break;
                case 3:
                    ul.displayAll(il);
                    break;
                case 4:
                    index = u.getInt(sc, "Enter index: ", 0, il.size()-1);
                    item = il.get(index);
                    item.input(sc);
                    il.set(index, item);
                    System.out.println("Done!");
                    break;
                case 5:
                    index = u.getInt(sc, "Enter index: ", 0, il.size()-1);
                    il.remove(index);
                    System.out.println("Done!");
                    break;
                case 6:
                    ul.displayItemByType("V", il);
                    break; 
                case 7:
                    ul.displayItemByType("P", il);
                    break;
                case 8:
                    ul.sort(new sortByValue());
                    System.out.println("Done!");
                    break;
                case 9:
                    System.out.println("List saved to Output.txt. Good bye!");
                    ul.saveToFile("Output.txt", il);
                    break;
            }
            System.out.println();
        }
        while (choice != 9);
    }
}
