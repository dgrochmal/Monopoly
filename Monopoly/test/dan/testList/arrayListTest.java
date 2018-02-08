package dan.testList;

import static org.junit.Assert.*;

import org.junit.Test;

import dan.list.ArrayList;

public class arrayListTest {

	@Test
	public void test() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		assertTrue(l.isEmpty());
		assertEquals(0, l.size());
		l.add(0, 0);
		l.add(1, 1);
		assertEquals(2, l.size());
		l.remove(1);
		assertEquals(1, l.size());
		int z = l.get(0);
		assertEquals(0, z);
		l.set(0, 100);
		z = l.get(0);
		assertEquals(100, z);
		
	}

}
