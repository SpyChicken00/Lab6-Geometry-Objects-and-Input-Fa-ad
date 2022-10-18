package input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import geometry_objects.points.Point;
import geometry_objects.points.PointDatabase;
import geometry_objects.Segment;
import input.builder.GeometryBuilder;
import input.components.ComponentNode;
import input.components.FigureNode;
import input.components.point.PointNode;
import input.components.segment.SegmentNode;
import input.parser.JSONParser;

public class InputFacade
{
	/**
	 * Acquire a figure from the given JSON file.
     *
	 * @param filename -- the name of a file
	 * @return a FigureNode object corresponding to the input file.
	 */
	public static FigureNode extractFigure(String filename)
	{
        // TODO
	}
	
	/**
	 * 1) Read in a figure from a JSON file.
	 * 2) Convert the PointNode and SegmentNode objects to a Point and Segment objects 
	 *    (those classes have more meaningful, geometric functionality).
     *
	 * @param filename
	 * @return a pair <set of points as a database, set of segments>
	 */
	public static Map.Entry<PointDatabase, Set<Segment>> toGeometryRepresentation(String filename)
	{
		// TODO
	}
}
