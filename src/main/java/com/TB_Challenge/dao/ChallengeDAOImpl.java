package com.TB_Challenge.dao;

import com.TB_Challenge.model.Challenge;
import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.Status;
import com.TB_Challenge.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class ChallengeDAOImpl implements ChallengeDAO {



    private final JdbcTemplate jdbcTemplate;

    public ChallengeDAOImpl(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    private RaceDAO raceDAO;




    @Override
    public List<Challenge> list(List<Status> s, int offset) {
        List<Challenge> list = jdbcTemplate.query("SELECT * FROM challenge order by date LIMIT 10 OFFSET "+offset, new RowMapper<Challenge>() {

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

                for(Status stat : s){
                    if(rs.getString("status").equals(stat.getId().toString())){
                        c.setStatus(stat.getName());
                    }
                }

                c.setDate(rs.getString("date"));



                System.out.println(c.toString());


                return c;
            }

        });

        return list;

    }
    @Override
    public List<Status> status() {
        List<Status> list = jdbcTemplate.query("SELECT * FROM statuslookup", new RowMapper<Status>() {

            @Override
            public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
                Status c = new Status();

                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDesc(rs.getString("description"));
                c.setStatus(rs.getString("status"));



                return c;
            }

        });

        return list;

    }


    @Override
    public Challenge getChallenge(int challengeID) {
        String sql = "SELECT * FROM  challenge WHERE id =" + challengeID;

        ResultSetExtractor<Challenge> extractor = new ResultSetExtractor<Challenge>() {

            @Override
            public Challenge extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {

                    Challenge c = new Challenge();
                    c.setId(challengeID);
                    c.setName(rs.getString("name"));
                    c.setDesc(rs.getString("description"));
                    c.setFirst_points(rs.getInt("first_points"));
                    c.setSecond_points(rs.getInt("second_points"));
                    c.setThird_points(rs.getInt("third_points"));
                    c.setFourth_points(rs.getInt("fourth_points"));
                    c.setStatus(rs.getString("status"));
                    c.setDate(rs.getString("date"));

                    return c;
                }

                return null;
            }

        };

        return jdbcTemplate.query(sql, extractor);


    }

    @Override
    public int save(Challenge c) {
        String sql = "INSERT INTO challenge (name, description, first_points, second_points, third_points, fourth_points, status, date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, c.getName(), c.getDesc(), c.getFirst_points(), c.getSecond_points(), c.getThird_points(), c.getFourth_points(), c.getStatus(), c.getDate());

    }

    @Override
    public int update(Challenge c) {
        String sql = "UPDATE  challenge SET name = ?, description = ?, first_points = ?,second_points = ?, third_points = ?, fourth_points = ?, status = ?, date = ? WHERE id =?";
        return jdbcTemplate.update(sql,c.getName(), c.getDesc(), c.getFirst_points(), c.getSecond_points(), c.getThird_points(), c.getFourth_points(), c.getStatus(), c.getDate(), c.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM  challenge WHERE id =" + id;
        return jdbcTemplate.update(sql);
    }

    @Override
    public List<Race> listRaces(int challengeID, List<Track> t) {

        List<Race> list = jdbcTemplate.query("SELECT * FROM challenge_race join race where race_id = id AND challenge_id =" + challengeID, new RowMapper<Race>() {

            @Override
            public Race mapRow(ResultSet rs, int rowNum) throws SQLException {


                    Race r = new Race();

                    r.setId(rs.getInt("id"));
                    r.setName(rs.getString("name"));
                    int track_id = rs.getInt("track_id");
                    r.setTrack_id(track_id);
                for(Track track : t){
                    if(rs.getString("track_id").equals(track.getId().toString())){
                        r.setTrackName(track.getName());
                    }
                }
                    r.setYear(rs.getString("year"));
                    r.setDate(rs.getString("date"));


                    System.out.println(r.toString());


                    return r;
                }


        });

        return list;

    }

    @Override
    public int deleteRace(Integer Cid, Integer Rid) {
        String sql = "DELETE FROM challenge_race where challenge_id = ? AND race_id = ?";
        return jdbcTemplate.update(sql, Cid, Rid);
    }


    @Override
    public int changeName(Integer id, String name) {
        String sql = "Update challenge set name = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, name);
    }

    @Override
    public int changeDesc(Integer id, String desc) {
        String sql = "Update challenge set description = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, desc);
    }
    @Override
    public int changeFirst(Integer id, Integer first) {
        String sql = "Update challenge set first_points = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, first);
    }
    @Override
    public int changeSecond(Integer id, Integer second) {
        String sql = "Update challenge set second_points = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, second);
    }
    @Override
    public int changeThird(Integer id, Integer third) {
        String sql = "Update challenge set third_points = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, third);
    }
    @Override
    public int changeFourth(Integer id, Integer fourth) {
        String sql = "Update challenge set fourth_points = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, fourth);
    }
    @Override
    public int changeStatus(Integer id, String status) {
        String sql = "Update challenge set status = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, status);
    }
    @Override
    public int changeDate(Integer id, String date) {
        String sql = "Update challenge set date = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, date);
    }


}
