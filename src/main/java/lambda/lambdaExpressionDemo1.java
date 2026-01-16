package lambda;



@FunctionalInterface
interface Cab {
    public void bookCab();
}

//class Beck implements Cab {
//    @Override
//    public void bookCab() {
//        System.out.println("Beck cab is booked...");
//   }
//}

public class lambdaExpressionDemo1 {
    public static void main(String[] args) {
//        Beck cab = new Beck();

       Cab cab = () -> System.out.println("Beck cab is booked..."); // Defined as inline function.
        cab.bookCab();
    }

}
