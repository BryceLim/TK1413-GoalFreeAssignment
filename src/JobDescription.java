import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

public class JobDescription extends JFrame{
	private JLabel title,driver,dcontact,vehicle,plate,date;//receiver,rcontact,address,parcel,remark,insurance,payment method;
	private JTextArea textArea;
	private JScrollPane scrollPane;


	
	public JobDescription(Job job) {

		Container pane=getContentPane();
		pane.setLayout(new BorderLayout());
		((JComponent)pane).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		setTitle("Job Description");
		setResizable(false);
		setVisible(true);
		setSize(500,310);
		
		title = new JLabel("Job Description",JLabel.CENTER);
		driver = new JLabel("Driver : " + job.getDriverName());
		dcontact = new JLabel("Contact : " + job.getDriverContact());
		vehicle = new JLabel("Vehicle : " + job.getVehicle());
		plate = new JLabel("Registration Plate : " + job.getPlate());
		date = new JLabel("Shipment Date : " + job.getShippingDate());
		textArea=new JTextArea(20,20);
		scrollPane=new JScrollPane(textArea);
		textArea.setEditable(false);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		textArea.append("Receiver  : " + job.getReceiverName() + "\n");
		textArea.append("Contact   : " + job.getReceiverContact() + "\n");
		textArea.append("Item      : " + job.getReceiverParcel() + "\n");
		textArea.append("Weight    : " + job.getReceiverParcel() + "\n");
		textArea.append("Insurance : " + job.getReceiverInsurance() + "\n");
		textArea.append("Payment   : " + job.getReceiverPayment() + "\n");
		textArea.append("Remark    : " + job.getReceiverRemark() + "\n");
		textArea.append("Address   :\n" + job.getReceiverAddress() + "\n");
		
		
		
		JPanel p1 = new JPanel(new GridLayout(5,2,5,5));
		p1.add(driver);
		p1.add(dcontact);
		p1.add(vehicle);
		p1.add(plate);
		p1.add(date);
	
		JPanel p2 = new JPanel(new GridLayout());
		p2.add(scrollPane);
		
		pane.add(title, BorderLayout.NORTH);
		pane.add(p1, BorderLayout.WEST);
		pane.add(p2, BorderLayout.EAST);

	}

}