import java.security.NoSuchAlgorithmException;

public class LoginModel {
	MySQLManager manager;
	
	
	public LoginModel() {
		manager = MySQLManager.getInstance();
	}


	public boolean createUser(String username, String password, String firstname, String lastname, String email,
			String phonenumber) {
		boolean success = false;
		
		try {
			success = manager.insertNewUser(username, password, firstname, lastname, email, phonenumber);
		} catch (NoSuchAlgorithmException e) {
			System.err.println("COULDN'T SECURE PASSWORD. CLOSING.");
			System.exit(1);
		}
		
		return success;
	}


	public User login(String username, String password) {
		User user = null;
		
		try {
			user = manager.loginUser(username, password)
		} catch (NoSuchAlgorithmException e) {
			System.err.println("COULDN'T SECURE PASSWORD. CLOSING.");
			System.exit(1);
		}
		
		return user;
	}
}
