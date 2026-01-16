package JavaProgramForSelenium;

import java.util.ArrayList;

public class ArrayListExample1 {
    public static void main(String[] args) {
        // Declaration
        ArrayList list = new ArrayList();
        // Add values to arraylist
        list.add("John");
        list.add("David");
        list.add("Scott");
        list.add("Smith");
        System.out.println(list.size()); // returns size of arraylist
        // reading values from arraylist
        for (Object s : list)
        {
            System.out.println(s);
        }
    }
}

