package Springboot.Bookstore.Repository_DAO;

import Springboot.Bookstore.Model.BookModel;
import Springboot.Bookstore.Repository_DAO.Interfaces.BookDAO_Interface;
import Springboot.Bookstore.Repository_DAO.forJDBCrowMapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
public class BookDAO implements BookDAO_Interface {

    String selectAll = "select * from book ; "; // --> This not used, because we need <selectAllJoinTables> to join to get all data
    String selectAllJoinTables = "Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID  ; ";
    String getBookByAuthName = "Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID WHERE author.authorName = (?); ";
    String getBookByCateName = "Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID WHERE category.categoryName = (?); ";
    String getBookBYcatID = "Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID WHERE category.categoryID = (?) ;  ";
    String getBookBYauthID = "Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID WHERE author.authorID = (?) ;";
    String getBookBYuid = "Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID WHERE book.bookUID = (?)  ;";
    // Important Update query noted, refer to <Sql_scripts.sql>
    String updateBook = " UPDATE book SET bookName = (?), authorID = (Select authorID from author where authorName = (?)), categoryID = (Select categoryID from category where categoryName = (?)), isbn= (?) WHERE bookUID = (?)  ;  ";
    String insertBook = "INSERT INTO book (bookName, authorID, categoryID, isbn) VALUES (?, ? , ? ,?); ";
    String deleteBook = "DELETE from book where bookUID = (?) ; ";
    String baseSearchBk = "Select * from book JOIN author ON author.authorID = book.authorID JOIN category ON book.categoryID = category.categoryID  WHERE ";


    @Autowired // this is called field injection, constructor injection is always better
    private JdbcTemplate jdbctemplate;

    // Here in below constructor we fetching connection datasource config to DAO
    // Constructor is not needed here, as Spring will inject the connection bean automatically, we can keep or delete
    BookDAO(DataSource dataSource){
        this.jdbctemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<BookModel> getAllBookfromDB() {
        List<BookModel> list = jdbctemplate.query(selectAllJoinTables, new BookRowMapper());
        return list;
    }

    @Override
    public List<BookModel> getBookByCateName(String categoryName) {
        List<BookModel> bm1 = jdbctemplate.query(getBookByCateName, new BookRowMapper(), categoryName);
        return bm1;
    }

    @Override
    public List<BookModel> getBookByAuthName(String authorName) {
        List<BookModel> bm1 = jdbctemplate.query(getBookByAuthName, new BookRowMapper(), authorName);
        return bm1;
    }

    @Override
    public List<BookModel> getBookBYcatID(int catID) {
        // For single book output ----> BookModel b1 = null;  BookModel b1 = jdbctemplate.queryForObject(getBookBYcatID, new BookRowMapper(), catID);
        List<BookModel> list = null;
        try { // without try catch this is working fine....but just adding try catch in case....only...

//            we dont need this below class to be created manually, we can use...below....
//            Course c1 =  jdbcTemplate.queryForObject(selectQueryONE, new BeanPropertyRowMapper<Course>(Course.class) , id); //this is new from Ranga Sropnboot tutorial: \Udemy\06 - Getting Started with JPA and Hibernate with Spring and Spring Boot // 008 Step 07 - Querying Data using Spring JDBC.mp4
//
//            I used this above line in the project name = JDBC_vs_SpringJDBC
//            File Path =         src/main/java/UdemyProject4/JDBC_vs_SpringJDBC/DataRepository/viaSpringJDBC/Repository_DAO/SpringJDBC_DAO.java
//            Method = selectONE()

            list = jdbctemplate.query(getBookBYcatID, new BookRowMapper(), catID);
        } catch (EmptyResultDataAccessException | NullPointerException ee) {
            ee.printStackTrace();
        }
        return list;
    }

    @Override
    public List<BookModel> getBookBYauthID(int authID) {
        // For single book output ----> BookModel b2 = jdbctemplate.queryForObject(getBookBYauthID, new BookRowMapper(), authID);
        List<BookModel> list = jdbctemplate.query(getBookBYauthID, new BookRowMapper(), authID);
        return list;
    }


    public List<BookModel> getBookBYuid(int bookUID) {
        List<BookModel> list = jdbctemplate.query(getBookBYuid, new BookRowMapper(), bookUID);
        return list;
    }


    public List<BookModel> updateBook(int bookUID, String bookName, String authName, String cateName, int isbn) {
        jdbctemplate.update(updateBook, bookName, authName, cateName, isbn, bookUID);
        List<BookModel> list = getBookBYuid(bookUID);
        return list;
    }


    public List<BookModel> insertBook(String bookName, int authID, int catID, int isbn) {
        KeyHolder kh = new GeneratedKeyHolder();
        jdbctemplate.update(prepStaeCrt_insertBook(bookName, authID, catID, isbn), kh);
        List<BookModel> list = getBookBYuid(kh.getKey().intValue());
        return list;
    }
    public PreparedStatementCreator prepStaeCrt_insertBook(String bookName, int authID, int catID, int isbn) {
        PreparedStatementCreator psc1 = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps11 = con.prepareStatement(insertBook, Statement.RETURN_GENERATED_KEYS);
                ps11.setString(1, bookName);
                ps11.setInt(2, authID);
                ps11.setInt(3, catID);
                ps11.setInt(4, isbn);

                return ps11;
            }
        };
        return psc1;
    }

    public String deleteBook(int bookUID) {
        int x = 0;
        if ((x = jdbctemplate.update(deleteBook, bookUID)) > 0) {
            return "\n\n\n Book rec. deleted on::" + bookUID + " , Affected rows=" + x;
        }
        return "\n\n\n No Books found on:" + bookUID + " , Affected rows=" + x;
    }

    public List<BookModel> searchBook(String bookName, String authName, String catName, Integer isbn) {

        String baseSearchBk1 = baseSearchBk + " LOWER(bookName) LIKE \"%" + bookName.toLowerCase() + "%\"";

        if ((authName != null)) {
            baseSearchBk1 = baseSearchBk1 + " or LOWER(authorName) LIKE \"%" + authName.toLowerCase() + "%\"";
        }

        if ((catName != null)) {
            baseSearchBk1 = baseSearchBk1 + " or LOWER(categoryName) LIKE \"%" + catName.toLowerCase() + "%\"";
        }

        if ((isbn != null)) {
            baseSearchBk1 = baseSearchBk1 + " or isbn = \"" + isbn + "\" ; ";
        }
        System.out.println("\n\n\n\n\n\n" + baseSearchBk1);

        List<BookModel> list =
                jdbctemplate.query(baseSearchBk1, new BookRowMapper());

        return list;

    }

}


