package dan.testBoard;

import static org.junit.Assert.*;
import org.junit.Test;
import dan.board.Board;

public class boardTest {

	@Test
	public void test() {
		Board b = new Board("input/board.txt");
		String l = new String(b.getLine(0));
		assertEquals("____________________________________________________________________________________________________________________________", l);
		l = new String(b.getLine(25));
		assertEquals(l, "|  <_______|     |        M     M  O     O  N    N N   O     O  P        O     O  L           Y            |  <_______|  RR |           ");
	}

}
