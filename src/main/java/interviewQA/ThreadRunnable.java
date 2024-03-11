package interviewQA;

public class ThreadRunnable {
    public void run(){
        System.out.println("ThreadRunnable runs...");
    }
    public static void main(String args[]){
        Thread ib = new Thread(String.valueOf(new ThreadRunnable()));
        ib.start();
    }
}

