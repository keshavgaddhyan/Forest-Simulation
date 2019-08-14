
/**
 * @author keshavgaddhyan
 * subclass of animal type wolf
 * contains data for wolf
 * 
 */
public class Wolf extends Canine{

	private int x,y;
	/* (non-Javadoc)
	 * @see Animal#setlocation(int, int)
	 * sets x and y location of wolf
	 */
	@Override
	void setlocation(int a, int b) {
		
		x=a;
		y=b;
	}
	/* (non-Javadoc)
	 * @see Animal#getlocationx()
	 * gets x location of wolf
	 */
	@Override
	int getlocationx() {
		
		return x;
	}
	/* (non-Javadoc)
	 * @see Animal#getlocationy()
	 * returns y location of wolf
	 */
	@Override
	int getlocationy() {
		
		return y;
	}

	
		
	}


