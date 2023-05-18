import java.awt.*;
import javax.swing.*;

public class JobList extends JFrame{
	private JLabel driver,demail,dcontact,gender,license,vehicle,plate,date;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private Job[] job;
	private int i;


	
	public JobList() {

		job = AssignJobs.getArrayJob();

		Container pane=getContentPane();
		pane.setLayout(new GridLayout(job.length, 1,10,10));
		((JComponent)pane).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		setTitle("Job List");
		setResizable(true);
		setVisible(true);
		setSize(700,800);

		for(i=0; i < job.length; i++){
		
			driver = new JLabel("Driver : " + job[i].getDriverName());
			demail = new JLabel("Email : " + job[i].getDriverEmail());
			dcontact = new JLabel("Contact : " + job[i].getDriverContact());
			gender = new JLabel("Gender : " + job[i].getDriverGender());
			license = new JLabel("License : " + job[i].getDriverLicense());
			vehicle = new JLabel("Vehicle : " + job[i].getVehicle());
			plate = new JLabel("Registration Plate : " + job[i].getPlate());
			date = new JLabel("Shipment Date : " + job[i].getShippingDate());
			textArea=new JTextArea(40,20);
			scrollPane=new JScrollPane(textArea);
			textArea.setEditable(false);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

			textArea.append("Receiver  : " + job[i].getReceiverName() + "\n");
			textArea.append("Contact   : " + job[i].getReceiverContact() + "\n");
			textArea.append("Item      : " + job[i].getReceiverParcel() + "\n");
			textArea.append("Weight    : " + job[i].getReceiverParcelWeight() + "\n");
			textArea.append("Insurance : " + job[i].getReceiverInsurance() + "\n");
			textArea.append("Payment   : " + job[i].getReceiverPayment() + "\n");
			textArea.append("Remark    : " + job[i].getReceiverRemark() + "\n");
			textArea.append("Address   :\n" + job[i].getReceiverAddress() + "\n");
			
			
			
			JPanel p1 = new JPanel(new GridLayout(8,1));
			p1.add(driver);
			p1.add(demail);
			p1.add(dcontact);
			p1.add(gender);
			p1.add(license);
			p1.add(vehicle);
			p1.add(plate);
			p1.add(date);
		
			JPanel p2 = new JPanel(new GridLayout());
			p2.add(scrollPane);

			JPanel p3 = new JPanel(new GridLayout(1,2,5,5));
			p3.add(p1);
			p3.add(p2);

			pane.add(p3);
		}

	}

}