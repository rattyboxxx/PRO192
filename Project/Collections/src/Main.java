
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Main
{    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        File f = new File("dictionary.txt");
        HashSet hs;
        try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr))
        {
            String line;
            hs = new HashSet();
            while ((line = br.readLine()) != null)
            {
                String[] tokens = line.split(";");
                DictionaryWord dw = new DictionaryWord(tokens[0], tokens[1]);
                hs.add(dw);
            }
            br.close();
            fr.close();
        }
        
        hs.add(new DictionaryWord("bank robber", "you gay"));
        hs.add(new DictionaryWord("bank robber", "you chicken"));
        
        System.out.println("Using HashSet:");
        int i = 1;
        Iterator iter = hs.iterator();
        while (iter.hasNext())
        {
            System.out.format("%d.%s", i++, iter.next());
        }
    
        System.out.println("\nUsing TreeSet:");
        TreeSet ts = new TreeSet(hs);
        ts.add(new DictionaryWord("boy", "not girl"));
        iter = ts.iterator();
        i = 1;
        while (iter.hasNext())
        {
            System.out.format("%d.%s", i++, iter.next());
        }
    }    
}
