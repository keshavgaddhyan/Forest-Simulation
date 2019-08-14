import java.util.Random;
/**
 * @author keshavgaddhyan
 *sub class of animals
 *Contains overridden functions for move and attack of felines
 */
public abstract class Feline extends Animal
{
	
	Random rand=new Random();
	 /* (non-Javadoc)
	 * @see Animal#move(Animal)
	 * controls movement of felines
	 */
	
	void move(Animal q)
	{
		int x=q.getlocationx();
		int y=q.getlocationy();
		/**
		 * x and y store original location of animal q
		 * nx and ny stores the location to which the animal would move
		 * probability is used to calculate the chances of movement
		 */
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
			nx=x+1;
			ny=y+1;
			
		}
		if(probability>=50 && probability<60)
		{
			nx=x+1;
			ny=y-1;
		}
		if(probability>=60 && probability<70)
		{
			nx=x-1;
			ny=y-1;
		}
		if(probability>=70 && probability<80)
		{
			nx=x-1;
			ny=y+1;
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
			nx=x+1;
			ny=y+1;
			
		}
		if(probability>=50 && probability<60)
		{
			nx=x+1;
			ny=y-1;
		}
		if(probability>=60 && probability<70)
		{
			nx=x-1;
			ny=y-1;
		}
		if(probability>=70 && probability<80)
		{
			nx=x-1;
			ny=y+1;
		}
		}
		if(sim[nx][ny]!='.')
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
	 * overidden function executed when attacker is feline
	 */
	void attack(Animal q, int nx, int ny)
			{
		
		 Animal opponent = null;
		 /**
		  * opponent stores the animal object which Animal q would attack
		  * x and y store the location of attacker q
		  * 
		  */
		int x=q.getlocationx();
		int y=q.getlocationy();
		for(Animal temp:animals)
		{
			if(temp.getlocationx()==nx && temp.getlocationy()==ny)
			{
				 opponent=temp;
				 break;
			}
		}
		 System.out.print(q.getClass().getName()+" from ("+x+", "+y+") attacks ");
		 if(sim[nx][ny]==Character.toLowerCase((q.getClass().getName().charAt(0))))
		 {
			int chance= rand.nextInt(2);
			if(chance==0)
			{
				System.out.println(opponent.getClass().getName()+" at ("+nx+", "+ny+") and wins");
				System.out.println("The Loser dies at ("+nx+", "+ny+") ");
				sim[x][y]='.';
				
				String temp=q.getClass().getName()+" died at location ("+nx+", "+ny+")";
				System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
				System.out.println("("+nx+", "+ny+") ");
				Animal.addDeadAnimals(temp);
				animals.remove(opponent);
				q.setlocation(nx, ny);
			}
			else
			{
				System.out.println(q.getClass().getName()+" at ("+nx+", "+ny+") and loses");
				System.out.println("The Loser dies at ("+x+", "+y+") ");
				sim[x][y]='.';
				String temp=q.getClass().getName()+" died at location ("+x+", "+y+")";
				Animal.addDeadAnimals(temp);
				animals.remove(q);
				
			}
			 
		 }
		 
		 
		 else if(Character.toLowerCase((q.getClass().getName().charAt(0)))=='l' && sim[nx][ny]=='h')
		 {
			 System.out.println("Hippo at ("+nx+", "+ny+") and wins");
			 System.out.println("The Loser dies at ("+nx+", "+ny+") ");
			 sim[x][y]='.';
			 sim[nx][ny]='l';
			 String temp="Hippo died at location ("+nx+", "+ny+") ";
			 System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
			 System.out.println("("+nx+", "+ny+") ");
			 Animal.addDeadAnimals(temp);
			 animals.remove(opponent);
			 q.setlocation(nx, ny);
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
		 else if(sim[nx][ny]=='d' || sim[nx][ny]=='w' || sim[nx][ny]=='f')
		 {
			 if(sim[nx][ny]=='d')
			 {
				 System.out.println("Dog at ("+nx+", "+ny+") and wins");
				 System.out.println("The Loser dies at ("+nx+", "+ny+") ");
				 sim[x][y]='.';
				 sim[nx][ny]=Character.toLowerCase((q.getClass().getName().charAt(0)));
				 String temp="Dog died at location ("+nx+", "+ny+") ";
				 System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
				 System.out.println("("+nx+", "+ny+") ");
				 Animal.addDeadAnimals(temp);
				 animals.remove(opponent);
				 q.setlocation(nx, ny);
			 }
			 if(sim[nx][ny]=='w')
			 { 
				 System.out.println("Wolf at ("+nx+", "+ny+") and wins");
				 System.out.println("The Loser dies at ("+nx+", "+ny+") ");
				 sim[x][y]='.';
				 sim[nx][ny]=Character.toLowerCase((q.getClass().getName().charAt(0)));
				 String temp="Wolf died at location ("+nx+", "+ny+") ";
				 System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
					System.out.println("("+nx+", "+ny+") ");
				 Animal.addDeadAnimals(temp);
				 animals.remove(opponent);
				 q.setlocation(nx, ny);
			 }
			 if(sim[nx][ny]=='f')
			 {
				 System.out.println("Fox at ("+nx+", "+ny+") and wins");
				 System.out.println("The Loser dies at ("+nx+", "+ny+") ");
				 sim[x][y]='.';
				 sim[nx][ny]=Character.toLowerCase((q.getClass().getName().charAt(0)));
				 String temp="Fox died at location ("+nx+", "+ny+") ";
				 System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
					System.out.println("("+nx+", "+ny+") ");
				 Animal.addDeadAnimals(temp);
				 animals.remove(opponent);
				 q.setlocation(nx, ny);
			 }
			 
		 }
		 else
		 {
			 super.attack(q,nx,ny);
			 
		 }
			}

}
