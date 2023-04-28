import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Library_Management {
	// make it public to access to other frame that calling out
	 public JFrame LibraryManagement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Library_Management window = new Library_Management();
					window.LibraryManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Library_Management() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Initialize the JFrame and set its size and close operation
		//Create the main JFrame and set its properties
		LibraryManagement = new JFrame();
		LibraryManagement.setBounds(100, 100, 450, 300);
		LibraryManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Create two JPanels, one for Admin login and one for Librarian login
		JPanel Admin_Panel = new JPanel();
		JPanel Libarian_Panel = new JPanel();
		// Use GroupLayout to arrange the components in the JFrame
		GroupLayout groupLayout = new GroupLayout(LibraryManagement.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(Admin_Panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
				.addComponent(Libarian_Panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(Admin_Panel, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
					.addGap(1)
					.addComponent(Libarian_Panel, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
					.addGap(0))
		);
		// When the user clicks on the Librarian login button 
		JButton Librarian_Button = new JButton("LIBRARIAN LOGIN");
		Librarian_Button.addActionListener(new ActionListener() {
			// When the user clicks on the Librarian login button, dispose the current JFrame and open a new JFrame for Librarian login
			public void actionPerformed(ActionEvent e) {
				// If the user clicks yes, it opens a new window for Librarian login.
				Component frmLibrarianLogin = null;
				if(JOptionPane.showConfirmDialog(frmLibrarianLogin,"CONTINUE TO LIBRARIAN LOGIN?","Librarian Login",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
				LibraryManagement.dispose();
				Librarian_Login librarian_login = new Librarian_Login();
				librarian_login.frmLibrarianLogin.setVisible(true);
				}
			}
		});
		GroupLayout gl_Libarian_Panel = new GroupLayout(Libarian_Panel);
		gl_Libarian_Panel.setHorizontalGroup(
			gl_Libarian_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Libarian_Panel.createSequentialGroup()
					.addGap(150)
					.addComponent(Librarian_Button, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
					.addGap(150))
		);
		gl_Libarian_Panel.setVerticalGroup(
			gl_Libarian_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Libarian_Panel.createSequentialGroup()
					.addGap(50)
					.addComponent(Librarian_Button, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
					.addGap(50))
		);
		Libarian_Panel.setLayout(gl_Libarian_Panel);
		// When the user clicks on the Admin login button, it opens a confirmation dialog box to confirm if the user wants to continue to Admin login. 
		
		JButton Admin_Button = new JButton("ADMIN LOGIN");
		Admin_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   
				// If the user clicks yes, it opens a new window for Admin login.
				Component frmAdmin = null;
				if(JOptionPane.showConfirmDialog(frmAdmin,"CONTINUE TO ADMIN LOGIN?","Admin Login",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
				LibraryManagement.dispose();
				Admin_Login admin_Login = new Admin_Login();
				admin_Login.frmAdmin.setVisible(true);
				}
				}
		});
		GroupLayout gl_Admin_Panel = new GroupLayout(Admin_Panel);
		gl_Admin_Panel.setHorizontalGroup(
			gl_Admin_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Admin_Panel.createSequentialGroup()
					.addGap(150)
					.addComponent(Admin_Button, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
					.addGap(150))
		);
		gl_Admin_Panel.setVerticalGroup(
			gl_Admin_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Admin_Panel.createSequentialGroup()
					.addGap(55)
					.addComponent(Admin_Button, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
					.addGap(49))
		);
		Admin_Panel.setLayout(gl_Admin_Panel);
		LibraryManagement.getContentPane().setLayout(groupLayout);
	}
		
	}

