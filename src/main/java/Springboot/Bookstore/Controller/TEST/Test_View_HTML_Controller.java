package Springboot.Bookstore.Controller.TEST;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


// The difference between @Controller vs @RestController is here...
// @Controller can return the view, in form of HTML we can attach like below, if we using the @RESTcontroller the view is rejected, and only returned the value only from body... head title etc ignored...
// Run this you will know...
@Controller
@RequestMapping("/api/bookstore/html_view_controller")
public class Test_View_HTML_Controller {

    @RequestMapping("welcome1")
    @ResponseBody // this is to return the response's bodypart from the below code:
    @ResponseStatus(HttpStatus.OK)
    public String html1(){

        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> Title of my HTML View COntroller page for Bookstore under: Test_View_HTML_Controller </title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("This is the body of HTML under view Controller : Test_View_HTML_Controller");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    // @ResponseBody // this is to return the response's bodypart from the below code:
    // I am returning view here... exactly same as above result..
    //@ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "welcome2")
    public String html2(){
        return "htmlintro";
    }

}
