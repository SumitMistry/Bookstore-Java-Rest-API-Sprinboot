package Springboot.Bookstore.Model;


public class BookModel {

    //@Id
    //@GeneratedValue(strategy=GenerationType.AUTO) // this will use a table to generate the IDs
    int book_uid;
    String bookName;
    AuthorModel author;
    //int authorID;
    CategoryModel category;
    //String categoryId;
    int isbn;

    public BookModel(int book_uid, String bookName, CategoryModel category, int isbn, AuthorModel author) {
        this.book_uid = book_uid;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
    }

    public int getBook_uid() {
        return book_uid;
    }

    public void setBook_uid(int book_uid) {
        this.book_uid = book_uid;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthorID(int authorID) {
        this.author = author;
    }

    public CategoryModel getCategoryId() {
        return category;
    }

    public void setCategoryId(String categoryId) {
        this.category = category;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "book_uid=" + book_uid +
                ", bookName='" + bookName + '\'' +
                ", author=" + author +
                ", category='" + category + '\'' +
                ", isbn=" + isbn +
                '}';
    }
}
