package Collections.set;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {

        Set<Integer> hs = new HashSet<Integer>();
        hs.add(10);
        hs.add(5);
        hs.add(12);
        hs.add(4);

        System.out.println("Set is " + hs);

        // Verify SET contains the object.
        int check = 10;
        System.out.println("Contains " + check + " " + hs.contains(check));

        // Remove object a object.
        hs. remove(5);
        System.out.println("Set is " + hs);

        //Finding minimum
        System.out.println("Maximum is " + Collections.max(hs));
        System.out.println("Minimum is " + Collections.min(hs));
        System.out.println("Size of the set is " + hs.size());

        Iterator value = hs.iterator();
        while(value.hasNext())
            System.out.println(value.next());
    }
}
