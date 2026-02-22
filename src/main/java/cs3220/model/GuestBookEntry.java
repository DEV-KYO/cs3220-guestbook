package cs3220.model;

public class GuestBookEntry {
	private int id;
	private String name;
	private String message;
	
	public GuestBookEntry(int id, String name, String message) {
		this.id = id;
		this.name = name;
		this.message = message;
	}
	
	public int getId() {return id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getMessage() {return message;}
	public void setMessage(String message) {this.message = message;}
}
