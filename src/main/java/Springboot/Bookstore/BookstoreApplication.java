package Springboot.Bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        SpringApplication.run(BookstoreApplication.class, args);
        System.out.println("> BookStore SpringBoot Application has started...");
        System.out.println(" > Go and explore @Controller http://localhost:8080 and http://localhost:8080/actuator \n" +
                "   CHECK:http://localhost:8080/api/bookstore/health and MySQL Workbench local .... \n" +
                "   HTML:   http://localhost:8080/api/bookstore/html_view_controller/welcome1               =returns (String) with @ResponseBody  \n" +
                "   HTML:   http://localhost:8080/api/bookstore/html_view_controller/welcome2               =returns (View) without @ResponseBody  \n" +
                "   JSP:    http://localhost:8080/api/bookstore/jsp_view_controller/welcome0   \n"  +
                "   JSP:    http://localhost:8080/api/bookstore/jsp_view_controller/welcome2                =returns (View) without @ResponseBody \n" +
                "   JSP:    http://localhost:8080/api/bookstore/jsp_view_controller/jspredirect?jsp=login   =returns (View) without @ResponseBody \n" +

                "   ConfigurationProperties:    http://localhost:8080/api/bookstore/ConfigurationProperties =returns (String) with @ResponseBody \n" +
                "   Login0 (Template):          http://localhost:8080/api/bookstore/login0           (GET)  =returns (View) without @ResponseBody \n"  +
                "   Login1 with Param:          http://localhost:8080/api/bookstore/login1?uid=xyz   (GET)  =returns (String) with @ResponseBody \n"  +
                "   Login2 with Param:          http://localhost:8080/api/bookstore/login2?uid=xyz   (POST) =returns (String) with @ResponseBody \n"  +
                "   Login3 with Param:          http://localhost:8080/api/bookstore/login3?uid=xyz   (POST) =returns (String) with @ResponseBody \n"





        );



    }


}
