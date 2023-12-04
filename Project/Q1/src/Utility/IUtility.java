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
public interface IUtility {
    int getInt(Scanner sc, String msg, int min, int max);
    String getString(Scanner sc, String msg, boolean isEmpty, String pattern);
    double getDouble(Scanner sc, String msg, double min, double max);
}
