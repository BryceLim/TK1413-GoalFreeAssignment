public class Driver extends Person{

	private String dContact;
	private String age;
	private String gender;
	private String license;
	
	public Driver(String dn,String de,String cd,String dage,String dgender,String ls) {
		super(dn,de);
		dContact = cd;
		age = dage;
		gender = dgender;
		license = ls;
	}
	
	public String getContact() {
		return dContact;
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