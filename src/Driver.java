public class Driver extends Person{

	private String age;
	private String gender;
	private String license;
	
	public Driver(String dn,String de,String dc,String dage,String dgender,String lic) {
		super(dn,de, dc);
		age = dage;
		gender = dgender;
		license = lic;
	}
	
	public String getAge() {
		return age;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getLicense() {
		return license;
	}
	
	public String toString() {
		return getName() + "(" + getLicense() + ")";
	}

}