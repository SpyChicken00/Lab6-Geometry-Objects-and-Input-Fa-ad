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
		Set<Segment> testSegments = testMap.getValue();
		Set<Segment> geoSegments = geometryMap.getValue();
		
		//System.out.println(testPointDB.getPoint("A").getName());
		//was unnamed for some reason, why? issue in pointNamingFactory? EMIL USING == grrr
		//System.out.println(geoPointDB.getPoint("A").getName());
		
		//assert points in testMap and geoMap are the same
		assertEquals(0, testPointDB.getPoint("A").compareTo(geoPointDB.getPoint("A")));
		assertEquals(0, testPointDB.getPoint("B").compareTo(geoPointDB.getPoint("B")));
		assertEquals(0, testPointDB.getPoint("C").compareTo(geoPointDB.getPoint("C")));
		
		//assert segments in testMap and geoMap are the same 
		assertTrue(testSegments.containsAll(geoSegments));
		assertTrue(geoSegments.containsAll(testSegments));
		
		/*
		for (Segment seg: geoSegments) {
			System.out.println(seg.getPoint1().getName() + seg.getPoint2().getName());
		}
		
		for (Segment seg: testSegments) {
			System.out.println(seg.getPoint1().getName() + seg.getPoint2().getName());
		}
		*/
	}
}
