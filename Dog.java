

/**
 * @author keshavgaddhyan
 * Lowest class in the heirarchy
 * This class stores location of each dog type animal
 */
public class Dog extends Canine{

	private int x,y;
	/* (non-Javadoc)
	 * @see Animal#setlocation(int, int)
	 * overloaded function to set location of Dog
	 */
	@Override
	void setlocation(int a, int b) 
	{
		x=a;
		y=b;
	}
/* (non-Javadoc)
 * @see Animal#getlocationx()
 * overloaded function to get location of x
 */
int getlocationx() 
{
	return x;
}

/* (non-Javadoc)
 * @see Animal#getlocationy()
 * overloaded function to get  y location of animal
 */
int getlocationy()
{
	return y;
}




}
