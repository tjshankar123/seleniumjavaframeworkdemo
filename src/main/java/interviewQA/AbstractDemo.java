package interviewQA;

//abstract final class InterviewBit{
abstract  class InterviewBit{
    public abstract void printMessage();
}

class ScalarAcademy extends WordPalindrom {
    public void printMessage(){
        System.out.println("Welcome to Sclar Topics by InterviewBit");
    }
}
 class SclarTopics extends ScalarAcademy{
    public void printMessage(){
        System.out.println("Welcome to Sclar Topics by Scalar Academy");
    }
}
public class AbstractDemo {
    public static void main(String [] args) {
        WordPalindrom ib = new SclarTopics();
        ((SclarTopics) ib).printMessage();

         ib = new ScalarAcademy();
         ((ScalarAcademy) ib).printMessage();
    }
}
