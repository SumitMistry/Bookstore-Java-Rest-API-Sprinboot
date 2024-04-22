package Springboot.Bookstore.Repository_DAO.forJDBCrowMapper;

import Springboot.Bookstore.Model.CategoryModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<CategoryModel> {

    @Override
    public CategoryModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        CategoryModel cmodel = new CategoryModel(
                rs.getString("categoryName"),
                rs.getInt("categoryID")
        );
        return cmodel;
    }
}
