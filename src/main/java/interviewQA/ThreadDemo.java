package interviewQA;

public class ThreadDemo extends Thread {
    public void run(){
        System.out.println("Thread runs...");
    }

    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        td.start();
    }
}
