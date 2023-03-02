/*
	Operations A and B are atomic with respect to each other if, from 
	the perspective oa thread executing A, when another thread executes B, 
	either all of B has executed or none of it has. An atomic operation is one
	that is atomic with respect to all operations, including itself, that 
	operate on the same state
 
 */

//using an exisitng thread-safe class
// Compound Actions: Sequences of operations that must be executed atomically in order to remain thread-safe (check-then-act and read-modify-write sequences)

@ThreadSafe
public class CountingFactorizer implements Servlet 
{
	private final AtomicLong count = new AtomicLong(0);

	public long getCount() { return count.get(); }

	public void service(ServletRequest req, ServletResponse resp)
	{
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = factor(i);
		count.incrementAndGet();
		encondeIntoResponse(resp, factors);
	}
}

/*
	Using exisitng thread-safe objects, like AtomicLong,
	to manage your class's state.

	Simplier to reason about the possible states and state transitions for exisitng thread-safe objects
	than it is for arbitrary state variables, and this makes it easier to maintain and verify thread safety
 */
