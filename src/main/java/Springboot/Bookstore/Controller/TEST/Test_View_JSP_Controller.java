package Springboot.Bookstore.Controller.TEST;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
        Step-1 create file/folder under:
            src/main/resources/META-INF/resources/WEB-INF/jsp/welcome1.jsp
            Write html code there...
                          <html>
                          <head>
                          <title> Login for Book: Test_View_HTML_Controller </title>
                          </head>
                          <body>
                                  This is the body of HTML under view Controller : Test_View_HTML_Controller
                                  HEre is the Login method TBD for the book...
                          </body>
                          </html>
            src/main/resources/META-INF/resources/WEB-INF/jsp/welcome2.jsp
            Write html code there...
                          <html>
                          <head>
                          <title> Welcome JSP Page? </title>
                          </head>
                          <body>
                                  Welcome, Hello how are you?.. this is JSP
                          </body>
                          </html>
        Step-2 create this current controller file <Test_JSP_Controller.java>


        Step-3 set App.properties values as below:
                # JSP
                # This is to set JSP web pages. Refer to below code/steps to know how JSP setup/config works...
                # JSP Java code:      src/main/java/Springboot/Bookstore/Controller/TEST/Test_View_JSP_Controller.java
                # JSP file sample:    src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
                spring.mvc.view.prefix=/WEB-INF/jsp/
                spring.mvc.view.suffix=.jsp


        Step-4 Add Dependency for the view in POM.xml:
                        <!-- These 2 dependencies for JSP page load for view, mandatory-->
							<dependency>
								<groupId>org.apache.tomcat.embed</groupId>
								<artifactId>tomcat-embed-jasper</artifactId>
								<version> 10.1.19</version>
							</dependency>

							<dependency>
								<groupId>javax.servlet</groupId>
								<artifactId>jstl</artifactId>
								<version>1.2</version>
							</dependency>
		                <!-- These 2 dependencies for JSP page load for view, mandatory-->

        Step-5   No use of @ResponseBody
            to return view as result, we CAN NOT use  @ResponseBody
            We must remove it to get view back from HTML/JSP page.

        Step-6  as a return value in "" use the file name.
                spring.mvc.view.prefix=/WEB-INF/jsp/
                spring.mvc.view.suffix=.jsp

                Eg: if file under prefix is above, then use below method to return view..

                @RequestMapping
                public String login1(){
                     return "login_intro_file";
                }
 */


@Controller
@RequestMapping("/api/bookstore/jsp_view_controller")
public class Test_View_JSP_Controller {

    @RequestMapping(value = "/welcome0", method = RequestMethod.GET)
    @ResponseBody  // this will NOT return view. But returns String/output result
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String welcome0(){
         return "welcome_how_are   _101";  //      +  @ResponseBody ---> this will NOT return view. And so it will result in hard code value as "login_intro_101"
    }

    @RequestMapping(value = "/welcome1", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String welcome1(){
        return "jsp_welcome1";
    }

    @RequestMapping(value = "/welcome2", method = RequestMethod.GET)
    //@ResponseStatus(HttpStatus.ACCEPTED) // removed  @ResponseBody  to get view as result
    public String welcome2(){
        return  "jsp_welcome2"; // this must match to JSP FILENAME to be redirected for correct view target (login_intro.jsp)
    }


    @RequestMapping(value = "/jspredirect")
    public String jspredirect(@RequestParam( value = "jsp") String jsp){
        System.out.println("\n\n User entered:" + jsp);
        return jsp;
    }
}
