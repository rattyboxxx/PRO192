package GUI;


import DTO.Item;
import DTO.Painting;
import DTO.Vase;
import Utility.Utility;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class Main {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        ItemList il = new ItemList();
        do
        {
            System.out.println("1. Add a new Vase");
            System.out.println("2. Add a new Painting");
            System.out.println("3. Display all items");
            System.out.println("4. Update item by index");
            System.out.println("5. Remove item by index");
            System.out.println("6. Display Vase items");
            System.out.println("7. Display Painting items");
            System.out.println("8. Sort items by ascending value");
            System.out.println("9. Exit");
            Utility u = new Utility();
            choice = u.getInt(sc, "Enter your choice (1-9):", 1, 9);
            Item item;
            switch(choice)
            {
                case 1:
                    item = new Vase();
                    item.input(sc);
                    il.addItem(item);
                    break;
                case 2:
                    item = new Painting();
                    item.input(sc);
                    il.addItem(item);
                    break;
                case 3:
                    il.displayAll();
                    break;
                case 4:
                    int index = u.getInt(sc, "Enter index: ", 0, ItemList.Max);
                    il.updateItem(sc, index);
                    break;
                case 5:
                    index = u.getInt(sc, "Enter index: ", 0, ItemList.Max);
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
            System.out.println("Press enter key to continue");
            sc.nextLine();
        } while(choice != 9);
        
    }
}


