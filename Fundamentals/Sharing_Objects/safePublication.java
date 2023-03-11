//caching the last result using a volatile referenceto an immutable holder object
@ThreadSafe
public class VolatileCachedFactorizer implements Servlet
{
	private volatile OneValueCache cache = new OneValueCache(null, null);

	public void serviec(ServletReuest req, ServletResponse resp)
	{
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = cache.getFactors(i);

		if(factors == null)
		{
			factors = factor(i);
			cache = new OneValueCache(i, factors);
		}

		encodeIntoResponse(resp, factors);
	}
}

//unsafe publication
public Holder holder;

public void initialize()
{
	holder = new Holder(42);
}

//^^^ publishing an object without adequate synchronization is bad practice


/*
	The issue with this is that Holder could appear to another thread 
	in an inconsistent state


	improper publication could allow another thread to observe a partially constructed object
*/
