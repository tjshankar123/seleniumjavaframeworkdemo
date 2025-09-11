import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class ErrorExample {
    public static void main(String[] args) throws FileNotFoundException {
        // Use System.err for exceptions, validation failures, or system-level issues.

        System.out.println("This is a standard output");
        System.err.println("This is a error output");   // output is displayed in RED.

        // Re-directing error to output file.
        PrintStream errorStream = new PrintStream(new File("errors.log"));
        System.setErr(errorStream);
        System.err.println("This error will go to errors.log");

    }
}
