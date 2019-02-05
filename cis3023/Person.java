import java.io.*;
import java.util.Scanner;


public class Person 
{
	/* State values */
	
	private String name, gender, birth, death, marriage, parent, grandparent, spouse;
	private int generation;

	
	/* Constructor */
	
	public Person()
	{
		// All values will start blank
		name = ""; gender = ""; birth = ""; death = ""; marriage = ""; parent = ""; grandparent = ""; spouse = ""; generation = 0;
	}
	
	
	/* Getters & Setters */
	
	// Accessors
	public String getName()
	{
		return name;
	}
	
	// The following two accessors return only the first or last name out of the name state.
	public String getFirstName()
	{
		return name.split("\\s")[0];
	}
	public String getLastName()
	{
		return name.split("\\s")[1];
	}
		
	public String getGender()
	{
		return gender;
	}
	public String getBirth()
	{
		return birth;
	}
	public String getDeath()
	{
		return death;
	}
	public String getMarriage()
	{
		return marriage;
	}
	public String getParent()
	{
		return parent;
	}
	public String getGrandparent()
	{
		return grandparent;
	}
	public String getSpouse()
	{
		return spouse;
	}
	public int getGeneration()
	{
		return generation;
	}
	
	// The following 3 accessors convert part of the birth string to an int and return it.
	public int getBirthYear()
	{
		return Integer.parseInt(birth.substring(4, 8));
	}
	public int getBirthMonth()
	{
		return Integer.parseInt(birth.substring(2, 4));
	}
	public int getBirthDay()
	{
		return Integer.parseInt(birth.substring(0, 2));
	}

	
	// Mutators
	public void setName(String n)
	{
		name = n;
	}
	public void setGender(String n)
	{
		gender = n;
	}
	public void setBirth(String n)
	{
		birth = n;
	}
	public void setDeath(String n)
	{
		death = n;
	}
	public void setMarriage(String n)
	{
		marriage = n;
	}
	public void setParent(String n)
	{
		parent = n;
	}
	public void setGrandparent(String n)
	{
		grandparent = n;
	}
	public void setSpouse(String n)
	{
		spouse = n;
	}
	public void setGeneration(int n)
	{
		generation = n;
	}

	
	/* Reads a text file of family tree data & store data in array of person objects */
	
	// Creates a new Person array based on the file specified by the user.
	public static Person[] readTreeFile()
	{
		Person[] dudes = new Person[0];
		String line, file = "";
		String[] tokens;
		int count = 0, search = 0, numberOfBirths = 0;
		
		try
		{
			//scan file name
			Scanner inFileName = new Scanner(System.in);
			//request file input from user
			System.out.print("Input the file to read from: ");
			file = inFileName.nextLine();
			inFileName.close();			
			
			BufferedReader inFile = new BufferedReader(new FileReader(file));
		
			while (inFile.ready())
			{//read each line
				line = inFile.readLine();
				
				//Error checking: make sure this line is a valid form of input
				if (line.length() > 5)
				{
					//determine how many records of people total
					if (line.substring(0 , 5).toLowerCase().equals("birth"))
					{
						numberOfBirths++;
					}
				}
			}
			//close file
			inFile.close();
			
			//initialize instance of Person as an array
			dudes = new Person[numberOfBirths];
			
			BufferedReader inLine = new BufferedReader(new FileReader(file));
			
			//while lines are input
			while (inLine.ready())
			{				
				//read each line
				line = inLine.readLine();
				
				// Make sure this is a valid line before proceeding
				if (line.length() > 5) 
				{
					// Break the line into tokens; spaces indicate where tokens are separated
					tokens = line.split("\\s+");
					
					//find all births
					if (tokens[0].toLowerCase().equals("birth"))
					{//set name, gender, birth date, parent, grandparent for each person with birth
						dudes[count] = new Person();
						dudes[count].setName(tokens[1] + " " + tokens[2]);
						dudes[count].setGender(tokens[3]);
						dudes[count].setBirth(tokens[4]);
						if (tokens.length > 6) dudes[count].setParent(tokens[5] + " " + tokens[6]);
						if (tokens.length > 8) dudes[count].setGrandparent(tokens[7] + " " + tokens[8]);
					}
					count++;
					
					//find all deaths
					if (tokens[0].toLowerCase().equals("death"))
					{
						search = 0;
						while (search < dudes.length)
						{//set the death date to the corresponding people
							if ((tokens[1] + " " + tokens[2]).equals(dudes[search].getName()))
							{
								dudes[search].setDeath(tokens[3]);
								search = dudes.length;
							}
							search++;
						}
					}
					
					//find all marriages
					if (tokens[0].toLowerCase().equals("marriage"))
					{
						search = 0;
						while (search < dudes.length)
						{//set the marriage date and spouse name to the corresponding people
							if ((tokens[1] + " " + tokens[2]).equals(dudes[search].getName()))
							{
								dudes[search].setSpouse(tokens[3]+ " " + tokens[4]);
								dudes[search].setMarriage(tokens[5]);
								search = dudes.length;
							}
						search++;
						}
					}
				}
				
			} // End while (inLine.ready())
			inLine.close();
		}// End try	
		
		//catch any exceptions
		catch(FileNotFoundException filenotfound)
		{
			System.out.println("No file named " + file + " found.");
		} 
		catch (IOException ioexception) 
		{
			System.out.println("Could not read from file.");
		}
		
		return dudes;
	}
	
	
	/* Display family tree data in different formats: sorted list and family tree */
	
	public static void everyDude(Person[] dudes)
	{
		// first and last name alphabetical sort
		sortByFirst(dudes);
		sortByLast(dudes);
		//set first and second generations
		firstSecondGen(dudes);
		//set all other generations
		otherGen(dudes);		
		//print out all the people in order of generation
		printGen(dudes);
	}
	
	//set the first and second generations
	private static void firstSecondGen(Person[] dudes)
	{
		for (int i = 0; i < dudes.length; i++)
		{
			if (dudes[i].getGrandparent().equals(""))
			{
				if (dudes[i].getParent().equals(""))
				{
					dudes[i].setGeneration(1);
				}
				else
				{
					dudes[i].setGeneration(2);
				}
			}
		}
	}
	//set all other generations
	private static void otherGen(Person[] dudes)
	{
		int gen = 2, exitCase = 0;
		while (exitCase == 0)
		{
			exitCase = 1;
			for (int i = 0; i < dudes.length; i++)
			{
				if (dudes[i].getGeneration() == gen)
				{
					for (int j = 0; j < dudes.length; j++)
					{
						if (dudes[j].getParent().equals(dudes[i].getName()))
						{
							dudes[j].setGeneration(gen + 1);
							exitCase = 0;
						}
					}
				}
			}
			gen++;
		}
	}
	
	//print out all the people in order of generation
	private static void printGen(Person[] dudes)
	{
		System.out.println("\nTHE FAMILY TREE:\n");
		dudes = familyBubble(dudes, dudes.length);
	
		// Creates a sorted list by generation.		
		Person[] generationDudes = sortGeneration(dudes);

		for (int i = 0; i < dudes.length; i++)
		{
			//indentations
			for (int j = generationDudes[i].getGeneration(); j > 1; j--)
			{
				System.out.print("   ");
			}
	
			//print name and sex
			System.out.print(generationDudes[i].getName()+"  Sex: "+generationDudes[i].getGender());
			//print spouses
			if (generationDudes[i].getSpouse().equals("") == false)
			{
				System.out.print("  Spouse: "+generationDudes[i].getSpouse()+"  ");
			}

			System.out.println();

			for (int j = generationDudes[i].getGeneration(); j > 1; j--)
			{
				System.out.print("   ");
			}
	
			//print birth date
			System.out.print("Birth: "+generationDudes[i].getBirth().substring(0, 2)+"-"+generationDudes[i].getBirth().substring(2, 4)+"-"+generationDudes[i].getBirth().substring(4, 8));
	
			//print death date
			if (generationDudes[i].getDeath().equals("") == false)
			{
				System.out.print("  Death: "+generationDudes[i].getDeath().substring(0, 2)+"-"+generationDudes[i].getDeath().substring(2, 4)+"-"+generationDudes[i].getDeath().substring(4, 8));
			}

			//print marriage date
			if (generationDudes[i].getMarriage().equals("") == false)
			{
				System.out.print("  Marriage date: "+generationDudes[i].getMarriage().substring(0, 2)+"-"+generationDudes[i].getMarriage().substring(2, 4)+"-"+generationDudes[i].getMarriage().substring(4, 8));
			}

			System.out.print("\n\n");		
		}
	}
	
	// Sorting method to sort the Person array for family tree display
	private static Person[] sortGeneration( Person[] list )
	{
		int numberOfKids = 0;
		
		// These two loops check each person in the list against each person after them in the list to see if they have kids.
		for (int location = 0; location < (list.length - 1); location++)
		{
			numberOfKids = 0;	// numberOfKids keeps track of how many kids have already been assigned to this parent. 
			    // This causes each additional kid to be put into the next spot after the previous kid, maintaining the integrity of the birthday sort.
			
			for (int i = (location + 1); i < list.length; i++)
			{
				// If kids are found, insert the kid right after the parent.
				if (list[location].getName().equals(list[i].getParent()))
				{
					insertPeople(list, location + 1 + numberOfKids, i);
					numberOfKids++;
				}
			}// End for loop
		}
		return list;
	}// End sortGeneration

	// This method inserts a person into the given position in the Person array
	private static Person[] insertPeople( Person[] list, int position1, int position2 )
	{
		// temp and temp2 are used for swapping. temp starts out as the person who is being moved.
		Person temp2 = new Person();
		Person temp = list[position2];
		
		for (int i = position1; i <= position2; i++)	// Loop until we overwrite the person who was copied, then stop.
		{
			temp2 = list[i];	// Store the person who is about to be bumped in temp2
			list[i] = temp;		// Put the person who is being moved into the right spot
			temp = temp2; 		// Store the bumped person in temp and repeat the loop, so they will be put in the next spot
		}
		return list;
	}// End insertPeople
	
	// Sort people by birthday
	private static Person[] familyBubble(Person[] dudes, int numberOfBirths)
	{
		boolean noExchanges;
		int pass = 1;
		//Person temp = new Person();
		
		// This will be performed at least once
		do
		{
			// noExchanges is a flag that stays true if no swaps are made. This will end the loop
			noExchanges = true;
			
			// Loop until the end of the array being searched is reached. Each pass reduces the size of the array being searched by 1.
			for (int i = 0; i < (numberOfBirths - pass); i++)
			{
				// First, check the birth years
				if (dudes[i].getBirthYear() > dudes[i + 1].getBirthYear())
				{
					swap( dudes, i, i+1 );
					noExchanges = false;	// Ensure that another pass will be done
				}
				// If the birth years are the same, check months
				else if (dudes[i].getBirthYear() == dudes[i + 1].getBirthYear())
				{
					if (dudes[i].getBirthMonth() > dudes[i + 1].getBirthMonth())
					{
						swap( dudes, i, i+1 );
						noExchanges = false;
					}
					// If months are the same also, check days
					else if (dudes[i].getBirthMonth() == dudes[i + 1].getBirthMonth())
					{
						if (dudes[i].getBirthDay() > dudes[i + 1].getBirthDay())
						{
							swap( dudes, i, i+1 );
							noExchanges = false;
						}
					}
				}
			}
			pass++;
		} while(!noExchanges);
		return dudes;
	}
	// swaps the location of two elements in a Person array
	private static void swap( Person[] dude, int index1, int index2 )
	{
		Person temp = dude[index1];
		dude[index1] = dude[index2];
		dude[index2] = temp;
	}
	
	
	/* Name Sorting Methods */
	
	public static void sortByLast(Person[] dudes)
	{
		String[] dudesList = new String[dudes.length]; // String array of names of persons still alive
		int j = 0;
		
		for(int i=0; i<dudes.length; i++) // Puts only the names of living persons in the array
		{
			if( dudes[i].getDeath() == "")
			{
				dudesList[j] = dudes[i].getLastName() + ", " + dudes[i].getFirstName();
				j++;
			}
		}
		quickSort( dudesList, 0, j-1 ); // Sorts the array
		
		System.out.println("\nLiving family members sorted by last name:\n");
		
		for( int i=0; i<j; i++ ) // Prints each element of the sorted array
		{
			System.out.println( dudesList[i] );
		}	
	}
	
	public static void sortByFirst(Person[] dudes) // Same as sortByLast but names are stored firstname first
	{
		int j = 0;
		String[] dudesList = new String[dudes.length];
		
		for(int i=0; i<dudes.length; i++)
		{
			if( dudes[i].getDeath() == "")
			{
				dudesList[j] = dudes[i].getFirstName() + " " + dudes[i].getLastName();
				j++;
			}
		}
		quickSort( dudesList, 0, j-1 );
		
		System.out.println("Living family members sorted by first name:\n");
			
		for( int i=0; i<j; i++ )
		{
			System.out.println( dudesList[i] );
		}	
	}
		
	private static void quickSort( String[] a, int first, int last ) // Quick Sort
	{
		int pivIndex; // location of pivot element
		
		if ( first < last )
		{
			// partition array into smaller and larger elements relative to pivot
			pivIndex = partition( a, first, last ); 
	
			quickSort( a, first, pivIndex-1 ); //sort first half
			
			quickSort( a, pivIndex+1, last ); // sort second half
		}
	}	

	// partition array to place elements smaller than pivot on one side, and those larger on the other side
	public static int partition( String[] a, int first, int last ) 
	{
		int pivIndex = first;
		
		int up = first, down = last;
		
		while( up < down )
		{
			while( a[pivIndex].compareTo(a[up]) > 0 ) // if a[up] is alphabetically before a[pivIndex] then move on;
			{
				up++; //move to next element
			}
			while( a[pivIndex].compareTo(a[down]) < 0 ) // a[down] is alphabetically after a[pivIndex];
			{
				down--; //move to next element
			}
			if( up < down )
			{
				swap( a, up, down); //swap a[up] and a[down] into the correct side of pivot;
			}
		}
		swap( a, pivIndex, down );
		
		return down;
	}
		
	// swaps the location of two elements in a String array
	private static void swap( String[] a, int index1, int index2 )
	{
		String temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}
}// End Class
