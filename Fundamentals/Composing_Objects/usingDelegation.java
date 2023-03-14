// delegates to a thread-safe class
// Immutable Point class used by DelegatingVechicleTracker
@Immutable
public class Point
{
	public final int x, y;

	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}

// Point is thead-safe because it's immutable


@ThreadSafe 
pulic class DelegatingBehicleTracker
{
	private final ConcurrentMap<String, Point> locations;

	private final Map<String, Point> unmodifiableMap;

	public DelegatingVehicleTracker(Map<String, Point> points)
	{
		locations = new ConcurrentHashMap<String, Point>(points);

		unmodifiableMap = Collections.unmodifiableMap(locations);
	}

	public Map<String, Point> getLocations()
	{
		return unmodifiableMap;
	}

	public Point getLocation(String id)
	{
		return locations.get(id);
	}

	public void setLocation(String id, int x, int y)
	{
		if(locations.replace(id, new Point(x, y)) == null)
		{
			throw new IllegalArgumentException("invalid vehicle name: " + id);
		}
	}
}

// All access to state is managed by ConcurrentHashMap
// all keys and values of the Map are immutable
// this is delegating thread safety to a ConcurrentHashMap


public Map<string, Point> getLocations() 
{
	return Collections.unmodifiableMap(new HashMap<String, Point>(locations));
}

// Returns a static copy of the locations set
// instead of a "live" one
