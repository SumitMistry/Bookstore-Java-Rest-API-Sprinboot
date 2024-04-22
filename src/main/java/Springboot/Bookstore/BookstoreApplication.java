package Springboot.Bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        SpringApplication.run(BookstoreApplication.class, args);
        System.out.println("> BookStore SpringBoot Application has started...");
            System.out.println(" > Go and explore @Controller http://localhost:8080          and                http://localhost:8080/actuator \n" +
                "   Book:       http://localhost:8080/api/bookstore/book        \n" +
                "   Health:     http://localhost:8080/api/bookstore/health and MySQL Workbench local .... \n" +
                "   HTML:       http://localhost:8080/api/bookstore/html_view_controller/welcome1               =returns (String) with @ResponseBody  \n" +
                "   HTML:       http://localhost:8080/api/bookstore/html_view_controller/welcome2               =returns (View) without @ResponseBody  \n" +
                "   JSP:        http://localhost:8080/api/bookstore/jsp_view_controller/welcome0   \n"  +
                "   JSP:        http://localhost:8080/api/bookstore/jsp_view_controller/welcome2                =returns (View) without @ResponseBody \n" +
                "   JSP:        http://localhost:8080/api/bookstore/jsp_view_controller/jspredirect?jsp=login   =returns (View) without @ResponseBody \n" +
                "               -> Available options =/jspredirect?jsp=jsp_welcome1   /jspredirect?jsp=jsp_welcome2        /jspredirect?jsp=htmlintro  \n" +
                "   ConfigurationProperties:    http://localhost:8080/api/bookstore/ConfigurationProperties =returns (String) with @ResponseBody \n" +
                "   Login0 (Template): GET      http://localhost:8080/api/bookstore/login0                  =returns (View) without @ResponseBody \n"  +
                "   Login1 with Param: GET      http://localhost:8080/api/bookstore/login1?uid=xyz          =returns (String) with @ResponseBody \n"  +
                "   Login2 with Param: POST     http://localhost:8080/api/bookstore/login2?uid=xyz          =returns (String) with @ResponseBody \n"  +
                "   Login3 MODEL intro: GET     http://localhost:8080/api/bookstore/login3?uid=SUmirgnrevun =returns (VIEW) without @ResponseBody \n"  +
                "   Login4 Form intro:  POST    http://localhost:8080/api/bookstore/login4                  =returns (VIEW) without @ResponseBody \n"





        );

    }


}
