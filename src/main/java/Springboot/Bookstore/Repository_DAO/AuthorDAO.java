package Springboot.Bookstore.Repository_DAO;

import Springboot.Bookstore.Model.AuthorModel;
import Springboot.Bookstore.Repository_DAO.Interfaces.AuthorDAO_Interface;
import Springboot.Bookstore.Repository_DAO.forJDBCrowMapper.AuthorRowMapper;
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
public class AuthorDAO implements AuthorDAO_Interface {

    private final String qetAllAuthors = "select * from author; ";
    private final String insertAuth = "Insert into author (authorName) values(?) ; ";
    private final String findAuthByID = "select * from author where authorID = (?) ; ";
    private final String updateAuthByID = "UPDATE author SET authorName = (?) WHERE authorID = (?);";
    private final String deleteByAuthID1 = " DELETE FROM book WHERE authorID=(?); ";
    private final String deleteByAuthID2 = " DELETE FROM author WHERE authorID=(?); ";


    //JdbcTemplate
    @Autowired // This is called field injection, constructor injection is always better.
    private JdbcTemplate jdbcTemplate;

    //fetching connection datasource config to DAO
    AuthorDAO(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<AuthorModel> getAllAuthors() {
        List<AuthorModel> list = jdbcTemplate.query(qetAllAuthors, new AuthorRowMapper());
        return list;
    }


    @Override
    public AuthorModel findAuthBYid(int authID) {
        AuthorModel a1 = jdbcTemplate.queryForObject(findAuthByID, new AuthorRowMapper(), authID);
        return a1;
    }


    // TABLE: Author will only allow UNIQUE values of authorName --> schema applied
    @Override
    public AuthorModel insertAuthName(String authName) {
        // Allowing only UNIQUE authorName --> schema applied
        KeyHolder kh1 = new GeneratedKeyHolder();
        jdbcTemplate.update(insertAuth_prepStatement(authName), kh1);
        AuthorModel a1 = findAuthBYid(kh1.getKey().intValue());
        return a1;
    }
    public PreparedStatementCreator insertAuth_prepStatement(String authID) {
        PreparedStatementCreator psc1 = new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {

                PreparedStatement ps1 = con.prepareStatement(insertAuth, Statement.RETURN_GENERATED_KEYS);
                ps1.setString(1, authID);
                return ps1;
            }
        };
        return psc1;
    }

    // For UPDATE, we dont need bookID to return. We already know or already have ID (which user is passing), so no keyholder required here.
    @Override
    public AuthorModel updateAuthBYid(String authName, int authID) {
        int rows = jdbcTemplate.update(updateAuthByID, authName, authID);
        AuthorModel a1 = findAuthBYid(authID);
        return a1;
    }

    @Override
    public String deleteAuthBYid(int authID) {
        int x = jdbcTemplate.update(deleteByAuthID1, authID);
        int y = jdbcTemplate.update(deleteByAuthID2, authID);
        if (x > 0 || y > 0) {
            System.out.println("\n \n \n book_table:" + x + "    author_table:" + y);
        } else {
            System.out.println("\n \n \n book_table:" + x + "    author_table:" + y);
        }
        return "\n \n \n book_table:" + x + "    author_table:" + y;
    }
}

