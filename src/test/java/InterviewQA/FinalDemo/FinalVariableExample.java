package InterviewQA.FinalDemo;

public class FinalVariableExample {
    final int MAX_VALUE = 100;          // Declared and initialized as final

    public void demonstrate() {
      //   MAX_VALUE = 150;             // This would cause a compilation error
        System.out.println("Max Value: " + MAX_VALUE);
    }

    public static void main(String[] args) {
        FinalVariableExample obj = new FinalVariableExample();
        obj.demonstrate();
    }
}