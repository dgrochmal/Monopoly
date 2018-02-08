package dan.list;

import dan.player.Player;
import dan.property.Property;

public class Node{
	
	Node next;
	private String name;
	private Property p;
	private ArrayList<Player> players;
	int pnum;
	private int x;
	private int y;
	
	public Node(String name, Property p, int x, int y){
		this.name = name;
		this.p = p;
		this.x = x;
		this.y = y;
		players = new ArrayList<Player>();
		pnum = 0;
	}
	
	
	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the p
	 */
	public Property getP() {
		return p;
	}

	/**
	 * @param p the p to set
	 */
	public void setP(Property p) {
		this.p = p;
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the pnum
	 */
	public int getPnum() {
		return pnum;
	}

	/**
	 * @param pnum the pnum to set
	 */
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	
}