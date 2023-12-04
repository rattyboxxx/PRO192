package GUI;

import DTO.Item;
import Utility.Utility;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int choice;
        Scanner sc = new Scanner(System.in);
        ItemList il = new ItemList();
        il.loadFromFile("item.txt");
        il.displayAll();
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
            System.out.println();
            Item item;
            switch(choice)
            {
                case 1:
                    il.addItem(sc, "Vase");
                    break;
                case 2:
                    il.addItem(sc, "Painting");
                    break;
                case 3:
                    il.displayAll();
                    break;
                case 4:
                    int index = u.getInt(sc, "Enter index: ", 0, il.size()-1);
                    il.updateItem(sc, index);
                    break;
                case 5:
                    index = u.getInt(sc, "Enter index: ", 0, il.size()-1);
                    il.removeItem(index);
                    break;
                case 6:
                    il.displayItemByType("Vase");
                    break;
                case 7:
                    il.displayItemByType("Painting");
                    break;
                case 8:
                    il.sortItem();
                    break;
                case 9:
                    System.out.println("See you soon!");
                    break;
            }
//            il.saveToFile("item.txt");
            System.out.println("\nPress enter key to continue");
            sc.nextLine();
        }
        while(choice != 9);       
    }
}


