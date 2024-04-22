package Springboot.Bookstore.Controller;

import Springboot.Bookstore.Model.BookModel;
import Springboot.Bookstore.Services.Book_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
            @RequestMapping is a class level
            @GetMapping is a method-level
Cannot map 'book_Controller' method Springboot.Bookstore.Controller.Book_Controller
to {GET [/api/bookstore/health]}: There is already 'author_Controller' bean method

Cannot map 'book_Controller' method Springboot.Bookstore.Controller.Book_Controller#welcomeMessage()
to


 */

@Controller
@RequestMapping("/api/bookstore")
public class Book_Controller {


    @Autowired
    Book_services bookServices11;

    @Autowired
    Category_Controller_v1_ResponseEntity catServices11;

    @Autowired
    Author_Controller authServices11;

    @GetMapping("/book")   // GET      //http://localhost:8080/api/bookstore/books
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<BookModel>> getAllBooks() {
        return new ResponseEntity<>(bookServices11.getAllBooks(), HttpStatus.OK);
    }

    @RequestMapping(value = "/book/category", method = RequestMethod.GET)
    // GET  // Category by name  //same as --> @GetMapping(value="/book/category")
    @ResponseBody
    public ResponseEntity<List<BookModel>> getBookBYcateName(@RequestParam("cateName") String cateName) {
        List<BookModel> b1 = bookServices11.getBookByCateName(cateName);
        return new ResponseEntity<List<BookModel>>(b1, HttpStatus.OK);
    }


    @GetMapping(value = "/book/author")    // GET  // Author by name
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<BookModel>> getBookBYauthName(@RequestParam("authName") String authorName) {
        List<BookModel> b1 = bookServices11.getBookByAuthName(authorName);
        return new ResponseEntity<List<BookModel>>(b1, HttpStatus.OK);
    }


    @GetMapping(value = "book/category/ID")     // GET by cateID
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<BookModel>> getBookBYcatID(@RequestParam(value = "catID", required = true, defaultValue = "catID") int catID) {
        List<BookModel> b1 = bookServices11.getBookBYcatID(catID);
        ResponseEntity<List<BookModel>> re1 = new ResponseEntity<List<BookModel>>(b1, HttpStatus.OK);
        return re1;
    }

    @RequestMapping(value = "book/author/ID", method = RequestMethod.GET)     // GET by authID
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<BookModel>> getBookBYauthID(@RequestParam(value = "authID", required = true, defaultValue = "1") int authID) {
        return new ResponseEntity<List<BookModel>>(bookServices11.getBookBYauthID(authID), HttpStatus.OK);
    }

    @RequestMapping(value = "book/UID", method = RequestMethod.GET)  // GET by UID
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<BookModel>> getBookBYuid(@RequestParam(value = "bookUID", required = true) int bookUID) {
        return new ResponseEntity<List<BookModel>>(bookServices11.getBookBYuid(bookUID), HttpStatus.OK);
    }

    @RequestMapping(value = "/book/update", method = RequestMethod.POST)   // POST UPDATE by UID
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<BookModel>> updateBook(@RequestParam(value = "bookUID", required = true) int bookUID,
                                                      @RequestParam(value = "bookName", required = true) String bookName,
                                                      @RequestParam(value = "authName", required = true) String authName,
                                                      @RequestParam(value = "cateName", required = true) String cateName,
                                                      @RequestParam(value = "isbn", required = true) int isbn) {

        try {
            // bad design below 2 lines....
            authServices11.insertAuth(authName);
            catServices11.insertCategory(cateName);
        } catch (DuplicateKeyException ee) {
            ee.printStackTrace();
            ee.getMessage();
        }
        return new ResponseEntity<List<BookModel>>(bookServices11.updateBook(bookUID, bookName, authName, cateName, isbn), HttpStatus.OK);
    }

    @RequestMapping(value = "book/insert", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    // insert( @RequestBody BookModel) {} //  in @RequestBody we need to define the whole JSON value whole body on our own.
    // https://www.youtube.com/watch?v=3idkW2fkXKA
    public ResponseEntity<List<BookModel>> insertBook(@RequestParam("bookName") String bookName,
                                                      @RequestParam("authID") int authID,
                                                      @RequestParam("catID") int catID,
                                                      @RequestParam("isbn") int isbn) {
        return new ResponseEntity<List<BookModel>>(bookServices11.insertBook(bookName, authID, catID, isbn), HttpStatus.CREATED);
    }

    @PostMapping("book/delete")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<String> deleteBook(@RequestParam("bookUID") int bookUID) {
        return new ResponseEntity<String>(bookServices11.deleteBook(bookUID), HttpStatus.ACCEPTED);
    }


    @GetMapping("/book/search")
    @ResponseBody
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<List<BookModel>> searchBook(@RequestParam(value = "bookName", required = true) String bookName,
                                                      @RequestParam(value = "authName", required = false) String authName,
                                                      @RequestParam(value = "catName", required = false) String catName,
                                                      @RequestParam(value = "isbn", required = false) Integer isbn) {
        return new ResponseEntity<>(bookServices11.searchBook(bookName, authName, catName, isbn), HttpStatus.FOUND);
    }


}
