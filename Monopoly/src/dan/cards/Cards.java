package dan.cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import dan.list.ArrayList;

public class Cards {

	static ArrayList<Card> chance;
	static ArrayList<Card> chest;
	static Random rg = new Random();
	
	public Cards(String chancefile, String chestfile) {
		chance = new ArrayList<Card>();
		chest = new ArrayList<Card>();
		readChance(chancefile);
		readChest(chestfile);
	}

	@SuppressWarnings("resource")
	private void readChance(String chancefile) {
		try {
			File f = new File(chancefile);
			Scanner s = null;
			int c = 0;
			Card card = null;
			s = new Scanner(f);
			while(s.hasNextLine()){
				String l = s.nextLine();
				card = new Card(c, l);
				chance.add(c, card);
				c++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file name");
		}
	}
	
	@SuppressWarnings("resource")
	private void readChest(String chestfile) {
		try {
			File f = new File(chestfile);
			Scanner s = null;
			int c = 0;
			Card card = null;
			s = new Scanner(f);
			while(s.hasNextLine()){
				String l = s.nextLine();
				card = new Card(c, l);
				chest.add(c, card);
				c++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file name");
		}
	}
	
	public static Card getChanceCard(){
		int i = rg.nextInt(15);
		return chance.get(i);
	}
	
	public static Card getChestCard(){
		int i = rg.nextInt(16);
		return chest.get(i);
	}

}