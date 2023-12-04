
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StudentList extends ArrayList<Student>
{    
    // Lay token tu tep roi in ra man hinh
    public void loadfromfile(String file, StudentList exe, String pattern) throws FileNotFoundException, IOException
    {
        File f = new File(file);
        if (!f.exists())
        {
            System.out.println("File not found!");
            return;
        }
        try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] token = line.split(";");
                switch (file)
                {
                    case "exercises.txt":
                        Student m = new Student(token[0], token[1], Double.parseDouble(token[2]));
                        exe.add(m);
                        if (token[0].equals(pattern))
                            System.out.println(token[1] + "\t\t" + token[2]);
                        break;
                    case "marks.txt":
                        Student n = new Student(token[0], token[1], token[2], Double.parseDouble(token[3]));
                        exe.add(n);
                        if (token[0].equals(pattern))
                        {
                            File newf = new File("exercises.txt");
                            try (FileReader newfr = new FileReader(newf); BufferedReader newbr = new BufferedReader(newfr))
                            {
                                String newline;
                                while ((newline = newbr.readLine()) != null)
                                {
                                    String[] newtoken = newline.split(";");
                                    if (token[1].equals(newtoken[0]))
                                    {
                                        System.out.println(token[2] + "\t\t" + newtoken[2] + "\t\t" + token[3]);
                                        break;
                                    }
                                }
                                newbr.close();
                                newfr.close();
                            }
                        }
                        break;
                    case "students.txt":
                        Student p = new Student(token[0], token[1], Integer.parseInt(token[2]));
                        exe.add(p);
                        System.out.println(token[0] + "\t" + token[1]);
                        break;
                    case "subjects.txt":
                        Student e = new Student(token[0], token[1]);
                        exe.add(e);
                        for (String token1 : token)
                            System.out.print(token1 + "\t\t");
                        System.out.print("\n");
                        break;
                }
            }
            br.close();
            fr.close();
        }
    }
    
    // Kiem tra xem co thoa man hay khong
    public boolean find(String line, String path, StudentList exe, String pattern1, String pattern2)
    {
        // pattern1 will be used for Subject ID, pattern2 will be used for Student ID
        switch (path)
        {
            case "exercises.txt":
                for (int i = 0; i < exe.size(); i++)
                {
                    if (exe.get(i).getSbj_id().equals(pattern1))
                    {
                        if (exe.get(i).getEx_name().equals(line)) return false;
                    }                    
                }
                return true;
            case "marks.txt":
                for (int i = 0; i < exe.size(); i++)
                {
                    if (exe.get(i).getSbj_id().equals(pattern1))
                    {
                        if (exe.get(i).getEx_name().equals(line) && exe.get(i).getId().equals(pattern2)) return true;
                    }                    
                }
                return false;
            case "students.txt":
                for (int i = 0; i < exe.size(); i++) {
                    if (exe.get(i).getId().equals(line)) return true;
                }
                return false;
            case "subjects.txt":
                for (int i = 0; i < exe.size(); i++)
                {
                    if (exe.get(i).getSbj_id().equals(line)) return true;
                }
                return false;
        }
        return false;
    }
    
    // Tinh total
    public double total(StudentList sl, String pattern)
    {
        double res = 0;
        for (int i = 0; i < sl.size(); i++)
        {
            if (sl.get(i).getSbj_id().equals(pattern))
                res += sl.get(i).getPer();
        }
        return res;
    }
    
    // Tinh max percentage
    public double maxi(StudentList sl, String pattern)
    {
        double res = 100;
        for (int i = 0; i < sl.size(); i++)
        {
            if (sl.get(i).getSbj_id().equals(pattern))
                res -= sl.get(i).getPer();
        }
        return res;
    }
    
    
    // Tinh total mark
    public double totalmark(StudentList sl, String pattern) throws IOException
    {
        double res = 0;
        for (int i = 0; i < sl.size(); i++)
        {
            if (sl.get(i).getId().equals(pattern))
            {
                File f = new File("exercises.txt");
                try (FileReader fw = new FileReader(f); BufferedReader br = new BufferedReader(fw))
                {
                    String line;
                    while ((line = br.readLine()) != null)
                    {
                        String[] token = line.split(";");
                        if (sl.get(i).getEx_name().equals(token[1]))
                        {                       
                            res += Double.parseDouble(token[2]) * sl.get(i).getMark();
                            break;
                        }
                    }
                    br.close();
                    fw.close();
                }
            }            
        }
        return res/100;
    }
    
    // Kiem tra xem mon hoc do co bai tap cua hoc sinh do khong
    public boolean checkblank(StudentList sl, String id, String subject)
    {
        for (int i = 0; i < sl.size(); i++)
        {
            if (sl.get(i).getId().equals(id) && sl.get(i).getSbj_id().equals(subject))
                return false;
        }
        return true;
    }
    
    // Luu vao tep
    public boolean saveToFile(String path, StudentList sl) throws IOException
    {
        File f1 = new File(path);
        try (FileWriter fw = new FileWriter(f1); PrintWriter pw = new PrintWriter(fw))
        {
            for (int i = 0; i < sl.size(); i++)
            {
                switch (path)
                {
                    case "exercises.txt":
                        pw.println(sl.get(i).getSbj_id() + ";" + sl.get(i).getEx_name() + ";" + sl.get(i).getPer());
                        break;
                    case "marks.txt":
                        pw.println(sl.get(i).getId() + ";" + sl.get(i).getSbj_id() + ";" + sl.get(i).getEx_name() + ";" + sl.get(i).getMark());
                        break;
                }        
            }                        
            pw.close();
            fw.close();
        }
        return true;
    }
}