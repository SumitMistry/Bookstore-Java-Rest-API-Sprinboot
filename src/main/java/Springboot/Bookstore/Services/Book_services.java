package Springboot.Bookstore.Services;

import Springboot.Bookstore.Model.BookModel;
import Springboot.Bookstore.Repository_DAO.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Book_services {

    @Autowired
    private BookDAO bookDAO1;

    public List<BookModel> getAllBooks() {
        return bookDAO1.getAllBookfromDB();
    }

    public List<BookModel> getBookByCateName(String cateName) {
        List<BookModel> b1 = bookDAO1.getBookByCateName(cateName);
        return b1;
    }

    public List<BookModel> getBookByAuthName(String authorName) {
        List<BookModel> b1 = bookDAO1.getBookByAuthName(authorName);
        return b1;
    }

    public List<BookModel> getBookBYcatID(int catID) {
        List<BookModel> b1 = bookDAO1.getBookBYcatID(catID);
        return b1;
    }

    public List<BookModel> getBookBYauthID(int authID) {
        List<BookModel> b1 = bookDAO1.getBookBYauthID(authID);
        return b1;
    }

    public List<BookModel> getBookBYuid(int bookUID) {
        List<BookModel> b1 = bookDAO1.getBookBYuid(bookUID);
        return b1;
    }

    public List<BookModel> updateBook(int bookUID, String bookName, String authName, String cateName, int isbn) {
        List<BookModel> list = bookDAO1.updateBook(bookUID, bookName, authName, cateName, isbn);
        return list;
    }


    public List<BookModel> insertBook(String bookName, int authID, int catID, int isbn) {
        List<BookModel> b1 = bookDAO1.insertBook(bookName, authID, catID, isbn);
        return b1;
    }

    public String deleteBook(int bookUID) {
        return bookDAO1.deleteBook(bookUID);
    }

    public List<BookModel> searchBook(String bookName, String authName, String catName, Integer isbn) {
        return bookDAO1.searchBook(bookName, authName, catName, isbn);
    }

}