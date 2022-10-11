package com.TB_Challenge.dao;

import com.TB_Challenge.model.RaceHorse;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class RaceHorseDAOImpl implements RaceHorseDAO{

    private final JdbcTemplate jdbcTemplate;

    public RaceHorseDAOImpl(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<RaceHorse> list(int offset) {
        List<RaceHorse> list = jdbcTemplate.query("SELECT * FROM horse LIMIT 10 OFFSET " + offset, new RowMapper<RaceHorse>() {

            @Override
            public RaceHorse mapRow(ResultSet rs, int rowNum) throws SQLException {
                RaceHorse r = new RaceHorse();

                r.setId(rs.getInt("horse_id"));
                r.setName(rs.getString("name"));
                r.setGender(rs.getString("gender"));


                if(rs.getDate("foalyear") == null) {
                    r.setFoalyear("N/A");
                }
                else {
                    java.sql.Date date = rs.getDate("foalyear");
                    DateFormat dateFormat = new SimpleDateFormat("yyyy");
                    String dateStr = dateFormat.format(date);
                    r.setFoalyear(dateStr);
                }

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
    @Override
    public List<RaceHorse> listSortByName(int offset) {
        List<RaceHorse> list = jdbcTemplate.query("SELECT * FROM horse order by name LIMIT 10 OFFSET " + offset, new RowMapper<RaceHorse>() {

            @Override
            public RaceHorse mapRow(ResultSet rs, int rowNum) throws SQLException {
                RaceHorse r = new RaceHorse();

                r.setId(rs.getInt("horse_id"));
                r.setName(rs.getString("name"));
                r.setGender(rs.getString("gender"));


                if(rs.getDate("foalyear") == null) {
                    r.setFoalyear("N/A");
                }
                else {
                    java.sql.Date date = rs.getDate("foalyear");
                    DateFormat dateFormat = new SimpleDateFormat("yyyy");
                    String dateStr = dateFormat.format(date);
                    r.setFoalyear(dateStr);
                }

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
    @Override
    public List<RaceHorse> listSortByFoalYear(int offset) {
        List<RaceHorse> list = jdbcTemplate.query("SELECT * FROM horse order by foalyear LIMIT 10 OFFSET "+offset, new RowMapper<RaceHorse>() {

            @Override
            public RaceHorse mapRow(ResultSet rs, int rowNum) throws SQLException {
                RaceHorse r = new RaceHorse();

                r.setId(rs.getInt("horse_id"));
                r.setName(rs.getString("name"));
                r.setGender(rs.getString("gender"));


                if(rs.getDate("foalyear") == null) {
                    r.setFoalyear("N/A");
                }
                else {
                    java.sql.Date date = rs.getDate("foalyear");
                    DateFormat dateFormat = new SimpleDateFormat("yyyy");
                    String dateStr = dateFormat.format(date);
                    r.setFoalyear(dateStr);
                }

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

    @Override
    public RaceHorse getRaceHorse(int racehorseID) {
        String sql = "SELECT * FROM  horse WHERE horse_id =" + racehorseID;

        ResultSetExtractor<RaceHorse> extractor = new ResultSetExtractor<RaceHorse>() {

            @Override
            public RaceHorse extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {

                    RaceHorse r = new RaceHorse();
                    r.setId(racehorseID);
                    r.setName(rs.getString("name"));
                    r.setGender(rs.getString("gender"));


                    if(rs.getDate("foalyear") == null) {
                        r.setFoalyear("N/A");
                    }
                    else {
                        java.sql.Date date = rs.getDate("foalyear");
                        DateFormat dateFormat = new SimpleDateFormat("yyyy");
                        String dateStr = dateFormat.format(date);
                        r.setFoalyear(dateStr);
                    }


                    r.setLink(rs.getString("equibaselink"));
                    r.setOwner(rs.getString("owner"));
                    r.setTrainer(rs.getString("trainer"));
                    r.setComments(rs.getString("comments"));


                    return r;
                }

                return null;
            }

        };

        return jdbcTemplate.query(sql, extractor);


    }

    @Override
    public int save(RaceHorse r) {
        System.out.println("Save racehorse called" + r.getFoalyear());
        String sql = "INSERT INTO horse (name, gender, foalyear, equibaselink, owner, trainer, comments) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, r.getName(), r.getGender(), r.getFoalyear(), r.getLink(), r.getOwner(), r.getTrainer(), r.getComments());

    }

    @Override
    public int update(RaceHorse r) {
        System.out.println("update racehorse called" + r.getFoalyear());
        String sql = "UPDATE  horse SET name = ?, gender = ?, foalyear = ?, equibaselink = ?, owner = ?, trainer = ?, comments = ? WHERE horse_id =?";
        return jdbcTemplate.update(sql, r.getName(), r.getGender(), r.getFoalyear(), r.getLink(), r.getOwner(), r.getTrainer(), r.getComments(), r.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM  horse WHERE horse_id =" + id;
        return jdbcTemplate.update(sql);
    }

    @Override
    public int changeName(Integer id, String name) {
        String sql = "Update horse set name = ? WHERE horse_id =" + id;
        return jdbcTemplate.update(sql, name);
    }
    @Override
    public int changeGender(Integer id, String gender) {
        String sql = "Update horse set gender = ? WHERE horse_id =" + id;
        return jdbcTemplate.update(sql, gender);
    }
    @Override
    public int changeFoal(Integer id, String foalyear) {
        String sql = "Update horse set foalyear = ? WHERE horse_id =" + id;
        return jdbcTemplate.update(sql, foalyear);
    }
    @Override
    public int changeLink(Integer id, String link) {
        System.out.println("LINK IS " + link);
        String sql = "Update horse set equibaselink = ? WHERE horse_id =" + id;
        return jdbcTemplate.update(sql, link);
    }
    @Override
    public int changeOwner(Integer id, String owner) {
        String sql = "Update horse set owner = ? WHERE horse_id =" + id;
        return jdbcTemplate.update(sql, owner);
    }
    @Override
    public int changeTrainer(Integer id, String trainer) {
        String sql = "Update horse set trainer = ? WHERE horse_id =" + id;
        return jdbcTemplate.update(sql, trainer);
    }
    @Override
    public int changeComments(Integer id, String comments) {
        String sql = "Update horse set comments = ? WHERE horse_id =" + id;
        return jdbcTemplate.update(sql, comments);
    }

}
