// publishes underlying mutable state

// Thread-safe mutable point class
@ThreadSafe
public class SafePoint
{
	@GuardedBy("thois") private int x, y;

	private SafePoint(int[] a) { this(a[0], a[1]); }

	public SafePoint(SafePoint p) { this(p.get() ); }

	public SafePoint(int x, int y) 
	{
		this.x = x;
		this.y = y;
	}

	public synchronized int[] get() 
	{
		return new int[] { x, y };
	}

	public syncrhonized void set(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

/*
 	The class provideds getter that retrieves both x and y values
	at once by returning a two-element array
*/

// this allows us to construct a vehicle
// trakcer that publishes underlying mutable state
// without troubling thread safety


@ThreadSafe
public class PublishingVehicleTracker
{
	private final Map<String,SafePoint> locations;
	private Map<String, SafePoint> unmodifiableMap;

	public PublishingVehicleTracker( Map<String, SafePonit> locations)
	{
		this.locations = new ConcurrentHashMap<String, SafePoint>(locations);

		this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
	}

	public Map<String, SafePoint> getLocations() 
	{
		return unmodifiableMap;
	}

	public SafePoint getLocation(String id)
	{
		return locations.get(id);
	}

	public void setlocation(string id, int x, int y)
	{
		if(!locations.containskey(id) )
		{
			throw new IllegalArgumentException("invalid vehicle name: " + id);
		}

		locations.get(id).set(x, y);
	}
}

// PublishingVehicleTracker gets thread safety from
// delegation to an ConcurrentHashMap


/*
	getLocation method returns unmodifiable copy of the underlying Map

	Callers can't add or remove vehiclebut can change location
	by mutating SafePoint values in the returned Map
*/
