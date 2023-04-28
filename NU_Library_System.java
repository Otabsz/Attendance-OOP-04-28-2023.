import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import javax.swing.JFrame;

public class NU_Library_System extends JFrame {
	// Creating an array of ElectronicBookSystem objects and initializing them with some sample data
	private ElectronicBookSystem[] books = {
            new ElectronicBookSystem("System Analysis and Design", "Gary B. Shelly", 2),
            new ElectronicBookSystem("Android Application", "Corinne Hoisington", 3),
            new ElectronicBookSystem("Programming Concepts and Logic Formulation", "Rosauro E. Manuel", 4),
            new ElectronicBookSystem("Other Book?","****",0),
    };
	// Defining some private variables
    private JTextArea bookList;
    private JButton rentBtn;
    private JButton exitBtn;
    private JComboBox<String> bookCombo;
    // make it public to access to other frame that calling out
    public  JFrame frame;
	
   
	/**
	 * 
	 */
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {// The main method which is the entry point of the program
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 
					 NU_Library_System window = new NU_Library_System();
	                    window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public NU_Library_System() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */

	

    public void  initialize() {// A method to create the GUI
    	// Create a new JFrame
    	frame = new JFrame();
    	frame.setTitle("NU LIBRARY SYSTEM");
    	frame.setSize(400, 300);
        
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.getContentPane().setLayout(new BorderLayout());
    	// Create a JTextArea to display the list of books
        bookList = new JTextArea(10, 25);
        bookList.setEditable(false);
        updateBookList();
        // Create a JScrollPane to allow scrolling of the book list
        JScrollPane scrollPane = new JScrollPane(bookList);

        bookCombo = new JComboBox<String>();
        for (int i = 0; i < books.length; i++) {
            bookCombo.addItem(i + " " + books[i].getTitle() + " by " + books[i].getAuthor()  + " (" + books[i].getCopiesAvailable() + " copies available)");
        }
        // The RentButtonListener class implements ActionListener and handles the event when the Rent button is clicked
        rentBtn = new JButton("Rent");
        rentBtn.addActionListener(new RentButtonListener());
        // The ExitButtonListener class implements ActionListener and handles the event when the Exit button is clicked.
        exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ExitButtonListener());
    	// Create a JPanel to hold the rent and exit buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(rentBtn);
        buttonPanel.add(exitBtn);
        // Add the GUI components to the frame
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(bookCombo, BorderLayout.NORTH);
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
 // Method to update the list of books displayed in the JTextArea
    private void updateBookList() {
        StringBuilder sb = new StringBuilder();
        for (ElectronicBookSystem book : books) {
            sb.append(book.getTitle()).append(" by ").append(book.getAuthor()).append(" (").append(book.getCopiesAvailable()).append(" copies available)\n");
        }
        bookList.setText(sb.toString());
    }
 // ActionListener class for the Rent button
    private class RentButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	//Index of the selected book from the JComboBox
            int index = bookCombo.getSelectedIndex();
          //Check if the selected index is valid or if the selected book is the "Other Book?"
             if (index < 0 || index >= books.length || books[index].getTitle().equals("Other Book?")) {
                JOptionPane.showMessageDialog( NU_Library_System.this, "Index does not exist, try again!");
                JOptionPane.showMessageDialog(NU_Library_System.this, "End of Program");
            	frame.dispose();
                return;
            }
             //Get the selected book object
            ElectronicBookSystem book = books[index];
          //Check if the book has available copies
            if (book.getCopiesAvailable() == 0) {
                JOptionPane.showMessageDialog( NU_Library_System.this, "No copies of this book are available, please try another one.");
               
                return;
            }
            //If the selected book has available copies, decrement the number of copies available and update the book list
            book.rentBook();
            updateBookList();
            JOptionPane.showMessageDialog( NU_Library_System.this, "You rented " + book.getTitle() + ". (There are now " + book.getCopiesAvailable() + " copies left.)");
            //Check if the user wants to rent another book
            if (JOptionPane.showConfirmDialog(NU_Library_System.this,"RENT ANOTHER BOOK?","BOOK RENTED",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
            	//Do nothing and let the user select another book
            	 	
            }else {
            	//Otherwise, display an error message and exit the program
            	JOptionPane.showMessageDialog(NU_Library_System.this, "End of Program");
            	frame.dispose();
            }
        }
    }
 // ActionListener class for the Exit button
    private class ExitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	frame.dispose();
        }
    }



}
