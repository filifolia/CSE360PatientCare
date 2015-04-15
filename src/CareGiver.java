public class CareGiver extends User 
{
	private String training;
	private int numOfPatients;
	private String degree;
	//private Reference[] patientList;
	
	public CareGiver()
	{
		training = null;
		numOfPatients = 0;
		degree = null;
		//patientList = new Reference[] patientList
	}
	
	//ALL setters and junk
	public void setTraining(String words)
	{
		training = words;
	}
	public void setNumOfPatients(int num)
	{
		numOfPatients = num;
	}
	public void setDegree(String words)
	{
		degree = words;
	}
	
	//ALL getters
	public String getTraining()
	{
		return training;
	}
	public int getNumOfPatients()
	{
		return numOfPatients;
	}
	public String getDegree()
	{
		return degree;
	}
}
