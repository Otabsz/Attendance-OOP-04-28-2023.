import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class Admin_Login  {
	// make it public to access to other frame that calling out
	public JFrame frmAdmin;
	private JTextField UsernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login window = new Admin_Login();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// This method initializes the graphical user interface for the admin panel. It sets up a JFrame with a white background,
		frmAdmin = new JFrame();
		frmAdmin.getContentPane().setBackground(Color.WHITE);
		frmAdmin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\BATO\\Downloads\\pngegg.png"));
		frmAdmin.setTitle("ADMIN");
		frmAdmin.setBounds(100, 100, 450, 300);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// an icon image, and a title of "ADMIN". It also creates two JLabels for the "USERNAME" and "PASSWORD" fields, and two
		JLabel lblUsername = new JLabel("USERNAME:");
		JLabel lblPassword = new JLabel("PASSWORD:");
		// text fields for entering the username and password.
		UsernameField = new JTextField();
		UsernameField.setColumns(10);
		passwordField = new JPasswordField();
		// Create a new JButton object and set the text to "Login"
		JButton LoginButton = new JButton("Login");
		// Add an ActionListener to the LoginButton object
		LoginButton.addActionListener(new ActionListener() {
			// Override the actionPerformed method of the ActionListener interface
			public void actionPerformed(ActionEvent e) { 
				// Get the text entered in the UsernameField and convert it to a String
				String username = UsernameField.getText();
				// Get the password entered in the passwordField and convert it to a String
		        String password = new String(passwordField.getPassword());
		        // Check if the username and password entered are correct for any of the admin accounts
		        if (username.equals("Admin_01") && password.equals("AdminOne") ||
		            username.equals("Admin_02") && password.equals("AdminTwo") ||
		            username.equals("Admin_03") && password.equals("AdminThree")) {
		        	frmAdmin.dispose(); 
		        	//To move to another, Welcome frame
		        	Welcome welcome = new Welcome();
		        	welcome.frmWelcome.setVisible(true);
		          
		         // If the credentials are correct, create a new Admin_Login object and dispose of the current JFrame
		        } else if (username.equals("") || password.equals("")) {
		            JOptionPane.showMessageDialog(null, "Please enter both username and password.",
		                                          "Missing Information", JOptionPane.ERROR_MESSAGE);
		         // Check if the username entered starts with "Admin"
		        } else if (username.startsWith("Admin")) {
		        	// If the username starts with "Admin", display an error message saying the password is incorrect	
		            JOptionPane.showMessageDialog(null, "Incorrect password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
		         // Check if the password entered starts with "Admin"
		        } else if (password.startsWith("Admin")) {
		        	 // If the password starts with "Admin", display an error message saying the username is incorrect
		            JOptionPane.showMessageDialog(null, "Incorrect Username.", "Login Failed", JOptionPane.ERROR_MESSAGE);
		         // If none of the above conditions are met, display an error message saying the username and password are incorrect
		        } else {
		            JOptionPane.showMessageDialog(null, "Incorrect username and password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
		        }
		    }
			
			
		});
		//this is for the title Admin i use Jlabel for the name
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 35));
		// this is line separtor Below
		JSeparator separatorBelow = new JSeparator();
		separatorBelow.setBackground(Color.BLACK);
		// this is line sepator Top
		JSeparator separatorTop = new JSeparator();
		separatorTop.setBackground(Color.BLACK);
		
		
		GroupLayout groupLayout = new GroupLayout(frmAdmin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(159)
					.addComponent(lblAdmin, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
					.addGap(131))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separatorBelow, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(separatorTop, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(lblUsername)
							.addGap(21)
							.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(166)
							.addComponent(LoginButton, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(lblPassword)
							.addGap(18)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(lblAdmin)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separatorTop, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblUsername))
						.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3)
							.addComponent(lblPassword))
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(separatorBelow, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(LoginButton))
		);
		frmAdmin.getContentPane().setLayout(groupLayout);
	}
}
