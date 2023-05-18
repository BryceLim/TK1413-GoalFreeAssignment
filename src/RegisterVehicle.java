import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RegisterVehicle extends JFrame implements ActionListener{
    private JLabel title, type,model, plate,year,driver;
    private JRadioButton motorcycle, van;
    private JTextField modelField, plateField,yearField;
    private JButton register;
    private JComboBox<Driver> driverCB;
    private Driver[] Ddata;
    private static Vehicle[] vehicle;
    private int currentIndex;

    public RegisterVehicle(){
        Container pane=getContentPane();
        pane.setLayout(new BorderLayout(10,10));
        ((JComponent)pane).setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        
        setTitle("Vehicle Info");
        setResizable(false);
        setVisible(true);
        setSize(500,310);

        Ddata = RegisterDriver.getArrayDriver();
        
        title = new JLabel("Vehicle Info", JLabel.CENTER);
        type = new JLabel("Type :");
        model = new JLabel("Model :");
        plate = new JLabel("Registration Plate :");
        year = new JLabel("Year :");
        driver = new JLabel("Driver :");
        motorcycle = new JRadioButton("Motorcycle");
        van = new JRadioButton("Van");
        register = new JButton("Register");
        modelField = new JTextField(10);
        plateField = new JTextField(10);
        yearField = new JTextField(10);
        driverCB = new JComboBox<Driver>(Ddata);

        ButtonGroup type1 = new ButtonGroup();
        type1.add(motorcycle);
        type1.add(van);

        JPanel typeButton=new JPanel(new GridLayout(1,2));
        typeButton.add(motorcycle);
        typeButton.add(van);

        JPanel p1=new JPanel(new GridLayout(5,2,5,5));
        p1.add(type);
        p1.add(typeButton);
        p1.add(model);
        p1.add(modelField);
        p1.add(plate);
        p1.add(plateField);
        p1.add(year);
        p1.add(yearField);
        p1.add(driver);
        p1.add(driverCB);

        JPanel p2 = new JPanel(new FlowLayout());
        p2.add(register);

        pane.add(title,BorderLayout.NORTH);
        pane.add(p1,BorderLayout.CENTER);
        pane.add(p2, BorderLayout.SOUTH);

        vehicle = new Vehicle[10];
        vehicle[0] = new Vehicle("Motorcycle", "Yamaha EX5", "NKL 2352", "2013", Ddata[0]);
        vehicle[1] = new Vehicle("Motorcycle", "Honda RS150R", "WDC 9525", "2016", Ddata[1]);
        vehicle[2] = new Vehicle("Van", "Toyota Hiace", "WDC 9525", "2015", Ddata[2]);    
        currentIndex = 3;

        register.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        Object obj = e.getSource();
        Driver D;

        int indexD = driverCB.getSelectedIndex();

        D = Ddata[indexD];

        if(obj == register){
            String tp;
            String mdl;
            String regplate;
            String yr;
            Driver dvr;

            if(motorcycle.isSelected()){
                tp = "Motorcycle";
            }
            else if(van.isSelected()){
                tp = "Van";
            }
            else{
                tp = null;
            }

            mdl = modelField.getText();
            regplate = plateField.getText();
            yr = yearField.getText();
            dvr = D;
            
            Vehicle newVehicle = new Vehicle(tp, mdl, regplate, yr, dvr);
            vehicle[currentIndex] = newVehicle;
            currentIndex++;

            if(currentIndex >= vehicle.length){
                Vehicle[] newVehicles = new Vehicle[vehicle.length * 2];
                System.arraycopy(vehicle, 0, newVehicles, 0, vehicle.length);
                vehicle = newVehicles;
            }

            motorcycle.setSelected(false);
            van.setSelected(false);
            modelField.setText("");
            plateField.setText("");
            yearField.setText("");

        }
            
    }
    
    public static Vehicle[] getArrayVehicle() {
		return vehicle;
	}

}