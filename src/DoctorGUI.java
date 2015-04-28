import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
/**
 *
 * @author Jeremy
 */
//The main file housing the components seen in the Doctor/Cargiver Interface. Shows Patients, info of individual user, and allows for
//the changing of thresholds.




//The GUI so far looks okay; for now, this is the skeleton, when I get a better understanding of the other classes and when the Report classes are done, the functionality will be inputted.
public class DoctorGUI extends LoginGUI{
        private static final long serialVersionID = 1L;
        private JTabbedPane tab1,tab2, tab3;
        private JPanel panel1, panel2, panel3, tabPanel,panel4;
        private static JFrame doctorFrame;
        private JButton setThresh, editInfo, logout,view;
        private JList list1;
        private JLabel label1, label2, firstName, lastName, careAge, careHeight, careWeight,specialty;
        private JSlider upThresh, lowThresh;
        private DefaultListModel model;
        private final int lowVal = 0,highVal = 10, defaultVal = 5;  //These are the slider values.
        private int lowerVal, higherVal;
        static Patient pat = new Patient();
        private int repNum = 0;
        
   public DoctorGUI()
           {
	           logInFrame.dispose();
               doctorFrame = new JFrame("Caregiver/Doctor Access");
               
               model = new DefaultListModel();
               model.addElement(patient.reports);
               list1 = new JList(model);
               
             
               panel1 = new JPanel();                           //Panel 1, or the View Patient Panel. So far, the only thing here is the JList displaying all the patients.
               panel1.setLayout(new GridLayout(5,1));
               panel1.add(list1);
               view = new JButton("View Report");
               panel1.add(view);
             
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
               
               lowerVal = lowThresh.getValue();
               higherVal = upThresh.getValue();
            
               firstName = new JLabel("Your first name is: " + careGiver.getFirstName());                //Labels for the user panels.
               lastName = new JLabel("Your last number is: " + careGiver.getLastName());
               careAge = new JLabel("Your current age is: " + careGiver.getAge());
               careHeight = new JLabel("Your current heightis : " + careGiver.getHeight());
               careWeight = new JLabel("Your current weight is: " + careGiver.getWeight());
               specialty = new JLabel("Your current specialty is: " + careGiver.getDegree());
               editInfo = new JButton("Edit User Info");
               
               panel3 = new JPanel();                           //Panel 3, our user info panel.
               panel3.setLayout(new GridLayout(10,1));           //For now, the labels serve to visualize the basic GUI,
               panel3.add(firstName);                            //They will then use the getter methods in User Class to display the correct info for each user.
               panel3.add(lastName);
               panel3.add(careAge);
               panel3.add(careHeight);
               panel3.add(specialty);
               
               
               panel4 = new JPanel();
               panel4.setLayout(new GridLayout(5,1));
               logout = new JButton("Logout");
               panel4.add(logout);
               
               tab1 = new JTabbedPane();                    //Our three tabs
               tab1.addTab("View Patient Reports", panel1);
               tab1.addTab("User Info", panel3);
               tab1.addTab("Patient Threshold", panel2);
               tab1.addTab("Logout", panel4);
               
               tabPanel = new JPanel();                     //Panel holding all of the tabs.
               tabPanel.setLayout(new GridLayout(1,1));
               tabPanel.add(tab1);
               
               doctorFrame.add(tabPanel);                      //Adding the panel to the frame and the other stuff.
               doctorFrame.setVisible(true);
               doctorFrame.setSize(600,600);
               doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
               logout.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        logInFrame.setVisible(true);
                        doctorFrame.setVisible(false);
                    }
                   
               });
               
               
               
               setThresh.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                      pat.setFirstThresh(lowerVal);
                      pat.setSecondThreshold(higherVal);
                    }
                   
               });
               
               view.addActionListener(new ActionListener(){                           //This will be the pop up window that displays the selected report from the list.
                    public void actionPerformed(ActionEvent e)
                    {
                        final JFrame repFrame = new JFrame("Reports");
                        JPanel repPanel = new JPanel();
                        repPanel.setLayout(new GridLayout(8,1));
                        JLabel patName = new JLabel("Patient: " + patient.getFirstName() + " " + patient.getLastName());
                        JLabel repPain = new JLabel("Pain Threshold: "+patient.reports[repNum].getPain());
                        JLabel repSleepy = new JLabel("Drowsiness Threshold: " + patient.reports[repNum].getSleepy());
                        JLabel repNausea = new JLabel("Nausea Threshold: " + patient.reports[repNum].getNausea());
                        JLabel repAnx = new JLabel("Anxiety Threshold: " + patient.reports[repNum].getAnxiety());
                        JLabel repDep = new JLabel("Depression Threshold: " + patient.reports[repNum].getDepression());
                        JLabel thresAvg = new JLabel("Average Threshold was: " + avgVal);
                        JButton closeIt = new JButton("Close");
                        repPanel.add(patName);
                        repPanel.add(repPain);
                        repPanel.add(repSleepy);
                        repPanel.add(repNausea);
                        repPanel.add(repAnx);
                        repPanel.add(repDep);
                        repPanel.add(thresAvg);
                        repPanel.add(closeIt);
                        repFrame.add(repPanel);
                        repFrame.setVisible(true);
                        repFrame.setSize(400,400);
                        repFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        //repNum++;                                                                   //THIS VARIABLE IS THE ISSUE, IT KEEPS TRACK OF WHERE IN THE ARRAY WE ARE, I HAVE TO INCREMENT IT SOMEWHERE
                    closeIt.addActionListener(new ActionListener(){                                 //SO IT DOESNT KEEP OVERWRITING THE VALUE AT 0, BUT I DON'T KNOW WHERE I CAN INCREMENT IT WITHOUT FUCKING IT UP
                    public void actionPerformed(ActionEvent e)                                      //RIGHT NOW, I CAN ONLY VIEW THE LAST SUBMITTED REPORT ONCE BECAUSE IT INCREMENTS HERE, BUT IF IT DOESNT INCREMENT
                    {                                                                               //IT KEEPS OVERWRITING.
                        repFrame.setVisible(false);
                     }
                   
               });
                    
                    }
                   
               });
           
           
               
               
               
               
              
           }
   
 
    public static void main(String[] args)              //Main file to test the GUI
       {
           new DoctorGUI();
       }
     }
