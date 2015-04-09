package aspects.logging;

/**
 *  A logging aspect for the banking application.
 *
 *@author     <a href="mailto:Sara.Bouchenak@inria.fr">Sara Bouchenak</a>
 *@version    1.0 - 13/01/2004
 */
public aspect LogAspect
{

	private pointcut printMethod():call ( void banking.Account.*(..));
	
	declare warning : printMethod() : "This method was overriden by AspectJ";
	
	before() : printMethod()
	{
		System.out.println("Im before methodcalling");
	}

}