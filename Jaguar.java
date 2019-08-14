
public class Jaguar extends Feline{

	private int x,y;
	@Override
	int getlocationx() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	int getlocationy() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	void setlocation(int a, int b) {
		x=a;
		y=b;

		
	}
	
	void attack(Animal q,int nx,int ny)
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
		if(sim[nx][ny]=='u')
		{
			System.out.print(q.getClass().getName()+" from ("+x+", "+y+") attacks Turtle at ("+nx+", "+ny+") and wins");
			System.out.println("The Loser dies at ("+nx+", "+ny+") ");
			sim[x][y]='.';
			sim[nx][ny]='j';
			String temp=opponent.getClass().getName()+" died at location ("+nx+", "+ny+")";
			System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
			System.out.println("("+nx+", "+ny+") ");
			Animal.addDeadAnimals(temp);
			animals.remove(opponent);
			q.setlocation(nx, ny);
			
		}
		else
		{
			super.attack(q, nx, ny);
		}
	}

}
