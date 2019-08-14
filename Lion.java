

/**
 * @author keshavgaddhyan
 *lowest subclass in the heirarchy
 *stores values of the animal type Lion
 */
public class Lion extends Feline
{

	private int x,y;

	/* (non-Javadoc)
	 * @see Animal#setlocation(int, int)
	 */
	@Override
	void setlocation(int a, int b) {
		
		x=a;
		y=b;
		
	}

	/* (non-Javadoc)
	 * @see Animal#getlocationx()
	 */
	@Override
	int getlocationx() {
	
		return x;
	}

	/* (non-Javadoc)
	 * @see Animal#getlocationy()
	 */
	@Override
	int getlocationy() {
	
		return y;
	}

}
