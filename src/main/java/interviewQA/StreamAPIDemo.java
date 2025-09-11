package interviewQA;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StreamAPIDemo {

        public static void main(String[] args) {
            StreamAPIDemo demo = new StreamAPIDemo();
            demo.filterAndTransformationList();
            demo.filterEvenNumbers();
            demo.sumOfNumberUsingReduce();
            demo.countElements();
        }

        public void filterAndTransformationList(){
            List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice", "Anna");
            List<String> filteredNames = names.stream()
                    .filter(name -> name.startsWith("A"))
                    .map(String::toUpperCase)
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(filteredNames);
        }

        public void filterEvenNumbers(){
            List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 5, 6);
            List<Integer> evenNumbers = numbers.stream()
                    .filter(number -> number % 2 == 0)
                    .collect(Collectors.toList());
            System.out.println("Filter even numbers: "+ evenNumbers);
        }

        public void sumOfNumberUsingReduce(){
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
            int sum = numbers.stream()
                    .reduce(0, (a, b) -> a + b);
            System.out.println("Sum of numbers: " + sum);
        }

        public void countElements(){
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
            long count = numbers.stream()
                    .filter(number -> number % 2 == 0)
                    .count();
            System.out.println("Count of even numbers: " + count);
        }

}
