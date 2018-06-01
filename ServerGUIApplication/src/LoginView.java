import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginView extends JFrame{
	JLabel titleLabel, usernameLabel, passwordLabel;
	JTextArea usernameTextArea;
	JPasswordField passwordField;
	JButton loginButton, createAccountButton;
	
	
	public LoginView(String title) {
		super(title);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setDefaultLayout();
		
		this.setVisible(true);
	}
	
	public void setDefaultLayout() {
		//this.removeAll();
		//this.revalidate();
		//this.repaint();
		
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		this.setBounds(50, 50, 150, 200);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		titleLabel = new JLabel("RaceReg Login");
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		this.add(titleLabel, c);
		
		usernameLabel = new JLabel("Username:");
		c.weighty = 0.1;
		c.gridx = 0;
		c.gridy = 1;
		this.add(usernameLabel, c);
		
		usernameTextArea = new JTextArea();
		//usernameTextArea.
		c.gridx = 0;
		c.gridy = 2;
		this.add(usernameTextArea, c);
		
		passwordLabel = new JLabel("Password:");
		c.gridx = 0;
		c.gridy = 3;
		this.add(passwordLabel, c);
		
		passwordField = new JPasswordField();
		//passwordTextArea.
		c.gridx = 0;
		c.gridy = 4;
		this.add(passwordField, c);
		
		loginButton = new JButton("LOGIN");
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 5;
		this.add(loginButton, c);
		
		createAccountButton = new JButton("Create Account");
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 6;
		this.add(createAccountButton, c);
	}
	
	public void restoreLayout() {
		titleLabel.setText("RaceReg Login");
		usernameLabel.setVisible(true);
		passwordLabel.setVisible(true);
		usernameTextArea.setText("");
		usernameTextArea.setVisible(true);
		passwordField.setText("");
		passwordField.setVisible(true);
		loginButton.setVisible(true);
		createAccountButton.setVisible(true);
	}
	
	public void setLoadingLayout() {
		titleLabel.setText("Trying...");
		usernameLabel.setVisible(false);
		passwordLabel.setVisible(false);
		usernameTextArea.setVisible(false);
		passwordField.setVisible(false);
		loginButton.setVisible(false);
		createAccountButton.setVisible(false);
	}
	
	public String getUsernameText() {
		return usernameTextArea.getText();
	}
	
	public String getPassword() {
		String password = "";
		char[] charpassword = passwordField.getPassword();
		
		for(int i = 0; i < charpassword.length; i++) {
			password += charpassword[i];
		}
		
		return password;
	}
	
	public void displayMessage(String message, String title) {
		JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void setLoginListener(ActionListener listener) {
		loginButton.addActionListener(listener);		
	}
	
	public void setCreateAccountListener(ActionListener listener) {
		createAccountButton.addActionListener(listener);		
	}

}
