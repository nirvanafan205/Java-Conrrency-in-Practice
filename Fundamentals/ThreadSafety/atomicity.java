@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet
{
	public long count = 0;

	public long getCount() { return count; }

	public void service(ServletRequest req, ServletResponse resp)
	{
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);

		++count;
		//The code isn't atomic meaning it doesnt execute as a single indivisible operation 
		// It's fetches current value, add one to it, and write the new value back: AKA read-modify-write operation

		encodeIntoResponse(resp, factors);
	}
}

