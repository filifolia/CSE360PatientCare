import java.io.*;

public final class ListIO {
	//Saves all detail of existing users to a text save file
	public static void savePatientFile(UserList patientList)
	{
		//This ObjectOutputStream will save the data into patientList.txt
		try {
			FileOutputStream fileOut = new FileOutputStream("src/patientList.ser");
			ObjectOutputStream output = new ObjectOutputStream(fileOut);
			output.writeObject(patientList);
			output.flush();
			output.close();
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File is not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O Exception");
			e.printStackTrace();
		}
	}
	
	//This method will save the docto
	public static void saveCareGiverFile(UserList doctorList)
	{
		//This ObjectOutputStream will save the data into patientList.txt
		try {
			FileOutputStream fileOut = new FileOutputStream("src/doctorList.ser");
			ObjectOutputStream output = new ObjectOutputStream(fileOut);
			output.writeObject(doctorList);
			output.flush();
			output.close();
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File is not found!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O Exception");
			e.printStackTrace();
		}
	}
	
	//Loads existing database of the list of users.
	public static UserList loadPatientFile()
	{
		UserList patient = null;
		//This ObjectOutputStream will save the data into patientList.txt
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/patientList.ser"));
			patient = (UserList)input.readObject();
			System.out.println("Patient list loaded!");
			input.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Patient does not exist");
			e.printStackTrace();	
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("File is not found!");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.out.println("I/O Exception");
			e.printStackTrace();
			return null;
		}
		return patient;
	}
	
	//Loads existing database of the list of doctors.
		public static UserList loadCareGiverFile()
		{
			UserList doctor = null;
			//This ObjectOutputStream will save the data into patientList.txt
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/doctorList.ser"));
				doctor = (UserList)input.readObject();
				System.out.println("Doctor list loaded!");
				input.close();
			} catch (ClassNotFoundException e) {
				System.out.println("Doctor does not exist");
				e.printStackTrace();	
				return null;
			} catch (FileNotFoundException e) {
				System.out.println("File is not found!");
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				System.out.println("I/O Exception");
				e.printStackTrace();
				return null;
			}
			return doctor;
		}
		
}
