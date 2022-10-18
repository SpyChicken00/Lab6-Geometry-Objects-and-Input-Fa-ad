package input.parser;


import static org.junit.jupiter.api.Assertions.*;

import java.util.AbstractMap;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import input.builder.DefaultBuilder;
import input.builder.GeometryBuilder;
import input.components.ComponentNode;
import input.components.FigureNode;
import input.exception.ParseException;
import input.visitor.ToJSONVisitor;
import input.visitor.UnparseVisitor;

/**
 * Test cases for parsing and unparsing JSON
 * @author Jace, Jack, and George
 * @Date 10-2-22
 *
 */
class JSONParserTest
{
	public static ComponentNode runFigureParseTest(String filename)
	{
		GeometryBuilder geoBuilder = new GeometryBuilder();
		JSONParser parser = new JSONParser(geoBuilder);

		String figureStr = utilities.io.FileUtilities.readFileFilterComments(filename);
		
		return parser.parse(figureStr);
	}
	
	
	@Test
	void invalid_json_string_test()
	{
		DefaultBuilder geoBuilder = new GeometryBuilder();
		JSONParser parser = new JSONParser(geoBuilder);
		//check empty string
		assertThrows(ParseException.class, () -> { parser.parse("{}"); });

		//check noDescription string
		String noDescription = utilities.io.FileUtilities.readFileFilterComments("JSON/NO_DESCRIPTION.json");
		ParseException exception = assertThrows(ParseException.class, () -> 
			{ parser.parse(noDescription);});
		assertEquals("Parse error: JSON Description Not Found", exception.getMessage());
		
		//check noPoints string
		String noPoints = utilities.io.FileUtilities.readFileFilterComments("JSON/NO_POINTS.json");
		exception = assertThrows(ParseException.class, () -> 
		{ parser.parse(noPoints);});
		assertEquals("Parse error: JSON Points Not Found", exception.getMessage());
		
		//check noSegments string
		String noSegments = utilities.io.FileUtilities.readFileFilterComments("JSON/NO_SEGMENTS.json");
		exception = assertThrows(ParseException.class, () -> 
		{ parser.parse(noSegments);});
		assertEquals("Parse error: JSON Segments Not Found", exception.getMessage());
	}

	
	@Test
	void ToJSONTest() 
	{
		ComponentNode node = JSONParserTest.runFigureParseTest("JSON/sailboat.json");

		assertTrue(node instanceof FigureNode);
		
		ToJSONVisitor jsonVisitor = new ToJSONVisitor();
		JSONObject FigureNodeJSON = (JSONObject) jsonVisitor.visitFigureNode((FigureNode) node, null);

		System.out.println(FigureNodeJSON.toString());

	}
	
	
	
	@Test
	void single_triangle_test()
	{
		ComponentNode node = JSONParserTest.runFigureParseTest("JSON/single_triangle.json");

		assertTrue(node instanceof FigureNode);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		String JSONString = (String) unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(JSONString);
	}


	
	
	@Test
	void crossingSymmetricTriangleTest()
	{
		ComponentNode node = JSONParserTest.runFigureParseTest("JSON/crossing_symmetric_triangle.json");

		assertTrue(node instanceof FigureNode);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		String JSONString = (String) unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(JSONString);
	}
	
	
	@Test
	void FullyConnectedIrregularPolygonTest()
	{
		ComponentNode node = JSONParserTest.runFigureParseTest("JSON/fully_connected_irregular_polygon.json");

		assertTrue(node instanceof FigureNode);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		String JSONString = (String) unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(JSONString);
	}
	
	@Test
	void SquareTest()
	{
		ComponentNode node = JSONParserTest.runFigureParseTest("JSON/square.json");

		assertTrue(node instanceof FigureNode);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		String JSONString = (String) unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(JSONString);
	}
	
	
	
	@Test
	void ThirdQuadrantSquareTest()
	{
		ComponentNode node = JSONParserTest.runFigureParseTest("JSON/third_quadrant_square.json");

		assertTrue(node instanceof FigureNode);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		String JSONString = (String) unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(JSONString);
	}
	
	
	@Test
	void PentagonTest()
	{
		ComponentNode node = JSONParserTest.runFigureParseTest("JSON/pentagon.json");

		assertTrue(node instanceof FigureNode);
		
		StringBuilder sb = new StringBuilder();
		UnparseVisitor unparser = new UnparseVisitor();
		String JSONString = (String) unparser.visitFigureNode((FigureNode)node, new AbstractMap.SimpleEntry<StringBuilder, Integer>(sb, 0));
		System.out.println(JSONString);
	}
	
	

	
	
	
}
