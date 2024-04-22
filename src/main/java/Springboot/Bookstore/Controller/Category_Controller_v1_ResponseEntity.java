package Springboot.Bookstore.Controller;

import Springboot.Bookstore.Model.CategoryModel;
import Springboot.Bookstore.Services.Category_Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
            @RequestMapping is a class level
            @GetMapping is a method-level
 */

@org.springframework.stereotype.Controller
@RequestMapping("/api/bookstore")
public class Category_Controller_v1_ResponseEntity {

    @Autowired
    Category_Services c1;


    @GetMapping("/category")  // GET
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<CategoryModel>> getAllCatego() {
        return new ResponseEntity<>(c1.getAllCAte(), HttpStatus.OK);
    }


    @GetMapping("/category/ID/{x}")  //  GET  ---> pass from website  REQUEST(website)
    @ResponseBody       // @PathVariable is requesting data from user via website URI
    public ResponseEntity<CategoryModel> findCatebyID(@PathVariable int x) {
        // importance of ResponseEntity<CategoryModel> return, this return us JSON Response + HTTP code = Best practices
        return new ResponseEntity<CategoryModel>(c1.findCateByID(x), HttpStatus.OK);
    }

    @PostMapping(value = "/category/ID")  //  POST  ---> pass this from postman  REQUEST(postman)
    // @RequestParam is requesting data from user via POSTMAN
    @ResponseBody // not allowed here, bcos this is we posting something
    public ResponseEntity<CategoryModel> findCatebyIDfromPOSTMAN(@RequestParam("catID") int x) {
        // importance of ResponseEntity<CategoryModel> return, this return us JSON Response + HTTP code = Best practices
        return new ResponseEntity<CategoryModel>(c1.findCateByID(x), HttpStatus.OK);
    }


    @PostMapping("/category")  // POST // insert         // Allowing only UNIQUE authorName --> schema applied
    @ResponseBody
    //java.sql.SQLIntegrityConstraintViolationException: Duplicate entry 'Horror' for key 'category.categoryName'
    public ResponseEntity<CategoryModel> insertCategory(@RequestParam("catName") String catName) {
        return new ResponseEntity<>(c1.insertCategory(catName), HttpStatus.OK);
    }


    @PostMapping(value = "/category/update") // POST // Update //  Allowing only UNIQUE authorName --> schema applied
    @ResponseBody
    public ResponseEntity<CategoryModel> updateCatByID(@RequestParam("newCat") String newCatName, @RequestParam("catID") int catID) {
        return new ResponseEntity<CategoryModel>(c1.updateCatByID(newCatName, catID), HttpStatus.OK);
    }


    //delete -
    @PostMapping(value = ("category/delete"))  // POST  // delete
    @ResponseBody
    public ResponseEntity<String> deletebyID(@RequestParam("catID") int catID) {
        return new ResponseEntity<String>(c1.deletebyID(catID), HttpStatus.OK);
    }


}
