import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AssignJobs extends JFrame implements ActionListener {
    
    JLabel title, driverL, dateL, receiverL;
    private JComboBox<Parcel> receiverCB;
    private JComboBox<Vehicle> driverCB;
    private JTextField dateTF;
    private JButton confirmB;
    private Parcel[]  Pdata;
    private Vehicle[] Vdata;
    private static Job[] job = new Job[1];
    private static int currentIndex = 0;

    public AssignJobs(){

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        ((JComponent)pane).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        setTitle("Assign Jobs");
        setResizable(false);
        setVisible(true);
        setSize(500,300);
        
        Pdata = RegisterParcel.getArrayParcel();
        Vdata = RegisterVehicle.getArrayVehicle();

        title = new JLabel("Assign Jobs");
        driverL = new JLabel("Driver:");
        dateL = new JLabel("Shipment Date(DD/MM/YYYY):");
        receiverL = new JLabel("Receiver:");
        driverCB = new JComboBox<>(Vdata);
        dateTF = new JTextField();
        receiverCB = new JComboBox<>(Pdata);
        confirmB = new JButton("Confirm");

        JPanel titleP = new JPanel(new FlowLayout());
        titleP.add(title);

        JPanel centerP = new JPanel(new GridLayout(3,2,5,5));
        centerP.add(driverL);
        centerP.add(driverCB);
        centerP.add(receiverL);
        centerP.add(receiverCB);
        centerP.add(dateL);
        centerP.add(dateTF);

        JPanel confirmP = new JPanel(new FlowLayout());
        confirmP.add(confirmB);

        pane.add(titleP, BorderLayout.NORTH);
        pane.add(centerP, BorderLayout.CENTER);
        pane.add(confirmP, BorderLayout.SOUTH);

        receiverCB.addActionListener(this);
        driverCB.addActionListener(this);
        confirmB.addActionListener(this);

    }
    public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
        Parcel P;
        Vehicle V;
        String shipdate;

        int indexP = receiverCB.getSelectedIndex();
        int indexV = driverCB.getSelectedIndex();

        P = Pdata[indexP];
        V = Vdata[indexV];
		
		if(obj == confirmB){

            shipdate = dateTF.getText();

            Job newjob = new Job(P,V, shipdate);

            job[currentIndex] = newjob;
            currentIndex++;

            if(currentIndex >= job.length){
                Job[] newJobs = new Job[job.length + 1];
                System.arraycopy(job, 0, newJobs, 0, job.length);;
                job = newJobs;
            }

            dateTF.setText("");
          
        }
			
    }

    public static Job[] getArrayJob(){
        return job;
    }

    public static int getCurrentIndex(){
        return currentIndex;
    }
    
}