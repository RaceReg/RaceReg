
public class User {
	private int id;
	private String username, password, firstname, lastname, email, phonenumber;
	
	public User() {
		this.id = -1;
		this.username = "";
		this.password = "";
		this.firstname = "";
		this.lastname = "";
		this.email = "";
		this.phonenumber = "";
	}
	
	public User(String username, String password, String firstname, String lastname, String email, String phonenumber) {
		this.id = -1;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
	}
	
	public User(int id, String username, String password, String firstname, String lastname, String email, String phonenumber) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	
	public String getLastName() {
		return this.lastname;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPhoneNumber() {
		return this.phonenumber;
	}
	
	public String toString() {
		String toReturn = "";
		
		toReturn += this.id + ",";
		toReturn += this.username + ",";
		toReturn += this.password + ",";
		toReturn += this.firstname + ",";
		toReturn += this.lastname + ",";
		toReturn += this.email + ",";
		toReturn += this.phonenumber + ",";
		
		return toReturn;
	}
}
