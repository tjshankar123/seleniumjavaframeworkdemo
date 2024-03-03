package Collections.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        int n = 5;

        List<Integer> li = new LinkedList<Integer>();

        for (int i=1; i <=n; i++){
            li.add(i);
        }

        System.out.println(li);

        li.remove(3);
        System.out.println(li);

        Iterator<Integer> itr = li.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }

        for (int i=0; i< li.size(); i++)
            System.out.println("print: " + li.get(i));
    }
}
