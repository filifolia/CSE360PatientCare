public class Report {
	private float pain;
	private float sleepy;
	private float nausea;
	private float anxiety;
	private float depression;
	private float average;
	
	//private Reference doctor;
	//private Reference patient;
	//private Date date;
	
	private int reportNumber;
	/*
	public Report(int a, int b, int c, int d, int e){
		pain = a;
		sleepy = b;
		nausea = c;
		anxiety = d;
		depression = e;
	}
	*/
	public Report(){
		
	}
	
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
	
	/*
	public Reference getPatient(){
		return patient;
	}
	*/
	/*
	public Reference getDoctor(){
		return doctor;
	}
	*/
	public int getReportNumber(){
		return reportNumber;
	}
	/*
	public Date getDate(){
		return date;
	}
	*/
	public void calcAve(){
		
	}
	
	public float getAverage(){
		return average;
	}
	
	
	
}
