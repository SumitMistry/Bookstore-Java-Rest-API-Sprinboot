package Springboot.Bookstore.Controller;

import Springboot.Bookstore.Model.AuthorModel;
import Springboot.Bookstore.Services.Author_services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/bookstore")
public class Author_Controller {


    @Autowired
    Author_services authService1;

    @GetMapping("/author")  // GET ALL
    @ResponseBody
    public ResponseEntity<List<AuthorModel>> getAllAuth() {
        return new ResponseEntity<List<AuthorModel>>(authService1.getAllAuthorsss(), HttpStatus.OK);
    }

    @PostMapping("/author") // POST insert 1 author // Allowing only UNIQUE authorName --> schema applied
    @ResponseBody
    //java.sql.SQLIntegrityConstraintViolationException: Duplicate entry 'AuthorA' for key 'author.authorName'
    public ResponseEntity<AuthorModel> insertAuth(@RequestParam("authName") String authName) {
        AuthorModel a1 = authService1.insertAuth(authName);
        return new ResponseEntity<AuthorModel>(a1, HttpStatus.OK);
    }
// Difference between @PathVariable------ vs ------  @RequestParam
    // @RequestParam use ---> http://localhost:8080/api/bookstore/author/ID?authID=4
    @GetMapping("/author/ID") // GET find by ID .... POSTMAN<int ID>
    @ResponseBody
    public ResponseEntity<AuthorModel> findAuthBYid1(@RequestParam(value = "authID") int authID) {
        AuthorModel a1 = authService1.findAuthBYid(authID);
        return new ResponseEntity<AuthorModel>(a1, HttpStatus.OK);
    }
// Difference between @PathVariable------ vs ------  @RequestParam
    // @PathVariable use ---> http://localhost:8080/api/bookstore/author/ID/4
    @GetMapping("/author/ID/{authID}") // GET find by ID .... POSTMAN<int ID>
    @ResponseBody
    public ResponseEntity<AuthorModel> findAuthBYid2(@PathVariable(value = "authID") int authID) {
        AuthorModel a1 = authService1.findAuthBYid(authID);
        return new ResponseEntity<AuthorModel>(a1, HttpStatus.OK);
    }

    @PostMapping("/author/update") // POST update
    @ResponseBody
    public ResponseEntity<AuthorModel> updateAuthBYid(@RequestParam("authName") String authName, @RequestParam("authID") int authID) {
        return new ResponseEntity<AuthorModel>(authService1.updateAuthBYid(authName, authID), HttpStatus.OK);
    }

    @PostMapping("author/delete")
    @ResponseBody
    public ResponseEntity<String> deleteAuthBYid(@RequestParam("authID") int authID) {
        return new ResponseEntity<String>(authService1.deleteAuthBYid(authID), HttpStatus.OK);
    }
}

