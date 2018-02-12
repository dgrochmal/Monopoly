package dan.testGC;

import static org.junit.Assert.*;

import org.junit.Test;

import dan.gamecenter.Roll;

public class testRoll {

	Roll r;
	int j = 0;
	
	@Test
	public void test() {
		for(int i = 0; i < 100; i++){
			r = new Roll();
			assertTrue(r.getDice1() > 0);
			assertTrue(r.getDice1() < 7);
			assertTrue(r.getDice2() > 0);
			assertTrue(r.getDice2() < 7);
			assertTrue(r.getTotal() > 0);
			assertTrue(r.getTotal() < 13);
			if(r.isDouble()){
				j++;
			}
		}
		System.out.println(j);
	}

}
