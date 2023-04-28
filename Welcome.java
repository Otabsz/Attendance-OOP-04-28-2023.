import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome {
	// make it public to access to other frame that calling out
	public JFrame frmWelcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome window = new Welcome();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Create the welcome frame
		frmWelcome = new JFrame();
		frmWelcome.setTitle("Welcome");
		frmWelcome.setBounds(100, 100, 450, 381);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		// Add the welcome label to the frame
		JLabel WelcomeLabel = new JLabel("   Welcome to NU Library System");
		WelcomeLabel.setBounds(0, 150, 408, 31);
		WelcomeLabel.setBackground(Color.WHITE);
		WelcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		frmWelcome.getContentPane().add(WelcomeLabel);
		// Add the return button to the frame Library managment
		JButton returnButton = new JButton("RETURN");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Library_Management window = new Library_Management();
				window.LibraryManagement.setVisible(true);
				frmWelcome.dispose();
			}
		});
		returnButton.setBounds(10, 11, 89, 23);
		frmWelcome.getContentPane().add(returnButton);
	}

}
