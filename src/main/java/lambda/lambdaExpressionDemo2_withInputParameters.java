package lambda;

public class lambdaExpressionDemo2_withInputParameters {

    @FunctionalInterface
    interface Cab{
        public void bookCab(String source, String destination );
    }

    public static void main(String[] args) {
        Cab cab = (source, destination ) -> System.out.println("Beck cab from " + source + " to " + destination + " is booked...");
        cab.bookCab("Toronto", "Montreal");
    }
}
