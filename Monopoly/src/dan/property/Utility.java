package dan.property;

public class Utility extends Property {

	private int count;
	
	public Utility(String name, int cost, int rent) {
		super(name, cost, rent);
		this.count = 0;
	}
	


	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

//	public static int calcRent(int roll, int count){
//		if(count == 1){
//			return roll * 4;
//		} else if (count == 2){
//			return roll * 10;
//		} else {
//			throw new IllegalArgumentException("Invalid count number");
//		}
//	}
	@Override
	public int calcRent() {
		if (count == 1){
			return 4;
		} else if (count == 2){
			return 10;
		} else {
			return 4;
		}
	}

}
