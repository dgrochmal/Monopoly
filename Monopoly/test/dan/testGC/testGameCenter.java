/**
 * 
 */
package dan.testGC;

import static org.junit.Assert.*;

import org.junit.Test;

import dan.gamecenter.GameCenter;
import dan.list.ArrayList;
import dan.property.Property;
import dan.property.RegProperty;

/**
 * @author Dan Grochmal
 *
 */
public class testGameCenter {

	@Test
	public void testSortProperties() {
		Property p1 = new RegProperty("Mediterranean Avenue", 1, 1, 1, 1, 1, 1, 1, 1);
		Property p2 = new RegProperty("Baltic Avenue", 1, 1, 1, 1, 1, 1, 1, 1);
		Property p3 = new RegProperty("Oriental Avenue", 1, 1, 1, 1, 1, 1, 1, 1);
		Property p5 = new RegProperty("Connecticut Avenue", 1, 1, 1, 1, 1, 1, 1, 1);
		ArrayList<Property> pList = new ArrayList<Property>();
		pList.add(0, p5);
		pList.add(0, p1);
		pList.add(0, p3);
		pList.add(0, p2);
		ArrayList<Property> sList = new ArrayList<Property>();
		sList = GameCenter.sortProperties(pList);
		for(int i = 0; i < sList.size(); i++){
			System.out.println(sList.get(i).getName());
		}
	}

}
