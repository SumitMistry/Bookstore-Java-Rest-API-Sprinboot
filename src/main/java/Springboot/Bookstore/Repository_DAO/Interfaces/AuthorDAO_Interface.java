package Springboot.Bookstore.Repository_DAO.Interfaces;

import Springboot.Bookstore.Model.AuthorModel;

import java.util.List;

public interface AuthorDAO_Interface {

    List<AuthorModel> getAllAuthors();

    AuthorModel insertAuthName(String authName);

    AuthorModel findAuthBYid(int authID);

    AuthorModel updateAuthBYid(String authName, int authID);

    String deleteAuthBYid(int authID);


}
