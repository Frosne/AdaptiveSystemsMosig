
package aspects.logging;
import banking.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.*;
import java.util.logging.Logger;
import java.util.logging.Level;


public aspect ExceptionLoggingAspect {
	
	private static final org.apache.log4j.Logger loggerA = LogManager.getLogger("HelloWorld");
	
	
	static Logger logger = Logger.getLogger("trace");

	after() throwing (Exception t): execution(public * *(..)) 
	{ 
		BasicConfigurator.configure();		
		
		String method = thisJoinPoint.getSignature().getName(); 
	/*	System.err.println("_________________________________"); 
		System.err.println("Exception:"+t.getMessage()+"in "+method); 
		System.err.println("_________________________________"); */
		logger.info("Exception information: "+ thisJoinPoint.toString());
		logger.log(Level.WARNING,"________________________" , "Exception:"+t.getMessage()+". "+method);
		logger.log(Level.WARNING,"Logger Event->  Exeption: " +t.getMessage()+" in "+method, "Exception:"+t.getMessage()+". "+method);
		logger.log(Level.WARNING,"________________________" , "Exception:"+t.getMessage()+". "+method);
		
		
		loggerA.info("Exception information: "+ thisJoinPoint.toString());
		loggerA.warn("Logger Event->  Exeption: " +t.getMessage()+" in "+method);
		
    }
	
}