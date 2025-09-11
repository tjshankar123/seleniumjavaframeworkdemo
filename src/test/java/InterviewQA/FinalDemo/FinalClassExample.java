package InterviewQA.FinalDemo;

// class SubClass extends ImmutableClass { // This would cause a compilation error
//     // ...
// }

public class FinalClassExample {
    public static void main(String[] args) {
        ImmutableClass obj = new ImmutableClass("Example");
        System.out.println("Name: " + obj.getName());
    }
}