/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Item;
import DTO.Painting;
import DTO.Vase;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author PC
 */

public class ItemList {
    private Item[] list;
    private int numOfItem;
    public static int Max=100;
    Scanner sc = new Scanner(System.in);
    
    
    public ItemList() {
        list = new Item[100];
        numOfItem = 0;
    }
    
    public boolean addItem(Item item){
        if(numOfItem>=Max){
            System.out.println("The list is full.");
            return false;
        }
        list[numOfItem] = item;
        numOfItem ++;
        System.out.println("The item has been added.");
        return true;
    }
    
    public boolean updateItem(Scanner sc ,int index){
        if(index>=0 && index<numOfItem){
            list[index].input(sc);
            return true;
        }
        return false;
    }
    
    public boolean removeItem(int index){
        if(index>=0 && index<numOfItem){
            for(int i=index;i<numOfItem-1;i++){
                list[i]=list[i+1];
            }
            numOfItem--;
            System.out.println("The item has been removed.");
            return true;
        }
        System.out.println("The item doesn't exist.");
        return false;
    }
    
    public void displayAll(){
        if(numOfItem==0){
            System.out.println("The list is empty!");
        }else{
            for(int i=0;i<numOfItem;i++){
                System.out.println("Item "+i+":");
                list[i].output();
            }
        }
        
    }
    
    public void displayItemByType(String type){
        boolean check=false;
        if(numOfItem==0){
            System.out.println("The list is empty!");
        }else if(type.equals("Vase")){
            for(int i=0;i<numOfItem;i++){
                if(list[i] instanceof Vase){
                    System.out.println("Item "+i+":");
                    list[i].output();
                    check=true;
                }
            }
        }else if(type.equals("Painting")){
            for(int i=0;i<numOfItem;i++){
                if(list[i] instanceof Painting){
                    System.out.println("Item "+i+":");
                    list[i].output();
                    check=true;
                }
            }
        }
    }
    
    public void sortItem(){
        Arrays.sort(list, 0, numOfItem, new sortByValue());
    }
}
