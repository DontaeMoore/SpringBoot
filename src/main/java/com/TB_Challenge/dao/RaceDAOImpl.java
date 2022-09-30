package com.TB_Challenge.dao;

import com.TB_Challenge.config.model.Race;
import com.TB_Challenge.config.model.Track;
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
    public List<Race> list() {
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
                //Track t = getTrackName(r.getTrack_id());
                //r.setTrackName(t.getName());
                r.setTrackName(r.getTrack_id() + " ");


                System.out.println(r.toString() + " " + r.getFinish_time());


                return r;
            }

        });

        return list;

    }

    @Override
    public Track getTrackName(int trackID) {
        String sql = "SELECT name FROM  tracks WHERE id =" + trackID;

        ResultSetExtractor<Track> extractor = new ResultSetExtractor<Track>() {

            @Override
            public Track extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    String name = rs.getString("name");


                    return new Track(trackID, name, "", "", "", "");
                }

                return null;
            }

        };

        return jdbcTemplate.query(sql, extractor);


    }

    @Override
    public Race getRace(int raceID) {
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
                    Track t = getTrackName(r.getTrack_id());
                    r.setTrackName(t.getName());

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
