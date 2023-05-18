public class Receiver extends Person{
	private String rContact;
	private String rAddress;
	
	public Receiver(String nm, String eml, String ct, String adrs) {
        super(nm, eml);
		rContact=ct;
		rAddress=adrs;
	}
	
	public String getContact() {
		return rContact;
	}
	
	public String getAddress() {
		return rAddress;
	}
	
	public String toString() {
		return getName();
	}
}