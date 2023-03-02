// always use the proper synchonization whenever data is shared across threads
public class NoVisibility 
{
	private static boolean ready;
	private static int number;

	private static class ReaderThread extends Thread
	{
		public void run()
		{
			while(!ready)
				Thread.yield();
			System.out.println(number);
		}
	}

	public static void main(String[] args)
	{
		new ReaderThread().start();
		number = 42;
		ready = true;
	}
}

/*
	threads sharing data without synchronization can go wrong 

	here we have two threads, main thread and the ready thread
	with access the shared variables ready and number

	main thread starts the reader thread and then sets number to 42 and ready to true

	problem is that NoVisibility may print zero or never terminate at all

	adequate synchronization isnt used, there's no guarantee that the values of ready and number written by the 
	main thread will be visible to the reader thread
*/
