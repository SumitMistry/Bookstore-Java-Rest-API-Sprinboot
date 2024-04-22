package Springboot.Bookstore.Controller.TEST;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/* Here the values are coming from Application.properties files as env vvariable
            # @ConfigurationProperties(prefix = "login-services")
            # public class AAA {
                # String url;
                # String username;
                # String password;
            login-services.url=http://default.sumit_book.com
            login-services.user        = default.user
            login-services.pass        = default.pass
 */
@ConfigurationProperties(value = "login-services")
@Component
public class Test_Login_Component_ConfigurationProp {

    String url;
    String user;
    String pass;

    public Test_Login_Component_ConfigurationProp() {
    }

    public Test_Login_Component_ConfigurationProp(String url, String user, String pass) {
        this.url = url;
        this.user = user;
        this.pass = pass;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Test_ConfigurationProperties_Login{" +
                "url='" + url + '\'' +
                ", user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
