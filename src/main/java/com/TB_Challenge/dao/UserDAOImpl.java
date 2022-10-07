package com.TB_Challenge.dao;

import com.TB_Challenge.model.Role;
import com.TB_Challenge.model.Status;
import com.TB_Challenge.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
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
        List<User> list = jdbcTemplate.query("SELECT * FROM users", new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User t = new User();

                t.setId(rs.getInt("id"));
                t.setUsername(rs.getString("user_name"));
                t.setPassword(rs.getString("password"));
                t.setRole(rs.getString("role_id"));
                t.setStatus(rs.getString("status_id"));


                return t;
            }

        });

        return list;
    }

    public List<User> Adminlist(List<Status> s, List<Role> r, int adminOffset) {
        System.out.println("adminOffset is " + adminOffset);
        List<User> list = jdbcTemplate.query("SELECT * FROM users LIMIT 10 OFFSET "+adminOffset, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User t = new User();

                t.setId(rs.getInt("id"));
                t.setUsername(rs.getString("user_name"));

                byte[] decodedPassBytes = Base64.getDecoder().decode(rs.getString("password"));
                String decodedPass = new String(decodedPassBytes);

                t.setPassword(decodedPass);
                t.setRole(rs.getString("role_id"));
                t.setStatus(rs.getString("status_id"));

                for(Status stat : s){
                    if(rs.getString("status_id").equals(stat.getId().toString())){
                        t.setStatus(stat.getName());
                    }
                }
                for(Role roles : r){
                    if(rs.getString("role_id").equals(roles.getId())){
                        t.setRole(roles.getName());
                    }
                }


                return t;
            }

        });

        return list;
    }

    @Override
    public User getUserInfo(String username) {
        username = "\"" + username + "\"";

        String sql = "SELECT * FROM  users WHERE user_name =" + username;
            System.out.println(sql);
        ResultSetExtractor<User> extractor = new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()) {
                    Integer id = rs.getInt("id");
                    String username = rs.getString("user_name");

                    String role = rs.getString("role_id");
                    String status = rs.getString("status_id");

                    byte[] decodedPassBytes = Base64.getDecoder().decode(rs.getString("password"));
                    String decodedPass = new String(decodedPassBytes);
                    String password = decodedPass;

                    return new User(id, username, password, role, status);
                }

                return null;
            }

        };

        return jdbcTemplate.query(sql, extractor);


    }

    @Override
    public User getUser(Integer id) {


        String sql = "SELECT * FROM  users WHERE id =" + id;
        System.out.println(sql);
        ResultSetExtractor<User> extractor = new ResultSetExtractor<User>() {

            @Override
            public User extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()) {
                    Integer id = rs.getInt("id");
                    String username = rs.getString("user_name");
                    String password = rs.getString("password");
                    String  role = rs.getString("role_id");
                    String status = rs.getString("status_id");


                    return new User(id, username, password, role, status);
                }

                return null;
            }

        };

        return jdbcTemplate.query(sql, extractor);


    }

    @Override
    public int update(User u) {
        String encodedString = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
        u.setPassword(encodedString);
        String sql = "UPDATE  users SET password = ?, role_id = ?, status_id = ? WHERE id =?";
        return jdbcTemplate.update(sql, u.getPassword(), u.getRole(), u.getStatus(), u.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM  users WHERE id =" + id;
        return jdbcTemplate.update(sql);
    }

    @Override
    public int updateAdmin(User u) {
        String encodedString = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
        u.setPassword(encodedString);
        String sql = "UPDATE  users SET user_name = ?,password = ?, role_id = ?, status_id = ? WHERE id =?";
        return jdbcTemplate.update(sql, u.getUsername(), u.getPassword(), u.getRole(), u.getStatus(), u.getId());
    }

    @Override
    public int saveAdmin(User u) {
        String encodedString = Base64.getEncoder().encodeToString(u.getPassword().getBytes());
        u.setPassword(encodedString);
        String sql = "INSERT INTO users (user_name, password, role_id, status_id) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql,u.getUsername(), u.getPassword(), u.getRole(), u.getStatus());

    }

}