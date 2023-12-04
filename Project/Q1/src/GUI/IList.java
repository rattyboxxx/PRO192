/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.Scanner;

/**
 *
 * @author 叫我Ratty
 */
public interface IList {
    void loadFromFile(String file);
    void saveToFile(String file);
    void addEdit(Scanner sc);
    void display();
}
