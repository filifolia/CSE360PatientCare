import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Scanner;

/**
 *
 * @author Jeremy
 */
public class PatientGUI extends LoginGUI {
    private JLabel pain, drowsiness, nausea, anxiety, depression,output,confirm,avg,replist;
    private JLabel patName, patAge, patHeight, phoNum, patWeight;
    private JPanel panel1, panel2, panel3, tabPanel,panel4;
    private JTabbedPane tab1;
    final public JSlider pSlider, dSlider, nSlider, aSlider, depSlider;
    public static JFrame patFrame;
    public JList list1;
    private JButton submit,edit,logout,viewR;
    public DefaultListModel model;
    private int repNum = 0;
    //public float avgVal = 0;
    private final int lowVal = 0,highVal = 10, defaultVal = 5;
    public float pSliderV, dSliderV, nSliderV, aSliderV, depSliderV;
    
 
    
    public PatientGUI()
    {
            logInFrame.dispose();
            patFrame = new JFrame("Patient Access");         //Main Frame
            
            model = new DefaultListModel();                    //Model serves just to test the GUI aesthetics
            list1 = new JList(model);
            
            
            panel1 = new JPanel();
            panel1.setLayout(new GridLayout(14,1));               //Our write report panel
            
            pSlider = new JSlider(JSlider.HORIZONTAL,lowVal,highVal,defaultVal);   //All five of the sliders
            pSlider.setMajorTickSpacing(10);
            pSlider.setMinorTickSpacing(1);
            pSlider.setPaintTicks(true);
            pSlider.setPaintLabels(true);
            
            dSlider = new JSlider(JSlider.HORIZONTAL,lowVal,highVal,defaultVal);  
            dSlider.setMajorTickSpacing(10);
            dSlider.setMinorTickSpacing(1);
            dSlider.setPaintTicks(true);
            dSlider.setPaintLabels(true);
            
            nSlider = new JSlider(JSlider.HORIZONTAL,lowVal,highVal,defaultVal);  
            nSlider.setMajorTickSpacing(10);
            nSlider.setMinorTickSpacing(1);
            nSlider.setPaintTicks(true);
            nSlider.setPaintLabels(true);
            
            aSlider = new JSlider(JSlider.HORIZONTAL,lowVal,highVal,defaultVal);  
            aSlider.setMajorTickSpacing(10);
            aSlider.setMinorTickSpacing(1);
            aSlider.setPaintTicks(true);
            aSlider.setPaintLabels(true);
            
            depSlider = new JSlider(JSlider.HORIZONTAL,lowVal,highVal,defaultVal);  
            depSlider.setMajorTickSpacing(10);
            depSlider.setMinorTickSpacing(1);
            depSlider.setPaintTicks(true);
            depSlider.setPaintLabels(true);
            
            pain = new JLabel("Enter your current level of pain: ");
            drowsiness = new JLabel("Enter your current level of drowsiness: ");
            nausea = new JLabel("Enter your current level of nausea: ");
            anxiety = new JLabel("Enter your current level of anxiety: ");
            depression = new JLabel("Enter your current level of depression: ");
            submit = new JButton("Submit Report");
            confirm = new JLabel("");
            avg = new JLabel("");
            
            
            panel1.add(pain);
            panel1.add(pSlider);
            panel1.add(drowsiness);
            panel1.add(dSlider);
            panel1.add(nausea);
            panel1.add(nSlider);
            panel1.add(anxiety);
            panel1.add(aSlider);
            panel1.add(depression);
            panel1.add(depSlider);
            panel1.add(submit);
            panel1.add(confirm);
            panel1.add(avg);
            
            
            
            output = new JLabel();
            panel2 = new JPanel();                          //Our user info panel
            panel2.setLayout(new GridLayout(10,1));
            patName = new JLabel("Your first name is: " + patient.getFirstName());  //Patient comes from the main file
            JLabel patlName = new JLabel("Your last name is: " + patient.getLastName());
            patAge = new JLabel("Your current age is: " + patient.getAge());
            phoNum = new JLabel("Your phone number is: " + patient.getPhoneNumber());
            patHeight = new JLabel("Your current height is: " + patient.getHeight());
            patWeight = new JLabel("Your current weight is: " + patient.getWeight());
            edit = new JButton("Edit User Info");
            
            
            panel2.add(patName);
            panel2.add(patlName);
            panel2.add(patAge);
            panel2.add(patHeight);
            panel2.add(patWeight);
            panel2.add(phoNum);
            
           
            
            panel3 = new JPanel();                              //Our view report panel
            panel3.setLayout(new GridLayout(5,1));
            panel3.add(list1);
            viewR = new JButton("View Selected Report");
            panel3.add(viewR);
            
            panel4 = new JPanel();
            panel4.setLayout(new GridLayout(5,1));
            logout = new JButton("Logout");
            panel4.add(logout);
            
            tab1 = new JTabbedPane();
            tab1.add("Write Report", panel1);
            tab1.add("User Info", panel2);
            tab1.add("View Reports", panel3);
            tab1.add("Logout",panel4);
            
            tabPanel = new JPanel();
            tabPanel.setLayout(new GridLayout(1,1));
            tabPanel.add(tab1);
           
           patFrame.add(tabPanel);
           patFrame.setVisible(true);
           patFrame.setSize(600,600);
           patFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
           logout.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        logInFrame.setVisible(true);
                        patFrame.setVisible(false);
                    }
                   
               });
           
           edit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        editPatGUI();
                        patFrame.setVisible(false);
                    }
                   
               });
           
           submit.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)    //Honestly not really sure how I'm gonna make this work, 
                    {                                             //But after putting the report in a DefaultModelList, it did show up(albeit it didn't show the contents), so there's progress.
                        pSliderV = pSlider.getValue();
                        dSliderV = dSlider.getValue();
                        nSliderV = nSlider.getValue();
                        aSliderV = aSlider.getValue();
                        depSliderV = depSlider.getValue();
                        
                        Report report = new Report(pSliderV,dSliderV,nSliderV,aSliderV,depSliderV);
                        patient.addReport(report);
                        report.calcAve(pSliderV,dSliderV,nSliderV,aSliderV,depSliderV);
                        
                        patient.reports[repNum].setPain(pSliderV);
                        patient.reports[repNum].setSleepy(dSliderV);
                        patient.reports[repNum].setNausea(nSliderV);
                        patient.reports[repNum].setAnxiety(aSliderV);
                        patient.reports[repNum].setDepression(depSliderV);
                        
                        confirm.setText("Report number " + repNum + " successfully submitted!");
                        confirm.setForeground(Color.green);
                        avgVal = report.getAverage();
                        avg.setText("The average threshold for this report was: " + avgVal);
                        model.addElement(patient.reports);
                        
                        
                    }
                   
               });
           
           viewR.addActionListener(new ActionListener(){                           //This will be the pop up window that displays the selected report from the list.
                    public void actionPerformed(ActionEvent e)
                    {
                        final JFrame repFrame = new JFrame("Reports");
                        JPanel repPanel = new JPanel();
                        repPanel.setLayout(new GridLayout(9,1));
                        JLabel patName = new JLabel("Patient: " + patient.getFirstName() + " " + patient.getLastName());
                        JLabel patNum = new JLabel("Patient Phone: " + patient.getPhoneNumber());
                        JLabel repPain = new JLabel("Pain Threshold: "+patient.reports[repNum].getPain());
                        JLabel repSleepy = new JLabel("Drowsiness Threshold: " + patient.reports[repNum].getSleepy());
                        JLabel repNausea = new JLabel("Nausea Threshold: " + patient.reports[repNum].getNausea());
                        JLabel repAnx = new JLabel("Anxiety Threshold: " + patient.reports[repNum].getAnxiety());
                        JLabel repDep = new JLabel("Depression Threshold: " + patient.reports[repNum].getDepression());
                        JLabel thresAvg = new JLabel("Average Threshold was: " + avgVal);
                        JButton closeIt = new JButton("Close");
                        repPanel.add(patName);
                        repPanel.add(patNum);
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
                        repNum++;                                                                   //THIS VARIABLE IS THE ISSUE, IT KEEPS TRACK OF WHERE IN THE ARRAY WE ARE, I HAVE TO INCREMENT IT SOMEWHERE
                    closeIt.addActionListener(new ActionListener(){                                 //SO IT DOESNT KEEP OVERWRITING THE VALUE AT 0, BUT I DON'T KNOW WHERE I CAN INCREMENT IT WITHOUT FUCKING IT UP
                    public void actionPerformed(ActionEvent e)                                      //RIGHT NOW, I CAN ONLY VIEW THE LAST SUBMITTED REPORT ONCE BECAUSE IT INCREMENTS HERE, BUT IF IT DOESNT INCREMENT
                    {                                                                               //IT KEEPS OVERWRITING.
                        repFrame.setVisible(false);
                     }
                   
               });
                    
                    }
                   
               });
           
           
           
    }
    
    public static void editPatGUI()
  {
      final JFrame editFrame = new JFrame("Patient Access");
      GridBagConstraints c = new GridBagConstraints();
      final JPanel editPan = new JPanel(new GridBagLayout());
      
      final JTextField name = new JTextField(10);
      JTextField number = new JTextField(10);
      JTextField nHeight = new JTextField(10);
      JTextField nWeight = new JTextField(10);
      JTextField nAge = new JTextField(10);
      JButton submitR = new JButton("Submit Changes");
      JButton cancel = new JButton("Cancel");
      
      
      JLabel editName = new JLabel("Enter your edited name: ");
      JLabel editNum = new JLabel("Enter your new phone number: ");
      JLabel editHeight = new JLabel("Enter your adjusted height: ");
      JLabel editWeight = new JLabel("Enter your adjusted weight: ");
      JLabel editAge = new JLabel("Enter your age: ");
      
      
      
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
      editPan.add(editAge,c);
      c.gridx = 1;
      c.gridy = 5;
      editPan.add(nAge,c);
      c.gridx = 0;
      c.gridy = 6;
      editPan.add(cancel,c);
      c.gridx = 1;
      c.gridy = 6;
      editPan.add(submitR,c);
      
      
      editFrame.add(editPan);
      editFrame.setVisible(true);
      editFrame.setSize(600,600);
      editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //submitR.addActionListener(new editLabel());                         Tried doing the submit change button here, but it ended up being much too complicated to implement nicely.
     /* submitR.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                        firstName = name.getText();
                        user1.setFirstName(firstName);
                        //editFrame.setVisible(false);
                        JFrame test = new JFrame(firstName);
                        test.setVisible(true);
                        test.setSize(400,400);
                        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        patFrame.setVisible(true);
                        
                    }
                   
               });*/
      
      
      
      cancel.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e)
                    {
                      editFrame.dispose();
                      patFrame.setVisible(true);
                    }
                   
               });
  }
    
    
    
    public static void main(String[] args) {
        new PatientGUI();
    }
    
}

