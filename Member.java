import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<Book> borrowedBooks;

    public Member(String name, String memberId){
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getMemberId() {
        return memberId;
    }
    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }
    public void borrowBook(Book book){
        borrowedBooks.add(book);
        book.setIsAvailable(false);
    }
    public void returnBook(Book book) throws Exception{
        if(!borrowedBooks.contains(book)){
            throw new Exception("Book was not borrowed by this member");
        }
        borrowedBooks.remove(book);
        book.setIsAvailable(true);
    }
    @Override
    public String toString(){
        return "Member [name="+name+", memberId="+memberId+", borrowedBooks="+borrowedBooks+"]";
    }
}
