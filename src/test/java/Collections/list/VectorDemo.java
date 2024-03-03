package Collections.list;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class VectorDemo {
    // Vector implement dynamic arrays. Though it's legacy class, it works with Collection framework.
    public static void main(String[] args) {
        int n = 5;

        List<Integer> v = new Vector<Integer>();

        for (int i=0; i<=n; i++)
            v.add(i);

        Iterator<Integer> itr = v.iterator();
        while (itr.hasNext())
            System.out.println(itr.next());

    }
}
