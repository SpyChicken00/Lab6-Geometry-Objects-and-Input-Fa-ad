package geometry_objects.points;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given a pair of coordinates; generate a unique name for it;
 * return that point object.
 *
 * Names go from A..Z..AA..ZZ..AAA...ZZZ
 */
public class PointNamingFactory
{
	private static final String _PREFIX = "*_"; // Distinguishes generated names

	private static final char START_LETTER = 'A';
	private static final char END_LETTER = 'Z';

	private String _currentName = "A";
	private int _numLetters = 1;

	//
	// A hashed container for the database of points;
	// This requires the Point class implement equals
	// based solely on the individual values and not a name
	// We need a get() method; HashSet doesn't offer one.
	// Each entry is a <Key, Value> pair where Key == Value
	//
	protected Map<Point, Point> _database;

	public PointNamingFactory()
	{
		// TODO
	}

	/**
	 * 
	 * @param points -- a list of points, named or not named
	 */
	public PointNamingFactory(List<Point> points)
	{
		// TODO
	}

	/**
	 * @param pt -- (x, y) coordinate pair object
	 * @return a point (if it already exists) or a completely new point that
	 *         has been added to the database
	 */
	public Point put(Point pt)
	{
		// TODO
	}

	/**
	 * @param x -- single coordinate
	 * @param y -- single coordinate
	 * @return a point (if it already exists) or a completely new point that has been added to the database
	 */
	public Point put(double x, double y)
	{
		// TODO
	}

	/**
	 * @param name -- the name of the point 
	 * @param x -- single coordinate
	 * @param y -- single coordinate
	 * @return a point (if it already exists) or a completely new point that
	 *         has been added to the database.
	 *         
	 *         If the point is in the database and the name differs from what
	 *         is given, nothing in the database will be changed; essentially
	 *         this means we use the first name given for a point.
	 *         
	 *         The exception is that a valid name can overwrite an unnamed point.
	 */
	public Point put(String name, double x, double y)
	{
		// TODO
	}    

	/**
	 * Strict access (read-only of the database)
	 * 
	 * @param x
	 * @param y
	 * @return stored database Object corresponding to (x, y) 
	 */
	public Point get(double x, double y)
	{
		// TODO
	}	
	public Point get(Point pt)
	{
		// TODO
	}

	/**
	 * @param name -- the name of the point 
	 * @param x -- single coordinate
	 * @param y -- single coordinate
	 * @return a point (if it already exists) or a completely new point that
	 *         has been added to the database.
	 *         
	 *         If the point is in the database and the name differs from what
	 *         is given, nothing in the database will be changed; essentially
	 *         this means we use the first name given for a point.
	 *         
	 *         The exception is that a valid name can overwrite an unnamed point.
	 */
	private Point lookupExisting(String name, double x, double y)
	{
		// TODO
	}  

	/**
	 * @param name -- the name of the point 
	 * @param x -- single coordinate
	 * @param y -- single coordinate
	 * @return a point (if it already exists) or a completely new point that
	 *         has been added to the database.
	 *         
	 *         If the point is in the database and the name differs from what
	 *         is given, nothing in the database will be changed; essentially
	 *         this means we use the first name given for a point.
	 *         
	 *         The exception is that a valid name can overwrite an unnamed point.
	 */
	private Point createNewPoint(String name, double x, double y)
	{
		// TODO
	}

	/**
	 * @param x -- single coordinate
	 * @param y -- single coordinate
	 * @return simple containment; no updating
	 */
	public boolean contains(double x, double y) { /* TODO */ }
	public boolean contains(Point p) { /* TODO */ }

	/**
	 * @return acquires and returns the next name in sequence; also
	 * generates the next name in a 'lazy list' manner 
	 */
	private String getCurrentName()
	{
        // TODO
	}

	/**
	 * Advances the current generated name to the next letter in the alphabet:
	 * 'A' -> 'B' -> 'C' -> 'Z' --> 'AA' -> 'BB'
	 */
	private  void updateName()
	{
        // TODO
	}

	/**
	 * @return The entire database of points.
	 */
	public  Set<Point> getAllPoints()
	{
        // TODO
	}

	public void clear() { _database.clear(); }
	public int size() { return _database.size(); }

	@Override
	public String toString()
	{
        // TODO
	}
}