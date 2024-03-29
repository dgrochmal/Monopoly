/**
 * 
 */
package dan.board;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dan.list.ArrayList;
import dan.player.Player;

/**
 * @author Dan G
 *
 */
public class Board {

	
	static ArrayList<char[]> board;
	
	/**
	 * 
	 */
	public Board(String file) {
		board = new ArrayList<char[]>();
		readBoard(file);
	}

	@SuppressWarnings("resource")
	private void readBoard(String filename) {
		try {
			File f = new File(filename);
			Scanner s = null;
			int currentLine = 0;
			s = new Scanner(f);
			while(s.hasNextLine()){
				String line = s.nextLine();
				board.add(currentLine, line.toCharArray());
				currentLine++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}
	
	public char[] getLine(int i){
		return board.get(i);
	}
	
	public static void printGrid(){
		for(int i = 0; i < board.size(); i++){
			System.out.println(board.get(i));
		}
	}

	public static void updateGrid(Player p1, Player p2) {
		int x = p1.getCurrent().getX();
		int y = p1.getCurrent().getY();
		char[] l = board.get(x);
		for(int i = y; i < y+3; i++){
			l[i] = p1.getAbbr().charAt(i-y);
		}
		board.set(x, l);
		
		int x2 = p2.getCurrent().getX();
		int y2 = p2.getCurrent().getY();
		//If Both players on on the same spot, and on the right column of the board, subtract p2 as to allow space
		if(x == x2 && y == y2 && y == 104){
			y2 -= 4;
		} else if(x == x2 && y == y2){ //allow space for second players name when two players are on the same spot
			y2 += 4;
		}
		
		char[] l2 = board.get(x2);
		for(int i = y2; i < y2+3; i++){
			l2[i] = p2.getAbbr().charAt(i-y2);
		}
		board.set(x2, l2);
		
		printGrid();
		
		char[] ll;
		if(x == 42){
			ll = board.get(x);
			for(int i = y; i < y+3; i++){
				ll[i] = '_';
			}
		} else {
			ll = board.get(x);
			for(int i = y; i < y+3; i++){
				ll[i] = ' ';
			}
		}
		board.set(x, ll);
		
		char[] ll2;
		if(x2 == 42){
			ll2 = board.get(x2);
			for(int i = y2; i < y2+3; i++){
				ll2[i] = '_';
			}
		} else {
			ll2 = board.get(x2);
			for(int i = y2; i < y2+3; i++){
				ll2[i] = ' ';
			}
		}
		board.set(x2, ll2);
	}
	
	public static void updateGrid(Player p1) {
		int x = p1.getCurrent().getX();
		int y = p1.getCurrent().getY();
		char[] l = board.get(x);
		for(int i = y; i < y+3; i++){
			l[i] = p1.getAbbr().charAt(i-y);
		}
		board.set(x, l);
				
		printGrid();
		
		char[] ll;
		if(x == 42){
			ll = board.get(x);
			for(int i = y; i < y+3; i++){
				ll[i] = '_';
			}
		} else {
			ll = board.get(x);
			for(int i = y; i < y+3; i++){
				ll[i] = ' ';
			}
		}
		board.set(x, ll);
	}

}