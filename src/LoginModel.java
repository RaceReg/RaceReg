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
}
