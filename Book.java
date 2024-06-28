public class Book{
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;

    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
    }

    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public String getIsbn(){return isbn;}
    public boolean getIsAvailable(){return isAvailable;}
    public void setIsAvailable(boolean isAvailable){this.isAvailable = isAvailable;}
    public String toString(){
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + isbn + "\nAvailable: " + isAvailable;
    }
}