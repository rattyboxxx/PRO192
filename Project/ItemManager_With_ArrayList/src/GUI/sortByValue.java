/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Item;
import java.util.Comparator;

/**
 *
 * @author PC
 */
public class sortByValue implements Comparator<Item>{

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getValue() - o2.getValue();
    }
    
}
