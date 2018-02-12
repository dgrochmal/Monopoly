package dan.gamecenter;

import java.util.Random;

public class Roll {

	private int dice1;
	private int dice2;
	private boolean isDouble;
	private int total;
	
	public Roll() {
		Random rg = new Random();
		this.dice1 = rg.nextInt(5);
		this.dice2 = rg.nextInt(5);
		this.dice1 += 1; //ensuring that a 0 cannot be rolled
		this.dice2 += 1;
		this.total = this.dice1 + this.dice2;
//		this.total = 0; //For debugging
		if(this.dice1 == this.dice2){
			this.isDouble = true;
		}
		//this.isDouble = true; //for debugging doubles
	}

	/**
	 * @return the dice1
	 */
	public int getDice1() {
		return dice1;
	}

	/**
	 * @param dice1 the dice1 to set
	 */
	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	/**
	 * @return the dice2
	 */
	public int getDice2() {
		return dice2;
	}

	/**
	 * @param dice2 the dice2 to set
	 */
	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	/**
	 * @return the isDouble
	 */
	public boolean isDouble() {
		return isDouble;
	}

	/**
	 * @param isDouble the isDouble to set
	 */
	public void setDouble(boolean isDouble) {
		this.isDouble = isDouble;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

}
