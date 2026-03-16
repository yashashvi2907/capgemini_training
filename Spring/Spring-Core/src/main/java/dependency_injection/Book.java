package dependency_injection;

public class Book {

    private int bookid;
    private String bookName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    @Override
    public String toString() {
        return "bookid: " + bookid +" bookName: " + bookName;
    }
}
