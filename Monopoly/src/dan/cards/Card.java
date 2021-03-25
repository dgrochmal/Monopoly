/**
 * 
 */
package dan.cards;

/**
 * @author Dan G
 *
 */
public class Card {

	private int n;
	private String description;
	
	/**
	 * 
	 */
	public Card(int n, String description) {
		this.n = n;
		this.description = description;
	}

	/**
	 * @return the n
	 */
	public int getN() {
		return n;
	}

	/**
	 * @param n the n to set
	 */
	public void setN(int n) {
		this.n = n;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
