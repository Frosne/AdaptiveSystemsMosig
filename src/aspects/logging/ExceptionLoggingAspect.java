
package aspects.logging;
import banking.*;


public aspect ExceptionLoggingAspect {
 
	after() throwing (Exception t): execution(public * *(..)) 
	{ 
		String method = thisJoinPoint.getSignature().getName(); 
		System.err.println("_________________________________"); 
		System.err.println("Exception:"+t.getMessage()+". "+method); 
		System.err.println("_________________________________"); 
		
    }
	
}