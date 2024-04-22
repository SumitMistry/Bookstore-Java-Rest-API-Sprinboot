package Springboot.Bookstore.Repository_DAO.Interfaces;

import Springboot.Bookstore.Model.CategoryModel;

import java.util.List;

public interface CategoryDAO_Interface {

    List<CategoryModel> getAllCategory();

    CategoryModel insertANDRetCategory(String catNAme);

    CategoryModel findbyCatID(int categoryIdd);

    CategoryModel updateCatByID(String newCatNAME, int catID);


    String deletebyID(int catID);


}
