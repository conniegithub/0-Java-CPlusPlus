
public class FamilyTree 
{


	public static void main(String[] args) 
	{
		// Get input file from the user, read family tree info and store it in an array of Persons
		Person[] dudes = Person.readTreeFile();
		
		// If family tree data was found, sort and print the data
		if (dudes.length > 0) Person.everyDude(dudes);
		
	}// End main()	
}// End Class
