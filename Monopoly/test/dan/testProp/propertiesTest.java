package dan.testProp;

import static org.junit.Assert.*;

import org.junit.Test;

import dan.property.RegProperty;

public class propertiesTest {

	@Test
	public void test() {
		RegProperty p = new RegProperty("Park Place", 350, 35, 175, 500, 1100, 1300, 1500, 200);
		assertEquals(p.getCost(), 350);
		assertEquals(p.getRent(), 35);
		assertEquals(p.getName(), "Park Place");
		p.incHouseNum();
		assertEquals(p.calcRent(), 175);
		
	}

}
