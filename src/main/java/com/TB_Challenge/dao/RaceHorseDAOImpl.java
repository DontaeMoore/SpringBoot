package com.TB_Challenge.dao;

import com.TB_Challenge.model.RaceHorse;
import com.TB_Challenge.model.User;
import com.TB_Challenge.model.UserPicks;
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
        List<RaceHorse> list = jdbcTemplate.query("SELECT * FROM horse", new RowMapper<RaceHorse>() {

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
    public RaceHorse getRaceHorseByName(String name) {
        String sql = "SELECT * FROM  horse WHERE name = '" + name + "'";

        ResultSetExtractor<RaceHorse> extractor = new ResultSetExtractor<RaceHorse>() {

            @Override
            public RaceHorse extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {

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


                    return r;
                }

                return null;
            }

        };

        return jdbcTemplate.query(sql, extractor);


    }

    @Override
    public List<RaceHorse> getRaceHorseInRace(int racehorseID) {

        String sql = "select * " +
                "from horse H " +
                "join horses_in_race R " +
                "on H.horse_id=R.H_horse_id " +
                "Where H_race_id = '" + racehorseID + "'";
        System.out.println(sql);

        List<RaceHorse> list = jdbcTemplate.query(sql, new RowMapper<RaceHorse>() {

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
                r.setPost(rs.getInt("post_position"));



                System.out.println(r.toString() + " " );


                return r;
            }

        });

        return list;


    }

    @Override
    public List<RaceHorse> getRaceHorseNotInRace(int racehorseID) {

        String sql = "select * from horse where horse_id NOT IN (select H.horse_id " +
                " from horse H " +
                "join horses_in_race R  " +
                "on H.horse_id=R.H_horse_id " +
                "Where H_race_id = '" + racehorseID + "' )";
        System.out.println(sql);

        List<RaceHorse> list = jdbcTemplate.query(sql, new RowMapper<RaceHorse>() {

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
    public List<UserPicks> listPicks() {
        List<UserPicks> list = jdbcTemplate.query("SELECT * FROM userpicks", new RowMapper<UserPicks>() {

            @Override
            public UserPicks mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserPicks u = new UserPicks();


                u.setUser_id(rs.getInt("up_user_id"));
                u.setRace_id(rs.getInt("up_race_id"));
                u.setHorse_id(rs.getInt("up_horse_id"));







                return u;
            }

        });

        return list;

    }

    @Override
    public List<UserPicks> listPicks(User user) {
        List<UserPicks> list = jdbcTemplate.query("SELECT * FROM userpicks " +
                "join horse join race where up_horse_id = horse_id and up_race_id = id and up_user_id =" + user.getId(), new RowMapper<UserPicks>() {

            @Override
            public UserPicks mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserPicks u = new UserPicks();


                u.setUser_id(rs.getInt("up_user_id"));
                u.setRace_id(rs.getInt("up_race_id"));
                u.setHorse_id(rs.getInt("up_horse_id"));
                u.setHorseName(rs.getString(6));
                u.setRaceName(rs.getString(15));
                u.setDate(rs.getString(17));







                return u;
            }

        });

        return list;

    }

    @Override
    public int updatePick(Integer user_id, Integer race_id, Integer horse_id) {
       String sql = "INSERT INTO userpicks (up_user_id, up_race_id, up_horse_id) values (?, ?, ?) ON DUPLICATE KEY UPDATE up_horse_id = ?";
        return jdbcTemplate.update(sql, user_id, race_id, horse_id, horse_id);
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

    @Override
    public int deleteRace(Integer hID, Integer rID) {
        String sql = "DELETE FROM horses_in_race where H_horse_id = ? AND H_race_id = ?";
        return jdbcTemplate.update(sql, hID, rID);
    }

}
