package Springboot.Bookstore.Repository_DAO.Interfaces;

import Springboot.Bookstore.Model.BookModel;

import java.util.List;

public interface BookDAO_Interface {

    List<BookModel> getAllBookfromDB();

    List<BookModel> getBookByCateName(String cateName);

    List<BookModel> getBookByAuthName(String authorName);

    List<BookModel> getBookBYcatID(int catID);

    List<BookModel> getBookBYauthID(int authID);

    List<BookModel> getBookBYuid(int bookUID);

    List<BookModel> updateBook(int bookUID, String bookName, String authName, String cateName, int isbn);

    List<BookModel> insertBook(String bookName, int authID, int catID, int isbn);

    String deleteBook(int bookUID);

    List<BookModel> searchBook(String bookName, String authName, String catName, Integer isbn);

}
