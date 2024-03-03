package Collections.list;

import java.util.List;
import java.util.Stack;

public class StackDemo {
    //Stack extends of Vector but implement LAST-IN-FIRST-OUT
    public static void main(String[] args) {
        int n = 5;

        List<Integer> st = new Stack<Integer>();

        for (int i=0; i<=n; i++)
            st.add(i*i);

        System.out.println(st);

    }
}
