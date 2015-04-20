
public class ReportList {
	private Report thisReport;
	private Report nextReport;
	
	public ReportList(){
		
	}
	
	public void setThisReport(Report x){
		thisReport = x;
	}
	
	public void setNextReport(Report x){
		nextReport = x;
	}
	
	public Report getThisReport(){
		return thisReport;
	}
	
	public Report getNextReport(){
		return nextReport;
	}
	
}
