package dan.property;

import dan.player.Player;

public abstract class Property {

	private String name;
	private int cost;
	private int rent;
	private boolean owned;
	private boolean mortgage;
	private Player owner;
	
	public Property(String name, int cost, int rent) {
		super();
		this.name = name;
		this.cost = cost;
		this.rent = rent;
		owned = false;
		mortgage = false;
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
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * @return the rent
	 */
	public int getRent() {
		return rent;
	}

	/**
	 * @param rent the rent to set
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}

	/**
	 * @return the owned
	 */
	public boolean isOwned() {
		return owned;
	}

	/**
	 * @param owned the owned to set
	 */
	public void setOwned(boolean owned) {
		this.owned = owned;
	}

	/**
	 * @return the mortgage
	 */
	public boolean isMortgage() {
		return mortgage;
	}

	/**
	 * @param mortgage the mortgage to set
	 */
	public void setMortgage(boolean mortgage) {
		this.mortgage = mortgage;
	}

	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public abstract int calcRent();
}
