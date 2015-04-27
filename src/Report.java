// The report class that patients create and caregivers can inspect.
// Saves the integer representation of symptoms, the patient and caregiver who can 
// view it, the date, and the report number.
public class Report {
	private float pain;
	private float sleepy;
	private float nausea;
	private float anxiety;
	private float depression;
	private float average;
	
	private Reference doctor;
	private Reference patient;
	//private Date date;
	
	private int reportNumber;
	
	//constructor that will substantiate the symptoms
	public Report(int a, int b, int c, int d, int e){
		pain = a;
		sleepy = b;
		nausea = c;
		anxiety = d;
		depression = e;
	}
	
	//basic constructor
	public Report(){
		
	}
	//the setter functions
	public void setPain(float x){
		pain = x;
	}
	
	public void setSleepy(float x){
		sleepy = x;
	}
	
	public void setNausea(float x){
		nausea = x;
	}
	
	public void setAnxiety(float x){
		anxiety = x;
	}
	
	public void setDepression(float x){
		depression = x;
	}
	
	public void setPatient(Reference x){
		patient = x;
	}
	
	public void setDoctor(Reference x){
		doctor = x;
	}
	
	public void setReportNumber(int x){
		reportNumber = x;
	}
	
	public void setDate(){
		
	}
	// the getter functions
	public float getPain(){
		return pain;
	}
	
	public float getSleepy(){
		return sleepy;
	}
	
	public float getNausea(){
		return nausea;
	}
	
	public float getAnxiety(){
		return anxiety;
	}
	
	public float getDepression(){
		return depression;
	}
	
	public Reference getPatient(){
		return patient;
	}
	
	public Reference getDoctor(){
		return doctor;
	}
	
	public int getReportNumber(){
		return reportNumber;
	}
	
	/*
	public Date getDate(){
		return date;
	}
	*/
	// how are we calculating the average?
	public void calcAve(){
		
	}
	// returns the average
	public float getAverage(){
		return average;
	}
	
	
	
}
