/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Student;
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
public class StudentList extends ArrayList<Student> implements IList {

    @Override
    public void loadFromFile(String file) {
        Scanner sc = new Scanner(System.in);
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
                this.add(new Student(token[0], token[1], Integer.parseInt(token[2])));
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
        this.display();
        Utility ul = new Utility();
        String id = ul.getString(sc, "Enter ID (HE012345):", false, "[H][E][0-9]{6}");
        String name = ul.getString(sc, "Enter name (NOT empty):", false, "");
        int age = ul.getInt(sc, "Enter age (18 - 25):", 18, 25);
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (this.get(i).getId().equals(id)) {
                this.set(i, new Student(id, name, age));
                count = 1;
                break;
            }
        }
        if (count == 0) this.add(new Student(id, name, age));
    }

    @Override
    public void display() {
        System.out.println("List of students:");
        this.stream().forEach((s) -> {
            System.out.println(s);
        });
    }
    
}
