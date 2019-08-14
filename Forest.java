import java.util.Scanner;

/**
 * @author keshavgaddhyan
 *main method which controls user interaction
 */
public class Forest {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
			Animal.initilizeforest();
			Animal.showforest();
			int x=10;
			while(x!=0)
			{
			System.out.println("1. Dog (d)");
			System.out.println("2. Fox (f)");
			System.out.println("3. Wolf (w)");
			System.out.println("4. Cat (c)");
			System.out.println("5. Lion (l)");
			System.out.println("6. Tiger (t)");
			System.out.println("7. Hippo (h)");
			System.out.println("8. Turtle (u)");
			System.out.println("What would you like to add to the Forest?");
			System.out.print("Please enter your choice (1-8, or 0 to finish the animal input): ");
			x=reader.nextInt();
			switch(x)
			{
			case 1:
				Animal.addAnimal(new Dog(),'d');
				System.out.println(" Dog is Canine, Canine moves in four directions, one or two steps a time.");
				Animal.showforest();
				break;
				
			case 2:
				Animal.addAnimal(new Fox(), 'f');
				System.out.println(" Fox is Canine, Canine moves in four directions, one or two steps a time.");
				Animal.showforest();
				break;
			
			case 3:
				Animal.addAnimal(new Wolf(), 'w');
				System.out.println(" Wolf is Canine, Canine moves in four directions, one or two steps a time.");
				Animal.showforest();
				break;
				
			case 4:
				Animal.addAnimal(new Cat(), 'c');
				System.out.println(" Cat is Feline, Feline moves in all eight directions, one step a time.");
				Animal.showforest();
				break;
				
			case 5:
				Animal.addAnimal(new Lion(), 'l');
				System.out.println(" Lion is Feline, Feline moves in all eight directions, one step a time.");
				Animal.showforest();
				break;
				
			case 6:
				Animal.addAnimal(new Tiger(), 't');
				System.out.println(" Tiger is Feline, Feline moves in all eight directions, one step a time.");
				Animal.showforest();
				break;
				
			case 7:
				Animal.addAnimal(new Hippo(), 'h');
				System.out.println(" Hippo moves in four direction, one step time.");
				Animal.showforest();
				break;
				
			case 8:
				Animal.addAnimal(new Turtle(), 'u');
				System.out.println(" Turtle has 50% chance stay in the same position, and 50% chance move in four directions, one step at a time.");
				Animal.showforest();
				break;
					
			case 0:
				Animal.showforest();
				
			}
			
			
			}
			Animal.sortforest();
			Scanner in=new Scanner(System.in);
			String line="";
			System.out.print("Press enter to iterate, type 'print' to print the Forest or 'exit' to quit: ");
			line=in.nextLine();
			
			while(!line.equals("exit"))
			{
				Animal.sortforest();
				
				if(line.equals("print"))
				{
					Animal.showforest();
					Animal.showDeadAnimals();
				}
				else
				{
					Animal.startsim();
				}
				System.out.print("Press enter to iterate, type 'print' to print the Forest or 'exit' to quit: ");
				line=in.nextLine();
				
			}
			if(line.equals("exit"))
			{
				Animal.showforest();
				Animal.showDeadAnimals();
			}
			
		}
}		
