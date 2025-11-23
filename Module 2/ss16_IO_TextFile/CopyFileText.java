package ss16_IO_TextFile;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        String sourceFile="Data.txt";
        File src=new File(sourceFile);
        if(!src.exists()){
            System.out.println("File not found");
            return;
        }
        Scanner sc= new Scanner(System.in);
        try{
            System.out.println("Enter your target file");
            String targetFile= sc.nextLine();
            File tgt=new File(targetFile);
            if(tgt.exists()){
                System.out.println("File is found. Please try again");
                return;
            }
            FileReader fr= new FileReader(src);
            FileWriter fw= new FileWriter(tgt);
            int ch;
            while ((ch=fr.read())!=-1){
                fw.write(ch);
            }
            fr.close();
            fw.close();
            System.out.println("Copy successful! ");
        }catch (IOException e){
            System.out.println("Error: "+ e.getMessage());
        }

    }
}
