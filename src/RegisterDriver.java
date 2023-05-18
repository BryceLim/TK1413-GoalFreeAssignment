import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterDriver extends JFrame implements ActionListener{
    
    JLabel title, nameL, emailL, contactL, ageL, genderL, licenseL;
    JTextField nameTF, emailTF, contactTF, ageTF;
    JRadioButton maleRB, femaleRB;
    ButtonGroup genderBG;
    JCheckBox BCB, DCB;
    JButton registerB;
    static Driver[] driver;
    int currentIndex;

    public RegisterDriver(){

        Container pane = getContentPane();
        pane.setLayout(new FlowLayout());
        ((JComponent)pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        setTitle("Register Driver");
        setResizable(false);
        setVisible(true);
        setSize(500, 310);

        title = new JLabel("Driver Info");
        nameL = new JLabel("Name :");
        nameTF = new JTextField(20);
        emailL = new JLabel("Email :");
        emailTF = new JTextField(20);
        contactL = new JLabel("Contact Number :");
        contactTF = new JTextField(20);
        ageL = new JLabel("Age :");
        ageTF = new JTextField(20);
        genderL = new JLabel("Gender :");
        maleRB = new JRadioButton("Male");
        femaleRB = new JRadioButton("Female");
        genderBG = new ButtonGroup();
        licenseL = new JLabel("License :");
        BCB = new JCheckBox("B2/B");
        DCB = new JCheckBox("D");
        registerB = new JButton("Register");
        
        registerB.addActionListener(this);
        maleRB.addActionListener(this);
        femaleRB.addActionListener(this);
        BCB.addActionListener(this);
        DCB.addActionListener(this);

        genderBG.add(maleRB);
        genderBG.add(femaleRB);

        JPanel titleP = new JPanel(new FlowLayout());
        titleP.add(title);

        JPanel genderP1 = new JPanel(new GridLayout(1,2));
        genderP1.add(maleRB);
        genderP1.add(femaleRB);

        JPanel licenseP1 = new JPanel(new GridLayout(1,2));
        licenseP1.add(BCB);
        licenseP1.add(DCB);

        JPanel combineP = new JPanel(new GridLayout(6,2,5,5));
        combineP.add(nameL);
        combineP.add(nameTF);
        combineP.add(emailL);
        combineP.add(emailTF);
        combineP.add(contactL);
        combineP.add(contactTF);
        combineP.add(ageL);
        combineP.add(ageTF);
        combineP.add(genderL);
        combineP.add(genderP1);
        combineP.add(licenseL);
        combineP.add(licenseP1);

        JPanel registerP = new JPanel(new FlowLayout());
        registerP.add(registerB);

        pane.add(titleP);
        pane.add(combineP);
        pane.add(registerP);

        driver = new Driver[10];
        driver[0] = new Driver("Ali bin Abu", "ali@gmail.com", "0124758395", "26", "Male", "B2/B & D");
        driver[1] = new Driver("Pavithran", "pavi@gmail.com", "0163859374", "31", "Male", "B2/B & D");
        driver[2] = new Driver("Wong Ah Miao", "miao@gmail.com", "0139567293", "25", "Female", "D");
        driver[3] = new Driver("Hafendi bin Abu Bakar", "hafendi@gmail.com", "0198172334", "27", "Male", "B2/B & D");
        driver[4] = new Driver("Benvinder Singh", "ben@gmail.com", "0148726633", "21", "Male", "D");
        driver[5] = new Driver("Lee Jun Jin", "ljj@gmail.com", "01123588234", "40", "Male", "B2/B");   
        currentIndex = 6;
		

    }

    public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==registerB) {
			String name=nameTF.getText();
			String email=emailTF.getText();
			String contact=contactTF.getText();
			String age=ageTF.getText();
            String license;
            String gender;

			if(maleRB.isSelected()){
                gender = "Male";
            }
            else if(femaleRB.isSelected()){
                gender = "Female";
            }
            else{
                gender = "Unknown";
            }

            if(BCB.isSelected() && DCB.isSelected()){
                license = "B2/B & D";
            }
            else if(BCB.isSelected() && !DCB.isSelected()){
                license = "B2/B";
            }
            else if(!BCB.isSelected() && DCB.isSelected()){
                license = "D";
            }
            else{
                license = "No license";
            }

			Driver newDriver=new Driver(name, email, contact, age, gender, license);
			
			driver[currentIndex]=newDriver;
			currentIndex++;
			
			if(currentIndex>=driver.length) {
				Driver[] drivers=new Driver[driver.length*2];
				System.arraycopy(driver, 0, drivers, 0, driver.length);
				driver=drivers;
			}
			
			nameTF.setText("");
			emailTF.setText("");
			contactTF.setText("");
			ageTF.setText("");
            maleRB.setSelected(false);
            femaleRB.setSelected(false);
            BCB.setSelected(false);
            DCB.setSelected(false);
			
		}
	}

    public static Driver[] getArrayDriver(){
        return driver;
    }

}