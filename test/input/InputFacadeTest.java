package input;

import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.event.ListSelectionEvent;

import org.junit.jupiter.api.Test;

import geometry_objects.Segment;
import geometry_objects.points.Point;
import geometry_objects.points.PointDatabase;
import input.components.FigureNode;
import input.exception.ParseException;

class InputFacadeTest {
	
	/**
	 * Creates a Map entry for a simple triangle 
	 * @return
	 */
	Map.Entry<PointDatabase, Set<Segment>> createTriangleMap() {
		Point A = new Point("A", 0, 0);
		Point B = new Point("B", 1, 1);
		Point C = new Point("C", 1, 0);
		List<Point> points = Arrays.asList(A, B, C);
		PointDatabase trianglePointDB = new PointDatabase(points);
		Segment AB = new Segment(A, B);
		Segment BC = new Segment(B, C);
		Segment AC = new Segment(A, C);
		Set<Segment> triangleSegmentSet = new HashSet<Segment>();
		triangleSegmentSet.add(AC);
		triangleSegmentSet.add(AB);
		triangleSegmentSet.add(BC);
		Map.Entry<PointDatabase, Set<Segment>> testMap = new AbstractMap.SimpleEntry<PointDatabase, Set<Segment>>(trianglePointDB, triangleSegmentSet);
		return testMap;
	}
	
	
	
	@Test
	void extractFigureTest() {
		FigureNode singleTriangle = InputFacade.extractFigure("JSON/single_triangle.json");
		assertTrue(singleTriangle instanceof FigureNode);
		FigureNode square = InputFacade.extractFigure("JSON/square.json");
		assertTrue(square instanceof FigureNode);
		FigureNode sailboat = InputFacade.extractFigure("JSON/sailboat.json");
		assertTrue(sailboat instanceof FigureNode);
		
		//test invalid file?
		ParseException exception = assertThrows(ParseException.class, () -> 
			{InputFacade.extractFigure("JSON/NO_DESCRIPTION.json");});
		assertEquals("Parse error: JSON Description Not Found", exception.getMessage());
	}

	@Test
	void triangleToGeometryRepresentationTest() {
		//create test map
		Map.Entry<PointDatabase, Set<Segment>> testMap = createTriangleMap();
		Map.Entry<PointDatabase, Set<Segment>> geometryMap = InputFacade.toGeometryRepresentation("JSON/single_triangle.json");
		PointDatabase testPointDB = testMap.getKey();
		PointDatabase geoPointDB = geometryMap.getKey();
		
		
		
		//System.out.println("TEST MAP POINTS: " + testMap.getKey().getPoints());
		//System.out.println("GEO MAP POINTS: " + geometryMap.getKey().getPoints());
		
		//assertEquals(testMap.getKey().getPoints(), geometryMap.getKey().getPoints());
		System.out.println(testPointDB.getPoint("B").getName());
		//TODO unnamed for some reason, why? issue in pointNamingFactory?
		System.out.println(geoPointDB.getPoint("B").getName());
		
			assertEquals(0, testMap.getKey().getPoint("A").compareTo(geometryMap.getKey().getPoint("A")));
			assertEquals(0, testMap.getKey().getPoint("B").compareTo(geometryMap.getKey().getPoint("B")));
			//assertEquals(0, testMap.getKey().getPoint("C").compareTo(geometryMap.getKey().getPoint("C")));
			
		
			
		//}

		
		

	}
}
