/**
 * 
 */
package dan.testCard;
import org.junit.Test;
import static org.junit.Assert.*;
import dan.cards.Card;

/**
 * @author Dan G
 *
 */
public class testCard {

	@Test
	public void cardTest() {
		Card c1 = new Card(1, "This is card 1");
		assertEquals(c1.getDescription(), "This is card 1");
		assertEquals(c1.getN(), 1);
		c1.setDescription("This is new");
		c1.setN(5);
		assertEquals(c1.getDescription(), "This is new");
		assertEquals(c1.getN(), 5);
	}

}
