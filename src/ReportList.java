// A LinkedList of reports

import java.util.LinkedList;

public class ReportList {
	//a basic linked list structure for report objects
	private LinkedList <Report> list;
	
	//constructor. Creates the list object
	public ReportList(){
		list = new LinkedList<Report>();
	}
	//adds new reports to the front of the linked list
	public void addReport(Report x){
		list.addFirst(x);
		
		return;
	}
	//access reports in the list based on their index
	public Report getReport(int index){
		return list.get(index);
	}
	//returns the size of the linked list
	public int getListSize(){
		return list.size();
	}
}
