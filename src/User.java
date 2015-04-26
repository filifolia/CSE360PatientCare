import java.io.*;

public class User implements Serializable
{
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String phoneNumber;
	private int age;
	private float weight;
	private float height;
	
	public User()
	{
		username = null;
		firstName = null;
		lastName = null;
		password = null;
		phoneNumber = null;
		age = 0;
		weight = 0;
		height = 0;
	}
	
	//ALL setter methods
	public void setUsername(String name)
	{
		username = name;
	}
	public void setFirstName(String name)
	{
		firstName = name;
	}
	public void setLastName(String name)
	{
		lastName = name;
	}
	public void setPassword(String code)
	{
		password = code;
	}
	public void setPhone(String number)
	{
		phoneNumber = number;
	}
	public void setAge(int num)
	{
		age = num;
	}
	public void setweight(float num)
	{
		weight = num;
	}
	public void setHeight(float num)
	{
		height = num;
	}
	
	//Getter methods
	public String getUsername()
	{
		return username;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String getPassword()
	{
		return password;
	}
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public int getAge()
	{
		return age;
	}
	public float getWeight()
	{
		return weight;
	}
	public float getHeight()
	{
		return height;
	}
}

