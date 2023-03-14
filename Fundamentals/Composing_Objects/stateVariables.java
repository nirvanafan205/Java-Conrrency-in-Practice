// one can delegate thread safety to more than one state variable
// so long as it's independent: 
// meaning that they don't impose any invariants involving multiple state variables


/*
	The following is a graphical component
	it allows clients to register listeners for a mouse and keystroke events

	there's no relationship between the mouse and key listeners
	both are indepened 

	it allows VisualComponent to delegate its thread safety oblications to two underlying thread-safe list
*/


public class VisualComponent
{
	private final List<keyListener> keyListeners = new CopyOnWriteArrayList<KeyListener>();

	private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<MouseListner>();

	public void addKeyListener(KeyListener listener)
	{
		keyListeners.add(listener);
	}

	public void addMouseListener(MouseListener listener)
	{
		mouseListeners.add(listener);
	}

	public void removeKeyListener(KeyListener listener)
	{
		keyListeners.add(listener);
	}

	public void removeKeyListener(KeyListener listener)
	{
		keyListners.remove(listener);
	}

	public void removeMouseListener(MouseListener listener)
	{
		mouseListeners.remove(listener);
	}
}

/*
	CopyOnWriteArrayList stores each listener list which is a thread-safe List implementation
	it is best for managing listene list

	Each List is thread-safe since there's no constraints coupling the state of one to the state of the other
*/
