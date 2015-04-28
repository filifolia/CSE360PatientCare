//This class represents the container class for the two User types
//This data structure is a hash table container. It uses open addressing
//to store users, since this program is meant to cover long term and chronic
//illnesses. 

import java.io.*;

public class UserList implements Serializable
{
	private static final long serialVersionUID = 1L;
	private User[] List;
	final private int size = 100;
	
	public UserList()
	{
		List = new User[size];
		for(int i=0; i!=size; i++)
		{
			List[i] = null;
		}
	}
	
	
	//This is the hashing method for the hash table. It uses the built in hashCode() method
	//to create ints from the two inputs. From there it creates two unique integers and then adds them together.
	//It then divides by size and returns the remainder
	public int hashing(String name, String code)
	{
		int hash1;
		int hash2;
		int hash = 0;
		for(int i=0; i<=9; i++)
		{
			hash1 = hash + name.hashCode() + code.hashCode();
			hash2 = hash + name.hashCode() % code.hashCode();
			hash = hash1 + hash2;
		}
		hash = hash % size;
		hash = Math.abs(hash);
		return hash;
	}
	
	//Adds a new user object to the list by hashing
	public boolean addElement(User person)
	{
		boolean flag = false;
		int hash = hashing(person.getUsername(), person.getPassword());		//Gets the hash code
		int count = 0; 														//Checks to make sure all spots have been checked. 
		while(count!=100)
		{
			if(List[hash]!=null)											//If that spot is not empty
			{
				count++;
				if(hash==99)												//If we are currently in the last position
				{
					hash = 0;												//reset hash to 0
				}
				else
				{
					hash++;													//increments the hash;
				}
			}
			else															//The position is null
			{
				List[hash] = person ;										//Add the already creates user
				count = 100;												//Break the loop
				flag = true;												//Insertion complete
			}
		}
		return flag;														//True if successful
	}
	
	//Takes in the username and returns its position
	//returns -1 if not found
	public int searchByUsername(String username)
	{
		int position = -1;
		for(int i=0; i<100; i++)
		{
			if(List[i] != null){												//The array isn't null		
				if(List[i].getUsername().equals(username))						//If found
				{
					position = i;
					i = 100;													//breaks loop
				}
			}
		}
		return position;
	}
	
	//Takes in the full name and returns its position
	//returns -1 if not found
	public int searchByName(String first, String last)
	{
		int position = -1;
		for(int i=0; i<100; i++)
		{
			if(List[i] != null){
				if(List[i].getFirstName().equals(first)&&List[i].getLastName().equals(last))	//If found
				{
					position = i;
					i = 100;																	//breaks loop
				}
			}
		}
		return position;		
	}
	
	//Getter method that access an element in the table according to the index parameter
	public User getUser(int index)
	{
		return List[index];
	}
	
	//Setter Method that sets the element in specified index.
	public void setUser(int index, User user)
	{
		List[index] = user;
	}
}
	
	