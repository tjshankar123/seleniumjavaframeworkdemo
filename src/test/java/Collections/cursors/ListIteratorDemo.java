package Collections.cursors;

import java.util.ArrayList;

public class ListIteratorDemo {
    // Unlike Iterator, ListIterator provide bidirectional iteration.
    public static void main(String[] args) {
        ArrayList al = new ArrayList();

        for (int i=0; i<10; i++) {
            al.add(i);
        }

        System.out.println(al);


    }
}
