

/**
 * @author keshavgaddhyan
 * class which stores location of animal type fox
 */
public class Fox extends Canine {

	private int x,y;
	/* (non-Javadoc)
	 * @see Animal#setlocation(int, int)
	 * sets x and y location of fox
	 */
	@Override
	void setlocation(int a, int b) {
		x=a;
		y=b;
		
	}
	/* (non-Javadoc)
	 * @see Animal#getlocationx()
	 * gets x location of fox
	 */
	@Override
	int getlocationx() {
		
		return x;
	}
	/* (non-Javadoc)
	 * @see Animal#getlocationy()
	 * gets y location of fox
	 */
	@Override
	int getlocationy() {
	
		return y;
	}

			
	}

