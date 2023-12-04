/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.util.Scanner;

/**
 *
 * @author 叫我Ratty
 */
public class Utility implements IUtility {

    @Override
    public int getInt(Scanner sc, String msg, int min, int max) {
        int res;
        do {
            System.out.print(msg);
            String s = sc.nextLine();
            try {
                res = Integer.parseInt(s);
                if (res >= min && res <= max) break;
                else;
            }
            catch (Exception ex) {}
        }
        while (true);
        return res;
    }

    @Override
    public String getString(Scanner sc, String msg, boolean isEmpty, String pattern) {
        String res;
        do
        {            
            System.out.print(msg);
            res = sc.nextLine();
            if (res.isEmpty() && !isEmpty);
            else
            {
                if (pattern.isEmpty()) break;
                else if (res.matches(pattern)) break;
                else;
            }
        }
        while (true);
        return res;
    }

    @Override
    public double getDouble(Scanner sc, String msg, double min, double max) {
        double res;
        do {
            System.out.print(msg);
            String s = sc.nextLine();
            try {
                res = Double.parseDouble(s);
                if (res >= min && res <= max) break;
                else;
            }
            catch (Exception ex) {}
        }
        while (true);
        return res;
    }
    
}
