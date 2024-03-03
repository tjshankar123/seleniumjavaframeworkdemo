package Collections.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    // List provide ordered collection of object and duplicate values can be stored.
    // It allow positional insertion and removal.
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();

        for (int i=0; i<10; i++){
            l1.add(i, i*10);
        }


        l2.add(0, 100);
        l2.add(1, 200);
        l2.add(2, 300);

        System.out.println(l1);
        System.out.println(l2);

        l2.addAll(3, l1);
        System.out.println(l2);
        System.out.println(l2.lastIndexOf(90));

        l2.remove(0);
        System.out.println(l2);

        l2.set(0, 222);
        System.out.println(l2);
        System.out.println(l2.lastIndexOf(90));
    }
}
