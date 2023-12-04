
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScholarshipList extends ArrayList<Scholarship> {
    
    public void loadFromFile(String file) {
        File f = new File(file);
        if (!f.exists()) {
            System.out.println("Not exist");
            return;
        }
        try
        (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] m_token = line.split("[\\s]+");
                if (m_token[0].contains("T")) {
                    double mark = Double.parseDouble(m_token[2]);
                    br.readLine();
                    String n_line = br.readLine();
                    String[] p_token = n_line.split("[\\s]+");
                    if (p_token[0].contains("M")) {
                        int per = Integer.parseInt(p_token[5].substring(0, p_token[5].length()-1));
                        add(new Scholarship(per, mark));
                    }
                    else;
                }
            }
            br.close();
            fr.close();
            System.out.println("Done!");
        } catch (Exception ex) {
            System.out.println("Error!");
        }
        
        Collections.sort(this, (Scholarship o1, Scholarship o2) -> {
            if (o1.getPercent() == o2.getPercent()) return Double.compare(o1.getMark(), o2.getMark());
            return o1.getPercent() - o2.getPercent();
        });
    }
    
    public void saveToFile(String file) {
        if (isEmpty()) return;
        try (FileWriter fw = new FileWriter(file); PrintWriter pw = new PrintWriter(fw)) {
            stream().forEach((aThi) -> {                           
                pw.println(aThi);
            });
            pw.close();
            fw.close();
            System.out.println("Saved!");
        } catch (IOException ex) {
            System.out.println("Save error!");
            Logger.getLogger(ScholarshipList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void check() {
        int[] percent = {30, 50, 70, 100};
        for (int a: percent) {
            int count = 0;
            double mini = 200, maxi = 0;
            for (Scholarship s: this) {
                if (s.getPercent() == a) {
                    count++;
                    double mark = s.getMark();
                    if (mark < mini) mini = mark;
                    if (mark > maxi) maxi = mark;
                }
            }
            System.out.println(a + "%:\t" + count + " thí sinh\tMin-" + mini + "     Max-" + maxi);
        }
    }
}
