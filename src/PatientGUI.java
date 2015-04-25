import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Jeremy
 */

//This is the GUI the patient will see upon a successful login.

public class PatientGUI {
    private JLabel pain, drowsiness, nausea, anxiety, depression;
    private JLabel patName, patAge, patStatus, phoNum, medList;
    private JPanel panel1, panel2, panel3, tabPanel;
    private JTabbedPane tab1;
    private JSlider pSlider, dSlider, nSlider, aSlider, depSlider;
    private JFrame patFrame;
    private JList list1;
    private JButton submit;
    private DefaultListModel model;
    private final int lowVal = 0,highVal = 10, defaultVal = 5; 
    
    public PatientGUI()
    {
            patFrame = new JFrame("Patient Access");         //Main Frame
            
            model = new DefaultListModel();                    //Model serves just to test the GUI aesthetics
            model.addElement("Hypothetical Report 1");
            model.addElement("Hypothetical Report 2");
            list1 = new JList(model);
            
            panel1 = new JPanel();
            panel1.setLayout(new GridLayout(11,1));               //Our write report panel
            
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
            
            panel2 = new JPanel();                          //Our user info panel
            panel2.setLayout(new GridLayout(10,1));
            patName = new JLabel("Your name: ");
            patAge = new JLabel("Your current age: ");
            phoNum = new JLabel("Your phone number is: ");
            patStatus = new JLabel("Your current affliction is: ");
            medList = new JLabel("Your current medications are: ");
            
            panel2.add(patName);
            panel2.add(patAge);
            panel2.add(phoNum);
            panel2.add(patStatus);
            panel2.add(medList);
            
            panel3 = new JPanel();                              //Our view report panel
            panel3.setLayout(new GridLayout(1,1));
            panel3.add(list1);
            
            tab1 = new JTabbedPane();
            tab1.add("Write Report", panel1);
            tab1.add("User Info", panel2);
            tab1.add("View Reports", panel3);
            
            tabPanel = new JPanel();
            tabPanel.setLayout(new GridLayout(1,1));
            tabPanel.add(tab1);
    
           patFrame.add(tabPanel);
           patFrame.setVisible(true);
           patFrame.setSize(600,600);
           patFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new PatientGUI();
    }
    
}
