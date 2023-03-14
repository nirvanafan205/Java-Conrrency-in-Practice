/*
   Failed attempt to create a helper class 
   with an atomic put-if-absent operation
   for operating on a thread-safe List

*/

@NotThreadSafe
public class ListHelper<E>
{
	public List<E> list = Collections.syncrhonizedList(new ArrayList<E>());

	public syncrhonized boolean putIfAbsent(E x)
	{
		boolean absent = !list.contains(x);

		if(absent)
		{
			list.add(x);
		}

		return absent;
	}
}

/*
   Even tho it's synchronized, it syncrhonizes on the wrong lock 

   there is no guarantee that another thread
   won't modify the list while putIfAbsent is executing
   */


// Best approach is to have same lock 
// that the list uses
//
// we do so through client-side locking 
// 	it entails guarding client code that uses some object X with lock X 
// 	uses to guard its own state


@ThreadSafe
public class ListHelper<E>
{
	public List<E> list = Collections.syncrhonizedList(new ArrayList<E>());


	public boolean putIfAbsent(E x)
	{
		syncrhonized (list) 
		{

			boolean absent = !list.contains(x);

			if(absent)
			{
				list.add(x);
			}

			return absent;
		}
	}
}
