import java.util.Random;

public class Kitten extends Cat {

	Random rand=new Random();
	private int x,y;
	@Override
	int getlocationx() {
		return x;
	
	}

	@Override
	int getlocationy() {
		
		return y;
	}

	@Override
	void setlocation(int a, int b) {
		x=a;
		y=b;
		
	}
	
	
	
	void move(Animal q)
	{
		int probability=rand.nextInt(100);
		if(probability>=30)
		{
			super.move(q);
		}
		else
		{
			System.out.println("Kitten stayed in ("+x+", "+y+")");
		}
			
		
	}
	
	void attack(Animal q, int nx, int ny)
	{
		 Animal opponent = null;
			for(Animal temp:animals)
			{
				if(temp.getlocationx()==nx && temp.getlocationy()==ny)
				{
					 opponent=temp;
					 break;
				}
			}
			if(sim[nx][ny] != 'c' || sim[nx][ny]!='k')
			{
				System.out.print(q.getClass().getName()+" from ("+x+", "+y+") attacks ");
				System.out.println(opponent.getClass().getName()+" at ("+nx+", "+ny+") and loses");
				System.out.println("The Loser dies at ("+x+", "+y+") ");
				sim[x][y]='.';
				String temp=q.getClass().getName()+" died at location ("+x+", "+y+")";
				Animal.addDeadAnimals(temp);
				animals.remove(q);
			}
			else if(sim[nx][ny]=='c')
			{
				int chance=rand.nextInt(10);
				if(chance<3)
				{
					System.out.print(q.getClass().getName()+" from ("+x+", "+y+") attacks Cat at ("+nx+", "+ny+") and wins");
					System.out.println("The Loser dies at ("+nx+", "+ny+") ");
					sim[x][y]='.';
					sim[nx][ny]='k';
					String temp=opponent.getClass().getName()+" died at location ("+nx+", "+ny+")";
					System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
					System.out.println("("+nx+", "+ny+") ");
					Animal.addDeadAnimals(temp);
					animals.remove(opponent);
					q.setlocation(nx, ny);
				}
				else
				{
					System.out.print(q.getClass().getName()+" from ("+x+", "+y+") attacks ");
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
				System.out.print(q.getClass().getName()+" from ("+x+", "+y+") attacks ");
				int chance= rand.nextInt(2);
				if(chance==0)
				{
					System.out.println(opponent.getClass().getName()+" at ("+nx+", "+ny+") and wins");
					System.out.println("The Loser dies at ("+nx+", "+ny+") ");
					sim[x][y]='.';
					String temp=opponent.getClass().getName()+" died at location ("+nx+", "+ny+")";
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
	}

}
