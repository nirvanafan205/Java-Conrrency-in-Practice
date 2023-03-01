@ThreadSafe
public class StatelessFactorizer implements Servlet 
{
	public void service(ServletRequest req, ServletResponse resp)
	{
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);

		encodeIntoResponse(resp, factors);
	}
}

/*
 	StatelessFactorizer is stateless:
		It has no fields and references no fields from other classes
	
	One thread accessing a StatelessFactorizer can't influence the 
	result of another thread accessing the same StatelessaFactorizer;
	because the two threads don't share state, it's as if they
	were accessing different instances

	Stateless objects are always thread-safe
*
		
