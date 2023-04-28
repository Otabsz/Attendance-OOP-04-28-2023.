// ElectronicBookSystem class to represent an electronic book with its title, author, and 
public class ElectronicBookSystem {
    private String title;
    private String author;
    private int copiesAvailable;
 // Constructor to initialize a new ElectronicBookSystem object with a given title, author, and number of available copies
    public ElectronicBookSystem(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }
 // Method to decrement the number of available copies by one when a book is rented
    public void rentBook() {
		
    	if (copiesAvailable > 0) {
	        copiesAvailable--;
	    }
	}
 // Getter method for the title of the book
	public String getTitle() {
        return title;
    }
// Getter method for the author of the book
    public String getAuthor() {
        return author;
    }
 // Getter method for the number of available copies of the book
    public int getCopiesAvailable() {
		return copiesAvailable;
    	
    	    
    	}
    }
