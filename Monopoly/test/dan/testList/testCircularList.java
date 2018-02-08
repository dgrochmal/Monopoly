package dan.testList;

import static org.junit.Assert.*;

import org.junit.Test;

import dan.list.CircularList;
import dan.list.Node;

public class testCircularList {

	@Test
	public void test() {
		Node n = new Node("Name", null, 5, 5);
		CircularList cl = new CircularList(n);
		assertEquals(cl.getHead().getName(), "Name");
		assertEquals(cl.getTail().getName(), "Name");
		assertEquals(cl.getLength(), 1);
		
		Node n1 = new Node("Second", null, 6, 6);
		cl.addNode(n1);
		assertEquals(cl.getLength(), 2);
		assertEquals(cl.getTail().getName(), "Second");
		assertEquals(cl.getTail().getNext().getName(), "Name");
	}

}
