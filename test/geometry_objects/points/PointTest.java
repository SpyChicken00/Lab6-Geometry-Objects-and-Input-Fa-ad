package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointTest {

	@Test
	void LexicographicOrderingTest() 
	{
		Point A = new Point("A", 1, 3);
		Point B = new Point("B", 2, 5);
		Point C = new Point("C", 1, 8);
		Point D = new Point("D", 5, 2);
		Point E = new Point("E", 5, 3);
		Point CopyA = new Point ("CopyA", 1, 3);
		
		
		//check point 1 null (-1)
		assertEquals(-1, Point.LexicographicOrdering(null, A));
		assertEquals(-1, Point.LexicographicOrdering(null, B));
		assertEquals(-1, Point.LexicographicOrdering(null, C));
		assertEquals(-1, Point.LexicographicOrdering(null, D));
		//check point 2 null (1)
		assertEquals(1, Point.LexicographicOrdering(A, null));
		assertEquals(1, Point.LexicographicOrdering(B, null));
		assertEquals(1, Point.LexicographicOrdering(C, null));
		assertEquals(1, Point.LexicographicOrdering(D, null));
		//check both points null (should pt1 = -1)
		assertEquals(-1, Point.LexicographicOrdering(null, null));
		
		
		//check pt1X > pt2X
		assertEquals(1, Point.LexicographicOrdering(D, A));
		assertEquals(1, Point.LexicographicOrdering(B, A));
		//check pt1X < pt2X
		assertEquals(-1, Point.LexicographicOrdering(A, D));
		assertEquals(-1, Point.LexicographicOrdering(C, B));
		//check Y pt1 > pt2
		assertEquals(1, Point.LexicographicOrdering(C, A));
		assertEquals(1, Point.LexicographicOrdering(E, D));
		//check Y pt1 < pt2
		assertEquals(-1, Point.LexicographicOrdering(A, C));
		assertEquals(-1, Point.LexicographicOrdering(D, E));
		//check points identical
		assertEquals(0, Point.LexicographicOrdering(A, CopyA));
	}

}
