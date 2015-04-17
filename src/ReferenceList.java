
//This class acts as a storage container for References.
//It is used for doctors to store references to all their patients, 
//without having to store the entire object in two places.

public class ReferenceList 
{
	private Reference head;
	private int size;
	
	//Default constructor
	public ReferenceList()
	{
		head = null;
		size = 0;
	}
	
	//ADD methods
	
	//This method takes in an already created reference and adds it
	//to the beginning of this list.
	public void addReference(Reference element)
	{
		element.setNext(head);
		head = element;
		size++;
	}
	
	//This method creates a new reference and adds it to the beginning
	//of this list
	public void addReference(String name, int key, boolean type)
	{
		Reference temp = new Reference(key, name, type);
		temp.setNext(head);
		head = temp;
		size++;
	}
	
	//SEARCH methods
	
	//This search method only searches by name
	//Returns position in list (0 - size-1)
	//Returns -1 if not found
	public int search(String name)
	{
		Reference temp = head;
		for(int i = 0; i < size; i++)
		{
			if(temp.getUsername().equals(name))
			{
				return i;
			}
			temp = temp.getNext();
		}
		return -1;
	}
	
	//This search method searches by name and key
	//Returns position in list (0 - size-1)
	//Returns -1 if not found
	public int search(Reference object)
	{
		Reference temp = head;
		for(int i=0; i<size; i++)
		{
			if(object.getKey()==temp.getKey()&&object.getUsername().equals(temp.getUsername()))
			{
				return i;
			}
			temp = temp.getNext();
		}
		return -1;
	}
	
}
