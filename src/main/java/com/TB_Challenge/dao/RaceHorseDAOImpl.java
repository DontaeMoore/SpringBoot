package com.TB_Challenge.dao;

import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.RaceHorse;
import com.TB_Challenge.model.Track;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RaceHorseDAOImpl implements RaceHorseDAO{

    private final JdbcTemplate jdbcTemplate;

    public RaceHorseDAOImpl(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<RaceHorse> list() {
        List<RaceHorse> list = jdbcTemplate.query("SELECT * FROM HORSE ", new RowMapper<RaceHorse>() {

            @Override
            public RaceHorse mapRow(ResultSet rs, int rowNum) throws SQLException {
                RaceHorse r = new RaceHorse();

                r.setId(rs.getInt("horse_id"));
                r.setName(rs.getString("name"));
                r.setGender(rs.getString("gender").charAt(0));
                r.setFoalyear(rs.getString("foalyear"));
                r.setLink(rs.getString("equibaselink"));
                r.setOwner(rs.getString("owner"));
                r.setTrainer(rs.getString("trainer"));
                r.setComments(rs.getString("comments"));



                System.out.println(r.toString() + " " );


                return r;
            }

        });

        return list;

    }

}
