package Springboot.Bookstore.Controller.TEST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/api/bookstore")
public class Test_Login_Controller_ConfigurationProp {

    @Autowired
    private Test_Login_Component_ConfigurationProp test_login_componentConfigurationProp;

    @RequestMapping(value = "/ConfigurationProperties", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Test_Login_Component_ConfigurationProp test_login_component_configurationProp(){
        System.out.println(test_login_componentConfigurationProp.toString());
        return test_login_componentConfigurationProp;
    }
}
