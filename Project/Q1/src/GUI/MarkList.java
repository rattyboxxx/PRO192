/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Mark;
import DTO.Student;
import DTO.Subject;
import Utility.Utility;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 叫我Ratty
 */
public class MarkList extends ArrayList<Mark> implements IList {

    @Override
    public void loadFromFile(String file) {
        int count = 0;
        File f = new File(file);
        if (!f.exists())
        {
            System.out.println("Not exist");
            return;
        }
        try
        (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                String[] token = line.split(";");
                this.add(new Mark(token[0], token[1], Double.parseDouble(token[2])));
            }
        }
        catch (Exception ex) {}
    }

    @Override
    public void saveToFile(String file) {
        if (isEmpty()) return;
        try (FileWriter fw = new FileWriter(file); PrintWriter pw = new PrintWriter(fw))
        {
            stream().forEach((aThi) -> {                           
                pw.println(aThi);
            });
            pw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(StudentList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addEdit(Scanner sc) {
        Utility ul = new Utility();
        StudentList sl = new StudentList();
        sl.loadFromFile("C:\\JAVA\\students.txt");
        sl.display();
        int res = 0;
        String id;
        do {
            id = ul.getString(sc, "Enter studentID in the list:", false, "");
            for (Student s: sl) {
                if (s.getId().equals(id)) res = 1;
            }
        }
        while (res == 0);
        SubjectList sbl = new SubjectList();
        sbl.loadFromFile("C:\\JAVA\\subjects.txt");
        sbl.display();
        res = 0;
        String s_id;
        do {
            s_id = ul.getString(sc, "Enter subjectID in the list:", false, "");
            for (Subject sb: sbl) {
                if (sb.getId().equals(s_id)) res = 1;
            }
        }
        while (res == 0);
        
        double mark = ul.getDouble(sc, "Enter marks (0 - 10):", 0, 10);
        
        res = 0;
        for (int i = 0; i < size(); i++) {
            if (this.get(i).getStudentID().equals(id) && this.get(i).getSubjectID().equals(s_id)) {
                this.get(i).setMarks(mark);
                res = 1;
                break;
            }
        }
        if (res == 0) this.add(new Mark(id, s_id, mark));
    }

    @Override
    public void display() {
        System.out.println("List of marks:");
        this.stream().forEach((m) -> {
            System.out.println(m);
        });
    }
    
}
