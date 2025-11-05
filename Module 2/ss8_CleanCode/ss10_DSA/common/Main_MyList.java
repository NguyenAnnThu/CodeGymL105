package ss10_DSA.common;

import ss10_DSA.entity.MyList;

public class Main_MyList {
    public static void main(String[] args) {
        MyList<String> list=new MyList<>();

        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("JS");

        System.out.println("Menu: ");
        for(int i=0;i< list.size();i++){
            System.out.println(list.get(i));
        }


        //add item
        list.add(2,"Go");
        System.out.println("\nAfter menu: ");
        for (int i=0;i< list.size();i++){
            System.out.println(list.get(i));
        }
        //remove item
        list.remove(1);
        System.out.println("\nRemove item: ");
        for(int i =0;i< list.size();i++){
            System.out.println(list.get(i));
        }

        //check
        System.out.println("\nDoes the list contain 'Java'?: "+  list.contains("Java"));
        System.out.println("The position of 'Go' is: "+ list.indexOf("Go"));

        MyList<String> cloneList= list.clone();
        System.out.println("\nMenu 2: ");
        for(int i =0; i< cloneList.size();i++){
            System.out.println(cloneList.get(i));
        }
        list.clear();
        System.out.println("\nAfter clear, list size: "+ list.size());
    }

}
