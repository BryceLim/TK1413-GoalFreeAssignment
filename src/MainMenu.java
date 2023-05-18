import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame implements ActionListener{

    JLabel title;
    JButton recBt, parBt, driBt, vehBt, jobBt;

    public MainMenu(){

        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4,1,10,10));
        ((JComponent)pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        title = new JLabel("TKL EXPRESS", JLabel.CENTER);
        title.setFont(new Font("Verdana", Font.PLAIN, 40));
        recBt = new JButton("Register Receiver");
        parBt = new JButton("Register Parcel");
        driBt = new JButton("Register Driver");
        vehBt = new JButton("Register Vehicle");
        jobBt = new JButton("Assign Jobs");
        jobBt.setSize(0,0);
        
        recBt.addActionListener(this);
        parBt.addActionListener(this);
        driBt.addActionListener(this);
        vehBt.addActionListener(this);
        jobBt.addActionListener(this);

        JPanel p1 = new JPanel(new GridLayout(1,2,10,10));
        p1.add(recBt);
        p1.add(parBt);

        JPanel p2 = new JPanel(new GridLayout(1,2,10,10));
        p2.add(driBt);
        p2.add(vehBt);

        JPanel p3 = new JPanel(new GridLayout(1,1,10,10));
        p3.add(jobBt);

        pane.add(title);
        pane.add(p1);
        pane.add(p2);
        pane.add(p3);
    }
    
    public void actionPerformed(ActionEvent e) {
    	Object obj=e.getSource();
    	if(obj==recBt) {
    		new RegisterReceiver();
    	}
    	if(obj==parBt) {
    		new RegisterParcel();
    	}
    	if(obj==driBt) {
    		new RegisterDriver();
    	}
    	if(obj==vehBt) {
    		new RegisterVehicle();
    	}
    	if(obj==jobBt) {
    		new AssignJobs();
    	}
   	 
    }

    public static void main(String[] args){
        MainMenu menu = new MainMenu();
        menu.setTitle("Main Menu");
        menu.setResizable(false);
        menu.setVisible(true);
        menu.setSize(420, 400);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
}