package Springboot.Bookstore.Repository_DAO.forJDBCrowMapper;

import Springboot.Bookstore.Model.AuthorModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorRowMapper implements RowMapper<AuthorModel> {

    @Override
    public AuthorModel mapRow(ResultSet rs, int mapprow) throws SQLException {

        AuthorModel authod1 = new AuthorModel(
                rs.getString("authorName"),
                rs.getInt("authorID")
        );

        return authod1;
    }

}
