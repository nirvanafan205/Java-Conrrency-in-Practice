// most composite classes have invariants that relate their component state varialbes


// Ex
// 	the following uses two AtomicIntegers to manage its state
// 	it allso imposes additional constraints that the first number
// 	be less than or equal to the second


//what makes this not thread safe is
// it has invariants invloving other state variables
public class NumberRange
{
	// Invariant: lower <= upper
	private final AtomicInteger lower = AtomicInteger(0);
	private final AtomicInteger upper = AtomicInteger(0);

	private void setLower(int i)
	{
		// Warning -- unsafe check-then-act

		if(i > upper.get() )
		{
			throw new IllegalArgumentException("can't set lower to " + i " > upper");
		}

		lower.set(i);
	}

	public void setUpper(int i)
	{
		// Warning -- unsafe check-then-act

		if(i < lower.get() )
		{
			throw new IllegalArgumentException("can't set lower to " + i " > lower");
		}

		upper.set(i);
	}

	public boolean isInRange(int i)
	{
		return (i >= lower.get() && i <= upper.get() );
	}
}

// number range class doesnt protect its invariantes
// it isn'tthread-safe
// doesn't preserve the invariant that constrains lower and upper


// both setLower and setUpper are check-then act sequences
//  not using correct locking to make them atomic


/*
	If a class is composed of multiple independent thread-safe state variables
	and no operations that haave any invalid state transitions

	it can delegate thread safety to the underlying state variables
*/
