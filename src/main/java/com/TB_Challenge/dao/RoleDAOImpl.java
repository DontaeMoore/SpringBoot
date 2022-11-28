package com.TB_Challenge.dao;

import com.TB_Challenge.model.Role;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RoleDAOImpl implements RoleDAO{

    private final JdbcTemplate jdbcTemplate;

    public RoleDAOImpl(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Role> roleList() {
        List<Role> list = jdbcTemplate.query("SELECT * FROM roles", new RowMapper<Role>() {

            @Override
            public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
                Role r = new Role();

                r.setId(rs.getString("id"));
                r.setName(rs.getString("name"));
                r.setDesc(rs.getString("description"));



                return r;
            }

        });



        return list;

    }
}
