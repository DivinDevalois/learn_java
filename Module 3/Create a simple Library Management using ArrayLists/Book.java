// Book class to represent a library book
public class Book {
    // Step 1: Declare private variables for bookTitle, author, publicationYear, and isAvailable
    // Hint: Use appropriate data types (String for title/author, int for year, boolean for availability)
    private String title;
    private String author;
    private int year;
    private boolean isAvailable;

    
    // Step 2: Create a constructor that accepts bookTitle, author, and publicationYear
    // Hint: Initialize all fields including setting isAvailable to true by default

    public  Book(){
        this.title="";
        this.author="";
        this.year=0;
        this.isAvailable=true;
    }
    
    // Step 3: Create public getter methods for each variable
    // Hint: Use the format: public returnType getVariableName()

    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }
    public int getYear(){
        return this.year;
    }
    public boolean  getStatus(){
        return this.isAvailable;
    }
    
    // Step 4: Create public setter methods for relevant variables
    // Hint: You might not need setters for all variables

    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthor(String author){
        this.author=author;
    }
    public void stYear(int year){
        this.year=year;
    }
    public void setStatuts(boolean  isAvailable){
        this.isAvailable=isAvailable;
    }
    
    // Step 5: Create methods to check out and return a book
    // checkOut() method should set isAvailable to false and return true if the book was available
    public boolean  checkoutBook(){
        if (isAvailable) {
            isAvailable=false;
            return true;
        }
        return  false;
    }
    // returnBook() method should set isAvailable to true and return true if the book was checked out

    public boolean  returnBook(){
        if (!isAvailable) {
            isAvailable=true;
            return true;
        }
        return  true;
    }
    
    // Step 6: Override toString() method to display book details
    // Hint: Show title, author, year, and availability status

   

    public String displayBook() {
        return "le title of the book is  " + title + "  d'auteur " + author + " ecrire en"+ year + " status" + isAvailable;
    }
}
