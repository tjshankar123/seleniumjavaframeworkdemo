package Collections.cursors;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorDemo {
    // Unlike Iterator, ListIterator provide bidirectional iteration.
    public static void main(String[] args) {
        ArrayList al = new ArrayList();

        for (int i=0; i<10; i++) {
            al.add(i);
        }
        System.out.println(al);

        ListIterator ltr = al.listIterator();
        while (ltr.hasNext()){
            System.out.println(ltr.next());
        }

        ltr.set(9);
        while (ltr.hasPrevious()){
            System.out.println(ltr.previous());
        }


    }
}
