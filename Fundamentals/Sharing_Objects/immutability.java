// immutable objects are always thread safe
/*
    An object is immutable if:
    	
    	It's state cannot be modified after construction;

	All is fileds are final

	it is properly constructed (the this reference doesn't escape during construction)
*/

@Immutable
public final class ThreeStooges
{
	private final Set<String> stooges = new HashSet<String>();

	public ThreeStooges()
	{
		stooges.add("Moe");
		stooges.add("Larry");
		stooges.add("Curly");
	}

	public boolean isStooge(String name)
	{
		return stooges.contains(name);
	}
}

/*
	Immutable objects can still use mutable objects internally
	to manage their state

	in ThreeStooges, the design makes it impossible to modify the set after construction


	stooges reference is final, so all object state is reached through a final field

	proper construction is met since the constructor does nothing
	that would case the this reference to become accessible to code other than the constructor and its caller
*/
