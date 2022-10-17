package com.TB_Challenge.dao;

import com.TB_Challenge.model.Challenge;
import com.TB_Challenge.model.ChallengeRace;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class Challenge_RaceDAOImpl implements Challenge_RaceDAO{

    private final JdbcTemplate jdbcTemplate;

    public Challenge_RaceDAOImpl(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(ChallengeRace cr) {
        System.out.println("yo");
        String sql = "INSERT INTO challenge_race (challenge_id, race_id) VALUES (?, ?)";
        return jdbcTemplate.update(sql, cr.getChal(), cr.getRace_id());

    }
}
