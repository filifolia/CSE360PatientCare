//This class creates the GUI for the login screen and the GUI for creating a new account.

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LoginGUI extends JPanel{
	private static JFrame logInFrame, logInFrame1, userInformationFrame;
	private static JLabel topLabel, userNameLabel, passwordLabel, confirmPasswordLabel, typeLabel, errorMessage;
	private static JPanel logInPanel, ImagePanel;
	private static JButton createNewAccount, signIn;
	private static JTextField userName;
	private static JPasswordField passwordField, confirmPasswordField;
	private static ButtonGroup patientDoctorButtonGroup;
	private static JRadioButton patientRadio, doctorRadio;
	private static UserList users = new UserList();
	private BufferedImage image;
	private static User newUser; //Temporary user object that will be used for sign up
	
	
	public LoginGUI(){
		logInFrame = new JFrame("Efferent Patient Care System");
		ImagePanel = new JPanel(new BorderLayout());
		logInPanel = new JPanel(new GridBagLayout());
		
		//Image
		try {
			image = ImageIO.read(new File("src/effecent.png"));
		} catch (IOException e1) {
			System.out.println("image broken");
			e1.printStackTrace();
		}
		JLabel effecentPic = new JLabel(new ImageIcon(image));
		
		//Labels
		topLabel = new JLabel("Patient/Doctor Sign In"); //Appears above the two text boxes
		userNameLabel = new JLabel("User Name:"); //Appears to the left of the top text box
		passwordLabel = new JLabel("Password:"); //Appears to the left of the bottom text box.
		typeLabel = new JLabel("Type of Account:");
		errorMessage = new JLabel(""); //Blank at first.

		
		//Buttons
		createNewAccount = new JButton("Create New Account");
		signIn = new JButton("Sign In");
		signIn.setBackground(new Color(224,224,224)); //Sets the background color of the buttons to a light gray. 
		createNewAccount.setBackground(new Color(224,224,224));
		
		//Text boxes
		passwordField = new JPasswordField(10);
		userName = new JTextField(10);
		
		//Radio buttons
		patientDoctorButtonGroup = new ButtonGroup();
		patientRadio = new JRadioButton("Patient");
		doctorRadio = new JRadioButton("Doctor");
		patientRadio.setSelected(true);
		doctorRadio.setSelected(false);
		patientDoctorButtonGroup.add(patientRadio);
		patientDoctorButtonGroup.add(doctorRadio);
		
		
		GridBagConstraints c = new GridBagConstraints(); //Used for arranging things on the panel.

		logInFrame.setVisible(true);
		logInFrame.setSize(650, 410);
		logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logInFrame.setLocationRelativeTo(null);
		//logInFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		//Adding everything to the panel.
		c.gridx = 1; //Coordinates for this variable "c" have to be changed each time, because
					//	each component is being added to a different spot. 
		c.gridy = 0;
		c.insets = new Insets(10, 10, 10, 10);
		logInPanel.add(topLabel, c);
		c.gridx = 1;
		c.gridy = 1;
		logInPanel.add(errorMessage,c);
		c.gridx = 1;
		c.gridy = 2;
		logInPanel.add(userName, c);
		c.gridx = 0;
		c.gridy = 2;
		logInPanel.add(userNameLabel, c);
		c.gridx = 1;
		c.gridy = 3;
		logInPanel.add(passwordField,c);
		c.gridx = 0;
		c.gridy = 3;
		logInPanel.add(passwordLabel, c);

		c.gridx = 0;
		c.gridy = 4;
		logInPanel.add(typeLabel, c);
		c.gridx = 1;
		c.gridy = 4;
		logInPanel.add(patientRadio, c);
		c.gridx = 1;
		c.gridy = 5;
		logInPanel.add(doctorRadio, c);
		
		c.gridx = 0;
		c.gridy = 6;
		logInPanel.add(createNewAccount, c);
		c.gridx = 1;
		c.gridy = 6;
		logInPanel.add(signIn, c);
		
		ImagePanel.add(effecentPic, BorderLayout.WEST);
		ImagePanel.add(logInPanel, BorderLayout.EAST);
		
		logInFrame.add(ImagePanel); //Add the panel to the frame. 
		
		//CREATE NEW ACCOUNT - action listener
		createNewAccount.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					newUser = new User();
					signUpGUI();
					logInFrame.setVisible(false); //Hide that first frame - the log-in one.
				}
		});
		//SIGN IN - action listener
		signIn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				userName.setBackground(Color.WHITE);
				passwordField.setBackground(Color.WHITE);
				
				Boolean fieldsAreFilled = true; //We assume all the fields are filled until we've been proven wrong.

				String password = String.valueOf(passwordField.getPassword());
				
				if(userName.getText().isEmpty()){
					userName.setBackground(Color.YELLOW);
					fieldsAreFilled = false;
				}
				if(password.isEmpty()){
					passwordField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;
				}
				if(!fieldsAreFilled){ //Will be true, if one of the above fields is empty.
					errorMessage.setText("Highlighted fields are required."); //Display an error message via a label.
					errorMessage.setForeground(Color.RED); //Nothing says "ERROR" like the color red.
				}
				else{ //All of the input fields were filled.
					
					//This is the kind of if statement that could be used here. 
					if(patientRadio.isSelected()){ //User selected "Patient"
						new PatientGUI();
						logInFrame.setVisible(false);
					}
					else{ //User selected "Doctor".
						//this.dispose();
						new DoctorGUI();
						logInFrame.setVisible(false); //Hide that first frame - the log-in one.
					}			
					
				}
			}
		}); 
		
	}
	//GUI for signing up for a new account.
	public static void signUpGUI(){
		logInFrame1 = new JFrame("Efferent Patient Care System");
		
		logInPanel = new JPanel(new GridBagLayout());
		
		//Labels
		topLabel = new JLabel("Patient/Doctor Sign Up"); //Appears above the two text boxes
		userNameLabel = new JLabel("New User Name"); //Appears to the left of the top text box
		passwordLabel = new JLabel("New Password"); //Appears to the left of the bottom text box.
		confirmPasswordLabel = new JLabel("Confirm Password");
		errorMessage = new JLabel(""); //Blank at first.
		
		
		//Buttons
		createNewAccount = new JButton("Create New Account");
		//signIn = new JButton("Sign In");
		//signIn.setBackground(new Color(224,224,224)); //Sets the background color of the buttons to a light gray. 
		createNewAccount.setBackground(new Color(224,224,224));
		
		//Text boxes
		passwordField = new JPasswordField(10);
		confirmPasswordField = new JPasswordField(10);
		userName = new JTextField(10);
		
		
		GridBagConstraints c = new GridBagConstraints(); //Used for arranging things on the panel.

		logInFrame1.setVisible(true);
		logInFrame1.setSize(400, 400);
		logInFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		logInFrame1.setLocationRelativeTo(null);

		
		//Adding everything to the panel.
		c.gridx = 1; //Coordinates for this variable "c" have to be changed each time, because
					//	each component is being added to a different spot. 
		c.gridy = 0;
		c.insets = new Insets(10, 10, 10, 10);
		logInPanel.add(topLabel, c);
		c.gridx = 1;
		c.gridy = 1;
		logInPanel.add(errorMessage, c);
		c.gridx = 1;
		c.gridy = 2;
		logInPanel.add(userName, c);
		c.gridx = 0;
		c.gridy = 2;
		logInPanel.add(userNameLabel, c);
		c.gridx = 1;
		c.gridy = 3;
		logInPanel.add(passwordField,c);
		c.gridx = 0;
		c.gridy = 3;
		logInPanel.add(passwordLabel, c);
		c.gridx = 1;
		c.gridy = 4;
		logInPanel.add(confirmPasswordField, c);
		c.gridx = 0;
		c.gridy = 4;
		logInPanel.add(confirmPasswordLabel, c);	
		
		c.gridx = 0;
		c.gridy = 5;
		logInPanel.add(typeLabel, c);
		c.gridx = 1;
		c.gridy = 5;
		logInPanel.add(patientRadio, c);
		c.gridx = 1;
		c.gridy = 6;
		logInPanel.add(doctorRadio, c);
		
		c.gridx = 1;
		c.gridy = 7;
		logInPanel.add(createNewAccount, c);
		/*c.gridx = 1;
		c.gridy = 4;
		logInPanel.add(signIn, c);*/
		
		logInFrame1.add(logInPanel); //Add the panel to the frame. 
		
		createNewAccount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Check if any of the fields are empty. 
				//Reset all the fields colors.
				userName.setBackground(Color.WHITE);
				passwordField.setBackground(Color.WHITE);
				confirmPasswordField.setBackground(Color.WHITE);
				
				Boolean fieldsAreFilled = true; //We assume all the fields are filled until we've been proven wrong.

				String password = String.valueOf(passwordField.getPassword());
				String confirmPassword = String.valueOf(confirmPasswordField.getPassword());
				
				if(userName.getText().isEmpty()){
					userName.setBackground(Color.YELLOW);
					fieldsAreFilled = false;
				}
				if(password.isEmpty()){
					passwordField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;
				}
				if(confirmPassword.isEmpty()){
					confirmPasswordField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;
				}
				if(password.length() < 4){
					passwordField.setBackground(Color.YELLOW);
					confirmPasswordField.setBackground(Color.YELLOW);
				}
				
				if(!userName.getText().isEmpty() && users.searchByUsername(userName.getText()) != -1){
					userName.setBackground(Color.YELLOW);
				}
				
				if(!fieldsAreFilled){ //Will be true, if one of the above fields is empty.
					errorMessage.setText("Highlighted fields are required."); //Display an error message via a label.
					errorMessage.setForeground(Color.RED); //Nothing says "ERROR" like the color red.
				}
				else if(password.length() < 4) { //Password needs to be equal or longer than 4 characters
					errorMessage.setText("Password too short.");
					errorMessage.setForeground(Color.RED);
				}
				else if(!password.equals(confirmPassword)){ //Will be true when password != confirmPassword
					errorMessage.setText("Passwords did not match.");
					passwordField.setBackground(Color.YELLOW);
					confirmPasswordField.setBackground(Color.YELLOW);
					errorMessage.setForeground(Color.RED);

				}
				
				else if(!userName.getText().isEmpty() && users.searchByUsername(userName.getText()) != -1){ //Checks hash table if the username exist
					errorMessage.setText("Username already exist in the database.");
					errorMessage.setForeground(Color.RED);
				}
				
				else{ //Create the account.
					newUser.setUsername(userName.getText()); //Set the user's username
					newUser.setPassword(password); //Set the user's password
					if(patientRadio.isSelected()){
						patientUserInformationGUI();
						logInFrame1.setVisible(false);	
					}
					else{
						doctorUserInformationGUI();
						logInFrame1.setVisible(false);
					}
					
				}
			}
		});
	}
	public static void patientUserInformationGUI(){
		JLabel userInformationLabel, requiredLabel, firstNameLabel, lastNameLabel, middleInitialLabel, ageLabel, heightLabel, weightLabel, phoneLabel;
		JPanel userInformationPanel;
		JTextField firstNameField, lastNameField, middleInitialField, ageField, heightField, weightField, phoneField;
		JButton submitButton;
		
		//Frame
		userInformationFrame = new JFrame("Efferent Patient Care System");
		userInformationFrame.setVisible(true);
		userInformationFrame.setSize(400, 450);
		userInformationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userInformationFrame.setLocationRelativeTo(null);

		//Labels
		userInformationLabel = new JLabel("Patient Information");
		firstNameLabel = new JLabel("*First Name:");
		lastNameLabel = new JLabel("*Last Name:");
		middleInitialLabel = new JLabel("Middle Initial:");
		ageLabel = new JLabel("*Age:");
		heightLabel = new JLabel("*Height:");
		weightLabel = new JLabel("*Weight:");
		phoneLabel = new JLabel("*Phone Number:");
		requiredLabel = new JLabel("* = required field");
		errorMessage = new JLabel(""); //Set it to be blank at first.

		
		//Buttons
		submitButton = new JButton("Submit");
		submitButton.setBackground(new Color(224,224,224)); 
		
		//Text fields
		firstNameField = new JTextField(10);
		lastNameField = new JTextField(10);
		middleInitialField = new JTextField(10);
		ageField = new JTextField(10);
		heightField = new JTextField(10);
		weightField = new JTextField(10);
		phoneField = new JTextField(10);
		
		//Panel
		GridBagConstraints c = new GridBagConstraints(); //Used for arranging things on the panel.
		userInformationPanel = new JPanel(new GridBagLayout());
		
		c.gridx = 1; //Coordinates for this variable "c" have to be changed each time, because
		c.gridy = 0; //	each component is being added to a different spot. 
		c.insets = new Insets(10, 10, 10, 10);
		userInformationPanel.add(userInformationLabel, c);
		c.gridx = 1;
		c.gridy = 1;
		userInformationPanel.add(errorMessage, c);
		c.gridx = 0;
		c.gridy = 2;
		userInformationPanel.add(firstNameLabel, c);	
		c.gridx = 1;
		c.gridy = 2;
		userInformationPanel.add(firstNameField, c);			
		c.gridx = 0;
		c.gridy = 3;
		userInformationPanel.add(lastNameLabel, c);
		c.gridx = 1;
		c.gridy = 3;
		userInformationPanel.add(lastNameField, c);
		c.gridx = 0;
		c.gridy = 4;
		userInformationPanel.add(middleInitialLabel, c);
		c.gridx = 1;
		c.gridy = 4;
		userInformationPanel.add(middleInitialField, c);
		c.gridx = 0;
		c.gridy = 5;
		userInformationPanel.add(ageLabel, c);
		c.gridx = 1;
		c.gridy = 5;
		userInformationPanel.add(ageField, c);
		c.gridx = 0;
		c.gridy = 6;
		userInformationPanel.add(heightLabel, c);
		c.gridx = 1;
		c.gridy = 6;
		userInformationPanel.add(heightField, c);
		c.gridx = 0;
		c.gridy = 7;
		userInformationPanel.add(weightLabel, c);
		c.gridx = 1;
		c.gridy = 7;
		userInformationPanel.add(weightField, c);
		c.gridx = 0;
		c.gridy = 8;
		userInformationPanel.add(phoneLabel, c);
		c.gridx = 1;
		c.gridy = 8;
		userInformationPanel.add(phoneField, c);
		c.gridx = 0;
		c.gridy = 9;
		userInformationPanel.add(requiredLabel, c);
		c.gridx = 1;
		c.gridy = 9;
		userInformationPanel.add(submitButton, c);
		
		userInformationFrame.add(userInformationPanel); //Add the panel to the frame. 
		
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Check if any of the required fields are left blank.
				Boolean fieldsAreFilled = true; //We assume all the fields are filled until we've been proven wrong.
				firstNameField.setBackground(Color.WHITE);
				lastNameField.setBackground(Color.WHITE);
				ageField.setBackground(Color.WHITE);
				
				if(firstNameField.getText().isEmpty()){
					firstNameField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;
				}
				if(lastNameField.getText().isEmpty()){
					lastNameField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;					
				}
				if(ageField.getText().isEmpty()){
					ageField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;				
				}
				if(heightField.getText().isEmpty()){
					heightField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;				
				}
				if(weightField.getText().isEmpty()){
					weightField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;				
				}
				if(phoneField.getText().isEmpty()){
					phoneField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;				
				}
				if(!fieldsAreFilled){ //Will be true if one of the required fields is empty.
					errorMessage.setText("Highlighted fields are required.");
					errorMessage.setForeground(Color.RED);
				}
				else if(!middleInitialField.getText().isEmpty() && middleInitialField.getText().length() != 1){
					//Checking if middle initial is one letter.
					errorMessage.setText("Middle initial must be one letter.");
					errorMessage.setForeground(Color.RED);
				}
				else if(!isANumber(phoneField.getText())){//Check if string is a number.
					errorMessage.setText("Phone must be numbers.");
					errorMessage.setForeground(Color.RED);
				}
				else if(!isANumber(ageField.getText())){//Check if string is a number.
					errorMessage.setText("Age must be a number.");
					errorMessage.setForeground(Color.RED);
				}
				else{
					//Actually make the new user account.
					newUser.setFirstName(firstNameField.getText());
					newUser.setLastName(firstNameField.getText());
					newUser.setAge(Integer.parseInt(ageField.getText()));
					newUser.setWeight(Integer.parseInt(weightField.getText()));
					newUser.setHeight(Integer.parseInt(heightField.getText()));
					newUser.setPhone(phoneField.getText());
					users.addElement(newUser); //Adds the user to the hash table
					new LoginGUI();
					userInformationFrame.setVisible(false);
				}
			}
		});
	}
	public static void doctorUserInformationGUI(){
		JLabel userInformationLabel, requiredLabel, firstNameLabel, lastNameLabel, middleInitialLabel, ageLabel, heightLabel, ethnicityLabel, specialtyLabel;
		JPanel userInformationPanel;
		JTextField firstNameField, lastNameField, middleInitialField, ageField, heightField, ethnicityField, specialtyField;
		JButton submitButton;
		
		//Frame
		userInformationFrame = new JFrame("Efferent Patient Care System");
		userInformationFrame.setVisible(true);
		userInformationFrame.setSize(400, 450);
		userInformationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userInformationFrame.setLocationRelativeTo(null);

		//Labels
		userInformationLabel = new JLabel("Doctor Information");
		firstNameLabel = new JLabel("*First Name:");
		lastNameLabel = new JLabel("*Last Name:");
		middleInitialLabel = new JLabel("Middle Initial:");
		ageLabel = new JLabel("*Age:");
		heightLabel = new JLabel("Height:");
		ethnicityLabel = new JLabel("Ethnicity:");
		specialtyLabel = new JLabel("*Specialty:");
		requiredLabel = new JLabel("* = required field");
		errorMessage = new JLabel(""); //Set it to be blank at first.

		
		//Buttons
		submitButton = new JButton("Submit");
		submitButton.setBackground(new Color(224,224,224)); 
		
		//Text fields
		firstNameField = new JTextField(10);
		lastNameField = new JTextField(10);
		middleInitialField = new JTextField(10);
		ageField = new JTextField(10);
		heightField = new JTextField(10);
		ethnicityField = new JTextField(10);
		specialtyField = new JTextField(10);
		
		//Panel
		GridBagConstraints c = new GridBagConstraints(); //Used for arranging things on the panel.
		userInformationPanel = new JPanel(new GridBagLayout());
		
		c.gridx = 1; //Coordinates for this variable "c" have to be changed each time, because
		c.gridy = 0; //	each component is being added to a different spot. 
		c.insets = new Insets(10, 10, 10, 10);
		userInformationPanel.add(userInformationLabel, c);
		c.gridx = 1;
		c.gridy = 1;
		userInformationPanel.add(errorMessage, c);
		c.gridx = 0;
		c.gridy = 2;
		userInformationPanel.add(firstNameLabel, c);	
		c.gridx = 1;
		c.gridy = 2;
		userInformationPanel.add(firstNameField, c);			
		c.gridx = 0;
		c.gridy = 3;
		userInformationPanel.add(lastNameLabel, c);
		c.gridx = 1;
		c.gridy = 3;
		userInformationPanel.add(lastNameField, c);
		c.gridx = 0;
		c.gridy = 4;
		userInformationPanel.add(middleInitialLabel, c);
		c.gridx = 1;
		c.gridy = 4;
		userInformationPanel.add(middleInitialField, c);
		c.gridx = 0;
		c.gridy = 5;
		userInformationPanel.add(ageLabel, c);
		c.gridx = 1;
		c.gridy = 5;
		userInformationPanel.add(ageField, c);
		c.gridx = 0;
		c.gridy = 6;
		userInformationPanel.add(heightLabel, c);
		c.gridx = 1;
		c.gridy = 6;
		userInformationPanel.add(heightField, c);
		c.gridx = 0;
		c.gridy = 7;
		userInformationPanel.add(ethnicityLabel, c);
		c.gridx = 1;
		c.gridy = 7;
		userInformationPanel.add(ethnicityField, c);
		c.gridx = 0;
		c.gridy = 8;
		userInformationPanel.add(specialtyLabel, c);
		c.gridx = 1;
		c.gridy = 8;
		userInformationPanel.add(specialtyField, c);
		c.gridx = 0;
		c.gridy = 9;
		userInformationPanel.add(requiredLabel, c);
		c.gridx = 1;
		c.gridy = 9;
		userInformationPanel.add(submitButton, c);
		
		userInformationFrame.add(userInformationPanel); //Add the panel to the frame. 
		
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//Check if any of the required fields are left blank.
				Boolean fieldsAreFilled = true; //We assume all the fields are filled until we've been proven wrong.
				firstNameField.setBackground(Color.WHITE);
				lastNameField.setBackground(Color.WHITE);
				ageField.setBackground(Color.WHITE);
				specialtyField.setBackground(Color.WHITE);
				
				if(firstNameField.getText().isEmpty()){
					firstNameField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;
				}
				if(lastNameField.getText().isEmpty()){
					lastNameField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;					
				}
				if(ageField.getText().isEmpty()){
					ageField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;				
				}
				if(specialtyField.getText().isEmpty()){
					specialtyField.setBackground(Color.YELLOW);
					fieldsAreFilled = false;
				}
				if(!fieldsAreFilled){ //Will be true if one of the required fields is empty.
					errorMessage.setText("Highlighted fields are required.");
					errorMessage.setForeground(Color.RED);
				}
				else if(!middleInitialField.getText().isEmpty() && middleInitialField.getText().length() != 1){
					//Checking if middle initial is one letter.
					errorMessage.setText("Middle initial must be one letter.");
					errorMessage.setForeground(Color.RED);
				}
				else if(!isANumber(ageField.getText())){//Check if string is a number.
					errorMessage.setText("Age must be a number.");
					errorMessage.setForeground(Color.RED);
				}
				else{
					//Actually make the new user account.
				}
			}
		});	
	}
	//Returns true if the string is a number. False otherwise.
	public static boolean isANumber(String input){
		for(int i = 0; i < input.length(); i++){
			if(input.charAt(i) != '0' && input.charAt(i) != '1' &&
			   input.charAt(i) != '2' && input.charAt(i) != '3' &&
			   input.charAt(i) != '4' && input.charAt(i) != '5' &&
			   input.charAt(i) != '6' && input.charAt(i) != '7' &&
			   input.charAt(i) != '8' && input.charAt(i) != '9'){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		
		new LoginGUI();
	}
}
