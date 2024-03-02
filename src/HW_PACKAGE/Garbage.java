package HW_PACKAGE;

public class Garbage {
	//I decided to have 3 features of the garbage object so that I will control the objects more efficiently.
	private String garbageName;
	private String garbageType;
	private String amount;
	
	public Garbage(String garbageName, String garbageType, String amount) {
		this.garbageName = garbageName;
		this.garbageType = garbageType;
		this.amount = amount;
	}
    
	@Override
	public String toString() {
		return this.garbageName;
				
	}
	//I wrote a getter method for the garbage type and the garbage amount
	public String getType() {
		return garbageType;
	}
	public String getAmount() {
		return amount;
		}
	@Override	
	public boolean equals(Object obj) {
		
		return (this==obj);
	}

}
