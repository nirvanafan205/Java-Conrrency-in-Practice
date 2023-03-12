/*
   Encapsulating data within an object confines access to the data to the
   object's methods, making it easier to esnure that the data is always 
   accessed with the appropriate lock held
   */

// using confinement to ensure thread safety
@ThreadSafe
public class PersonSet
{
	@GuardedBy("this")
	private final Set<Person> mySet = new HashSet<Person>();

	public syncrhonized void addPerson(Person p)
	{
		mySet.add(p);
	}

	public syncrhonized boolean containsPerson(Person p)
	{
		return mySet.contains(p);
	}
}

/*
   Confinement makes it easier to build thread-safe classes because a class that
   confines its state can be analyzed for thread safety withouth having to
   examine the whole program
 */
