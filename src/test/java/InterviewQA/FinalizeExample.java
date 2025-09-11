package InterviewQA;

/*
*** Deprecated in 9
Purpose: A protected method of the Object class that the Garbage Collector might call just before an object is garbage collected.
It was historically used for cleanup operations, but its use is deprecated in modern Java due to its unpredictable nature and
performance overhead. Resource management should be handled using try-with-resources or finally blocks.
Usage: Overridden in a class to define cleanup logic.
 */
public class FinalizeExample {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize method called for cleanup.");
        super.finalize(); // Call superclass finalize
    }

    public static void main(String[] args) {
        FinalizeExample obj = new FinalizeExample();
        obj = null;                     // Make object eligible for garbage collection
        System.gc();                    // Request garbage collection (not guaranteed to run immediately)
    }
}