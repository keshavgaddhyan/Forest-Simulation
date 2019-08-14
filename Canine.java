
import java.util.Random;
/**
 * @author keshavgaddhyan
 *This is a subclass from animals 
 *it is the parent class of Dog, Wolf and Fox
 *it has move and attack functions for animal type canine
 */
public abstract class Canine extends Animal{
	
	Random rand=new Random();
 /* (non-Javadoc)
 * @see Animal#move(Animal) 
 * this is overloaded function for movememnt of canines
 */
void move(Animal q)
{
	/**
	 * x and y store the location of animal to be moved
	 * nx and ny stores stores the final location of the moved animal
	 */
	int x=q.getlocationx();
	int y=q.getlocationy();
	int nx=x,ny=y;

	int probability=rand.nextInt(80);
	if(probability<10)
	{
		nx=x+1;
	}
	if(probability>=10 && probability<20)
	{
		nx=x-1;
	}
	if(probability>=20 && probability<30)
	{
		ny=y-1;
	}
	if(probability>=30 && probability<40)
	{
		ny=y+1;
	}
	if(probability>=40 && probability<50)
	{
		nx=x+2;
		
	}
	if(probability>=50 && probability<60)
	{
		nx=x-2;
	}
	if(probability>=60 && probability<70)
	{
		ny=y-2;
	}
	if(probability>=70 && probability<80)
	{
		ny=y+2;
	}
	while(nx<0 || nx>=15 || ny<0 || ny>=15)
	{
	 nx=x;ny=y;
	 probability=rand.nextInt(80);
	if(probability<10)
	{
		nx=x+1;
	}
	if(probability>=10 && probability<20)
	{
		nx=x-1;
	}
	if(probability>=20 && probability<30)
	{
		ny=y-1;
	}
	if(probability>=30 && probability<40)
	{
		ny=y+1;
	}
	if(probability>=40 && probability<50)
	{
		nx=x+2;		
	}
	if(probability>=50 && probability<60)
	{
		nx=x-2;
	}
	if(probability>=60 && probability<70)
	{
		ny=y-2;
	}
	if(probability>=70 && probability<80)
	{
		ny=y+2;
	}
	}
	if(nx-x==2   && sim[nx-1][ny]!='.')
	{
		q.attack(q, nx-1, ny);
		if(animals.contains(q))
		{
			if(sim[nx][ny]!='.')
				q.attack(q,nx,ny);

			else
			{
				x=getlocationx();
				y=getlocationy();
				sim[x][y]='.';
				sim[nx][ny]=Character.toLowerCase((q.getClass().getName().charAt(0)));
				System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
				System.out.println("("+nx+", "+ny+") ");
				q.setlocation(nx, ny);
			}
		}
		
	}
	else if(x-nx==2   && sim[nx+1][ny]!='.')
	{
		q.attack(q, nx+1, ny);
		if(animals.contains(q))
		{
			if(sim[nx][ny]!='.')
				q.attack(q,nx,ny);

			else
			{
				x=getlocationx();
				y=getlocationy();
				sim[x][y]='.';
				sim[nx][ny]=Character.toLowerCase((q.getClass().getName().charAt(0)));
				System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
				System.out.println("("+nx+", "+ny+") ");
				q.setlocation(nx, ny);
			}
		}
	}
	else if(ny-y==2   && sim[nx][ny-1]!='.')
	{
		q.attack(q, nx, ny-1);
		if(animals.contains(q))
		{
			if(sim[nx][ny]!='.')
				q.attack(q,nx,ny);

			else
			{
				x=getlocationx();
				y=getlocationy();
				sim[x][y]='.';
				sim[nx][ny]=Character.toLowerCase((q.getClass().getName().charAt(0)));
				System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
				System.out.println("("+nx+", "+ny+") ");
				q.setlocation(nx, ny);
			}
		}
	}
	else if(y-ny==2   && sim[nx][ny+1]!='.')
	{
		q.attack(q, nx, ny+1);
		if(animals.contains(q))
		{
			if(sim[nx][ny]!='.')
				q.attack(q,nx,ny);

			else
			{
				x=getlocationx();
				y=getlocationy();
				sim[x][y]='.';
				sim[nx][ny]=Character.toLowerCase((q.getClass().getName().charAt(0)));
				System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
				System.out.println("("+nx+", "+ny+") ");
				q.setlocation(nx, ny);
			}
		}
	}
	else if(sim[nx][ny]!='.')
	{
		q.attack(q,nx,ny);
	}
	else
	{
		sim[x][y]='.';
		sim[nx][ny]=Character.toLowerCase((q.getClass().getName().charAt(0)));
		System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
		System.out.println("("+nx+", "+ny+") ");
		q.setlocation(nx, ny);
	}
}
 /* (non-Javadoc)
 * @see Animal#attack(Animal, int, int)
 * this is the overloaded function when the attacker is Canine
 */
void attack(Animal q, int nx, int ny)
 {
	 Animal opponent = null;
	 /**
	  * opponent stores the animal object which Animal q would attack
	  * x and y store the location of the attacking animal
	  * 
	  */
		int x=q.getlocationx();
		int y=q.getlocationy();
		for(Animal temp: animals)
		{
			if(temp.getlocationx()==nx && temp.getlocationy()==ny)
			{
				 opponent=temp;
				 break;
			}
		}
		 System.out.print(q.getClass().getName()+" from ("+x+", "+y+") attacks ");
		 
		  if(Character.toLowerCase((q.getClass().getName().charAt(0)))=='f' && sim[nx][ny]=='c')
		 {
			 System.out.println("Cat at ("+nx+", "+ny+") and wins");
			 System.out.println("The Loser dies at ("+nx+", "+ny+") ");
			 sim[x][y]='.';
			 sim[nx][ny]='f';
			 String temp="Cat died at location ("+nx+", "+ny+") ";
			 System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
			System.out.println("("+nx+", "+ny+") ");
			q.setlocation(nx, ny);
			 Animal.addDeadAnimals(temp);
			animals.remove(opponent);
		 }
		  else if(sim[nx][ny]=='u')
			 {
				 int chance=rand.nextInt(5);
				 if(chance==0)
				 {
					 System.out.println("Turtle at ("+nx+", "+ny+") and wins");
					 System.out.println("The Loser dies at ("+nx+", "+ny+") ");
					 sim[x][y]='.';
					 sim[nx][ny]=Character.toLowerCase((q.getClass().getName().charAt(0)));
					 String temp="Turtle died at location ("+nx+", "+ny+") ";
					 System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
						System.out.println("("+nx+", "+ny+") ");
					 Animal.addDeadAnimals(temp);
					 animals.remove(opponent);
					 q.setlocation(nx, ny);
				 }
				 else
				 {
					 System.out.println("Turtle at ("+nx+", "+ny+") and loses");
						System.out.println("The Loser dies at ("+x+", "+y+") ");
						sim[x][y]='.';
						String temp=q.getClass().getName()+" died at location ("+x+", "+y+")";
						Animal.addDeadAnimals(temp);
						animals.remove(q);
				 }
			 }
		  else if(sim[nx][ny]==Character.toLowerCase((q.getClass().getName().charAt(0))) || sim[nx][ny]=='c' || sim[nx][ny]=='t'|| sim[nx][ny]=='l')
			 {
				int chance= rand.nextInt(2);
				if(chance==0)
				{
					System.out.println(opponent.getClass().getName()+" at ("+nx+", "+ny+") and wins");
					System.out.println("The Loser dies at ("+nx+", "+ny+") ");
					sim[x][y]='.';
					sim[nx][ny]=Character.toLowerCase((q.getClass().getName().charAt(0)));
					String temp=opponent.getClass().getName()+" died at location ("+nx+", "+ny+")";
					System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
					System.out.println("("+nx+", "+ny+") ");
					Animal.addDeadAnimals(temp);
					animals.remove(opponent);
					q.setlocation(nx, ny);
				}
				else
				{
					System.out.println(opponent.getClass().getName()+" at ("+nx+", "+ny+") and loses");
					System.out.println("The Loser dies at ("+x+", "+y+") ");
					sim[x][y]='.';
					String temp=q.getClass().getName()+" died at location ("+x+", "+y+")";
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
