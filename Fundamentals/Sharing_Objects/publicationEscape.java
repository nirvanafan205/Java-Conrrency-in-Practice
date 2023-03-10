//publishing an object means making it available to code ousetide of it's current scope
// an example could be storing a reference to it where other code can find it
// returning it from a non private method or passing it to a method in another class

//an object that is published when it should not have been is escaped


// common form of publication is to store a reference in a public static field

public static Set<Secret> knownSecrets;

public void initialize() 
{
	knownSecrets = new HashSet<Secret>();

	/*
		instantiates a new HashSet
		publishes it by storing a reference to it into knownSecrets 
	*/
}

// an issue of publishing an object is it may indirectly publish others


///this allows internal mutable state to escape, bad practice
//the issue is any caller can modify its contents

class UnsafeStates
{
	private String[] states = new String[] 
	{
		"AK", "AL" ...
	};

	public String[] getStates() { return states; }
}

//another issue could be implicityly allowing the this reference to escape. This shouldn't be done
public class ThisEscape 
{
	public ThisEscape(EventSource source)
	{
		source.registerListener(
				new EventListener()
				{
					public void onEvent(Event e) 
					{
						doSomething(e);
					}
				});
	}
}


