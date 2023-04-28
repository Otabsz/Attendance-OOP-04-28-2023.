import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Librarian_Login  {
	// make it public to access to other frame that calling out
	public JFrame frmLibrarianLogin;
	private JTextField UsernameField;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Librarian_Login window = new Librarian_Login();
					window.frmLibrarianLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Librarian_Login() {
		initialize();
	}

	private void initialize() {
		// Create a new JFrame for librarian login
		frmLibrarianLogin = new JFrame();
		// Set the background color of the JFrame to white
		frmLibrarianLogin.getContentPane().setBackground(Color.WHITE);
		// Set the icon image of the JFrame
		frmLibrarianLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\BATO\\Downloads\\pngegg (1).png"));
		// Set the title of the JFrame
		frmLibrarianLogin.setTitle("LIBRARIAN LOGIN");
		// Set the position and size of the JFrame
		frmLibrarianLogin.setBounds(100, 100, 450, 300);
		// Set the default close operation of the JFrame
		frmLibrarianLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create a label for username
		JLabel lblUsername = new JLabel("USERNAME:");
		// Create a label for password
		JLabel lblPassword = new JLabel("PASSWORD:");
		// Create a text field for username
		UsernameField = new JTextField();
		UsernameField.setColumns(10);
		// Create a password field for password
		passwordField = new JPasswordField();
		// Create a button for login and add an action listener
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String username = UsernameField.getText();
			        String password = new String(passwordField.getPassword());
			     // If correct, dispose of the login window and show the main library system window
				if (username.equals("Librarian_01") && password.equals("LibOne") ||
		                   username.equals("Librarian_02") && password.equals("LibTwo") ||
		                   username.equals("Librarian_03") && password.equals("LibThree")) {
		           
					frmLibrarianLogin.dispose();
					JOptionPane.showMessageDialog(null,"SUCCESSFULLY LOGIN");
					NU_Library_System nu_login_system = new NU_Library_System();
					nu_login_system.frame.setVisible(true);
					// If the username or password is blank, show an error message    
		        } else if (username.equals("") || password.equals("")) {
		            JOptionPane.showMessageDialog(null, "Please enter both username and password.",
		                                          "Missing Information", JOptionPane.ERROR_MESSAGE);
		         // If the username starts with "Librarian" but the password is incorrect, show an error message
		        } else if ( username.startsWith("Librarian")) {
		            JOptionPane.showMessageDialog(null, "Incorrect password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
		         // If the password starts with "Lib" but the username is incorrect, show an error message
		        } else if ( password.startsWith("Lib")) {
		            JOptionPane.showMessageDialog(null, "Incorrect username.", "Login Failed", JOptionPane.ERROR_MESSAGE);
		         // If both the username and password are incorrect, show an error message
		        } else {
		            JOptionPane.showMessageDialog(null, "Incorrect username and password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		// Creates a new JLabel with text "LIBRARIAN"
		JLabel lblLibrarian = new JLabel("LIBRARIAN");
		lblLibrarian.setFont(new Font("Tahoma", Font.BOLD, 35));
		GroupLayout groupLayout = new GroupLayout(frmLibrarianLogin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(lblUsername))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField)
						.addComponent(UsernameField, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
					.addGap(77))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(116)
					.addComponent(lblLibrarian, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(116))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(174)
					.addComponent(LoginButton, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
					.addGap(139))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblLibrarian)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername)
						.addComponent(UsernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(LoginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(38))
		);
		frmLibrarianLogin.getContentPane().setLayout(groupLayout);
	}

}
