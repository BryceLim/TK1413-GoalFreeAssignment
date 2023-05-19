public class Receiver extends Person{
	private String rAddress;
	
	public Receiver(String nm, String eml, String ct, String adrs) {
        super(nm, eml, ct);
		rAddress=adrs;
	}
	
	public String getAddress() {
		return rAddress;
	}
	
	public String toString() {
		return getName();
	}
}