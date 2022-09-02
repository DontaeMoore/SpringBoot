package com.example.demo.dao;

import com.example.demo.model.Contact;
import com.example.demo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private JdbcTemplate jdbcTemplate;

    public UserDAOImpl(DataSource dataSource) {

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
}