/*
	The most common type of race condition is check-then-act:
		Where a potentially stale observation is used to make a decision on what to do next

	Non programming ex:

	Let's say you planned to meet a friend at noon at starbucks on university avenue
	When you get there, there are two Starbucks on University Avenue and you're not sure which one you agreed to meet at

	You don't see your friend at Starbucks A so you walk over to Starbucks B to see if he's there but he isn't there either

	Few possibilities:
	your friend is late and not at either starbucks, 
	your friend arrived at Starbucks A after you left
	your friend was at Starbucks B but went to look for you and is now en route to Starbucks A

	reaching the desired outcome depends on the relative timing of events ---- race condition
 */


//race conditions in lazy initialization

@NotThreadSafe
public class LazyInitRace 
{
	private ExpensiveObject instance = null;

	public ExpensiveObject getInstance() 
	{
		if(instance == null)
		{
			instance = new ExpensiveObject();
		}

		return instane;
	}
}
