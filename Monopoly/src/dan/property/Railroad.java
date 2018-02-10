package dan.property;

public class Railroad  extends Property{

	private int count;
	
	public Railroad(String name, int cost, int rent) {
		super(name, cost, rent);
		this.count = 1;
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

	@Override
	public int calcRent() {
		if(count == 1){
			return 25;
		} else if (count == 2){
			return 50;
		} else if (count == 3){
			return 100;
		} else if (count == 4){
			return 200;
		} else {
			return 25;			
		}
	}

}
