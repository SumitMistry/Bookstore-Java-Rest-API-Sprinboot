package Springboot.Bookstore.Repository_DAO.forJDBCrowMapper;

import Springboot.Bookstore.Model.AuthorModel;
import Springboot.Bookstore.Model.BookModel;
import Springboot.Bookstore.Model.CategoryModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/*
        int book_uid;
        String bookName;
        String authorName;
        int authorID;
        String categoryId;
        int isbn;
 */

/*
we dont need this below class to be created manually, we can use...below....
        Course c1 =  jdbcTemplate.queryForObject(selectQueryONE, new BeanPropertyRowMapper<Course>(Course.class) , id); //this is new from Ranga Sropnboot tutorial: \Udemy\06 - Getting Started with JPA and Hibernate with Spring and Spring Boot // 008 Step 07 - Querying Data using Spring JDBC.mp4

        I used this above line in the project name = JDBC_vs_SpringJDBC
        File Path =         src/main/java/UdemyProject4/JDBC_vs_SpringJDBC/DataRepository/viaSpringJDBC/Repository_DAO/SpringJDBC_DAO.java
        Method = selectONE()


 */
public class BookRowMapper implements RowMapper<BookModel> {

    @Override
    public BookModel mapRow(ResultSet rs, int rownum) throws SQLException {

        // Author obj()
        AuthorModel auth1 = new AuthorModel(rs.getString("authorName"), rs.getInt("authorID"));
        // Cate Obj()
        CategoryModel cat1 = new CategoryModel(rs.getString("categoryName"), rs.getInt("categoryID"));

        BookModel bkmodel = new BookModel(

                rs.getInt("bookUID"),
                rs.getString("bookName"),
                cat1,
                //rs.getString("category"),
                rs.getInt("isbn"),
                //rs.getInt("authorID")
                auth1
        );

        return bkmodel;
    }

}
