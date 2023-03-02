@ThreadSafe
public class CachedFactorizer implements Servlet
{
	@GuardedBy("this") private BigInteger lastNumber;
	@GuardedBy("this") private BigInteger BigInteger[] lastFactors;
	@GuardedBy("this") private BigInteger long hits;
	@GuardedBy("this") private BigInteger long cacheHits;

	public synchronized long getHits() { return hits; }

	public synchronized double getCachHitRatio() 
	{
		return (double cacheHits / (double)hits;
	}

	public void service(ServletRequest req, ServletResponse resp)
	{
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = null;

		snchronized (this) 
		{
			++hits;

			if(i.equals(lastNumber) )
			{
				++cacheHits;
				factors = lastFactors.clone();
			}
		}

		if(factors == null)
		{
			factors = factor(i);
			synchronized(this)
			{
				lastNumber = i;
				lastFactors = factors.clone();
			}
		}

		encodeIntoResponse(resp, factors);
	}
}

/*
	When implemenitng a synchronization policy, (it potentially comrpomising safety)
	don't sacrifice simplicity for performance

	avoid holding locks for long computations or
	operations risk of not completing quickly such as network or console I/O
*/
