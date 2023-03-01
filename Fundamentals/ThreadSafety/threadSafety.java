//common concurrency hazard: race condition
//whether or not getNext returns a unique value when called from multiple threads
//depends on how the runtime interleaves the operations
@NotThreadSafe
public class UnsafeSequence 
{
	private int value;

	/** Returns a unique value */

	public int getNext() 
	{
		return value++;
	}

	/*
	   The problem with UnsafeSequence is that with some unlucky timing
	   two threads could call getNext and recieve the same value
	   */
}

/*
   Annotations documenting thread safety are useful
   if a class is annoted with @ThreadSafe, users can use it with confidence in a multithreaded environment
   */

@ThreadSafe
public class Sequence 
{
	@GuardedBy("this") private int value;

	public synchronized int getNext()
	{
		return value++;
	}
}

/*
   If multiple threads access the same mutable state variable
   without appropriate synchronization, your pgram is broken
   there are three ways to fix it

 * Don't share the state variable across threads
 * Make the state variable immutable
 * Use synchronization whenever accessing the state variable
 

  When designing thread-safe classes, good object-oriented techniques
  encapsulation, immutability, and clear specification of invariants 
  are your best friends
 */

/*
	A class is thread-safe if it behaves correctly when accessed from multiple threads, regardless of the scheduling
	or interleaveing of the execution of those trheads by the runtime environment, and with no addictional 
	synchronization or other coordination of the part of the calling code
*/
