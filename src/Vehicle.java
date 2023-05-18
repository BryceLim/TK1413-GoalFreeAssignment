public class Vehicle {
    
	private String vType;
	private String vModel;
	private String vPlate;
	private String vYear;
	private Driver vDriver;
	
	public Vehicle(String tp, String mdl, String pt, String yr, Driver dvr) {
		vType=tp;
		vModel=mdl;
		vPlate=pt;
		vYear=yr;
		vDriver=dvr;
	}
	
	public String getType() {
		return vType;
	}
	
	public String getModel() {
		return vModel;
	}
	
	public String getPlate() {
		return vPlate;
	}
	
	public String getYear() {
		return vYear;
	}

	public Driver getDriver(){
		return vDriver;
	}

	public String getDriverName(){
		return vDriver.getName();
	}

	public String getDriverEmail(){
		return vDriver.getEmail();
	}

	public String getDriverContact(){
		return vDriver.getContact();
	}
	
	public String getDriverAge(){
		return vDriver.getAge();
	}

	public String getDriverGender(){
		return vDriver.getGender();
	}

	public String getDriverLicense(){
		return vDriver.getLicense();
	}

	public String toString() {
		return getDriverName();
	}
}