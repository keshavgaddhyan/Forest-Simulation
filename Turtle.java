
import java.util.Random;

/**
 * @author keshavgaddhyan
 * this class has the data stored for animal type turtle
 * it also overides move and attack function for type turtle
 */
public class Turtle extends Animal {

	Random rand=new Random();
	private int x,y;
	/* (non-Javadoc)
	 * @see Animal#setlocation(int, int)
	 * sets x and y location of turtle
	 */
	@Override
	void setlocation(int a, int b) {
		
		x=a;
		y=b;
	}

	/* (non-Javadoc)
	 * @see Animal#move(Animal)
	 * 
	 * implements the move function when animal is a turtle
	 */
	@Override
	void move(Animal q) {
		int nx=x,ny=y;
		/**
		 * nx and ny stores the final location of the moved animal
		 * variable probablity calculates the chances of where the animal wpould move
		 */
		int probability=rand.nextInt(100);
		if(probability<50)
		{
			int prob=rand.nextInt(100);
			if(prob<25)
			{
				
				nx=x+1;
			}
			
			if(prob>24 && prob<50)
			{
				nx=x-1;
			}
			
			if(prob>49 && prob<75)
			{
				ny=y+1;
			}
			
			if(prob>74 && prob<100)
			{
				ny=y-1;
			}
			
		
		while(nx<0 || nx>=15 || ny<0 || ny>=15)
		{
			nx=x;ny=y;
			prob=rand.nextInt(100);
			if(prob<25)
			{
				
				nx=x+1;
			}
			
			if(prob>24 && prob<50)
			{
				nx=x-1;
			}
			
			if(prob>49 && prob<75)
			{
				ny=y+1;
			}
			
			if(prob>74 && prob<100)
			{
				ny=y-1;
			}
			
		}
		if(sim[nx][ny]!='.')
		{
			q.attack(q,nx,ny);  //attack function call
		}
		else
		{
			sim[x][y]='.';
			sim[nx][ny]='u';
			System.out.print("Turtle moved from ("+x+", "+y+") to ");
			System.out.println("("+nx+", "+ny+") ");
			x=nx;
			y=ny;
		}
	}
		else
		{
			x=nx;
			y=ny;
			System.out.println("Turtle stayed in ("+nx+", "+ny+")");
		}
		
		
	}

	/* (non-Javadoc)
	 * @see Animal#getlocationx()
	 * returns x location of turtle
	 */
	@Override
	int getlocationx() {
		
		return x;
	}

	/* (non-Javadoc)
	 * @see Animal#getlocationy()
	 * return y location of turtle
	 */
	@Override
	int getlocationy()
	{
		
		return y;
	}

	/* (non-Javadoc)
	 * @see Animal#attack(Animal, int, int)
	 * implements the attack when the attacker is a turtle
	 */
	@Override
	void attack(Animal q, int nx, int ny)
	{
		/**
		 * opponenet stores the animal object which Animal q would attack
		 */
		Animal opponent = null;
		for(Animal temp:animals)
		{
			if(temp.getlocationx()==nx && temp.getlocationy()==ny)
			{
				 opponent=temp;
				 break;
			}
		}
		
		System.out.print("Turtle from ("+x+", "+y+") attacks ");
			int chance= rand.nextInt(2);
			if(chance==0)
			{
				System.out.println(opponent.getClass().getName()+" at ("+nx+", "+ny+") and wins");
				System.out.println("The Loser dies at ("+nx+", "+ny+") ");
				sim[x][y]='.';
				sim[nx][ny]='u';
				System.out.print("Turtle moved from ("+x+", "+y+") to ");
				System.out.println("("+nx+", "+ny+") ");
				String temp= opponent.getClass().getName()+" died at location ("+nx+", "+ny+")";
				Animal.addDeadAnimals(temp);
				animals.remove(opponent);
				q.setlocation(nx, ny);
			}
			else
			{
				super.attack(q,nx,ny);        //calling the parent attack function
				
				
			}
}
}
