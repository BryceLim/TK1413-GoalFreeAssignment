import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RegisterParcel extends JFrame implements ActionListener {
	private JLabel ParcelInfo, itemType, shippingFee, itemCategory, insurance, weight, payment, receiver, remarks;
	private String[] Pdata;
	private Receiver[] Rdata;
	private JComboBox<String> itemTypeData;
	private JComboBox<Receiver> receiverData;
	private JTextField shippingField, weightField;
	private JTextArea remarksArea;
	private JRadioButton parcelButton, documentButton, yesButton, noButton, paidButton, codButton;
	private JButton Register;
	static Parcel[] parcel;
	private int currentIndex;
	
	public RegisterParcel() {
		Container pane=getContentPane();
		pane.setLayout(new BorderLayout());
		((JComponent)pane).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		setTitle("Register Parcel");
		setVisible(true);
		setSize(800, 300);
		
		Pdata=new String[]{"Electronic product", "Household goods", "Clothing", "Accessories", "Cosmetic", "Food", "Other"};
		Rdata=RegisterReceiver.getArrayReceiver();
		
		ParcelInfo=new JLabel("Parcel Info", JLabel.CENTER);
		itemType=new JLabel("Item type: ");
		shippingFee=new JLabel("Shipping fee(RM): ");
		itemCategory=new JLabel("Item category: ");
		insurance=new JLabel("Insurance: ");
		weight=new JLabel("Weight(kg): ");
		payment=new JLabel("Payment Method: ");
		receiver=new JLabel("Receiver: ");
		remarks=new JLabel("Remarks: ");
		itemTypeData=new JComboBox<>(Pdata);
		receiverData=new JComboBox<>(Rdata);
		shippingField=new JTextField(10);
		weightField=new JTextField(10);
		remarksArea=new JTextArea(3,20);
		parcelButton=new JRadioButton("Parcel");
		documentButton=new JRadioButton("Document");
		yesButton=new JRadioButton("Yes");
		noButton=new JRadioButton("No");
		paidButton=new JRadioButton("Paid");
		codButton=new JRadioButton("COD");
		Register=new JButton("Register");
		
		Register.addActionListener(this);
		
		ButtonGroup itCat=new ButtonGroup();
		itCat.add(parcelButton);
		itCat.add(documentButton);
		
		ButtonGroup insrce=new ButtonGroup();
		insrce.add(yesButton);
		insrce.add(noButton);
		
		ButtonGroup paymt=new ButtonGroup();
		paymt.add(paidButton);
		paymt.add(codButton);
		
		JPanel b1=new JPanel(new GridLayout(1,2));
		b1.add(parcelButton);
		b1.add(documentButton);
		
		JPanel b2=new JPanel(new GridLayout(1,2));
		b2.add(yesButton);
		b2.add(noButton);
		
		JPanel b3=new JPanel(new GridLayout(1,2));
		b3.add(paidButton);
		b3.add(codButton);
		
		JPanel p1=new JPanel(new GridLayout(4,2,5,5));
		p1.add(itemType);
		p1.add(itemTypeData);
		p1.add(itemCategory);
		p1.add(b1);
		p1.add(weight);
		p1.add(weightField);
		p1.add(shippingFee);
		p1.add(shippingField);
		
		JPanel p2=new JPanel(new GridLayout(4,2,5,5));
		p2.add(receiver);
		p2.add(receiverData);
		p2.add(remarks);
		p2.add(remarksArea);
		p2.add(insurance);
		p2.add(b2);
		p2.add(payment);
		p2.add(b3);
		
		JPanel a1=new JPanel(new BorderLayout());
		a1.add(p1, BorderLayout.WEST);
		a1.add(p2, BorderLayout.EAST);
		
		JPanel a2=new JPanel(new FlowLayout());
		a2.add(Register);
		
		pane.add(ParcelInfo, BorderLayout.NORTH);
		pane.add(a1, BorderLayout.CENTER);
		pane.add(a2, BorderLayout.SOUTH);
		
		parcel=new Parcel[10];
		currentIndex=0;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		Receiver rec;

		int indexR = receiverData.getSelectedIndex();

        rec = Rdata[indexR];
		
		if(obj==Register) {
			int indexT=itemTypeData.getSelectedIndex();
			String type = Pdata[indexT];
			
			String cat = "";
			if(parcelButton.isSelected()) {
				cat = "Parcel";
			}
			else if(documentButton.isSelected()) {
				cat = "Document";
			}
			
			Boolean ins=false;
			if(yesButton.isSelected()) {
				ins=true;
			}
			else if(noButton.isSelected()) {
				ins=false;
			}
			
			String wg=weightField.getText();
			
			String pay="";
			if(paidButton.isSelected()) {
				pay="Paid";
			}
			else if(codButton.isSelected()) {
				pay="COD";
			}
			
			String ship=shippingField.getText();

			String rem=remarksArea.getText();


			
			Parcel newParcel=new Parcel(type, cat, wg, pay, ship, rem, ins, rec);
			
			parcel[currentIndex]=newParcel;
			currentIndex++;
			
			if(currentIndex>=parcel.length) {
				Parcel[] parcels=new Parcel[parcel.length*2];
				System.arraycopy(parcel, 0, parcels, 0, parcel.length);
				parcel=parcels;
			}
			
			weightField.setText("");
			shippingField.setText("");
			remarksArea.setText("");
			
		}
	}

	public static Parcel[] getArrayParcel() {
		return parcel;
	}
	
}