//This class creates the GUI for the login screen. 
import java.awt.*;
import javax.swing.*;

public class LoginGUI {
	private JFrame logInFrame;
	private JLabel topLabel, userNameLabel, passwordLabel;
	private JPanel logInPanel;
	private JButton createNewAccount, signIn;
	private JTextField userName;
	private JPasswordField passwordField;
	public LoginGUI(){
		logInFrame = new JFrame("Efferent Patient Care System");
		
		logInPanel = new JPanel(new GridBagLayout());
		
		//Labels
		topLabel = new JLabel("Patient/Doctor Sign In"); //Appears above the two text boxes
		userNameLabel = new JLabel("User Name"); //Appears to the left of the top text box
		passwordLabel = new JLabel("Password"); //Appears to the left of the bottom text box.
		
		//Buttons
		createNewAccount = new JButton("Create New Account");
		signIn = new JButton("Sign In");
		signIn.setBackground(new Color(224,224,224)); //Sets the background color of the buttons to a light gray. 
		createNewAccount.setBackground(new Color(224,224,224));
		
		//Text boxes
		passwordField = new JPasswordField(10);
		userName = new JTextField(10);
		
		
		GridBagConstraints c = new GridBagConstraints(); //Used for arranging things on the panel.

		logInFrame.setVisible(true);
		logInFrame.setSize(400, 400);
		logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Adding everything to the panel.
		c.gridx = 1; //Coordinates for this variable "c" have to be changed each time, because
	               //	each component is being added to a different spot. 
		c.gridy = 0;
		c.insets = new Insets(10, 10, 10, 10);
		logInPanel.add(topLabel, c);
		c.gridx = 1;
		c.gridy = 1;
		logInPanel.add(userName, c);
		c.gridx = 0;
		c.gridy = 1;
		logInPanel.add(userNameLabel, c);
		c.gridx = 1;
		c.gridy = 2;
		logInPanel.add(passwordField,c);
		c.gridx = 0;
		c.gridy = 2;
		logInPanel.add(passwordLabel, c);
		c.gridx = 0;
		c.gridy = 3;
		logInPanel.add(createNewAccount, c);
		c.gridx = 1;
		c.gridy = 3;
		logInPanel.add(signIn, c);
		
		logInFrame.add(logInPanel); //Add the panel to the frame. 
		
	}
	public static void main(String[] args){
		new LoginGUI();
	}
}
