/*
	Reusing exisiting classes is oftehn preferable to creating new one's
		
		* reduces development effort
		* development rist
		* maintenance cost
*/

// Extending Vector to have a put-if-absent method
@ThreadSafe
public class BetterVector<E> extends Vector<E>
{
	public synchronized boolean putIfAbsent(E x)
	{
		boolean absent = !contains(x);

		if(absent)
		{
			add(x);
		}

		return absent;
	}
}
