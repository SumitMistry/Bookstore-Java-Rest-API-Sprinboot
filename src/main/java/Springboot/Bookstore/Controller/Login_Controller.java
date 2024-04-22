package Springboot.Bookstore.Controller;

import Springboot.Bookstore.Services.Login_Authentication_Services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/api/bookstore")
public class Login_Controller {

    private Logger logger_controller = LoggerFactory.getLogger(Login_Controller.class);

    private Login_Authentication_Services login_authentication_services;

    // we dont need to autowire this constructor, Spring will automatically take care of adding ....
    //              Login_Authentication_Services...
    Login_Controller(Login_Authentication_Services logn_auth_Servi){
        this.login_authentication_services = logn_auth_Servi;
    }

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


///////////////     Basic Form  + JSP VIEW  + GET() + POST() + ModelMapping
    ///////////     GET specific below
    @RequestMapping(value = "/login4", method = RequestMethod.GET)
    public String login4_get(){
        logger_controller.info("    Running: login4_get()");
        return "login4_get";  //this is returning login4.jsp  RETURNS(VIEW).
        // This login4.jsp form has <Form method= "post">
    }
    // same as above method, but handling only POST side
    ///////////     POST specific below
    @RequestMapping(value = "/login4", method = RequestMethod.POST)
    public String login4_post(@RequestParam String uid, @RequestParam String pass, ModelMap modelMap){

        // Authentication BASIC logic set in SERVICES:
        boolean goAheadOrNOT = login_authentication_services.authenticate_basic1(uid,pass);
        logger_controller.info("    Running: login4_post()+  Authentication Validation indicator" + goAheadOrNOT);
        if(goAheadOrNOT == false){
            modelMap.put( "message", "AUTH FAILED ");
            return "login4_get";
        }
        else{
            modelMap.put( "message", "Successful...");
            modelMap.put("uid",uid);
            modelMap.put("pass",pass);
            logger_controller.info("    uid="+ uid+"   pass="+pass + modelMap );
            return "login4_post";  //this is returning logn4_post.jsp  RETURNS(VIEW).
        }

    }

///////////////     HTML Template  + JSP VIEW  + GET() + POST() + ModelMapping
    ///////////     GET specific below
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login_get(){
        logger_controller.info("    Running: login_get()");
        return "login";  //this is returning login4.jsp  RETURNS(VIEW).
        // This login4.jsp form has <Form method= "post">
    }
    // same as above method, but handling only POST side
    ///////////     POST specific below
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login_post(@RequestParam String uid, @RequestParam String pass, ModelMap modelMap){

        // Authentication BASIC logic set in SERVICES:
        boolean goAheadOrNOT = login_authentication_services.authenticate_basic1(uid,pass);
        logger_controller.info("    Running: login_post()+  Authentication Validation indicator" + goAheadOrNOT);
        if(goAheadOrNOT == false){
            modelMap.put( "message", "AUTH FAILED ");
            return "login";
        }
        else{
            modelMap.put( "message", "Successful...");
            modelMap.put("uid",uid);
            modelMap.put("pass",pass);
            logger_controller.info("    uid="+ uid+"   pass="+pass + modelMap );
            return "login4_post";  //this is returning logn4_post.jsp  RETURNS(VIEW).
        }

    }


}
