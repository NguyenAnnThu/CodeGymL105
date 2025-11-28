package casestudy.common;

import java.io.*;
import java.sql.SQLOutput;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CheckInput {
    private static final Scanner sc= new Scanner(System.in);
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     public  static int intInput(String msg){
         int v;
         while(true){
             System.out.println(msg);
             try{
                 v= Integer.parseInt(sc.nextLine());
                return  v;
             }catch (Exception e){
                 System.out.println("Please Enter a integer number!");
             }
         }
    }

    public static double doubleInput(String msg){
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim();
            try {
                double v = Double.parseDouble(s);
                if (v >= 0) return v;
                else System.out.println("Please try again!");
            } catch (NumberFormatException e) {
                System.out.println("Please try again!");
            }
        }
    }

    public static String stringInput(String msg){
         while (true){
                 System.out.println(msg);
                 String s= sc.nextLine().trim();
                 if(!s.isEmpty()) return s;
                 System.out.println("Cannot be left blank!");
         }
    }
    public  static LocalDate dateInput(String msg){
        while (true) {
            try {
                System.out.print(msg + " (yyyy-MM-dd): ");
                String s = sc.nextLine().trim();
                return LocalDate.parse(s, DATE_FMT);
            } catch (DateTimeParseException ex) {
                System.out.println("Invalid date. Please enter in yyyy-MM-dd format.");
            }
        }
    }

    public static String InputExpiredDate(String msg, String importDateStr){
        LocalDate importDate= LocalDate.parse(importDateStr,DATE_FMT);
        DateTimeFormatter fmt=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while(true){
            System.out.println(msg);
            String expireStr=sc.nextLine().trim();
            try{
                LocalDate expireDate=LocalDate.parse(expireStr, DATE_FMT);
                if(expireDate.isBefore(importDate)){
                    System.out.println("Please enter again!");
                    continue;
                }
                return expireStr;
            }catch (DateTimeException e){
                System.out.println("Please enter the correct format");
            }
        }
    }
    public static List<String> readFile(String path){
        List<String > list= new ArrayList<>();
        File f= new File(path);
        if(!f.exists()) return list;
        try(BufferedReader br=new BufferedReader(new FileReader(f))){
            String line;
            while ((line= br.readLine())!=null){
                list.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }
    public static void  writerFile(String path, List<String> lines){
         File f= new File(path);
        try {
            File parent = f.getParentFile();
            if (parent != null && !parent.exists()) parent.mkdirs();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                for (String line : lines) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void appendFile(String path, String line){
        File f = new File(path);
        try {
            File parent = f.getParentFile();
            if (parent != null && !parent.exists()) parent.mkdirs();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean yesNo(String prompt) {
        while (true) {
            System.out.print(prompt + " (y/n): ");
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("y") || s.equals("yes")) return true;
            if (s.equals("n") || s.equals("no")) return false;
            System.out.println("Please try agian!");
        }
    }
    public static long daysBetween(LocalDate from, LocalDate to) {
        return ChronoUnit.DAYS.between(from, to);
    }

    public static boolean isNearExpiry(LocalDate expiryDate, LocalDate today, long thresholdDays) {
        if (expiryDate.isBefore(today)) return true;
        long diff = ChronoUnit.DAYS.between(today, expiryDate);
        return diff >= 0 && diff <= thresholdDays;
    }
}
