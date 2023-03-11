//ThreadLocal
//	allows you to associate a per-thread value with a value-holding object
// Used to prevent sharing in designs based on mutable Singletons or global variables

private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>()
{
	public Connection initialValue()
	{
		return DriverManager.getConnection(DB_URL);
	}
};

//Using ThreadLocal to ensure thread confinement

public static Connection getConnection()
{
	return connectionHolder.get();
}

/*
	Can be used when a frequently used operation requires a 
	temporry object such as a buffer and wants to avoid
	reallocating the temporary objec on each invocation
*/
