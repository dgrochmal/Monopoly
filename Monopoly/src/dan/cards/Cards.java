package dan.cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import dan.list.ArrayList;

public class Cards {

	static ArrayList<String> chance;
	static ArrayList<String> chest;
	static Random rg = new Random();
	
	public Cards(String chancefile, String chestfile) {
		chance = new ArrayList<String>();
		chest = new ArrayList<String>();
		readChance(chancefile);
		readChest(chestfile);
	}

	private void readChance(String chancefile) {
		File f = new File(chancefile);
		Scanner s = null;
		int c = 0;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file name");
		}
		while(s.hasNextLine()){
			String l = s.nextLine();
			chance.add(c, l);
			c++;
		}
	}
	
	private void readChest(String chestfile) {
		File f = new File(chestfile);
		Scanner s = null;
		int c = 0;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.out.println("Invalid file name");
		}
		while(s.hasNextLine()){
			String l = s.nextLine();
			chest.add(c, l);
			c++;
		}
	}
	
	public static String getChanceCard(){
		int i = rg.nextInt(15);
		return chance.get(i);
	}
	
	public static String getChestCard(){
		int i = rg.nextInt(16);
		return chest.get(i);
	}

}