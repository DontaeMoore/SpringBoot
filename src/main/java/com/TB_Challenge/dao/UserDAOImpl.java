package com.TB_Challenge.dao;

import com.TB_Challenge.model.Track;
import com.TB_Challenge.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    public UserDAOImpl(DataSource dataSource) {
        this.passwordEncoder = new BCryptPasswordEncoder();
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> list() {
        List<User> list = jdbcTemplate.query("SELECT * FROM USERS", new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User t = new User();

                t.setId(rs.getInt("id"));
                t.setUsername(rs.getString("username"));
                t.setPassword(rs.getString("password"));
                t.setRole(rs.getString("role"));
                t.setStatus(rs.getString("status"));


                return t;
            }

        });

        return list;
    }

    @Override
    public User getUserInfo(String username) {
        username = "\"" + username + "\"";

        String sql = "SELECT * FROM  users WHERE username =" + username;
            System.out.println(sql);
        ResultSetExtractor<User> extractor = new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()) {
                    Integer id = rs.getInt("id");
                    String username = rs.getString("username");
                    String role = rs.getString("role");
                    String status = rs.getString("status");


                    return new User(id, username, role, status);
                }

                return null;
            }

        };

        return jdbcTemplate.query(sql, extractor);


    }

    @Override
    public int update(User u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        String sql = "UPDATE  Users SET password = ?, role = ?, status = ? WHERE id =?";
        return jdbcTemplate.update(sql, u.getPassword(), u.getRole(), u.getStatus(), u.getId());
    }
}