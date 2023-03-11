// Don't allow the this reference to escape during construction
// A common mistake that can let the this referense escape during construction is to start a thread from a constructor
// Using a factory method to prevent the this referense from escaping during construction

public class SafeListener
{
	private final EvenListener listener;

	private SafeListener()
	{
		listener = new EvenListener()
		{
			public void onEvent(Event e) 
			{
				doSomething(e);
			}
		};
	}

	public static SafeListener newInstance(EventSource Source)
	{
		SafeListener safe = new SafeListener();
		source.registerListener(safe.listener);
		return safe;
	}
}
