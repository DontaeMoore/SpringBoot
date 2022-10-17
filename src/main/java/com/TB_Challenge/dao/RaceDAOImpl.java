package com.TB_Challenge.dao;

import com.TB_Challenge.model.Challenge;
import com.TB_Challenge.model.Race;
import com.TB_Challenge.model.Status;
import com.TB_Challenge.model.Track;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class RaceDAOImpl implements RaceDAO {


    private final JdbcTemplate jdbcTemplate;

    public RaceDAOImpl(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Race> list(List<Track> t, int offset) {
        List<Race> list = jdbcTemplate.query("SELECT * FROM race ", new RowMapper<Race>() {

            @Override
            public Race mapRow(ResultSet rs, int rowNum) throws SQLException {
                Race r = new Race();

                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setYear(rs.getString("year"));
                r.setTrack_id(rs.getInt("track_id"));
                r.setDate(rs.getString("date"));
                String time = rs.getString("deadline");
                r.setDeadline(time.substring(0,5));
                r.setDistance(rs.getDouble("distance"));
                r.setFinish_time(rs.getDouble("finish_time"));

                for(Track track : t){
                    if(rs.getString("track_id").equals(track.getId().toString())){
                        r.setTrackName(track.getName());
                    }
                }



                System.out.println(r.toString() + " " + r.getFinish_time());


                return r;
            }

        });

        return list;

    }

    @Override
    public List<Race> listRaceNotInChallenge(int challengeId) {
        System.out.println("is races being hit");
        List<Race> list = jdbcTemplate.query("SELECT * FROM race where id NOT IN " +
                "(SELECT id FROM challenge_race join race where race_id = id And challenge_id =" + challengeId + ")"  , new RowMapper<Race>() {

            @Override
            public Race mapRow(ResultSet rs, int rowNum) throws SQLException {
                Race r = new Race();

                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setYear(rs.getString("year"));
                r.setTrack_id(rs.getInt("track_id"));
                r.setDate(rs.getString("date"));
                String time = rs.getString("deadline");
                r.setDeadline(time.substring(0,5));
                r.setDistance(rs.getDouble("distance"));
                r.setFinish_time(rs.getDouble("finish_time"));



                System.out.println(r.toString() + " " + r.getFinish_time());


                return r;
            }

        });

        return list;

    }
    @Override
    public List<Race> listSortByName(List<Track> t, int offset) {
        List<Race> list = jdbcTemplate.query("SELECT * FROM race order by name LIMIT 10 OFFSET " + offset, new RowMapper<Race>() {

            @Override
            public Race mapRow(ResultSet rs, int rowNum) throws SQLException {
                Race r = new Race();

                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setYear(rs.getString("year"));
                r.setTrack_id(rs.getInt("track_id"));
                r.setDate(rs.getString("date"));
                String time = rs.getString("deadline");
                r.setDeadline(time.substring(0,5));
                r.setDistance(rs.getDouble("distance"));
                r.setFinish_time(rs.getDouble("finish_time"));
                for(Track track : t){
                    if(rs.getString("track_id").equals(track.getId().toString())){
                        r.setTrackName(track.getName());
                    }
                }


                System.out.println(r.toString() + " " + r.getFinish_time());


                return r;
            }

        });

        return list;

    }
    @Override
    public List<Race> listSortByDate(List<Track> t, int offset) {
        List<Race> list = jdbcTemplate.query("SELECT * FROM race order by date LIMIT 10 OFFSET " + offset, new RowMapper<Race>() {

            @Override
            public Race mapRow(ResultSet rs, int rowNum) throws SQLException {
                Race r = new Race();

                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setYear(rs.getString("year"));
                r.setTrack_id(rs.getInt("track_id"));
                r.setDate(rs.getString("date"));
                String time = rs.getString("deadline");
                r.setDeadline(time.substring(0,5));
                r.setDistance(rs.getDouble("distance"));
                r.setFinish_time(rs.getDouble("finish_time"));
                for(Track track : t){
                    if(rs.getString("track_id").equals(track.getId().toString())){
                        r.setTrackName(track.getName());
                    }
                }


                System.out.println(r.toString() + " " + r.getFinish_time());


                return r;
            }

        });

        return list;

    }

    @Override
    public List<Track> getTracks() {
        List<Track> list = jdbcTemplate.query("SELECT * FROM tracks ", new RowMapper<Track>() {

            @Override
            public Track mapRow(ResultSet rs, int rowNum) throws SQLException {
               Track t = new Track();

                t.setId(rs.getInt("id"));
                t.setName(rs.getString("name"));




                System.out.println(t.toString());


                return t;
            }

        });

        return list;



    }

    @Override
    public Race getRace(int raceID, List<Track> t) {
        String sql = "SELECT * FROM  race WHERE id =" + raceID;

        ResultSetExtractor<Race> extractor = new ResultSetExtractor<Race>() {

            @Override
            public Race extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {

                    Race r = new Race();
                    r.setId(raceID);
                    r.setName(rs.getString("name"));
                    r.setYear(rs.getString("year"));
                    r.setTrack_id(rs.getInt("track_id"));
                    r.setDate(rs.getString("date"));
                    String time = rs.getString("deadline");
                    r.setDeadline(time.substring(0,5));
                    r.setDistance(rs.getDouble("distance"));
                    r.setFinish_time(rs.getDouble("finish_time"));
                    for(Track track : t){
                        if(rs.getString("track_id").equals(track.getId().toString())){
                            r.setTrackName(track.getName());
                        }
                    }
                    return r;
                }

                return null;
            }

        };

        return jdbcTemplate.query(sql, extractor);


    }

    @Override
    public Race getRaceID(String name2) {

        String sql = "SELECT * FROM race WHERE name = '" + name2 + "'";


        ResultSetExtractor<Race> extractor = new ResultSetExtractor<Race>() {

            @Override
            public Race extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {

                    Race r = new Race();
                    r.setId(rs.getInt("id"));
                    r.setName(rs.getString("name"));
                    r.setYear(rs.getString("year"));
                    r.setTrack_id(rs.getInt("track_id"));
                    r.setDate(rs.getString("date"));
                    String time = rs.getString("deadline");
                    r.setDeadline(time.substring(0,5));
                    r.setDistance(rs.getDouble("distance"));
                    r.setFinish_time(rs.getDouble("finish_time"));

                    return r;
                }

                return null;
            }

        };

        return jdbcTemplate.query(sql, extractor);


    }

    @Override
    public int save(Race r) {
        String sql = "INSERT INTO race (year, name, track_id, date, deadline, distance, finish_time) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, r.getYear(), r.getName(), r.getTrack_id(), r.getDate(), r.getDeadline(), r.getDistance(), r.getFinish_time());

    }

    @Override
    public int update(Race r) {
        String sql = "UPDATE  race SET year = ?, name = ?, track_id = ?, date = ?, deadline = ?, distance = ?, finish_time = ? WHERE id =?";
        return jdbcTemplate.update(sql, r.getYear(), r.getName(), r.getTrack_id(), r.getDate(), r.getDeadline(), r.getDistance(), r.getFinish_time(), r.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM  race WHERE id =" + id;
        return jdbcTemplate.update(sql);
    }

    @Override
    public int changefinish(Integer id, double new_finish) {
        String sql = "Update race set finish_time = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, new_finish);
    }

    @Override
    public int changedist(Integer id, double new_dist) {
        String sql = "Update race set distance = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, new_dist);
    }

    @Override
    public int changedead(Integer id, String dead) {
        String sql = "Update race set deadline = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, dead);
    }

    @Override
    public int changetrackID(Integer id, Integer trackid) {
        String sql = "Update race set track_id = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, trackid);
    }
    @Override
    public int changeDate(Integer id, String date) {
        String sql = "Update race set date = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, date);
    }
    @Override
    public int changeName(Integer id, String name) {
        String sql = "Update race set name = ? WHERE id =" + id;
        return jdbcTemplate.update(sql, name);
    }


}
