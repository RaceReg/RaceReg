
public class User {
	String username, password, firstname, lastname, email, phonenumber;
	
	public User() {
		this.username = "";
		this.password = "";
		this.firstname = "";
		this.lastname = "";
		this.email = "";
		this.phonenumber = "";
	}
	
	public User(String username, String password, String firstname, String lastname, String email, String phonenumber) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
	}
}
