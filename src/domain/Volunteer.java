package domain;

public class Volunteer extends AbsStaffMember {
	private String description;

	public Volunteer(String name, String address, String phone) throws Exception {
		super(name, address, phone);
		
		this.description = description;
	}

	
	@Override
	public void pay() {
		description = "Volunteers dont get paid.";	
	}
	
	@Override
	public String toString() {
		return super.toString() + "[description=" + description + "]";
	}
	
}
