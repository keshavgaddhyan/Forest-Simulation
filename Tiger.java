
/**
 * @author keshavgaddhyan
 * Contains the location and other data of animal type Tiger
 */
public class Tiger extends Feline{

	private int x,y;


	/* (non-Javadoc)
	 * @see Animal#setlocation(int, int)
	 * sets the x and y location of animal type tiger
	 */
	@Override
	void setlocation(int a, int b) {
		
		x=a;
		y=b;
		
	}

	/* (non-Javadoc)
	 * @see Animal#getlocationx()
	 * returns x location of animal type tiger
	 */
	@Override
	int getlocationx() {
	
		return x;
	}

	/* (non-Javadoc)
	 * @see Animal#getlocationy()
	 * return y location of animal type tiger
	 */
	@Override
	int getlocationy() {
		
		return y;
	}

}
