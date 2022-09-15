package com.TB_Challenge.dao;

import com.TB_Challenge.model.Track;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrackDAOImpl implements TrackDAO {

	private final JdbcTemplate jdbcTemplate;

	public TrackDAOImpl(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Track c) {
		String sql = "INSERT INTO tracks (name, city, state, zip, ownership) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, c.getName(), c.getCity(), c.getState(), c.getZip(), c.getOwnership());

	}

	@Override
	public int update(Track c) {
		String sql = "UPDATE  tracks SET name = ?, city = ?, state = ?, zip = ?, ownership = ? WHERE id =?";
		return jdbcTemplate.update(sql, c.getName(), c.getCity(), c.getState(), c.getZip(), c.getOwnership(), c.getId());
	}

	@Override
	public Track get(final Integer id) {
		String sql = "SELECT * FROM  tracks WHERE id =" + id;

		ResultSetExtractor<Track> extractor = new ResultSetExtractor<Track>() {

			@Override
			public Track extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					String city = rs.getString("city");
					String state = rs.getString("state");
					String zip = rs.getString("zip");
					String ownership = rs.getString("ownership");

					return new Track(id, name, city, state, zip, ownership);
				}

				return null;
			}

		};

		return jdbcTemplate.query(sql, extractor);


	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM  tracks WHERE id =" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Track> list() {
		List<Track> list = jdbcTemplate.query("SELECT * FROM TRACKS", new RowMapper<Track>() {

			@Override
			public Track mapRow(ResultSet rs, int rowNum) throws SQLException {
				Track t = new Track();

				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setCity(rs.getString("city"));
				t.setState(rs.getString("state").toUpperCase());
				t.setZip(rs.getString("zip"));
				t.setOwnership(rs.getString("ownership"));
				t.findTemp();


				return t;
			}

		});

		return list;

	}

	@Override
	public List<Integer> getTrackID() {

		ArrayList<Integer> slist = new ArrayList<Integer>();

		List<Track> list = jdbcTemplate.query("SELECT * FROM TRACKS", new RowMapper<Track>() {

			@Override
			public Track mapRow(ResultSet rs, int rowNum) throws SQLException {
				Track t = new Track();


				slist.add(rs.getInt("id"));

				return t;
			}

		});

		return slist;


	}

}
