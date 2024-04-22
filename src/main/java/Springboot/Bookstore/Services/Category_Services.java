package Springboot.Bookstore.Services;

import Springboot.Bookstore.Model.CategoryModel;
import Springboot.Bookstore.Repository_DAO.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Category_Services {

    @Autowired
    private CategoryDAO cateDAO;

    public List<CategoryModel> getAllCAte() {
        return cateDAO.getAllCategory();
    }


    public CategoryModel insertCategory(String catNAme) {
        return cateDAO.insertANDRetCategory(catNAme);
    }


    public CategoryModel findCateByID(int x) {
        return cateDAO.findbyCatID(x);
    }

    public CategoryModel updateCatByID(String newCatName, int catID) {
        return cateDAO.updateCatByID(newCatName, catID);
    }

    public String deletebyID(int catID) {
        return cateDAO.deletebyID(catID);
    }

}
