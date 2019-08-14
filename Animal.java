import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 * @author keshavgaddhyan
 *This is the parent class of all animals 
 *This class also implements comparable to compare objects of type Animal and sort them in array list
 *It is declared as abstract so as to allow easy Polymorphism
 */
/**
 * @author keshavgaddhyan
 *
 */
public abstract class Animal implements Comparable<Animal>{
	
	/**
	 * Array sim is used to simulate the forest. 
	 * It stores all the initial letter of the animals
	 */
	public static char sim[][]=new char[15][15];
	/**
	 * This is an ArrayList of type Animal which stores the different animals added to the forest
	 */
	public static ArrayList<Animal> animals = new ArrayList<Animal>();
	private static ArrayList<String> locationDead= new ArrayList<String>();
	/**
	 * This function is used to set the forest as empty and initialize each element of sim as '.'
	 */
	 static void initilizeforest()
	{
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				sim[i][j]='.';
			}
	    }
	}
	/**
	 * This function prints out the forest to the screen
	 */
	 static void showforest()
	{
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
				System.out.print(sim[i][j]);
			}
			System.out.println();
	    }
		System.out.println();
	}
	 public int compareTo(Animal a) {
			if (getClass().getName().compareTo(a.getClass().getName())!=0)
				return getClass().getName().compareTo(a.getClass().getName());
			else if (getlocationx()-a.getlocationx()!=0)
				return getlocationx()-a.getlocationx();
			else
				return getlocationy()-a.getlocationy();
		}
	 /**
	 * @param x receives the object of the new animal to add in the list of animals
	 * @param shortform is the letter with which we would represent the animal
	 * This function assigns a random location to each animal and adds that animal to the animal list
	 * 
	 */
	public static void addAnimal(Animal x, char shortform)
	{
		
		animals.add(x);
		Random rand=new Random();
		int randomX=rand.nextInt(15);
		int randomY=rand.nextInt(15);
		while(sim[randomX][randomY]!='.')
		{
		 randomX=rand.nextInt(15);
		 randomY=rand.nextInt(15);
		}
		sim[randomX][randomY]=shortform;
		x.setlocation(randomX,randomY);
		System.out.print("Added "+ x.getClass().getName()+ " at (" +randomX+","+randomY+"):");
	}

	  
	/**
	 * Sorts the list of animals in ascending order
	 */
	public static void sortforest()
	 {
		 Collections.sort(animals);
	 }
	 
	 /**
	 * This functions starts the simulation when user inputer enter
	 * it moves the animals in the list in alphabetical order
	 */
	public static void startsim()
	 {
		
		for (int z=0;z<animals.size();z++) 
		{
			int count=animals.size();
			Animal y=animals.get(z);
			animals.get(z).move(animals.get(z));
			if(count!=animals.size())
			{
				if(!animals.contains(y))
				{
					z--;
				}
			}
			else if(animals.indexOf(y)!=z)
			{
				z--;
			}
			
		}
		Animal.showforest();
		 
	 }
	 /**
	 * @param value accepts the string containing dead animal and its location
	 * stores the dead animals in a list of locationDead.
	 */
	public static void addDeadAnimals(String value)
	 {
		 locationDead.add(value);
	 }
	 /**
	 * prints the list of dead animals
	 */
	public static void showDeadAnimals()
	 {
		 for(String p: locationDead)
		 {
			 System.out.println(p);
		 }
		 System.out.println();
	 }

/**
 * @param q is the animal which we have to move
 * This function is overloaded in the sub-classes
 * it moves the animals according to the rules mentioned
 */
abstract void move(Animal q);
  /**
 * @param q is the attacking animal
 * @param nx is the x location of animal being attacked
 * @param ny is the y location of animal being attacked
 * this is the default case in which attacker always loses
 * this function is overloaded in other sub classes
 */
void attack(Animal q, int nx,int ny)
  {
	  int x=q.getlocationx();
		int y=q.getlocationy();
	  Animal opponent=null;
	  for(Animal temp: animals)
	{
		if(temp.getlocationx()==nx && temp.getlocationy()==ny)
		{
			 opponent=temp;
			 break;
		}
	}
	 System.out.println(opponent.getClass().getName()+" at ("+nx+", "+ny+") and loses");     
	System.out.println("The Loser dies at ("+x+", "+y+") ");
	sim[x][y]='.';
	String temp=q.getClass().getName()+" died at location ("+x+", "+y+")";
	Animal.addDeadAnimals(temp);
	 animals.remove(q);
  }
 /**
 * @return x location of animal
 */
abstract int getlocationx();
 /**
 * @return y location of animal
 */
abstract int getlocationy();
  /**
 * @param randomX set x location of an animal 
 * @param randomY set y location of an animal
 */
abstract void setlocation(int randomX, int randomY);
	}
	
	

