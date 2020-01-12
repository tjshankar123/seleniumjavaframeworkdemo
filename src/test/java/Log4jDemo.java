import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Log4jDemo {

	private static Logger logger = (Logger) LogManager.getLogger(Log4jDemo.class);
			
	public static void main(String[] args) {
		
		logger.setLevel(Level.TRACE);
		
		System.out.println("\n   Hello World...!   \n");
		
		logger.trace("This is trace message.");
		logger.info("This is info message.");
		logger.error("This is error message.");
		logger.warn("This is warn message.");
		logger.fatal("This is fatal message.");
		
		
		System.out.println("   Completed... ");
	}
}
