@NotThreadSafe
public class MutableInteger
{
	private int value;

	public int get() { return value; }

	public void set(int value) { this.value = value; }
}

// ^^ not thread-safe mutable integer holder
// value field is accessed from both get and set without synchonization
// it's susceptible to stale values
// if one thread calls set, the other threads calling get may or may not see that update



@ThreadSafe
public class SynchronizedInteger 
{
	@GuardedBy("this") private int value;

	public synchronized int get() { return value; }
	public synchronized void set(int value) { this.value = value; }
}

// ^^^ thread safe mutable integer holder
// synchonizing the getter and setter makes it safe
