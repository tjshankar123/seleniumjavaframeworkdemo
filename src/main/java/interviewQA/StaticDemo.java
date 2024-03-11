package interviewQA;

class StaticDemo{
    int i;
    static int j;

    // Instance block is executed when an object is created.
    {
        System.out.println(" Instance Block 1. Value of i = "+i);
    }

    // static block is a set of instruction that run only ONCE when the class is loaded into memory
    static{
        System.out.println(" Static Block 1. Value of j = "+j);
        method_2();
    }
    {
        i = 5;
    }
    static{
        j = 10;
    }
    StaticDemo(){
        System.out.println(" Welcome to InterviewBit ");
    }
    public static void main(String[] args){
        StaticDemo ib = new StaticDemo();
    }
    public void method_1(){
        System.out.println(" Instance method. ");
    }
    static{
        System.out.println(" Static Block 2. Value of j = "+j);
    }
    {
        System.out.println(" Instance Block 2. Value of i = "+i);
        method_1();
    }
    public static void method_2(){
        System.out.println(" Static method. ");
    }
}