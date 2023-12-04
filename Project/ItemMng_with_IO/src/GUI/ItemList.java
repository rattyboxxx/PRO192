
package GUI;

import DTO.Item;
import DTO.Painting;
import DTO.Vase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class ItemList
{
    private final Item[] list = new Item[100];
    private int numOfItem = 0;
    public static int Max = 100;
    Scanner sc = new Scanner(System.in);
    
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
                if (item != null) list[numOfItem++] = item;
            }
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
    
    public boolean addItem(Scanner sc, String msg)
    {
        switch (msg)
        {
            case "Vase":
                Vase it = new Vase();
                it.input(sc);
                list[numOfItem++] = it;
                return true;
            case "Painting":
                Painting it1 = new Painting();
                it1.input(sc);
                list[numOfItem++] = it1;
                return true;
            default:
                return false;                
        }
    }
    
    public boolean updateItem(Scanner sc ,int index)
    {
        if (index >= 0 && index < numOfItem)
        {
            list[index].input(sc);
            return true;
        }
        return false;
    }
    
    public boolean removeItem(int index)
    {
        if (index >= 0 && index < numOfItem)
        {
            for(int i = index; i < numOfItem-1; i++)
            {
                list[i]=list[i+1];
            }
            numOfItem--;
            return true;
        }
        System.out.println("The item doesn't exist.");
        return false;
    }
    
    public void displayAll()
    {
        if (numOfItem == 0)
        {
            System.out.println("The list is empty!");
        }
        else
        {
            for(int i = 0; i < numOfItem; i++)
            {
                list[i].output();
            }
        }       
    }
    
    public void displayItemByType(String type)
    {
        if (numOfItem == 0)
        {
            System.out.println("The list is empty!");
        }
        else if (type.equals("Vase"))
        {
            for (int i = 0; i < numOfItem; i++)
                if(list[i] instanceof Vase) list[i].output();
        }
        else
        {
            for (int i = 0; i < numOfItem; i++)
                if (list[i] instanceof Painting) list[i].output();
        }
    }
    
    public void sortItem()
    {
        Arrays.sort(list, 0, numOfItem, new sortByValue());
        displayAll();
    }
    
    public int getNumOfItem()
    {
        return numOfItem;
    }
}
