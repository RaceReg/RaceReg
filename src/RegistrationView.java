import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class RegistrationView extends JFrame {

	public RegistrationView() {
		super("RaceReg Registration & Meet Management");
		
		setDefaultLayout();
		
		this.setVisible(true);
	}
	
	public void setDefaultLayout() {
		GridBagLayout gbl = new GridBagLayout();
		this.setLayout(gbl);
		this.setBounds(50, 50, 500, 1000);
		
		
		JMenuBar menuBar;
		JMenu fileMenu;
		JMenuItem exitMenuItem;
		
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		exitMenuItem = new JMenuItem("Exit");
		fileMenu.add(exitMenuItem);
		menuBar.add(fileMenu);
		this.add(menuBar);

		
		
		
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		JLabel titleLabel = new JLabel("RaceReg Registration & Meet Management is under developement. Features are coming soon!");
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		this.add(titleLabel, c);
		
		
	}
}
