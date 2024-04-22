package Springboot.Bookstore.Repository_DAO;

import Springboot.Bookstore.Model.CategoryModel;
import Springboot.Bookstore.Repository_DAO.Interfaces.CategoryDAO_Interface;
import Springboot.Bookstore.Repository_DAO.forJDBCrowMapper.CategoryRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class CategoryDAO implements CategoryDAO_Interface {

    private final String selectAllcat = "select * from category ; ";
    private final String insertCat = "Insert into category (categoryName) values(?) ; ";
    private final String selectCatByID = "select * from category where categoryID = (?) ; ";
    private final String updateCatByID = "UPDATE category SET categoryName = (?) WHERE categoryID = (?);";
    private final String deleteByCatID1 = " DELETE FROM book WHERE categoryID=(?); ";
    private final String deleteByCatID2 = " DELETE FROM category WHERE categoryID=(?); ";



    @Autowired
    private JdbcTemplate jdbctemplate;


    //fetching connection datasource config to DAO
    CategoryDAO(DataSource dataSource){
        this.jdbctemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<CategoryModel> getAllCategory() {
        List<CategoryModel> list = jdbctemplate.query(selectAllcat, new CategoryRowMapper());
        return list;
    }

    // TABLE: Category will only allow UNIQUE values of categoryName --> schema applied
    @Override
    public CategoryModel insertANDRetCategory(String catName) {
        // Allowing only UNIQUE authorName --> schema applied
        KeyHolder id_keyholder = new GeneratedKeyHolder();

        jdbctemplate.update(prepState_forCreate(catName), id_keyholder);  // return numbers of row it applies
        CategoryModel c1 = findbyCatID(id_keyholder.getKey().intValue());
        return c1;
    }

    // This will be exclusively used for .... <public CategoryModel  insertANDRetCategory(String catName)>
    public PreparedStatementCreator prepState_forCreate(String catName) {
        PreparedStatementCreator psc = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertCat, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, catName);
                return ps;
            }
        };
        return psc;
    }

    @Override
    public CategoryModel findbyCatID(int categoryIdd) {
        CategoryModel c1 = jdbctemplate.queryForObject(selectCatByID, new CategoryRowMapper(), categoryIdd);
        return c1;
    }


    // For UPDATE, we dont need bookID to return. We already know or already have ID (which user is passing), so no keyholder required here.
    @Override
    public CategoryModel updateCatByID(String newCatNAME, int catID) {
        jdbctemplate.update(updateCatByID, newCatNAME, catID);
        CategoryModel c1 = findbyCatID(catID);
        return c1;
    }


    public String deletebyID(int catID) {
        int x = jdbctemplate.update(deleteByCatID1, catID);
        int y = jdbctemplate.update(deleteByCatID2, catID);
        System.out.println("\n \n \n book_table:" + x + "    category_table:" + y);
        if (x > 0 || y > 0) {
            return "\n \n \n book_table:" + x + "    category_table:" + y;
        }
        return "\n \n \n book_table:" + x + "    category_table:" + y;
    }

}
