

/**
 * @author keshavgaddhyan
 * Lowest subclass in the heirarchy
 * This class stores location of each Cat type animal
 */
public class Cat extends Feline
{
	
	private int x,y;

	/* (non-Javadoc)
	 * @see Animal#getlocationx()
	 * overloaded function to get x location
	 */
	int getlocationx()
	{
		return x;
	}
	
	/* (non-Javadoc)
	 * @see Animal#getlocationy()
	 * overloaded function to get y location
	 */
	int getlocationy()
	{
		return y;
	}
	/* (non-Javadoc)
	 * @see Animal#setlocation(int, int)
	 * overloaded function to set x,y location of Cat
	 */
	@Override
	void setlocation(int a, int b)
	{
		
		x=a;
		y=b;
		
	}

	
		
	}


