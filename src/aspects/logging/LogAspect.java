package aspects.logging;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *  A logging aspect for the banking application.
 *
 *@author     <a href="mailto:Sara.Bouchenak@inria.fr">Sara Bouchenak</a>
 *@version    1.0 - 13/01/2004
 */
public aspect LogAspect
{
	static Logger logger = Logger.getLogger("trace");
	private pointcut printMethod():call ( * banking.*.*(..));
	
	// Eclipse stuff?
	declare warning : printMethod() : "This method was caught by AspectJ";
	
	//(a) Logging methods
	before() : printMethod()
	{
		//delete comments, i just put it for comfort
		//System.out.println("Method Signature: "+thisJoinPoint.getSignature());
		// Just simply
		//System.out.println(thisJoinPoint);
		
		//According to tutorials log.log is used for exceptions
		//	logger.log(Level.INFO,"Logger Event-> calling method: ", message);		
		//https://docs.oracle.com/javase/7/docs/api/java/util/logging/Logger.html?is-external=true
		logger.info("Method information: "+ thisJoinPoint.toString());
	
		
	}

}