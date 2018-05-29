import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class RegistrationProgram {
	public static LoginView loginView;
	public static LoginModel loginModel;
	public static RegistrationView registrationView;
	public static RegistrationModel registrationModel;
	
	public RegistrationProgram() {
		LoginView loginView = new LoginView("RaceReg Login");
		loginView.setLoginListener(new LoginListener(loginView));
		loginView.setCreateAccountListener(new CreateAccountListener(loginView));
		
		loginModel = new LoginModel();
	}
	
	public void launchRegistrationView() {
		registrationView = new RegistrationView();
	}
	
	private class LoginListener implements ActionListener{
		LoginView loginView;
		
		public LoginListener(LoginView loginView) {
			super();
			this.loginView = loginView;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//JOptionPane.showMessageDialog(loginView, "Attempting Login", "RaceReg Login", JOptionPane.INFORMATION_MESSAGE);
			loginView.setLoadingLayout();
			
			
			
		}
		
	}
	
	private class CreateAccountListener implements ActionListener{
		LoginView loginView;
		
		public CreateAccountListener(LoginView loginView) {
			super();
			this.loginView = loginView;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//JOptionPane.showMessageDialog(loginView, "Creating Account...", "RaceReg Login", JOptionPane.INFORMATION_MESSAGE);
			loginView.setLoadingLayout();
			
			String firstname = JOptionPane.showInputDialog(loginView, "Enter your First Name:", "User Details", JOptionPane.QUESTION_MESSAGE);
			String lastname = JOptionPane.showInputDialog(loginView, "Enter your Last Name:", "User Details", JOptionPane.QUESTION_MESSAGE);
			String email = JOptionPane.showInputDialog(loginView, "Enter your email:", "User Details", JOptionPane.QUESTION_MESSAGE);
			String phonenumber = JOptionPane.showInputDialog(loginView, "Enter your phone number:", "User Details", JOptionPane.QUESTION_MESSAGE);
			
			boolean successful = loginModel.createUser(loginView.getUsernameText(), loginView.getPassword(), firstname, lastname, email, phonenumber);
			
			if(successful) {
				loginView.dispose();
				JOptionPane.showMessageDialog(null, "User Created.",
						"RaceReg Login", JOptionPane.INFORMATION_MESSAGE);				
			}
			else {
				loginView.restoreLayout();
				JOptionPane.showMessageDialog(null, "User couldn't be created. Try another username.",
						"RaceReg Login", JOptionPane.ERROR_MESSAGE);	
			}
		}
		
	}
}
