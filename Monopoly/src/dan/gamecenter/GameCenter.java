package dan.gamecenter;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import dan.board.Board;
import dan.cards.Cards;
import dan.list.ArrayList;
import dan.list.CircularList;
import dan.list.Node;
import dan.player.Player;
import dan.property.Property;
import dan.property.Railroad;
import dan.property.RegProperty;
import dan.property.Utility;

public class GameCenter {

	static ArrayList<RegProperty> properties;
	static ArrayList<Railroad> railroads;
	static ArrayList<Utility> utilities;
	static CircularList cl;
	static ArrayList<Player> players;
	static GameCenter gc;
	
	static Node go;
	static Node med;
	static Node cc1;
	static Node bal;
	static Node incTax;
	static Node rRR;
	static Node orien;
	static Node chance1;
	static Node vmt;
	static Node conn;
	static Node jail;
	static Node stchls;
	static Node elec;
	static Node sts;
	static Node vir;
	static Node pRR;
	static Node stjms;
	static Node cc2;
	static Node tenn;
	static Node nya;
	static Node fp;
	static Node kent;
	static Node chance2;
	static Node indiana;
	static Node ili;
	static Node boRR;
	static Node atl;
	static Node vent;
	static Node water;
	static Node mg;
	static Node gtj;
	static Node pac;
	static Node nc;
	static Node cc3;
	static Node pen;
	static Node slRR;
	static Node chance3;
	static Node pp;
	static Node luxTx;
	static Node bw;
	
	static boolean twoPlayer = false;
	
	public GameCenter() {
		// TODO Auto-generated constructor stub
		//System.out.println("I AM PRINTING FROM THE CONSTRUCTOR BUT I CAN ALSO INITIALIZE STUFF");
	}
	
	//TODO make all user input into switch/case to not accept bad input as no, but instead lets them try again.
	
	@SuppressWarnings("resource")
	public static void main(String [] args){
		Board b = new Board("input/board.txt");
		Cards c = new Cards("input/chance.txt", "input/chest.txt");
		gc = new GameCenter();
		readProperties("input/properties.txt", "input/railroads.txt", "input/utilities.txt");
		setUpCircularList();
		System.out.println("How many players? (2 or 3): ");
		Scanner in = new Scanner(System.in);
		int numberOfPlayers = in.nextInt();
		if(!(numberOfPlayers == 2 || numberOfPlayers == 3)){
			throw new IllegalArgumentException("Illegal player number");
		}
//		System.out.println("Enter Player 1 infomation (<Name> <3 character abbreviation>): ");
//		String p1Name = in.next();
//		String p1Abbr = in.next();
//		Player p1 = new Player(p1Name, p1Abbr, cl.getHead());
		Player p1 = new Player("Dan", "ddd", cl.getHead());
		
//		System.out.println("Enter Player 2 infomation (<Name> <3 character abbreviation>): ");
//		String p2Name = in.next();
//		String p2Abbr = in.next();
//		Player p2 = new Player(p2Name, p2Abbr, cl.getHead());
		Player p2 = new Player("Emily", "eee", cl.getHead());
		
		Player p3 = null;
		if(numberOfPlayers == 3){
			System.out.println("Enter Player 3 infomation (<Name> < 3 character abbreviation>): ");
			String p3Name = in.next();
			String p3Abbr = in.next();
			p3 = new Player(p3Name, p3Abbr, cl.getHead());
		}
		//Getting a null pointer here
		players = new ArrayList<Player>();
		players.add(0, p1);
		players.add(1, p2);
		if(numberOfPlayers == 3){
			twoPlayer = false;
			players.add(2, p3);
			threePlayerGame(p1, p2, p3);
		} else {
			twoPlayer = true;
			twoPlayerGame(p1, p2);
		}
	}

	private static void threePlayerGame(Player p1, Player p2, Player p3) {
		Board.printGrid();
		Board.updateGrid(p1, p2);
		Board.printGrid();
		while(p1.getMoney() >= 0 && p2.getMoney() >= 0 && p3.getMoney() >= 0){
			
		}
		if(p1.getMoney() < 0){
			twoPlayerGame(p2, p3);
		} else if (p2.getMoney() < 0) {
			twoPlayerGame(p1, p3);
		} else {
			twoPlayerGame(p1, p2);
		}
	}

	@SuppressWarnings("resource")
	private static void twoPlayerGame(Player p1, Player p2) {
			Board.printGrid();
			Board.updateGrid(p1, p2);
			Scanner in = new Scanner(System.in);
			while(p1.getMoney() >= 0 && p2.getMoney() >= 0){
				String ans = "";
				char answer = 'e';				
				
				boolean hasRolled = false;
				//Allows for players to cycle through all options endlessly until they roll
				while(!hasRolled){
					System.out.printf("%s, enter one of the following: 'R' to roll & move, 'S' to see current properties, cash, etc., 'T' to attempt a trade,\n'M' to mortgage properties, 'U' to un-mortgage properties, or 'H' to manage houses and hotels\n", p1.getName());
					ans = in.next();
					answer = ans.charAt(0);
					switch(answer){
						case 'S' :
							printStats(p1);
							break;
						case 'H' :
							manageBuildings(p1);
							break;
						case 'M' :
							mortgageProperties(p1);
							break;
						case 'U' :
							unMortgageProperties(p1);
							break;
						case 'T' :
							handleTrade(p1, p2);
							break;
						case 'R' :
							int r = roll();
							System.out.println("You rolled a: " + r);
							waitTwo();
							Node n = p1.move(p1.getCurrent(), r);
							p1.setCurrent(n);
							Board.updateGrid(p1, p2);
							executeTurn(n, p1, r);
							hasRolled = true;
							break;
					}
				}				

				hasRolled = false;
				
				while(!hasRolled){
					System.out.printf("%s, enter one of the following: 'R' to roll & move, 'S' to see current properties, cash, etc., 'T' to attempt a trade,\n'M' to mortgage properties, 'U' to un-mortgage properties, or 'H' to manage houses and hotels\n", p2.getName());
					ans = in.next();
					answer = ans.charAt(0);
					switch(answer){
					case 'S' :
						printStats(p2);
						break;
					case 'T' :
						handleTrade(p2, p1);
						break;
					case 'H' :
						manageBuildings(p1);
						break;
					case 'M' :
						mortgageProperties(p1);
						break;
					case 'U' :
						unMortgageProperties(p1);
						break;
					case 'R' :
						int r = roll();
						System.out.println("You rolled a: " + r);
						waitTwo();
						Node n = p2.move(p2.getCurrent(), r);
						p2.setCurrent(n);
						Board.updateGrid(p1, p2);
						executeTurn(n, p2, r);
						hasRolled = true;
						break;
					}
				}
				
				
			}
			if(p1.getMoney() < 0){
				System.out.printf("%s wins!!!!!", p2.getName());
			} else {
				System.out.printf("%s wins!!!!!", p1.getName());
			}
	}

	@SuppressWarnings("resource")
	private static void unMortgageProperties(Player p1) {
		System.out.println(p1.getName() + "'s Properties: ");
		ArrayList<Property> pSort1 = sortProperties(p1.getProperties());
		for(int i = 0; i < pSort1.size(); i++){
			System.out.printf("\t%20s\t%20s\n", pSort1.get(i).getName(), pSort1.get(i).getCost());
		}
			
		
		System.out.println("Enter in the name of your properties that you would like to un-mortgage. Separate by lines, and hit enter twice when done\n");
		Scanner s = new Scanner(System.in);
		String p = "";
		ArrayList<Property> tList1 = new ArrayList<Property>();
		boolean notEmpty = true;
		while(notEmpty){
			p = s.nextLine();
			if(p.length() == 0){
				notEmpty = false;
			}
			int count = 0;
			for(int i = 0; i < pSort1.size(); i++){
				if(pSort1.get(i).getName().equals(p)){
					tList1.add(count, pSort1.get(i));
				}
			}
		}
		System.out.println("These are the properties that you have elected to un-mortgage, is this correct('Y' OR 'N')?");
		for(int i = 0; i < tList1.size(); i++){
			System.out.println(tList1.get(i).getName());
		}
		String ans = s.next().toUpperCase();
		if(ans.equals("Y")){
			for(int i = 0; i < p1.getProperties().size(); i++){
				for(int j = 0; j < tList1.size(); j++){
					if(p1.getProperties().get(i).getName().equals(tList1.get(j).getName())){
						p1.getProperties().get(i).setMortgage(false);
						p1.takeMoney(p1.getProperties().get(i).getCost() / 2);
					}
				}
			}
		} else {
			//Do nothing?
		}
		
	}

	@SuppressWarnings("resource")
	private static void mortgageProperties(Player p1) {
		System.out.println(p1.getName() + "'s Properties: ");
		ArrayList<Property> pSort1 = sortProperties(p1.getProperties());
		for(int i = 0; i < pSort1.size(); i++){
			System.out.printf("\t%20s\t%20s\n", pSort1.get(i).getName(), pSort1.get(i).getCost());
		}
			
		
		System.out.println("Enter in the name of your properties that you would like to mortgage. Separate by lines, and hit enter twice when done\n");
		Scanner s = new Scanner(System.in);
		String p = "";
		ArrayList<Property> tList1 = new ArrayList<Property>();
		boolean notEmpty = true;
		while(notEmpty){
			p = s.nextLine();
			if(p.length() == 0){
				notEmpty = false;
			}
			int count = 0;
			for(int i = 0; i < pSort1.size(); i++){
				if(pSort1.get(i).getName().equals(p)){
					tList1.add(count, pSort1.get(i));
				}
			}
		}
		System.out.println("These are the properties that you have elected to mortgage, is this correct('Y' OR 'N'?)");
		for(int i = 0; i < tList1.size(); i++){
			System.out.println(tList1.get(i).getName());
		}
		String ans = s.next().toUpperCase();
		if(ans.equals("Y")){
			for(int i = 0; i < p1.getProperties().size(); i++){
				for(int j = 0; j < tList1.size(); j++){
					if(p1.getProperties().get(i).getName().equals(tList1.get(j).getName())){
						p1.getProperties().get(i).setMortgage(true);
						p1.addMoney(p1.getProperties().get(i).getCost() / 2);
					}
				}
			}
		} else {
			//Do nothing?
		}
	}

	private static void manageBuildings(Player p1) {
		// TODO Player can build and sell houses and hotels on properties that they have monopolies on
			
	}

	@SuppressWarnings("resource")
	private static void handleTrade(Player p1, Player p2) {
		System.out.println(p1.getName() + "'s Properties: ");
		ArrayList<Property> pSort1 = sortProperties(p1.getProperties());
		for(int i = 0; i < pSort1.size(); i++){
			System.out.printf("\t%20s\t%20s", pSort1.get(i).getName(), pSort1.get(i).getCost());
			if(pSort1.get(i).isMortgage()){
				System.out.printf("\t%22s", "Property is mortgaged");
			}
			System.out.println();
		}
		System.out.println(p2.getName() + "'s Properties: ");
		ArrayList<Property> pSort2 = sortProperties(p2.getProperties());
		for(int i = 0; i < pSort2.size(); i++){
			System.out.printf("\t%20s\t%20s", pSort2.get(i).getName(), pSort2.get(i).getCost());
			if(pSort2.get(i).isMortgage()){
				System.out.printf("\t%22s", "Property is mortgaged");
			}
			System.out.println();
		}		
		System.out.println("Enter in the name of your properties that you are putting on the trading block. Separate by lines, and hit enter twice when done\n");
		Scanner s = new Scanner(System.in);
		String p = "";
		ArrayList<Property> tList1 = new ArrayList<Property>();
		ArrayList<Property> tList2 = new ArrayList<Property>();
		boolean notEmpty = true;
		while(notEmpty){
			p = s.nextLine();
			if(p.length() == 0){
				notEmpty = false;
			}
			int count = 0;
			for(int i = 0; i < pSort1.size(); i++){
				if(pSort1.get(i).getName().equals(p)){
					tList1.add(count, pSort1.get(i));
				}
			}
		}
		boolean goojf1to2 = false;
		boolean goojf2to1 = false;
		if(p1.isGoojf()){
			System.out.println("Would you like to add your Get Out of Jail Free Card to the trade('Y' or 'N')?");
			String a = s.next();
			if(a.toUpperCase().equals("Y")){
				goojf1to2 = true;
			}
		}
		if(p2.isGoojf()){
			System.out.printf("Would you like to add %s's Get Out of Jail Free Card to the trade('Y' or 'N')?\n", p2.getName());
			String a = s.next();
			if(a.toUpperCase().equals("Y")){
				goojf2to1 = true;
			}
		}
		notEmpty = true;
		System.out.println("Enter in the name of your opponent's properties that you are trading for, separated by commas Separate by lines, and hit enter twice when done\n");
		while(notEmpty){
			p = s.nextLine();
			if(p.length() == 0){
				notEmpty = false;
			}
			int count = 0;
			for(int i = 0; i < pSort2.size(); i++){
				if(pSort2.get(i).getName().equals(p)){
					tList2.add(count, pSort2.get(i));
				}
			}
		}
		System.out.printf("%s, would you like to add an amount of money to the trade('Y' or 'N')?\n", p1.getName());
		String w = s.next().toUpperCase();
		int amt1to2 = 0;
		int amt2to1 = 0;
		if(w.equals("Y")){
			System.out.println("Enter in the number of dollars you are adding from your end: ");
			amt1to2 = s.nextInt();
			System.out.println("Enter in the number of dollars you are requesting from the opponent: ");
			amt2to1 = s.nextInt();
		}
		boolean hasDecided = false;
		printTrade(p1, p2, tList1, tList2, goojf1to2, goojf2to1, amt1to2, amt2to1);
		while(!hasDecided){
			System.out.printf("%s, enter in 'Y' to accept the trade or 'N' to decline the trade\n", p2.getName());
			String ans = s.next();
			char answer = ans.charAt(0);
			switch(answer){
			case 'Y' :
				for(int i = 0; i < tList1.size(); i++){
					tList1.get(i).setOwner(p2);
					p2.getProperties().add(p2.getProperties().size(), tList1.get(i));
				}
				for(int i = 0; i < p1.getProperties().size(); i++){
					for(int j = 0; j < tList1.size(); j++){
						if(p1.getProperties().get(i).equals(tList1.get(j))){
							p1.getProperties().remove(i);
						}
					}
				}
				if(amt1to2 > 0){
					p2.takeMoney(amt1to2);
					p1.addMoney(amt1to2);
				}
				if(amt2to1 > 0){
					p2.takeMoney(amt2to1);
					p1.addMoney(amt2to1);
				}
				if(goojf1to2){
					p1.setGoojf(false);
					p2.setGoojf(true);
				}
				if(goojf2to1){
					p2.setGoojf(false);
					p1.setGoojf(true);
				}
				for(int i = 0; i < tList2.size(); i++){
					tList2.get(i).setOwner(p1);
					p1.getProperties().add(p1.getProperties().size(), tList2.get(i));
				}
				for(int i = 0; i < p2.getProperties().size(); i++){
					for(int j = 0; j < tList2.size(); j++){
						if(p2.getProperties().get(i).equals(tList2.get(j))){
							p2.getProperties().remove(i);
						}
					}
				}
				
				hasDecided = true;
				break;
			case 'N' :
				
				hasDecided = true;
				break;
			default:
				System.out.println("Invalid character, try again.");
				break;
			}
		}
	
	}

	private static void printTrade(Player p1, Player p2, ArrayList<Property> tList1, ArrayList<Property> tList2, boolean goojf1to2,
			boolean goojf2to1, int amt1to2, int amt2to1) {
		System.out.printf("%s has proposed the following trade:\nFrom %s: \n", p1.getName(), p1.getName());
		for(int i = 0; i < tList1.size(); i++){
			System.out.printf("\t%s", tList1.get(i).getName());
		}
		if(goojf1to2){
			System.out.printf("\t'Get Out of Jail Free' Card");
		}
		if(amt1to2 > 0){
			System.out.printf("$%d in cash\n", amt1to2);
		}
		System.out.printf("From %s: \n", p2.getName());
		for(int i = 0; i < tList2.size(); i++){
			System.out.printf("\t%s", tList2.get(i).getName());
		}
		if(goojf2to1){
			System.out.printf("\t'Get Out of Jail Free' Card");
		}
		if(amt2to1 > 0){
			System.out.printf("$%d in cash", amt2to1);
		}
	}

	@SuppressWarnings("resource")
	private static void executeTurn(Node n, Player p1, int r) {
		String ans = "";
		Scanner in = new Scanner(System.in);
		if(n.getP() != null){
			Property p = n.getP();
			boolean mort = p.isMortgage();
			Player owner = findOwner(p);
			//If the property is owned, not mortgaged, and is not owned by the current player
			if(p.isOwned() && !mort && !(owner.getName().equals(p1.getName()))){
				//if it is owned, pay rent
				int rent = getRent(p, r);
				if((p1.getMoney() - rent) < 0 && p1.getProperties().size() > 0){
					System.out.printf("Paying the rent of $%d will put you below $0. Please mortgage some properties.", rent);
					mortgageProperties(p1);
				}
				//TODO opportunity to also sell houses/hotels
				p1.takeMoney(rent);
				owner.addMoney(rent);
				System.out.printf("Transferring rent of $%d from %s to %s.\n%s's money total is $%d and %s's money total is $%d.\n\n", rent, p1.getName(), owner.getName(), p1.getName(), p1.getMoney(), owner.getName(), owner.getMoney());
			} else if(!p.isOwned()){
				//If property is unowned, prompt to buy
				System.out.printf("%s is available to buy, type 'Y' to buy or 'N' to pass\n", p.getName());
				ans = in.next().toUpperCase();
				int cost = p.getCost();
				if(ans.equals("Y") && cost < p1.getMoney()){
					
					//get property in property list and change owner
					for(int i = 0; i < properties.size(); i++){
						if(p.getName().equals(properties.get(i).getName())){
							properties.get(i).setOwner(p1);
							//add property to list of player's properties
							p1.addProperty(properties.get(i));
							n.getP().setOwned(true);
						}
					}
					//get railroad in railroad list and change owner
					for(int i = 0; i < railroads.size(); i++){
						if(p.getName().equals(railroads.get(i).getName())){
							railroads.get(i).setOwner(p1);
							//add property to list of player's properties
							p1.addProperty(railroads.get(i));
							n.getP().setOwned(true);
						}
					}
					//get railroad in railroad list and change owner
					for(int i = 0; i < utilities.size(); i++){
						if(p.getName().equals(utilities.get(i).getName())){
							utilities.get(i).setOwner(p1);
							//add property to list of player's properties
							p1.addProperty(utilities.get(i));
							n.getP().setOwned(true);
						}
					}
					//subtract property cost from players money
					p1.takeMoney(cost);
					
				} else if (ans.equals("N")){
					//Do nothing
				} else {
					System.out.printf("You do not have the required funds to by %s\n", p.getName());
				}
			} else {
				System.out.println("You own this property, so no rent is due!");
			}
		} else {
			//if it is chance/CC pull a card
			String c = n.getName();
			String card = "";
			if(c.equals("Community Chest")){
				card = Cards.getChestCard();
				System.out.printf("Your Community Chest Card is:\n%s\n\n", card);
				gc.doChestAction(p1, card);
			} else if (c.equals("Chance")){
				card = Cards.getChanceCard();
				System.out.printf("Your Chance Card is:\n%s\n\n", card);
				gc.doChanceAction(p1, card);
			}
		}		
	}

	public static void waitTwo(){
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			//do nothing
		}
	}
	
	private void doChanceAction(Player p, String card) {
		if(card.equals("Advance to Go (Collect $200)")){
			Node n = p.cardMove(p.getCurrent(), card);
			p.setCurrent(n);
			waitTwo();
			Board.updateGrid(p);
			executeTurn(n, p, 0);
		} else if(card.equals("Advance to Illinois Ave�If you pass Go, collect $200")){
			Node n = p.cardMove(p.getCurrent(), card);
			p.setCurrent(n);
			waitTwo();
			Board.updateGrid(p);
			executeTurn(n, p, 0);
		} else if(card.equals("Advance to St. Charles Place � If you pass Go, collect $200")){
			Node n = p.cardMove(p.getCurrent(), card);
			p.setCurrent(n);
			waitTwo();
			Board.updateGrid(p);
			executeTurn(n, p, 0);
		} else if(card.equals("Advance token to nearest Utility. If unowned, you may buy it from the Bank.")){
			Node n = p.cardMove(p.getCurrent(), card);
			p.setCurrent(n);
			waitTwo();
			Board.updateGrid(p);
			executeTurn(n, p, 0);
		} else if(card.equals("Advance token to the nearest Railroad. If Railroad is unowned, you may buy it from the Bank.")){
			Node n = p.cardMove(p.getCurrent(), card);
			p.setCurrent(n);
			waitTwo();
			Board.updateGrid(p);
			executeTurn(n, p, 0);
		} else if(card.equals("Bank pays you dividend of $50")){
			p.addMoney(50);
		} else if(card.equals("Get Out of Jail Free")){
			p.setGoojf(true);
		} else if(card.equals("Go Back 3 Spaces")){
			Node n = p.cardMove(p.getCurrent(), card);
			p.setCurrent(n);
			waitTwo();
			Board.updateGrid(p);
			executeTurn(n, p, 0);
		} else if(card.equals("Go to Jail�Go directly to Jail�Do not pass Go, do not collect $200")){
			Node n = p.cardMove(p.getCurrent(), card);
			p.setCurrent(n);
			waitTwo();
			Board.updateGrid(p);
			executeTurn(n, p, 0);
		} else if(card.equals("Make general repairs on all your property�For each house pay $25�For each hotel $100")){
			//TODO
		} else if(card.equals("Pay poor tax of $15")){
			p.takeMoney(15);
		} else if(card.equals("Take a trip to Reading Railroad�If you pass Go, collect $200")){
			Node n = p.cardMove(p.getCurrent(), card);
			p.setCurrent(n);
			waitTwo();
			Board.updateGrid(p);
			executeTurn(n, p, 0);
		} else if(card.equals("Take a walk on the Boardwalk�Advance token to Boardwalk")){
			Node n = p.cardMove(p.getCurrent(), card);
			p.setCurrent(n);
			waitTwo();
			Board.updateGrid(p);
			executeTurn(n, p, 0);
		} else if(card.equals("You have been elected Chairman of the Board�Pay each player $50")){
			for(int i = 0; i < players.size(); i++){
				if(!p.getName().equals(players.get(i).getName())){
					players.get(i).addMoney(50);
					p.takeMoney(50 * players.size());
				}
			}
		} else if(card.equals("Your building and loan matures�Collect $150")){
			p.addMoney(150);
		} else if(card.equals("You have won a crossword competition�Collect $100")){
			p.addMoney(100);
		}
	}

	private void doChestAction(Player p, String card) {
		if(card.equals("Advance to Go (Collect $200)")){
			
		} else if(card.equals("Bank error in your favor - collect $75")){
			p.addMoney(75);
		} else if(card.equals("Doctor's fees - Pay $50 ")){
			p.takeMoney(50);
		} else if(card.equals("Get out of jail free � this card may be kept until needed, or sold ")){
			p.setGoojf(true);
		} else if(card.equals("Go to jail � go directly to jail � Do not pass Go, do not collect $200 ")){
			Node n = p.cardMove(p.getCurrent(), card);
			p.setCurrent(n);
			waitTwo();
			Board.updateGrid(p);
			executeTurn(n, p, 0);
		} else if(card.equals("It is your birthday Collect $10 from each player ")){
			for(int i = 0; i < players.size(); i++){
				if(!p.getName().equals(players.get(i).getName())){
					players.get(i).takeMoney(10);
					p.addMoney(10);
				}
			}
		} else if(card.equals("Grand Opera Night � collect $50 from every player for opening night seats ")){
			for(int i = 0; i < players.size(); i++){
				if(!p.getName().equals(players.get(i).getName())){
					players.get(i).takeMoney(50);
					p.addMoney(50);
				}
			}
		} else if(card.equals("Income Tax refund � collect $20 ")){
			p.addMoney(20);
		} else if(card.equals("Life Insurance Matures � collect $100 ")){
			p.addMoney(100);
		} else if(card.equals("Pay Hospital Fees of $100 ")){
			p.takeMoney(100);
		} else if(card.equals("Pay School Fees of $50 ")){
			p.takeMoney(50);
		} else if(card.equals("Receive $25 Consultancy Fee ")){
			p.addMoney(25);
		} else if(card.equals("You are assessed for street repairs � $40 per house, $115 per hotel ")){
			//TODO
		} else if(card.equals("You have won second prize in a beauty contest� collect $10 ")){
			p.addMoney(10);
		} else if(card.equals("You inherit $100 ")){
			p.addMoney(100);
		} else if(card.equals("From sale of stock you get $50 ")){
			p.addMoney(50);
		} else if(card.endsWith("Holiday Fund matures - Receive $100")){
			p.addMoney(100);
		}
	}

	private static int getRent(Property p, int r) {
		String pType = p.getClass().getName().substring(13);
		if (pType.equals("Utility")){
			return p.calcRent() * r;
		} else {
			return p.calcRent();
		}
//		String pType = p.getClass().getName().substring(13);
//		if(pType.equals("Railroad")){
//			return 25;
//			//TODO add code for changed rent
//		} else if (pType.equals("Utility")){
//			return 6 * r;
//		} else if (pType.equals("RegProperty")){
//			return p.getRent();
//		}
//		return 0;
	}

	private static Player findOwner(Property p) {
		if(p.getOwner() == null){
			return null;
		}
		for(int i = 0; i < players.size(); i++){
			for(int j = 0; j < players.get(i).getProperties().size(); j++){
				if(p.getOwner().getName().equals(players.get(i).getName())){
					return players.get(i);
				}
			}
		}
		return null;
	}

	private static int roll() {
		Random rg = new Random();
		int d1 = rg.nextInt(5);
		int d2 = rg.nextInt(5);
		d1 += 1; //ensuring that a 0 cannot be rolled
		d2 += 1; //two dice being used to allow for "roll doubles and go again functionality" TODO
		return d1 + d2;
		//return 7;
	}

	private static void printStats(Player p) {
		System.out.println();
		System.out.println(p.getName());
		System.out.println("Money: " + p.getMoney() + "\nProperties:\n");
		ArrayList<Property> pSort = sortProperties(p.getProperties());
		for(int i = 0; i < pSort.size(); i++){
			System.out.printf("\t%20s\t%20s", pSort.get(i).getName(), pSort.get(i).getCost());
			if(pSort.get(i).isMortgage()){
				System.out.printf("\t%22s", "Property is mortgaged");
			}
			System.out.println();
		}
		
		if(p.isGoojf()){
			System.out.println("Has a 'Get out of jail free' Card");
		}
		System.out.println();
		//print properties, GOOJF, etc
	}

	private static ArrayList<Property> sortProperties(ArrayList<Property> properties) {
		//TODO does not properly split property groups
		ArrayList<Property> sList = new ArrayList<Property>();
		Property p = new Railroad("----------------------", 0, 0);
		int idx = 0;
		boolean lPrint = false; //true if seperator is necessary, false otherwise
		int s = properties.size();
		for(int i = 0; i < s; i++){
			if(properties.get(i).getName().equals("Mediterranean Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Baltic Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(lPrint){
				sList.add(idx, p);
				idx++;
			}
			lPrint = false;
			
			if(properties.get(i).getName().equals("Oriental Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Vermont Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Connecticut Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(lPrint){
				sList.add(idx, p);
				idx++;
			}
			lPrint = false;
			
			if(properties.get(i).getName().equals("St. Charles Place")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("States Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Virginia Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(lPrint){
				sList.add(idx, p);
				idx++;
			}
			lPrint = false;
			
			if(properties.get(i).getName().equals("St. James Place")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Tennessee Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("New York Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(lPrint){
				sList.add(idx, p);
				idx++;
			}
			lPrint = false;
			
			if(properties.get(i).getName().equals("Kentucky Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Indiana Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Illinois Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(lPrint){
				sList.add(idx, p);
				idx++;
			}
			lPrint = false;
			
			if(properties.get(i).getName().equals("Atlantic Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Ventor Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Marvin Gardens")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(lPrint){
				sList.add(idx, p);
				idx++;
			}
			lPrint = false;
			
			if(properties.get(i).getName().equals("Pacific Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("North Carolina Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Pennsylvania Avenue")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(lPrint){
				sList.add(idx, p);
				idx++;
			}
			lPrint = false;
			
			if(properties.get(i).getName().equals("Park Place")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Boardwark")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(lPrint){
				sList.add(idx, p);
				idx++;
			}
			lPrint = false;
			
			if(properties.get(i).getName().equals("Reading Railroad")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Pennsylvania Railroad")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("B. & O. Railroad")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Short Line")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(lPrint){
				sList.add(idx, p);
				idx++;
			}
			lPrint = false;
			
			if(properties.get(i).getName().equals("Electric Company")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(properties.get(i).getName().equals("Water Works")){
				sList.add(idx, properties.get(i));
				lPrint = true;
				idx++;
			}
			if(lPrint){
				sList.add(idx, p);
				idx++;
			}
			lPrint = false;
		}
		return sList;
	}

	
	
	@SuppressWarnings("resource")
	private static void readProperties(String prop, String rr, String util) {
		properties = new ArrayList<RegProperty>();
		File f = new File(prop);
		Scanner p = new Scanner(System.in);
		int count = 0;
		try {
			p = new Scanner(f).useDelimiter(",|\\n");
		} catch (FileNotFoundException e) {
			System.out.println("Invalid property file name");
		}
		while(p.hasNextLine()){
			String name = p.next();
			int cost = p.nextInt();
			int rent = p.nextInt();
			int one = p.nextInt();
			int two = p.nextInt();
			int three = p.nextInt();
			int four = p.nextInt();
			int hotelR = p.nextInt();
			String sHouseCost = p.next();
			Scanner i = new Scanner(sHouseCost);
			int houseCost = i.nextInt();
			RegProperty rp = new RegProperty(name, cost, rent, one, two, three, four, hotelR, houseCost);
			properties.add(count, rp);
		}
		
		
		railroads = new ArrayList<Railroad>();
		File f2 = new File(rr);
		Scanner r = new Scanner(System.in);
		count = 0;
		try {
			r = new Scanner(f2).useDelimiter(",|\\n");
		} catch (FileNotFoundException e) {
			System.out.println("Invalid property file name");
		}
		while(r.hasNextLine()){
			String name = r.next();
			int cost = r.nextInt();
			String rentString = r.next();
			Scanner r2 = new Scanner(rentString);
			int rent = r2.nextInt();
			Railroad rail = new Railroad(name, cost, rent);
			railroads.add(count, rail);
		}
		
		
		utilities = new ArrayList<Utility>();
		File f3 = new File(util);
		Scanner u = new Scanner(System.in);
		count = 0;
		try {
			u = new Scanner(f3).useDelimiter(",|\\n");
		} catch (FileNotFoundException e) {
			System.out.println("Invalid property file name");
		}
		while(u.hasNextLine()){
			String name = u.next();
			String costString = u.next();
			Scanner u2 = new Scanner(costString);
			int cost = u2.nextInt();
			int rent = 0;
			Utility utility = new Utility(name, cost, rent);
			utilities.add(count, utility);
		}
	}
	
	private static void setUpCircularList() {
		Node go = new Node("GO", null, 43, 126);
		cl = new CircularList(go);
		Node med = new Node("Mediterranean Avenue", properties.get(21), 42, 98);
		cl.addNode(med);
		Node cc1 = new Node("Community Chest", null, 42, 88);
		cl.addNode(cc1);
		Node bal = new Node("Baltic Avenue", properties.get(20), 42, 78);
		cl.addNode(bal);
		Node incTax = new Node("Income Tax",  null, 42, 68);
		cl.addNode(incTax);
		Node rRR = new Node("Reading Railroad",  railroads.get(3), 42, 58);
		cl.addNode(rRR);
		Node orien = new Node("Oriental Avenue",  properties.get(19), 42, 48);
		cl.addNode(orien);
		Node chance1 = new Node("Chance",  null, 42, 38);
		cl.addNode(chance1);
		Node vmt = new Node("Vermont Avenue",  properties.get(18), 42, 28);
		cl.addNode(vmt);
		Node conn = new Node("Connecticut Avenue",  properties.get(17), 42, 18);
		cl.addNode(conn);
		Node jail = new Node("Jail/Just Visiting",  null, 49, 2);
		cl.addNode(jail);
		Node stchls = new Node("St. Charles Place",  properties.get(16), 40, 19);
		cl.addNode(stchls);
		Node elec = new Node("Electric Company",  utilities.get(1), 36, 19);
		cl.addNode(elec);
		Node sts = new Node("States Avenue",  properties.get(15), 32, 19);
		cl.addNode(sts);
		Node vir = new Node("Virginia Avenue",  properties.get(14), 28, 19);
		cl.addNode(vir);
		Node pRR = new Node("Pennsylvania Railroad",  railroads.get(2), 24, 19);
		cl.addNode(pRR);
		Node stjms = new Node("St. James Place",  properties.get(13), 20, 19);
		cl.addNode(stjms);
		Node cc2 = new Node("Community Chest",  null, 16, 19);
		cl.addNode(cc2);
		Node tenn = new Node("Tennessee Avenue",  properties.get(12), 12, 19);
		cl.addNode(tenn);
		Node nya = new Node("New York Avenue",  properties.get(11), 9, 19);
		cl.addNode(nya);
		Node fp = new Node("Free Parking", null, 5, 3);
		cl.addNode(fp);
		Node kent = new Node("Kentucky Avenue",  properties.get(10), 7, 19);
		cl.addNode(kent);
		Node chance2 = new Node("Chance", null, 7, 29);
		cl.addNode(chance2);
		Node indiana = new Node("Indiana Avenue", properties.get(9), 7, 39);
		cl.addNode(indiana);
		Node ili = new Node("Illinios Avenue", properties.get(8), 7, 49);
		cl.addNode(ili);
		Node boRR = new Node("B. & O. Railroad", railroads.get(1), 7, 59);
		cl.addNode(boRR);
		Node atl = new Node("Atlantic Avenue", properties.get(7), 7, 69);
		cl.addNode(atl);
		Node vent = new Node("Ventor Avenue", properties.get(6), 7, 79);
		cl.addNode(vent);
		Node water = new Node("Water Works", utilities.get(0), 7, 89);
		cl.addNode(water);
		Node mg = new Node("Marvin Gardens", properties.get(5), 7, 99);
		cl.addNode(mg);
		Node gtj = new Node("Go To Jail", null, 49, 2);
		cl.addNode(gtj);
		Node pac = new Node("Pacific Avenue", properties.get(4), 9, 104);
		cl.addNode(pac);
		Node nc = new Node("North Carolina Avenue", properties.get(3), 13, 104);
		cl.addNode(nc);
		Node cc3 = new Node("Community Chest", null, 17, 104);
		cl.addNode(cc3);
		Node pen = new Node("Pennsylvania Avenue", properties.get(2), 21, 104);
		cl.addNode(pen);
		Node slRR = new Node("Short Line", railroads.get(0), 25, 104);
		cl.addNode(slRR);
		Node chance3 = new Node("Chance", null, 29, 104);
		cl.addNode(chance3);
		Node pp = new Node("Park Place", properties.get(1), 33, 104);
		cl.addNode(pp);
		Node luxTx = new Node("Luxury Tax", null, 37, 104);
		cl.addNode(luxTx);
		Node bw = new Node("Boardwalk", properties.get(0), 40, 104);
		cl.addNode(bw);
	}
	
//	private boolean checkMonopolized(Property p){
//	TODO	
//	}

}