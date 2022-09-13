package com.TB_Challenge.dao;

import com.TB_Challenge.model.Race;
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
    public List<Race> list() {
        List<Race> list = jdbcTemplate.query("SELECT * FROM RACES ", new RowMapper<Race>() {

            @Override
            public Race mapRow(ResultSet rs, int rowNum) throws SQLException {
                Race r = new Race();

                r.setId(rs.getInt("id"));
                r.setName(rs.getString("name"));
                r.setYear(rs.getString("year"));
                r.setTrack_id(rs.getInt("track_id"));
                r.setDate(rs.getString("date"));
                r.setDeadline(rs.getString("deadline"));
                r.setDistance(rs.getString("distance"));
                r.setFinish_time(rs.getString("finish_time"));
                Track t = getTrackName(r.getTrack_id());
                r.setTrackName(t.getName());


                System.out.println(r.toString() + " " + r.getFinish_time());


                return r;
            }

        });

        return list;

    }

    @Override
    public Track getTrackName(int trackID) {
        String sql = "SELECT * FROM  tracks WHERE id =" + trackID;

        ResultSetExtractor<Track> extractor = new ResultSetExtractor<Track>() {

            @Override
            public Track extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String city = rs.getString("city");
                    String state = rs.getString("state");
                    String zip = rs.getString("zip");
                    String ownership = rs.getString("ownership");

                    return new Track(trackID, name, city, state, zip, ownership);
                }

                return null;
            }

        };

        return jdbcTemplate.query(sql, extractor);


    }

    @Override
    public Race getRace(int raceID) {
        String sql = "SELECT * FROM  races WHERE id =" + raceID;

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
                    r.setDeadline(rs.getString("deadline"));
                    r.setDistance(rs.getString("distance"));
                    r.setFinish_time(rs.getString("finish_time"));
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
        String sql = "INSERT INTO races (year, name, track_id, date, deadline, distance, finish_time) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, r.getYear(), r.getName(), r.getTrack_id(), r.getDate(), r.getDeadline(), r.getDistance(), r.getFinish_time());

    }

    @Override
    public int update(Race r) {
        String sql = "UPDATE  races SET year = ?, name = ?, track_id = ?, date = ?, deadline = ?, distance = ?, finish_time = ? WHERE id =?";
        return jdbcTemplate.update(sql, r.getYear(), r.getName(), r.getTrack_id(), r.getDate(), r.getDeadline(), r.getDistance(), r.getFinish_time(), r.getId());
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM  races WHERE id =" + id;
        return jdbcTemplate.update(sql);
    }


}
