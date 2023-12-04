
package GUI;

import DTO.Item;
import DTO.Painting;
import DTO.Vase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ItemList extends ArrayList<Item> {    

    public ItemList() {
    }
    
    public boolean loadFromFile(String ad)
    {
        int count = 0;
        File f = new File(ad);
        if (!f.exists())
        {
            System.out.println("Not exist");
            return false;
        }
        try
        (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                Item item = createItem(line);
                if (item != null) add(item);
            }
            br.close();
            fr.close();
        }
        catch (Exception ex)
        {
            return false;
        }
        return true;
    }
    
    private static Item createItem(String line)
    {
        Item item;
        String[] token;
        token = line.split(";");
        try
        {
            switch (token[0]) {
                case "V":
                    item = new Vase();
                    item.setValue(Integer.parseInt(token[1]));
                    item.setCreator(token[2]);
                    ((Vase)item).setHeight(Integer.parseInt(token[3]));
                    ((Vase)item).setMaterial(token[4]);
                    break;
                case "P":
                    item = new Painting();
                    item.setValue(Integer.parseInt(token[1]));
                    item.setCreator(token[2]);
                    ((Painting)item).setHeight(Integer.parseInt(token[3]));
                    ((Painting)item).setWidth(Integer.parseInt(token[4]));
                    boolean tmp;
                    tmp = token[5].equals("1");
                    ((Painting)item).setIsWatercolour(tmp);
                    tmp = token[6].equals("1");
                    ((Painting)item).setIsFramed(tmp);
                    break;
                default:
                    return null;
            }
        }
        catch (Exception ex)
        {
            return null;
        }
    return item;
    }
    
    public boolean saveToFile(String file) throws IOException
    {
        if (isEmpty()) return false;
        try (FileWriter fw = new FileWriter(file); PrintWriter pw = new PrintWriter(fw))
        {
            stream().forEach((aThi) -> {                           
                pw.println(aThi);
            });
            pw.close();
            fw.close();
        }
        return true;
    }
    
    public boolean addItem(Scanner sc, String type)
    {
        Item item;
        switch (type) {
            case "Vase":
                item = new Vase();
                break;
            case "Painting":
                item = new Painting();
                break;
            default:
                return false;
        }
        item.input(sc);
        add(item);
        return true;
    }

    public void displayAll(){
        if (isEmpty())
        {
            System.out.println("The list is empty!");
            return;
        }
        stream().forEach( (aThi) -> {
            System.out.println(aThi);
        } );      
    }
    
    public boolean updateItem(Scanner sc, int index){
        if (index < 0 || index >= size())
        {
            return false;
        }
        ((Item)get(index)).input(sc);
        return true;
    }
    
    public boolean removeItem(int index)
    {
        if (index < 0 || index >= size()) return false;
        remove(index);
        return true;
    }
    
    public void displayItemByType(String type){
        if (isEmpty()) System.out.println("The list is empty!");
        else if (type.equals("Vase"))
        {
            stream().filter((my) -> (my instanceof Vase)).forEach((my) -> {
                System.out.println(my);
            });
        }
        else if (type.equals("Painting")){
            stream().filter((my) -> (my instanceof Painting)).forEach((my) -> {
                System.out.println(my);
            });
        }
    }
    
    public void sortItem(){
        Collections.sort(this, new sortByValue());
        displayAll();
    }
}
