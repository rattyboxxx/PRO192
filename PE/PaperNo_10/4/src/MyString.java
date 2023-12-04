
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ratty
 */
public class MyString implements IString {

    public int count(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                char s = Character.toLowerCase(str.charAt(i));
                if (s != 'a' && s != 'e' && s != 'i' && s != 'o' && s != 'u') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int f1(String str) {
        String[] words = str.split("[\\s]+");
        int count = 0;
        for (String word : words) {
            if (count(word) > 1) {
                ++count;
            }
        }
        return count;
    }

    @Override
    public String f2(String str) {
        ArrayList<Character> chr = new ArrayList<>();
        ArrayList<Integer> count = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toLowerCase(str.charAt(i));
            if (chr.indexOf(c) == -1) {
                chr.add(c);
            }
        }
        for (char c: chr) {
            int cou = 0;
            for (int i = 0; i < str.length(); i++) {
                char s = Character.toLowerCase(str.charAt(i));
                if (c == s) {
                    ++cou;
                }
            }
            count.add(cou);
        }
        
        for (int i = 0; i < chr.size(); i++) {
            for (int j = 0; j < chr.size()-1; j++) {
                if (chr.get(j) < chr.get(j+1)) {
                    Collections.swap(chr, j, j+1);
                    Collections.swap(count, j, j+1);
                }
            }
        }
        
        boolean check = true;
        String res = "";
        for (int i = 0; i < chr.size(); i++) {
            if (count.get(i) > 1) {
                check = false;
                res += chr.get(i) + "";
            }
        }
        if (check) res = "NO";
        return res;
    }

}
