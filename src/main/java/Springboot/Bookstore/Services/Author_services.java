package Springboot.Bookstore.Services;

import Springboot.Bookstore.Model.AuthorModel;
import Springboot.Bookstore.Repository_DAO.AuthorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Author_services {

    @Autowired
    private AuthorDAO authDAO;

    public List<AuthorModel> getAllAuthorsss() {
        return authDAO.getAllAuthors();
    }

    public AuthorModel insertAuth(String authName) {
        return authDAO.insertAuthName(authName);
    }

    public AuthorModel findAuthBYid(int authID) {
        return authDAO.findAuthBYid(authID);
    }

    public AuthorModel updateAuthBYid(String authName, int authID) {
        return authDAO.updateAuthBYid(authName, authID);
    }

    public String deleteAuthBYid(int authID) {
        return authDAO.deleteAuthBYid(authID);
    }

}
