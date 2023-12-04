package Utility;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author PC
 */
public class Utility implements IUtility{

    @Override
    public String getString(Scanner sc, String msg, boolean isEmpty, String pattern) {
        String line="";
        do{            
            System.out.print(msg);
            line = sc.nextLine();
            if(line.isEmpty() && !isEmpty){
                continue;
            }else{
                if(pattern.isEmpty()){
                    break;
                }else if(line.matches(pattern)){
                    break;
                }else{
                    continue;
                }
            }
        }while(true);
        return line;
    }

    @Override
    public int getInt(Scanner sc, String msg, int min, int max) {
        int result;
        String line;
        do{ 
            System.out.print(msg);
            line = sc.nextLine();
            try{
                result = Integer.parseInt(line);
                if(result>=min && result<=max){
                    break;
                }else{
                    continue;
                }
            }catch (Exception e) {
                continue;
            }
        } while (true);
        return result;
    }

    @Override
    public double getDouble(Scanner sc, String msg, double min, double max) {
        double result;
        String line;
        do{ 
            System.out.print(msg);
            line = sc.nextLine();
            try{
                result = Double.parseDouble(line);
                if(result>=min && result<=max){
                    break;
                }else{
                    continue;
                }
            }catch (Exception e) {
                continue;
            }
        } while (true);
        return result;
    }

    @Override
    public Date getDate(Scanner sc, String msg) {
        Date date;
        String line;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        do {            
            System.out.print(msg);
            line = sc.nextLine();
            try {
                date = dateFormat.parse(line);
                break;
            } catch (Exception e) {
                continue;
            }
        } while (true);
        return date;
    }

}
