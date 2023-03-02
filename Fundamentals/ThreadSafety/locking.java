@NotThreadSafe
public class UnsafeCachingFactorizer implements Servlet 
{
	pivate final AtomicRefernece<BigInteger> lastNumber = new AtomicReference<BigInteger>();

	private final AtomicReference<BigInteger[] lastFactors = new AtomicReference<BigInteger[]>();

	public void service(ServletRequest req, ServletResponse resp)
	{
		BigInteger i = extractFromRequest(req);

		if(i.equals(lastNumber.get()))
			encodeIntoResponse(resp, lastFactors.get();

					else
					{
						BigInteger[] factors = factor(i);
						lastNumber.set(i);
						lastFactors.set(factors);
						encodeIntoResponse(resp, factors);
					}
	}
}

/*
	Even though the atomic references are individually thread safe

	there's race conditions that could make the wrong answer

	thread safety requires that invariants be preserved regardless of timing or interleaving 
	of operations in multiple threads

	an invariant would be the product of the factors cached in lastFactors equal the value cached in lastNumber

	when multiple variables participate in an invariant, they're not indeependent (value of one constrains the allowed values of the others)

	so when updating, you must update the other in the same atomic operations

	to preserve state consistency, update related state variables in a single atomic operation[:
*/
