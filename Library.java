import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Member> members;
    
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addMember(Member member){
        members.add(member);
    }

    public boolean borrowBook(String isbn, String memberId) throws Exception{
        Book book = findBookByIsbn(isbn);
        Member member = findMemberById(memberId);
        if(book == null){
            throw new Exception("Book not found");
        }
        if(member == null){
            throw new Exception("Member not found");
        }
        if(!book.getIsAvailable()){
            throw new Exception("Book is not available");
        }
        member.borrowBook(book);
        return true;
    }

    public boolean returnBook(String isbn, String memberId) throws Exception {
        Book book = findBookByIsbn(isbn);
        Member member = findMemberById(memberId);
    
        if (book == null) {
            throw new Exception("Book not found");
        }
        if (member == null) {
            throw new Exception("Member not found");
        }
        
        if (!member.getBorrowedBooks().contains(book)) {
            throw new Exception("Book not borrowed");
        }
        
        // Return the book
        member.returnBook(book);
        return true;
    }
    
    public Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }    
    
    public void checkBookAvailability(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book != null) {
            System.out.println("Book availability: " + book.getIsAvailable());
        } else {
            System.out.println("Book not found");
        }
    }

    @Override
    public String toString() {
        return "Library [books=" + books + ", members=" + members + "]";
    }
}

