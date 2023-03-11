/* the design process for a thread-safe class should include these three basic elements
	
   	* Identify the variables that form the objects state
	
	* Identify the invariants that constrain the state variables
	
	* Establish a policy for managing concurrent access to the objects state
*/

//simple thread-safe counter using java monitor pattern
@ThreadSafe
public final class Counter
{
	@GuardedBy("this") private long value = 0;

	public synchronized long getValue()
	{
		return value;
	}

	public synchronized long increment()
	{
		if(value == Long.MAX_VALUE)
		{
			throw new IllegalStateException("counter overflow");
		}

		return ++value;
	}
}

// synchronization policy defines how an object coordinates access to its state
// without violating its invariants or postconditions
