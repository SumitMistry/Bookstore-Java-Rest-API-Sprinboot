package Springboot.Bookstore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/bookstore")
public class Login_Controller {

/////////////// GET       + JSP VIEW     // ready-made HTML template here
    @RequestMapping(value = "/login0", method = RequestMethod.GET)
    // no @ResponseBody needed
    public String login_start_html(){
        return "login";
    }

/////////////// GET     /login1
    // login?user_id=xyz if we dont put (value="user_id"), it takes as default to login?name=xyz
    @RequestMapping(value = "/login1", method = RequestMethod.GET)
    @ResponseBody
    public String login1(@RequestParam( value = "uid") String uid){
        System.out.println("\n\n User entered:" + uid);
        return uid;
    }


/////////////// POST    /login2
    @RequestMapping(value = "/login2", method = RequestMethod.POST)  // login?user_id=xyz if we dont put (value="user_id"), it takes as default to login?name=xyz
    @ResponseBody
    public String login2(@RequestParam( value = "uid") String uid){
        System.out.println("\n\n User entered:" + uid);
        return uid;
    }

///////////////     MODEL   introduction   + JSP VIEW
    @RequestMapping(value = "/login3", method = RequestMethod.GET)
    public String login3(@RequestParam(value="uid") String uid, ModelMap modelMap){
        modelMap.put( "uid_holder",    uid );  // <uid_holder>: this value is defined in login3.jsp file as ${uid_holder}
        System.out.println("\n\n User entered:" + uid + modelMap.toString());
        return "login3";  //this is returning login3.jsp  RETURNS(VIEW)
    }




}
