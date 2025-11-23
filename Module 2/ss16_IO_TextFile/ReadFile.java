package ss16_IO_TextFile;

import java.io.*;
import java.util.Scanner;

public class ReadFile {
    static final String File_name= "countries.csv";
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("\n======Menu=====\n");
            System.out.println("1. View file contents");
            System.out.println("2. Add new contents");
            System.out.println("3. Exit");
            choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    readCSV();
                    break;
                case 2:
                    addnew(sc);
                    break;
                case 3:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid!!!");
            }
        }

    }
    private static void readCSV() {
        File file= new File(File_name);
        if(!file.exists()|| file.length()==0){
            System.out.println("File has no data yet!");
            return;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(File_name));
            String line;
            System.out.println("-----List of countries--------");
            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }
            System.out.println("------------");
        }catch (IOException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }

    private static void addnew(Scanner sc) {
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(File_name,true));
            System.out.println("Enter ID: ");
            int id=Integer.parseInt(sc.nextLine());
            System.out.println("Enter code of contries: ");
            String code= sc.nextLine();
            System.out.println("Enter name contries: ");
            String name= sc.nextLine();

            String record= id+ ",\"" + code+ "\",\""+ name+ ",\"";
            bw.write(record);
            bw.newLine();
            bw.flush();
            System.out.println("Add successful");

        }catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }
    }

}
