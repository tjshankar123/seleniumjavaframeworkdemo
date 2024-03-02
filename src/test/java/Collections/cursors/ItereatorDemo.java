package Collections.cursors;

import java.util.ArrayList;
import java.util.Iterator;

public class ItereatorDemo {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        al.add(50);
        al.add(60);

        Iterator<Integer> itr = al.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        itr.remove();
        System.out.println(al);
    }
}
