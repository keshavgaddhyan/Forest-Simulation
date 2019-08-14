
import java.util.Random;

/**
 * @author keshavgaddhyan
 * Contains the move,attack and location of animal type hippo
 */
public class Hippo extends Animal {
	Random rand=new Random();

	private int x,y;
	@Override
	void setlocation(int a, int b) {
		
		x=a;
		y=b;
		
	}

	/* (non-Javadoc)
	 * @see Animal#move(Animal)
	 * controls movement of animal type Hippo
	 */
	@Override
	void move(Animal q)
	{
		int nx=x,ny=y;
		/**
		 * nx and ny stores the final location of moving animal
		 * probability calculates the chances of hippo moving to a location
		 */
		int probability=rand.nextInt(100);
		if(probability<25)
		{
			
			nx=x+1;
		}
		
		if(probability>24 && probability<50)
		{
			nx=x-1;
		}
		
		if(probability>49 && probability<75)
		{
			ny=y+1;
		}
		
		if(probability>74 && probability<100)
		{
			ny=y-1;
		}
		while(nx<0 || nx>=15 || ny<0 || ny>=15)
		{
			nx=x;ny=y;
		probability=rand.nextInt(100);
		if(probability<25)
		{
			
			nx=x+1;
		}
		
		if(probability>24 && probability<50)
		{
			nx=x-1;
		}
		
		if(probability>49 && probability<75)
		{
			ny=y+1;
		}
		
		if(probability>74 && probability<100)
		{
			ny=y-1;
		}
		}
		if(sim[nx][ny]!='.')
		{
			q.attack(q,nx,ny);
		}
		else
		{
			sim[x][y]='.';
			sim[nx][ny]='h';
			System.out.print("Hippo moved from ("+x+", "+y+") to ");
			System.out.println("("+nx+", "+ny+") ");
			x=nx;
			y=ny;
		}
	}

	
	/* (non-Javadoc)
	 * @see Animal#getlocationx()
	 * returns x location of hippo
	 */
	@Override
	int getlocationx() {
		
		return x;
	}

	/* (non-Javadoc)
	 * @see Animal#getlocationy()
	 * return y location of hoppi
	 */
	@Override
	int getlocationy() {
		
		return y;
	}
		
	

	/* (non-Javadoc)
	 * @see Animal#attack(Animal, int, int)
	 * Controls the attack if the attacker is hippo
	 */
	@Override
	void attack(Animal q, int nx, int ny) {
		/**
		 * opponent stores the animal object which Animal q would attack
		 * 
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
		
		System.out.print("Hippo from ("+x+", "+y+") attacks ");
		if(sim[nx][ny]=='h')
		 {
			int chance= rand.nextInt(2);
			if(chance==0)
			{
				System.out.println("Hippo at ("+nx+", "+ny+") and wins");
				System.out.println("The Loser dies at ("+nx+", "+ny+") ");
				sim[x][y]='.';
				System.out.print("Hippo moved from ("+x+", "+y+") to ");
				System.out.println("("+nx+", "+ny+") ");
				String temp="Hippo died at location ("+nx+", "+ny+")";
				Animal.addDeadAnimals(temp);
				animals.remove(opponent);
				q.setlocation(nx, ny);
			}
			else
			{
				System.out.println("Hippo at ("+nx+", "+ny+") and loses");
				System.out.println("The Loser dies at ("+x+", "+y+") ");
				sim[x][y]='.';
				String temp="Hippo died at location ("+x+", "+y+")";
				Animal.addDeadAnimals(temp);
				animals.remove(q);
				
			}
			 
		 }
		else if(sim[nx][ny]=='u')
		 {
			int chance=rand.nextInt(5);
			 if(chance==0)
			 {
				 System.out.println("Turtle at ("+nx+", "+ny+") and wins");
				 System.out.println("The Loser dies at ("+nx+", "+ny+") ");
				 sim[x][y]='.';
				 sim[nx][ny]='h';
				 System.out.print("Hippo moved from ("+x+", "+y+") to ");
					System.out.println("("+nx+", "+ny+") ");
				 String temp="Turtle died at location ("+nx+", "+ny+") ";
				 Animal.addDeadAnimals(temp);
				 animals.remove(opponent);
				 q.setlocation(nx, ny);
			 }
			 else
			 {
				 System.out.println("Turtle at ("+nx+", "+ny+") and loses");
					System.out.println("The Loser dies at ("+x+", "+y+") ");
					sim[x][y]='.';
					String temp="Hippo died at location ("+x+", "+y+")";
					Animal.addDeadAnimals(temp);
					animals.remove(q);
			 }
		 
	}
		else
		{
			super.attack(q,nx,ny);
			
		}
	}
}
