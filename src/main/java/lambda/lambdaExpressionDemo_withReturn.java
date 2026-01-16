package lambda;

public class lambdaExpressionDemo_withReturn {
    @FunctionalInterface
    interface Cab {
        public String bookCab(String source, String destination);
    }

    public static void main(String[] args) {
        Cab cab = (source, destination) -> "Beck cab from " + source + " to " + destination + " is booked...";
        System.out.println(cab.bookCab("Ottawa", "Halifax"));
    }
}
