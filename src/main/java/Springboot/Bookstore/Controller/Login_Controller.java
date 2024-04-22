package Springboot.Bookstore.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/bookstore")
public class Login_Controller {

    private Logger logger_controller = LoggerFactory.getLogger(Login_Controller.class);

/////////////// GET       + JSP VIEW     // ready-made HTML template here
    @RequestMapping(value = "/login0", method = RequestMethod.GET)
    // no @ResponseBody needed
    public String login_start_html(){
        logger_controller.info("    Running: login_start_html()");
        return "login";
    }

/////////////// GET     /login1
    // login?user_id=xyz if we dont put (value="user_id"), it takes as default to login?name=xyz
    @RequestMapping(value = "/login1", method = RequestMethod.GET)
    @ResponseBody
    public String login1(@RequestParam( value = "uid") String uid){
        logger_controller.info("    Running: login1()");
        logger_controller.debug("    User entered:" + uid);
        //      System.out.println("\n\n User entered:" + uid);
        return uid;
    }


/////////////// POST    /login2
    @RequestMapping(value = "/login2", method = RequestMethod.POST)  // login?user_id=xyz if we dont put (value="user_id"), it takes as default to login?name=xyz
    @ResponseBody
    public String login2(@RequestParam( value = "uid") String uid){
        logger_controller.info("    Running: login2()");
        logger_controller.debug("    User entered:" + uid);
        //        System.out.println("\n\n User entered:" + uid);
        return uid;
    }

///////////////     MODEL   introduction   + JSP VIEW
    @RequestMapping(value = "/login3", method = RequestMethod.GET)
    public String login3(@RequestParam(value="uid") String uid, ModelMap modelMap){
        logger_controller.info("    Running: login3()");
        modelMap.put( "uid_holder",    uid );  // <uid_holder>: this value is defined in login3.jsp file as ${uid_holder}
        logger_controller.debug("    User entered:" + uid +"       //    " + modelMap.toString());      //---> 2024-04-22T00:48:52.735-04:00 DEBUG 12336 --- [Bookstore] [nio-8080-exec-5] S.Bookstore.Controller.Login_Controller  :     User entered:SUmirgnrevun       //    {uid_holder=SUmirgnrevun}
                    // No need, log will print....      System.out.println("\n\n User entered:" + uid + modelMap.toString());
        return "login3";  //this is returning login3.jsp  RETURNS(VIEW)
    }


    ///////////////     Basic Form  + JSP VIEW + POST
    @RequestMapping(value = "/login4")
    public String login4(){
        //logger_controller.info("    Running: login4()");
        return "login4";  //this is returning login4.jsp  RETURNS(VIEW).
        // This login4.jsp form has <Form method= "post">

    }



    ///////////////     MODEL + Front Controller + JSP VIEW

}
