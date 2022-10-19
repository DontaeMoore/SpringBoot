package com.TB_Challenge.dao;

import com.TB_Challenge.model.Race;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class RaceppsDAOImpl implements RaceppsDAO{

    private final JdbcTemplate jdbcTemplate;

    public RaceppsDAOImpl(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public int save(Integer race_id, Integer horse_id, Integer post) {
        String sql = "INSERT INTO horses_in_race (H_race_id, H_horse_id, post_position) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, race_id, horse_id, post);

    }
}
