package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

class PointNamingFactoryTest {
	@Test
	// test for put(Point)
	void putPointTest() {
		PointNamingFactory pnf = new PointNamingFactory();
		Point pt1 = new Point("Hey", 0, 1);
		Point pt2 = new Point("Bye", 1, 0);
		Point pt3 = new Point("Yo", 2, 2);
		Point pt4 = new Point(4, 4);
		Point pt5 = new Point("Overwrite", 4, 4);
		
		
		Point addedpt1 = pnf.put(pt1);
		assertTrue(pnf.contains(pt1));
		assertEquals(addedpt1.getX(), pt1.getX());
		assertEquals(addedpt1.getY(), pt1.getY());
		assertEquals(addedpt1.getName(), pt1.getName());
		
		Point addedpt2 = pnf.put(pt2);
		assertTrue(pnf.contains(pt2));
		assertEquals(addedpt2.getX(), pt2.getX());
		assertEquals(addedpt2.getY(), pt2.getY());
		assertEquals(addedpt2.getName(), pt2.getName());
		
		Point addedpt3 = pnf.put(pt3);
		assertTrue(pnf.contains(pt3));
		assertEquals(addedpt3.getX(), pt3.getX());
		assertEquals(addedpt3.getY(), pt3.getY());
		assertEquals(addedpt3.getName(), pt3.getName());
		assertEquals(3, pnf.size());
		
		Point addedpt4 = pnf.put(pt4);
		assertTrue(pnf.contains(pt4));
		assertEquals(addedpt4.getX(), pt4.getX());
		assertEquals(addedpt4.getY(), pt4.getY());
		assertEquals(addedpt4.getName(), "*_A");
		assertEquals(4, pnf.size());
		
		Point addedpt5 = pnf.put(pt5);
		assertTrue(pnf.contains(addedpt5));
		assertEquals(4, pnf.size());
		assertEquals("Overwrite", pnf.get(addedpt5).getName());
		assertEquals(addedpt5.getX(), pt5.getX());
		assertEquals(addedpt5.getY(), pt5.getY());
		
		pnf.clear();
		for (int i = 0; i < 50; i++) {
			Point addpt = new Point(i, i+1);
			pnf.put(addpt);
		}
		assertEquals("*_XX", pnf.get(49, 50).getName());
				
	}
	
	@Test
	// test for put(Double, Double)
	void putxyTest() {
		PointNamingFactory pnf = new PointNamingFactory();
		
		Point pt1 = new Point(1,0);
		Point addedpt1 = pnf.put(pt1.getX(), pt1.getY());
		assertTrue(pnf.contains(pt1.getX(), pt1.getY()));
		assertTrue(pnf.contains(pt1));
		assertEquals(pt1, addedpt1);
		
		Point pt2 = new Point(1,2);
		Point addedpt2 = pnf.put(pt2.getX(), pt2.getY());
		assertTrue(pnf.contains(pt2));
		assertTrue(pnf.contains(pt2.getX(), pt2.getY()));
		assertEquals(addedpt2, pt2);
		
		Point pt3 = new Point(4, 4);
		Point addedpt3 = pnf.put(pt3.getX(), pt3.getY());
		assertTrue(pnf.contains(pt3));
		assertTrue(pnf.contains(pt3.getX(), pt3.getY()));
		assertEquals(addedpt3, pt3);
		
		Point pt4 = new Point(4, 4);
		Point addedpt4 = pnf.put(pt4.getX(), pt4.getY());
		assertTrue(pnf.contains(addedpt4));
		assertEquals(3, pnf.size());
		
		pnf.clear();
		for (int i = 0; i < 50; i++) {
			Point addpt = new Point(i, i+1);
			pnf.put(addpt.getX(), addpt.getY());
		}
		assertEquals("*_XX", pnf.get(49, 50).getName());
	}

	@Test
	// test for put(String, Double, Double)
	void putNameXYTest() {
		PointNamingFactory pnf = new PointNamingFactory();
		
		Point pt1 = new Point("Hey", 1,0);
		Point addedpt1 = pnf.put(pt1.getName(), pt1.getX(), pt1.getY());
		assertTrue(pnf.contains(pt1.getX(), pt1.getY()));
		assertTrue(pnf.contains(pt1));
		assertEquals(pt1, addedpt1);
		assertEquals(pt1.getName(), addedpt1.getName());
		
		Point pt2 = new Point(1,2);
		Point addedpt2 = pnf.put(pt2.getName(), pt2.getX(), pt2.getY());
		assertTrue(pnf.contains(pt2));
		assertTrue(pnf.contains(pt2.getX(), pt2.getY()));
		assertEquals(addedpt2, pt2);
		assertEquals("*_A", addedpt2.getName());
		
		Point pt3 = new Point("Edge", 4, 4);
		Point addedpt3 = pnf.put(pt3.getName(), pt3.getX(), pt3.getY());
		assertTrue(pnf.contains(pt3));
		assertTrue(pnf.contains(pt3.getX(), pt3.getY()));
		assertEquals(addedpt3, pt3);
		assertEquals(pt3.getName(), addedpt3.getName());
		
		Point pt4 = new Point(3, 9);
		Point addedpt4 = pnf.put(pt4.getName(), pt4.getX(), pt4.getY());
		assertTrue(pnf.contains(pt4));
		assertTrue(pnf.contains(pt4.getX(), pt4.getY()));
		assertEquals(addedpt4, pt4);
		assertEquals("*_B", addedpt4.getName());
	}
	
	@Test 
	// test for get(Point)
	void getXYTest() {
		PointNamingFactory pnf = new PointNamingFactory();
		Point pt1 = new Point("Hey", 1,0);
		pnf.put(pt1.getName(), pt1.getX(), pt1.getY());
		assertEquals(pt1, pnf.get(pt1));
		
		Point pt2 = new Point(1,2);
		pnf.put(pt2);
		assertEquals(pt2, pnf.get(pt2));
		
		Point pt3 = new Point("Edge", 4, 4);
		pnf.put(pt3);
		assertEquals(pt3, pnf.get(pt3));
		
		Point pt4 = new Point(3, 9);
		pnf.put(pt4.getX(), pt4.getY());
		assertEquals(pt4, pnf.get(pt4));
	}
	
	@Test
	// test for get(POint)
	void getPointTest() {
		PointNamingFactory pnf = new PointNamingFactory();
		Point pt1 = new Point("Hey", 1,0);
		pnf.put(pt1.getName(), pt1.getX(), pt1.getY());
		assertEquals(pt1, pnf.get(pt1.getX(), pt1.getY()));
		
		Point pt2 = new Point(1,2);
		pnf.put(pt2);
		assertEquals(pt2, pnf.get(pt2.getX(), pt2.getY()));
		
		Point pt3 = new Point("Edge", 4, 4);
		pnf.put(pt3);
		assertEquals(pt3, pnf.get(pt3.getX(), pt3.getY()));
		
		Point pt4 = new Point(3, 9);
		pnf.put(pt4.getX(), pt4.getY());
		assertEquals(pt4, pnf.get(pt4.getX(), pt4.getY()));
	}
	
	@Test
	// test for contains(Point)
	void containsPointTest() {
		PointNamingFactory pnf = new PointNamingFactory();
		
		Point pt1 = new Point("Hey", 1,0);
		pnf.put(pt1.getName(), pt1.getX(), pt1.getY());
		assertTrue(pnf.contains(pt1));
		
		Point pt2 = new Point(1,2);
		pnf.put(pt2);
		assertTrue(pnf.contains(pt2));
		
		Point pt3 = new Point("Edge", 4, 4);
		pnf.put(pt3);
		assertTrue(pnf.contains(pt3));
		
		Point pt4 = new Point(3, 9);
		pnf.put(pt4.getX(), pt4.getY());
		assertTrue(pnf.contains(pt4));
	}
	
	@Test
	// test for contains(Double, Double)
	void containsXYTest() {
		PointNamingFactory pnf = new PointNamingFactory();
		
		Point pt1 = new Point("Hey", 1,0);
		pnf.put(pt1.getName(), pt1.getX(), pt1.getY());
		assertTrue(pnf.contains(pt1.getX(), pt1.getY()));
		
		Point pt2 = new Point(1,2);
		pnf.put(pt2);
		assertTrue(pnf.contains(pt2.getX(), pt2.getY()));
		
		Point pt3 = new Point("Edge", 4, 4);
		pnf.put(pt3);
		assertTrue(pnf.contains(pt3.getX(), pt3.getY()));
		
		Point pt4 = new Point(3, 9);
		pnf.put(pt4.getX(), pt4.getY());
		assertTrue(pnf.contains(pt4.getX(), pt4.getY()));
	}
	
	@Test
	void getAllPointsTest() {
		PointNamingFactory pnf = new PointNamingFactory();
		
		Point pt1 = new Point("Hey", 1,0);
		Point pt2 = new Point(1,2);
		Point pt3 = new Point("Edge", 4, 4);
		Point pt4 = new Point(3, 9);
		
		pnf.put(pt4.getX(), pt4.getY());
		pnf.put(pt3);
		pnf.put(pt2);
		pnf.put(pt1.getName(), pt1.getX(), pt1.getY());
		
		Set<Point> ptSet = pnf.getAllPoints();
		for (Point p : ptSet) {
			assertTrue(pnf.contains(p));
		}
		assertEquals(4, ptSet.size());
	}
	
	@Test
	void toStringTest() {
		PointNamingFactory pnf = new PointNamingFactory();
		Point pt1 = new Point("Hey", 1,0);
		Point pt2 = new Point(1,2);
		Point pt3 = new Point("Edge", 4, 4);
		Point pt4 = new Point(3, 9);
		
		pnf.put(pt4.getX(), pt4.getY());
		assertEquals("(*_A, 3.0, 9.0)", pnf.toString());
		pnf.put(pt3);
		assertEquals("(*_A, 3.0, 9.0), (Edge, 4.0, 4.0)", pnf.toString());
		pnf.put(pt2);
		assertEquals("(*_A, 3.0, 9.0), (Edge, 4.0, 4.0), (*_B, 1.0, 2.0)", pnf.toString());
		pnf.put(pt1.getName(), pt1.getX(), pt1.getY());
		assertEquals("(*_A, 3.0, 9.0), (Edge, 4.0, 4.0), "
				+ "(*_B, 1.0, 2.0), (Hey, 1.0, 0.0)", pnf.toString());
	}
	
	@Test
	void sizeTest() {
		PointNamingFactory pnf = new PointNamingFactory();
		Point pt1 = new Point("Hey", 1,0);
		Point pt2 = new Point(1,2);
		Point pt3 = new Point("Edge", 4, 4);
		Point pt4 = new Point(3, 9);
		
		assertEquals(0, pnf.size());
		pnf.put(pt4.getX(), pt4.getY());
		assertEquals(1, pnf.size());
		pnf.put(pt3);
		assertEquals(2, pnf.size());
		pnf.put(pt2);
		assertEquals(3, pnf.size());
		pnf.put(pt1.getName(), pt1.getX(), pt1.getY());
		assertEquals(4, pnf.size());
	}
	@Test
	void clearTest() {
		PointNamingFactory pnf = new PointNamingFactory();
		Point pt1 = new Point("Hey", 1,0);
		Point pt2 = new Point(1,2);
		Point pt3 = new Point("Edge", 4, 4);
		Point pt4 = new Point(3, 9);
		
		assertEquals(0, pnf.size());
		
		pnf.put(pt4.getX(), pt4.getY());
		pnf.put(pt3);
		pnf.put(pt2);
		pnf.put(pt1.getName(), pt1.getX(), pt1.getY());
		
		assertFalse(pnf.size() == 0);
		pnf.clear();
		assertEquals(0, pnf.size());
	}
	
}
