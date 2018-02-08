package dan.property;

public class RegProperty extends Property{

	
	private int houseNum;
	private boolean hasHotel;
	private int oneHouseRent;
	private int twoHouseRent;
	private int threeHouseRent;
	private int fourHouseRent;
	private int hotelRent;
	private int houseCost;
	private boolean monopolized;
	private int rent;
	
	
	public RegProperty(String name, int cost, int rent, int one, int two, int three, int four, int hotelRent, int houseCost) {
		super(name, cost, rent);
		this.hasHotel = false;
		this.houseNum = 0;
		this.oneHouseRent = one;
		this.twoHouseRent = two;
		this.threeHouseRent = three;
		this.fourHouseRent = four;
		this.hotelRent = hotelRent;
		this.houseCost = houseCost;
		monopolized = false;
		this.rent = rent;
	}

	

	/**
	 * @return the houseNum
	 */
	public int getHouseNum() {
		return houseNum;
	}


	/**
	 * @param houseNum the houseNum to set
	 */
	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}


	/**
	 * @return the hasHotel
	 */
	public boolean hasHotel() {
		return hasHotel;
	}


	/**
	 * @param hasHotel the hasHotel to set
	 */
	public void setHasHotel(boolean hasHotel) {
		this.hasHotel = hasHotel;
	}


	/**
	 * @return the oneHouseRent
	 */
	public int getOneHouseRent() {
		return oneHouseRent;
	}


	/**
	 * @param oneHouseRent the oneHouseRent to set
	 */
	public void setOneHouseRent(int oneHouseRent) {
		this.oneHouseRent = oneHouseRent;
	}


	/**
	 * @return the twoHouseRent
	 */
	public int getTwoHouseRent() {
		return twoHouseRent;
	}


	/**
	 * @param twoHouseRent the twoHouseRent to set
	 */
	public void setTwoHouseRent(int twoHouseRent) {
		this.twoHouseRent = twoHouseRent;
	}


	/**
	 * @return the threeHouseRent
	 */
	public int getThreeHouseRent() {
		return threeHouseRent;
	}


	/**
	 * @param threeHouseRent the threeHouseRent to set
	 */
	public void setThreeHouseRent(int threeHouseRent) {
		this.threeHouseRent = threeHouseRent;
	}


	/**
	 * @return the fourHouseRent
	 */
	public int getFourHouseRent() {
		return fourHouseRent;
	}


	/**
	 * @param fourHouseRent the fourHouseRent to set
	 */
	public void setFourHouseRent(int fourHouseRent) {
		this.fourHouseRent = fourHouseRent;
	}


	/**
	 * @return the hotelRent
	 */
	public int getHotelRent() {
		return hotelRent;
	}


	/**
	 * @param hotelRent the hotelRent to set
	 */
	public void setHotelRent(int hotelRent) {
		this.hotelRent = hotelRent;
	}


	/**
	 * @return the houseCost
	 */
	public int getHouseCost() {
		return houseCost;
	}


	/**
	 * @param houseCost the houseCost to set
	 */
	public void setHouseCost(int houseCost) {
		this.houseCost = houseCost;
	}

	/**
	 * @return the mortgaged
	 */
	public boolean isMonopolized() {
		return monopolized;
	}

	/**
	 * @param mortgaged the mortgaged to set
	 */
	public void setMonopolized (boolean monopolized) {
		this.monopolized = monopolized;
	}

//	public static int calcRent(RegProperty p){
//		int n = p.getHouseNum();
//		if(p.hasHotel){
//			return p.getHotelRent();
//		} else if (n == 1){
//			return p.getOneHouseRent();
//		} else if (n == 2){
//			return p.getTwoHouseRent();
//		} else if (n == 3){
//			return p.getThreeHouseRent();
//		} else if (n == 4){
//			return p.getFourHouseRent();
//		} else {
//			return 0;
//		}
//	}

	@Override
	public int calcRent() {
		if(hasHotel){
			return getHotelRent();
		} else if(houseNum == 1){
			return oneHouseRent;
		} else if(houseNum == 2){
			return twoHouseRent;
		} else if(houseNum == 3){
			return threeHouseRent;
		} else if(houseNum == 4){
			return fourHouseRent;
		} else if(monopolized){
			return rent * 2;
		} else {
			return rent;
		}
	}

}
