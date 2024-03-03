package Collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class CollectionDemo {
    public static void main(String[] args) {
        // Create empty linkedList
        Collection<String> list = new LinkedList<String>();
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");

        System.out.println("List is: " + list);

        list.add("Last");
        list.add("Element");
        System.out.println("New List is: " + list);

        Collection<String> list2 = new LinkedList<String>();
        list2.add("100");
        list2.add("200");
        System.out.println("List2 is: " + list2);
        list.addAll(list2);
        System.out.println("New appended List is: " + list);

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()){
            System.out.println("Itr: " + itr.next());
        }
    }
}
