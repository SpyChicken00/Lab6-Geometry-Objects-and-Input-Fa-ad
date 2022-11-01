package geometry_objects.points;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class PointDatabaseTest {
	
	public List<Point> fillPDB() {
		List<Point> list = new ArrayList<Point>();

		list.add(new Point("Hey", 0, 1));
		list.add(new Point("Bye", 1, 0));
		list.add(new Point("Yo", 2, 2));
		list.add(new Point("", 4.0, 4.0));
		return list;
	}

	@Test
	void pointNodeDatabasetest() {
		PointDatabase pdb = new PointDatabase();
		assertEquals(0, pdb.size());
		PointDatabase pdb2 = new PointDatabase(fillPDB());
		assertEquals(4, pdb2.size());
	}
	
	
	@Test
	void puttest() {
		PointDatabase pdb = new PointDatabase();		
		
		pdb.put("Hey", 0, 1);
		assertEquals(1, pdb.size());
		
		pdb.put("Bye", 1, 0);
		assertEquals(2, pdb.size());
		
		pdb.put("Yo", 2, 2);
		assertEquals(3, pdb.size());
		
		pdb.put("", 4.0, 4.0);
		assertEquals(4, pdb.size());
		
		pdb.put("Overwrite", 4, 4);
		assertEquals(4, pdb.size());
		
	}
	
	@Test
	void sizetest() {
		PointDatabase pdb = new PointDatabase();
		
		assertEquals(0, pdb.size());
		
		for (int i = 0; i < 50; i++) {
			pdb.put(null, i, i);
			assertEquals(i+1, pdb.size());
		}
		assertEquals(50, pdb.size()); 
	}
	
	@Test
	void getNametest() {
		PointDatabase pdb = new PointDatabase(fillPDB());		
		
		assertEquals("Hey", pdb.getName(0, 1));
		assertEquals("Hey", pdb.getName(pdb.getPoint("Hey")));
		
		assertEquals("Bye", pdb.getName(1, 0));
		assertEquals("Bye", pdb.getName(pdb.getPoint("Bye")));
		
		assertEquals("Yo", pdb.getName(2, 2));
		assertEquals("Yo", pdb.getName(pdb.getPoint("Yo")));
		
		assertEquals("*_A", pdb.getName(4, 4));
		assertEquals("*_A", pdb.getName(pdb.getPoint("*_A")));
		
		pdb.put("Overwrite", 4, 4);
		assertEquals("Overwrite", pdb.getName(4, 4));
		assertEquals("Overwrite", pdb.getName(pdb.getPoint("Overwrite")));
	}
	
	@Test
	void getPointtest() {		
		List<Point> list = fillPDB();
		PointDatabase pdb = new PointDatabase(list);
		
		assertEquals(4, pdb.size());
		
		assertEquals(list.get(0), pdb.getPoint("Hey"));
		assertEquals(list.get(0), pdb.getPoint(pdb.getPoint("Hey")));
		assertEquals(list.get(0), pdb.getPoint(0, 1));
		
		assertEquals(list.get(1), pdb.getPoint("Bye"));
		assertEquals(list.get(1), pdb.getPoint(pdb.getPoint("Bye")));
		assertEquals(list.get(1), pdb.getPoint(1, 0));
		
		assertEquals(list.get(2), pdb.getPoint("Yo"));
		assertEquals(list.get(2), pdb.getPoint(pdb.getPoint("Yo")));
		assertEquals(list.get(2), pdb.getPoint(2, 2));
		
		assertEquals(list.get(3), pdb.getPoint("*_A"));
		assertEquals(list.get(3), pdb.getPoint(pdb.getPoint("*_A")));
		assertEquals(list.get(3), pdb.getPoint(4, 4));
		
	}

	@Test
	void getPointstest() {
		
	}
}
