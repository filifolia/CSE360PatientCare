import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Jeremy
 */
//The main file housing the components seen in the Doctor/Cargiver Interface. Shows Patients, info of individual user, and allows for
//the changing of thresholds.




//The GUI so far looks okay; for now, this is the skeleton, when I get a better understanding of the other classes and when the Report classes are done, the functionality will be inputted.
public class DoctorGUI {
        private JTabbedPane tab1,tab2, tab3;
        private JPanel panel1, panel2, panel3, tabPanel;
        private JFrame doctorFrame;
        private JButton setThresh,editInfo;
        private JList list1;
        private JLabel label1, label2, fullName, phoNum, status, patNum, degree;
        private JSlider upThresh, lowThresh;
        private DefaultListModel model;
        private final int lowVal = 0,highVal = 10, defaultVal = 5;  //These are the slider values.
        
   public DoctorGUI()
           {
               doctorFrame = new JFrame("Caregiver/Doctor Access");
               
               model = new DefaultListModel();                      //Since we don't have our patient list totally done, I used a DefaultListModel to put a pseudolist so I can test how it looks in the GUI
               model.addElement("Hypothetical Patient 1 ");
               model.addElement("Hypothetical Patient 2 ");
               
               list1 = new JList(model);
               JLabel asdf = new JLabel("asdf");
             
               panel1 = new JPanel();                           //Panel 1, or the View Patient Panel. So far, the only thing here is the JList displaying all the patients.
               panel1.setLayout(new BorderLayout(1,1));
               panel1.add(list1);
             
               upThresh = new JSlider(JSlider.HORIZONTAL,lowVal,highVal,defaultVal);   //Making our two sliders for setting our thresholds.
               upThresh.setMajorTickSpacing(10);
               upThresh.setMinorTickSpacing(1);
               upThresh.setPaintTicks(true);
               upThresh.setPaintLabels(true);
               lowThresh = new JSlider(JSlider.HORIZONTAL,lowVal,highVal,defaultVal);
               lowThresh.setMajorTickSpacing(10);
               lowThresh.setMinorTickSpacing(1);
               lowThresh.setPaintTicks(true);
               lowThresh.setPaintLabels(true);
               
               label1 = new JLabel("Lower Threshold Value");        //Threshold Labels to signify which slider is which.
               label2 = new JLabel("Upper Threshold Value");
               setThresh = new JButton("Set Thresholds");   //Button which sets our new Thresholds.
               
               panel2 = new JPanel();                       //Our second panel, which contains all of the sliders and is used for the threshold setting.
               panel2.setLayout(new GridLayout(5,1));
               panel2.add(label1);
               panel2.add(lowThresh);
               panel2.add(label2);
               panel2.add(upThresh);
               panel2.add(setThresh);
            
               fullName = new JLabel("Your full name is: ");                //Labels for the user panels.
               phoNum = new JLabel("Your phone number is: ");
               status = new JLabel("Your current height is: ");
               patNum = new JLabel("Your current weight: ");
               degree = new JLabel("Your current degree: ");
               editInfo = new JButton("Edit User Info");
               
               panel3 = new JPanel();                           //Panel 3, our user info panel.
               panel3.setLayout(new GridLayout(10,1));           //For now, the labels serve to visualize the basic GUI,
               panel3.add(fullName);                            //They will then use the getter methods in User Class to display the correct info for each user.
               panel3.add(phoNum);
               panel3.add(status);
               panel3.add(patNum);
               panel3.add(degree);
               panel3.add(editInfo);
               
               tab1 = new JTabbedPane();                    //Our three tabs
               tab1.addTab("View Patients", panel1);
               tab1.addTab("User Info", panel3);
               tab1.addTab("Patient Threshold", panel2);
               
               tabPanel = new JPanel();                     //Panel holding all of the tabs.
               tabPanel.setLayout(new GridLayout(1,1));
               tabPanel.add(tab1);
               
               doctorFrame.add(tabPanel);                      //Adding the panel to the frame and the other stuff.
               doctorFrame.setVisible(true);
               doctorFrame.setSize(600,600);
               doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
               editInfo.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        editGUI();
                        doctorFrame.setVisible(false);
                    }
                   
               });
               
           }
           
public static void editGUI()    //Our new Edit panel
  {
      JFrame editFrame = new JFrame("Doctor/Cargiver Access");
      GridBagConstraints c = new GridBagConstraints();
      JPanel editPan = new JPanel(new GridBagLayout());
      
      JTextField name = new JTextField(10);
      JTextField number = new JTextField(10);
      JTextField nHeight = new JTextField(10);
      JTextField nWeight = new JTextField(10);
      JTextField nDeg = new JTextField(10);
      JButton submit = new JButton("Submit Changes");
      JButton cancel = new JButton("Cancel");
      
      JLabel editName = new JLabel("Enter your edited name: ");
      JLabel editNum = new JLabel("Enter your new phone number: ");
      JLabel editHeight = new JLabel("Enter your adjusted height: ");
      JLabel editWeight = new JLabel("Enter your adjusted weight: ");
      JLabel editDeg = new JLabel("Enter your degree: ");
      
      c.gridx = 0;
      c.gridy = 1;
      c.insets = new Insets(10, 10, 10, 10);
      editPan.add(editName,c);
      c.gridx = 1;
      c.gridy = 1;
      editPan.add(name,c);
      c.gridx = 0;
      c.gridy = 2;
      editPan.add(editNum,c);
      c.gridx = 1;
      c.gridy = 2;
      editPan.add(number,c);
      c.gridx = 0;
      c.gridy = 3;
      editPan.add(editHeight,c);
      c.gridx = 1;
      c.gridy = 3;
      editPan.add(nHeight,c);
      c.gridx = 0;
      c.gridy = 4;
      editPan.add(editWeight,c);
      c.gridx = 1;
      c.gridy = 4;
      editPan.add(nWeight,c);
      c.gridx = 0;
      c.gridy = 5;
      editPan.add(editDeg,c);
      c.gridx = 1;
      c.gridy = 5;
      editPan.add(nDeg,c);
      c.gridx = 0;
      c.gridy = 6;
      editPan.add(submit,c);
      c.gridx = 1;
      c.gridy = 6;
      editPan.add(cancel,c);
      
      editFrame.add(editPan);
      editFrame.setVisible(true);
      editFrame.setSize(600,600);
      editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
  }
    public static void main(String[] args)              //Main file to test the GUI
       {
           new DoctorGUI();
       }
     }
