// Immutable holder for caching a number and its factors
@Immutable
class OneValueCache
{
	private final BigInteger lastNumber;
	private final BigInteger[] lastFactors;

	public OneValueCache(BigInteger i, BigInteger[] factors)
	{
		lastNumber = i;
		lastFactors = Arrays.copyOf(factors, factors.length);
	}

	public BigInteger[] getFactors(BigInteger i)
	{
		if(lastNumber == null || !lastNumber.equals(i))
		{
			return null;
		}

		else
		{
			return Arrays.copyOf(lastFactors, lastFactors.length);
		}
	}
}

/*
	since the data items must be acted on atomically, 
	we create an immutable holder class for them

	this would elimante race conditions accessing or updating multiple related variables 

	the mutable holder object would lock to ensure atomicity

	immutable holder object, once a thread acquires a reference to it, there need sno more worry about another thread modifying its state
*/
