package InterviewQA.FinalDemo;

class Parent {
    public final void displayMessage() {
        System.out.println("This is a final method in Parent.");
    }
}

class Child extends Parent {
    // @Override
    // public void displayMessage() {                                   // This would cause a compilation error
    //     System.out.println("Attempting to override final method.");
    // }
}

public class FinalMethodExample {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.displayMessage();
    }
}