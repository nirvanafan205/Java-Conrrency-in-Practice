// following the principle of instance confinement to its logical conlusion
// leads you to java monitor patterns


public class PrivateLock
{
	private final Object myLock = new Object();

	@GuadedBy("mLock") Widget widget;

	void someMethod()
	{
		synchronized(myLock)
		{
			// Access or modify the state of widget
		}
	}
}

//Making the lock obect private enxapsulates the lock
//so that client code can't aquire it
