package ss11_Stack_Queue;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountItem {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your text: ");
        String text=sc.nextLine();

        countWords(text);
        sc.close();
    }

    public static void countWords(String text) {
        Map<String, Integer> wordMap=new TreeMap<>();
        String[] words= text.toLowerCase().split("[^a-zA-Z0-9]+");

        for(String word: words){
            if(word.isEmpty())continue;
            if(wordMap.containsKey(word)){
                wordMap.put(word,wordMap.get(word)+1);
            }
            else{
                wordMap.put(word,1);
            }
        }
        System.out.println("\nWord\t\tCount");
        System.out.println("-------------------------");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.printf("%-10s : %d%n", entry.getKey(), entry.getValue());
        }
    }

}
