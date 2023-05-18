import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterReceiver extends JFrame implements ActionListener{
	private JLabel ReceiverInfo, rName, rEmail, rContact, rAddress;
	private JTextField rNameField, rEmailField, rContactField;
	private JTextArea  rAddressField;
	private JScrollPane scrollpane;
	private JButton Register;
	static Receiver[] receiver;
	private int currentIndex;
	
	public RegisterReceiver() {
		Container pane=getContentPane();
		pane.setLayout(new BorderLayout());
		((JComponent)pane).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		setTitle("Register Receiver");
		setVisible(true);
		setSize(400, 300);
		
		ReceiverInfo=new JLabel("Receiver Info", JLabel.CENTER);
		rName=new JLabel("Name: ");
		rEmail=new JLabel("Email: ");
		rContact=new JLabel("Contact Number");
		rAddress=new JLabel("Address: ");
		rNameField=new JTextField(10);
		rEmailField=new JTextField(10);
		rContactField=new JTextField(10);
		rAddressField=new JTextArea(6,10);
		scrollpane = new JScrollPane(rAddressField);
		Register=new JButton("Register");
		
		Register.addActionListener(this);
		
		JPanel p1=new JPanel(new GridLayout(4, 2, 7, 7));
		p1.add(rName);
		p1.add(rNameField);
		p1.add(rEmail);
		p1.add(rEmailField);
		p1.add(rContact);
		p1.add(rContactField);
		p1.add(rAddress);
		p1.add(scrollpane);
		
		JPanel p2=new JPanel(new FlowLayout());
		p2.add(Register);
		
		pane.add(ReceiverInfo, BorderLayout.NORTH);
		pane.add(p1, BorderLayout.CENTER);
		pane.add(p2, BorderLayout.SOUTH);
		
		receiver=new Receiver[10];
		receiver[0] = new Receiver("Khor Yi Qian", "khor@gmail.com", "0152358375", "17, Jalan Pju 8/3B,\nBandar Damansara Perdana\n47820 Petaling Jaya\nSelangor");
		receiver[1] = new Receiver("Ahmad bin Shafiz", "ahmad@gmail.com", "0172439473", "252, Jalan Midah 7,\n Taman Midah\n30450 Ipoh\nPerak");
		receiver[2] = new Receiver("Shati a/p Nagulan", "shati@gmail.com", "0183057402", "22, Jalan Ss25/34,\nMayang Industrial Park\n47301 Petaling Jaya\nSelangor");
		receiver[3] = new Receiver("Tan Yan Yu", "tan@gmail.com", "0139275034", "2, Wisma Rampai Jln 34/26,\nTaman Sri Rampai\n53300 Wilayah Persekutuan\nKuala Lumpur");
		receiver[4] = new Receiver("Siti binti Hamzan", "siti@gmail.com", "0182230534", "No 9-1 Jalan Sp 1,\nTaman Semabok Perdana\n75050 Alor Gajah\nMelaka");
		receiver[5] = new Receiver("Kogulan a/l Sativaran", "kogulan@gmail.com", "0191213777", "No. 9-1 Jalan Sp 1,\nTaman Semabok Perdana\n40150 Shah Alam\nSelangor");
		currentIndex=6;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==Register) {
			String name=rNameField.getText();
			String email=rEmailField.getText();
			String contact=rContactField.getText();
			String address=rAddressField.getText();
			
			Receiver newReceiver=new Receiver(name, email, contact, address);
			
			receiver[currentIndex]=newReceiver;
			currentIndex++;
			
			if(currentIndex>=receiver.length) {
				Receiver[] receivers=new Receiver[receiver.length*2];
				System.arraycopy(receiver, 0, receivers, 0, receiver.length);
				receiver=receivers;
			}
			
			rNameField.setText("");
			rEmailField.setText("");
			rContactField.setText("");
			rAddressField.setText("");
			
		}
	}
	
	public static Receiver[] getArrayReceiver() {
		return receiver;
	}

}

