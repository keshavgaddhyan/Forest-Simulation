import java.util.Random;

public class Dinosaur extends Animal{

	Random rand=new Random();
	private int x,y;
	@Override
	void move(Animal q) {
		
		int nx=x,ny=y;
		int probability=rand.nextInt(100);
		if(probability<25)
		{
			
			nx=x+3;
			int nnx=x+1;
			
			if(nx<15)
			{
			while(animals.contains(q) && nnx<nx)
			{
				if(sim[nnx][ny] !='.')
				{
					q.attack(q, nnx, ny);
					
				}
				nnx++;
			}
			}
		}
		
		if(probability>24 && probability<50)
		{
			nx=x-3;
            int nnx=x-1;
			
			if(nx>=0)
			{
			while(animals.contains(q) && nnx>nx)
			{
				if(sim[nnx][ny] !='.')
				{
					q.attack(q, nnx, ny);
					
				}
				nnx--;
			}
			}   
		}
		
		if(probability>49 && probability<75)
		{
			ny=y+3;
			int nny=y+1;
			
			if(ny<15)
			{
			while(animals.contains(q) && nny<ny)
			{
				if(sim[nx][nny] !='.')
				{
					q.attack(q, nx, nny);
					
				}
				nny++;
			}
			}
		}
		
		if(probability>74 && probability<100)
		{
			ny=y-3;
			 int nny=y-1;
				
				if(ny>=0)
				{
				while(animals.contains(q) && nny>ny)
				{
					if(sim[nx][nny] !='.')
					{
						q.attack(q, nx, nny);
						
					}
					nny--;
				}
				}   
		}
		while(nx<0 || nx>=15 || ny<0 || ny>=15)
		{
			nx=x;
		  ny=y;
			 probability=rand.nextInt(100);
			if(probability<25)
			{
				
				nx=x+3;
				int nnx=x+1;
				
				if(nx<15)
				{
				while(animals.contains(q) && nnx<nx)
				{
					if(sim[nnx][ny] !='.')
					{
						q.attack(q, nnx, ny);
						
					}
					nnx++;
				}
				}
			}
			
			if(probability>24 && probability<50)
			{
				nx=x-3;
	            int nnx=x-1;
				
				if(nx>=0)
				{
				while(animals.contains(q) && nnx>nx)
				{
					if(sim[nnx][ny] !='.')
					{
						q.attack(q, nnx, ny);
						
					}
					nnx--;
				}
				}   
			}
			
			if(probability>49 && probability<75)
			{
				ny=y+3;
				int nny=y+1;
				
				if(ny<15)
				{
				while(animals.contains(q) && nny<ny)
				{
					if(sim[nx][nny] !='.')
					{
						q.attack(q, nx, nny);
						
					}
					nny++;
				}
				}
			}
			
			if(probability>74 && probability<100)
			{
				ny=y-3;
				 int nny=y-1;
					
					if(ny>=0)
					{
					while(animals.contains(q) && nny>ny)
					{
						if(sim[nx][nny] !='.')
						{
							q.attack(q, nx, nny);
							
						}
						nny--;
					}
					}   
			}
		}
		if(sim[nx][ny]!='.' && animals.contains(q))
		{
			q.attack(q,nx,ny);
			if(animals.contains(q))
			{
				sim[x][y]='.';
				sim[nx][ny]='i';
				System.out.print("Dinosaur moved from ("+x+", "+y+") to ");
				System.out.println("("+nx+", "+ny+") ");
				q.setlocation(nx, ny);
				
			}
			else
			{
				sim[x][y]='.';
			}
		}
		else if(animals.contains(q))
		{
			sim[x][y]='.';
			sim[nx][ny]='i';
			System.out.print("Dinosaur moved from ("+x+", "+y+") to ");
			System.out.println("("+nx+", "+ny+") ");
			q.setlocation(nx, ny);
		}
		
	}
	
	@Override
	void attack(Animal q, int nx, int ny) {
		
		Animal opponent = null;
		for(Animal temp:animals)
		{
			if(temp.getlocationx()==nx && temp.getlocationy()==ny)
			{
				 opponent=temp;
				 break;
			}
		}
		System.out.print(q.getClass().getName()+" from ("+x+", "+y+") attacks ");
		if(sim[nx][ny]!='i')
		{
			System.out.println(opponent.getClass().getName()+" at ("+nx+", "+ny+") and wins");
			System.out.println( opponent.getClass().getName()+" dies at ("+nx+", "+ny+") ");
			//sim[x][y]='.';
			sim[nx][ny]='.';
			String temp=opponent.getClass().getName()+" died at location ("+nx+", "+ny+")";
			//System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
			//System.out.println("("+nx+", "+ny+") ");
			Animal.addDeadAnimals(temp);
			animals.remove(opponent);
			//q.setlocation(nx, ny);
		}
		else
		{
			
			int chance= rand.nextInt(2);
			if(chance==0)
			{
				System.out.println(opponent.getClass().getName()+" at ("+nx+", "+ny+") and wins");
				System.out.println(opponent.getClass().getName()+" dies at ("+nx+", "+ny+") ");
				//sim[x][y]='.';
				sim[nx][ny]='.';
				String temp=opponent.getClass().getName()+" died at location ("+nx+", "+ny+")";
				//System.out.print(q.getClass().getName()+" moved from ("+x+", "+y+") to ");
				//System.out.println("("+nx+", "+ny+") ");
				Animal.addDeadAnimals(temp);
				animals.remove(opponent);
				//q.setlocation(nx, ny);
			}
			else
			{
				System.out.println(q.getClass().getName()+" at ("+nx+", "+ny+") and loses");
				System.out.println("Dinosaur dies at ("+x+", "+y+") ");
				sim[x][y]='.';
				String temp=q.getClass().getName()+" died at location ("+x+", "+y+")";
				Animal.addDeadAnimals(temp);
				animals.remove(q);
				
			}
		}
	}

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

}
