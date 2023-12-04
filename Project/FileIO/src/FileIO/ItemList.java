
package FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ItemList extends ArrayList<Item>
{    
    public boolean loadFromFile(String path, ItemList il)
    {
        int count = 0;
        File f = new File(path);
        if (!f.exists())
        {
            System.out.println("File not exist!");
            return false;
        }
        try
        (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                Item item = createItem(line);
                if (item != null) il.add(item);
            }
        }
        catch (Exception ex)
        {
            return false;
        }
        return true;
    }
    
    public boolean saveToFile(String path, ItemList il) throws IOException
    {
        File f1 = new File(path);
        try (FileWriter fw = new FileWriter(f1); PrintWriter pw = new PrintWriter(fw))
        {
            for (int i = 0; i < il.size(); i++)
                pw.println(il.get(i));
        }
        return true;
    }
    
    private Item createItem(String line)
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
                    tmp = token[5].equals("1");
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
    
    public void displayAll(ItemList il)
    {
        for (int i = 0; i < il.size(); i++)
            System.out.println(il.get(i));
    }
    
    public void displayItemByType(String type, ItemList il)
    {
        switch (type)
        {
            case "V":
                for (int i = 0; i < il.size(); i++)
                    if (il.get(i) instanceof Vase)
                        System.out.println(il.get(i));
                break;
            case "P":
                for (int i = 0; i < il.size(); i++)
                    if (il.get(i) instanceof Painting)
                        System.out.println(il.get(i));
                break;
        }
    }
}
