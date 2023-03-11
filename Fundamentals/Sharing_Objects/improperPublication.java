//class at risk of failure if not properly published

public class Holder
{
	private int n;

	public Holder(int n) { this.n = n; }

	public void assertSanity()
	{
		if(n != N)
		{
			throw new AssertionError("This statement is false.");
		}
	}
}

/*
	Since synchronization wasn't used to make the holder visible to othe threads
	it wasn't properly published

	Two things can go wrong with imporperly published objects

		other threads could see a stale value for the holder fields
		which will have it seen as a null reference or other older value


		Other threads could see an up-to-date value for the holder reference,
		but stale values for the state of the Holder
*/
