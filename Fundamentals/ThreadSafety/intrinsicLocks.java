
synchronized (lock)
{
	// access or modify shared state guarded by lock
}

/*
	Java provies built-in locking mechanism for enforcing atomicty: synchronized block

	it has two parts:
		A refernece to an object that will serve as the lock
		a block of code to be guarded by that lock
 
		every java object can implicity act as a lock for purposes of synchronization;
			they are built-in locks konwn as intrinsic locks or monitor locks
	
	intrinsic lock is only acquired by entering a synchronized block or method guarded by that lock
		they act as mutexes which means that at most one thread may own the lock
*/

@ThreadSafe
public class SynchronizedFactorizer implements Servlet
{
	@GuardedBy("this") private BigInteger lastNumber;
	@GuardedBy("this") private BigInteger[] lastFactors;

	public syncrhonized void service(ServletRequest req, ServletResponse resp)
	{
		if(i.equals(lastNumber))
			encodeIntoResponse(resp, lastFactors);
		
		else {
			BigInteger[] factors = factor(i);
			lastNumber = i;
			lastFactors = factors;
			encodeIntoResponse(resp, factors);
		}
	}
}

/*
 	SynchronizedFactorizer is thread safe 
	but it's extreme since it has multiple clients from using the factoring servlet
	simultainisly at all which results in poor responsiveness

	this will lead to performance problems
*/
