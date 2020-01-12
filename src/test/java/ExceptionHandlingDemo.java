
public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		
		System.out.println("Hello World....");
		
		try {
			int i = 1/0;
		} 
		catch (Exception e) {
			System.out.println("Inside catch block:");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		finally {
			System.out.println("In finally block.");
			
		}
		
		System.out.println("Completed.");

	}

}
