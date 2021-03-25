package dan.player;

import java.util.Scanner;

import dan.cards.Card;
import dan.cards.Cards;
//import dan.gamecenter.GameCenter;
import dan.list.ArrayList;
import dan.list.Node;
import dan.property.Property;

public class Player {

	private String name;
	private String abbr;
	private int money;
	private boolean goojf;
	Node current;
	private ArrayList<Property> properties;
	int pCount;
	private boolean inJail;
	private int jailCounter;
	private int houseAmt;
	private int hotelAmt;
	
	public Player(String name, String abbr, Node n) {
		this.current = n;
		this.name = name;
		this.money = 1500;
		this.goojf = false;
		this.houseAmt = 0;
		this.hotelAmt = 0;
		if(abbr.length() != 3){
			throw new IllegalArgumentException();
		}
		this.abbr = abbr;
		properties = new ArrayList<Property>();
		pCount = 0;
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
	 * @return the abbr
	 */
	public String getAbbr() {
		return abbr;
	}

	/**
	 * @param abbr the abbr to set
	 */
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

//	/**
//	 * @param money the money to set
//	 */
//	public void setMoney(int money) {
//		this.money = money;
//	}
	
	/**
	 * @param money the money to set
	 */
	public void addMoney(int n) {
		this.money += n;
	}
	
	/**
	 * @param money the money to set
	 */
	public void takeMoney(int n) {
		this.money -= n;
	}

	/**
	 * @return the goojf
	 */
	public boolean isGoojf() {
		return goojf;
	}

	/**
	 * @param goojf the goojf to set
	 */
	public void setGoojf(boolean goojf) {
		this.goojf = goojf;
	}

	/**
	 * @return the current
	 */
	public Node getCurrent() {
		return current;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(Node current) {
		this.current = current;
	}

	public Node cardMove(Node n, Card card){
		if(card.getDescription().equals("Advance to Go (Collect $200)")){
			while(!n.getName().equals("GO")){
				n = n.getNext();
			}
			passGo();
		} else if(card.getDescription().equals("Advance to Illinois Ave-If you pass Go, collect $200")) {
			while(!n.getName().equals("Illinois Avenue")){
				n = n.getNext();
				if(n.getName().equals("GO")){
					passGo();
				}
			}
		} else if(card.getDescription().equals("Advance to St. Charles Place – If you pass Go, collect $200")){
			while(!n.getName().equals("St. Charles Place")){
				n = n.getNext();
				if(n.getName().equals("GO")){
					passGo();
				}
			}
		} else if(card.getDescription().equals("Advance token to nearest Utility. If unowned, you may buy it from the Bank.")){
			while(!n.getName().equals("Electric Company") && !n.getName().equals("Water Works")){
				n = n.getNext();
				if(n.getName().equals("GO")){
					passGo();
				}
			}
		} else if(card.getDescription().equals("Advance token to the nearest Railroad. If Railroad is unowned, you may buy it from the Bank.")){
			while(!n.getName().equals("Reading Railroad") && !n.getName().equals("Pennsylvania Railroad") && !n.getName().equals("B. & O. Railroad") && !n.getName().equals("Short Line")){
				n = n.getNext();
				if(n.getName().equals("GO")){
					passGo();
				}
			}
		} else if(card.getDescription().equals("Go Back 3 Spaces")){
			for(int i = 0; i < 37; i++){
				n = n.getNext();
			}
			//Community chest, income tax, or new york avenue
			if(n.getName().equals("Community Chest")){
				Card c = Cards.getChestCard();
				System.out.printf("Your Community Chest Card is:\n%s\n\n", card);
				//TODO
			} else if (n.getName().equals("New York Avenue")){
				//TODO
			} else {
				//TODO
			}
			//move(n, 0);
		} else if (card.getDescription().equals("Go to Jail–Go directly to Jail–Do not pass Go, do not collect $200")){
			while(!n.getName().equals("Jail")){
				n = n.getNext();
			}
			setInJail(true);
		} else if (card.getDescription().equals("Take a trip to Reading Railroad–If you pass Go, collect $200")){
			while(!n.getName().equals("Reading Railroad")){
				n = n.getNext();
				if(n.getName().equals("GO")){
					passGo();
				}
			}
		} else if (card.getDescription().equals("Take a walk on the Boardwalk-Advance token to Boardwalk")){
			while(!n.getName().equals("Reading Railroad")){
				n = n.getNext();
			}
		} else if (card.getDescription().equals("Go to jail – go directly to jail – Do not pass Go, do not collect $200 ")){
			while(!n.getName().equals("Jail")){
				n = n.getNext();
			}
			setInJail(true);
		}
		return n;
	}
	
	
	@SuppressWarnings("resource")
	public Node move(Node n, int r) {
//		if(n.getName().equals("Free Parking")){
//			GameCenter.waitTwo();
//		}
		if(n.getName().equals("Go To Jail")){
			for(int i = 0; i < 20; i++){
				n = n.getNext();
			}
			setInJail(true);
			//What happens when in jail? TODO
		}
		
		if(isInJail() && getJailCounter() < 2 && isGoojf()){
			System.out.println("You have a get out of jail free card, would you like to use it? (Y/N) ");
			Scanner s = new Scanner(System.in);
			if(s.next().equals("Y")){
				setInJail(false);
			}
		}
		
		if(isInJail() && getJailCounter() < 2){
			jailCounter++;
			System.out.println("To get out of jail, select 'P' to pay $50, get out, and complete roll, or select 'S' to stay in jail.");
			Scanner s = new Scanner(System.in);
			if(s.next().equals("P")){
				takeMoney(50);
				setInJail(false);
				setJailCounter(0);
				for(int i = 0; i < r; i++){
					n = n.getNext();
					if(n.getName().equals("GO")){
						passGo();
					}
				}
			}
		} else if(isInJail() && getJailCounter() == 2){
			setInJail(false);
			System.out.println("You have spent 3 turns in jail, so you will be charged the $50 fee, and have your roll completed");
			takeMoney(50);
			setJailCounter(0);
			for(int i = 0; i < r; i++){
				n = n.getNext();
			}
		} else {
			for(int i = 0; i < r; i++){
				n = n.getNext();
				if(n.getName().equals("GO")){
					passGo();
				}
			}
		}
		
		if(n.getName().equals("Income Tax")){
			System.out.println("You have landed on Income Tax, enter 'F' for the $200 fee, or 'P' for  10% of your current money total");
			Scanner s = new Scanner(System.in);
			if(s.next().equals("F")){
				takeMoney(200);
			} else {
				takeMoney(money / 10);
			}
		}
		
		if(n.getName().equals("Luxury Tax")){
			System.out.println("You have landed on Luxury Tax, $75 will be transferred to the bank");
			takeMoney(200);
		}
		
		return n;
	}

	private void passGo() {
		addMoney(200);
	}

	/**
	 * @return the properties
	 */
	public ArrayList<Property> getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void addProperty(Property p) {
		properties.add(pCount, p);
		pCount++;
	}

	/**
	 * @return the inJail
	 */
	public boolean isInJail() {
		return inJail;
	}

	/**
	 * @param inJail the inJail to set
	 */
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	/**
	 * @return the jailCounter
	 */
	public int getJailCounter() {
		return jailCounter;
	}

	/**
	 * @param jailCounter the jailCounter to set
	 */
	public void setJailCounter(int jailCounter) {
		this.jailCounter = jailCounter;
	}

	/**
	 * @return the pCount
	 */
	public int getpCount() {
		return pCount;
	}

	/**
	 * @param pCount the pCount to set
	 */
	public void decPCount() {
		this.pCount--;
	}

	/**
	 * @return the houseAmt
	 */
	public int getHouseAmt() {
		return houseAmt;
	}

	/**
	 * @param houseAmt the houseAmt to set
	 */
	public void setHouseAmt(int houseAmt) {
		this.houseAmt = houseAmt;
	}
	
	/**
	 * @param houseAmt the houseAmt to set
	 */
	public void incHouseAmt() {
		this.houseAmt++;
	}

	/**
	 * @return the hotelAmt
	 */
	public int getHotelAmt() {
		return hotelAmt;
	}

	/**
	 * @param hotelAmt the hotelAmt to set
	 */
	public void setHotelAmt(int hotelAmt) {
		this.hotelAmt = hotelAmt;
	}
	
	/**
	 * @param hotelAmt the hotelAmt to set
	 */
	public void incHotelAmt() {
		this.hotelAmt++;
	}

}
