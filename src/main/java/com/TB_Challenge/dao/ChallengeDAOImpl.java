package com.TB_Challenge.dao;

import com.TB_Challenge.model.Challenge;
import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.Track;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ChallengeDAOImpl implements ChallengeDAO {



    private final JdbcTemplate jdbcTemplate;

    public ChallengeDAOImpl(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }




    @Override
    public List<Challenge> list() {
        List<Challenge> list = jdbcTemplate.query("SELECT * FROM challenge ", new RowMapper<Challenge>() {

            @Override
            public Challenge mapRow(ResultSet rs, int rowNum) throws SQLException {
              Challenge c = new Challenge();

                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDesc(rs.getString("description"));
                c.setFirst_points(rs.getInt("first_points"));
                c.setSecond_points(rs.getInt("second_points"));
                c.setThird_points(rs.getInt("third_points"));
                c.setFourth_points(rs.getInt("fourth_points"));
                c.setStatus(rs.getString("status"));



                System.out.println(c.toString());


                return c;
            }

        });

        return list;

    }


}
