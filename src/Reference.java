import java.io.Serializable;


public class Reference implements Serializable
{
	private int key;
	private String username;
	private boolean list;
	public Reference next;
	//False of Patient, true if CareGiver
	
	public Reference()
	{
		key = 0;
		username = null;
		list = false;
		next = null;
	}
	
	public Reference(int code, String name, boolean type)
	{
		key = code;
		username = name;
		list = type;
		next = null;
	}
	
	//ALL setters
	public void setKey(int code)
	{
		key = code;
	}
	
	public void setUsername(String name)
	{
		username = name;
	}
	
	public void setList(boolean type)
	{
		list = type;
	}
	
	public void setNext(Reference next)
	{
		this.next = next;
	}
	
	//ALL getters
	public int getKey()
	{
		return key;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public boolean checkList()
	{
		return list;
	}
	
	public Reference getNext()
	{
		return next;
	}
}
