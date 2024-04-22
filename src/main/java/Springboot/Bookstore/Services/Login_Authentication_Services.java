package Springboot.Bookstore.Services;

import org.springframework.stereotype.Service;

@Service
public class Login_Authentication_Services {


    /*
        @Autowired
        private LoginAUthDAO loginAUthDAO; --> no need of this for this basic page,
            this DAO will bring user pass wuthentication data from somewhere LDAP/file etc...we dont care for now in this,
            so we ignoring DAO
     */

    public boolean authenticate_basic1(String username, String password){

        boolean v1 = username.toLowerCase().contains("@");
        boolean v2 = password.toLowerCase().length()==4 ? true : false;

        return v1 && v2; //v1 and v2 BOTH must be YES....
    }
}
