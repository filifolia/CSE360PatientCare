import java.io.Serializable;

public class Patient extends User implements Serializable
{
	private String[] conditions;
	private String[] medications;
	public Report[] reports;
	private int numOfCond;
	private int numOfReports;
	private int numOfMeds;
	private float firstThreshold;
	private float secondThreshold;
	private Reference doctor;
	
	public Patient()
	{
		conditions = new String[5];
		medications = new String[5];
		reports = new Report[100];
		firstThreshold = 5;
		secondThreshold = 7;
		doctor = new Reference();
		numOfCond=0;
		numOfMeds=0;
		numOfReports = 0;
	}
	
	//ALL setters
	public void setFirstThresh(float num)
	{
		firstThreshold = num;
	}
	public void setSecondThreshold(float num)
	{
		secondThreshold = num;
	}
	
	//ALL getters
	public float getFirstThresh()
	{
		return firstThreshold;
	}
	public float getSecondThreshold()
	{
		return secondThreshold;
	}
	
	//Adding into the Reports array
	//Returns the location
	
	public int addReport(Report newReport)
	{
		int location = numOfReports%100;
		reports[location]=newReport;
		numOfReports++;
		return location;
	}
	
	//Search functions for reports
	//Adding methods to string arrays
	//Return true if successful, false otherwise
	public boolean addCondition(String condition)
	{
		if(numOfCond<5)
		{
			conditions[numOfCond] = condition;
			numOfCond++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean addMedication(String medicine)
	{
		if(numOfMeds<5)
		{
			medications[numOfMeds] = medicine;
			numOfMeds++;
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	//Search methods for string arrays
	//return the index of the value, -1 otherwise
	public int searchConditions(String cond)
	{
		int temp = -1;
		for(int i=0; i<5; i++)
		{
			if(conditions[i].equals(cond))
			{
				temp = i;
			}
		}
		return temp;
	}
	
	public int searchMedications(String meds)
	{
		int temp = -1;
		for(int i=0; i<5; i++)
		{
			if(medications[i].equals(meds))
			{
				temp = i;
			}
		}
		return temp;
	}
}

