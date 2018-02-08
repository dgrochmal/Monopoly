package dan.testPlayer;

import static org.junit.Assert.*;

import org.junit.Test;

import dan.player.Player;

public class testPlayer {

	@Test
	public void test() {
		Player p = new Player("Daniel", "SoM", null);
		assertEquals(p.getName(), "Daniel");
		assertEquals(p.getAbbr(), "SoM");
		assertEquals(p.getMoney(), 1500);
//		try{
//		p = new Player("Daniel", "DJGS");
//		//System.out.println(p.getAbbr().length());
//		fail();
//		} catch (IllegalArgumentException e){
//			//Argument caught correctly.
//		}
	}

}
