public class CareGiver extends User 
{
	private int numOfPatients;
	private String degree;
	//private Reference[] patientList;
	
	public CareGiver()
	{
		numOfPatients = 0;
		degree = null;
		//patientList = new Reference[] patientList
	}
	
	//ALL setters and junk
	public void setNumOfPatients(int num)
	{
		numOfPatients = num;
	}
	public void setDegree(String words)
	{
		degree = words;
	}
	
	//ALL getters
	public int getNumOfPatients()
	{
		return numOfPatients;
	}
	public String getDegree()
	{
		return degree;
	}
}
