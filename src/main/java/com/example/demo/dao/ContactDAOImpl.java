package com.example.demo.dao;

import com.example.demo.model.Contact;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactDAOImpl implements ContactDAO {

	private JdbcTemplate jdbcTemplate;

	public ContactDAOImpl(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Contact c) {
		String sql = "INSERT INTO tracks (name, city, state, zip, ownership) VALUES (?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, c.getName(), c.getCity(), c.getState(), c.getZip(), c.getOwnership());

	}

	@Override
	public int update(Contact c) {
		String sql = "UPDATE  tracks SET name = ?, city = ?, state = ?, zip = ?, ownership = ? WHERE id =?";
		return jdbcTemplate.update(sql, c.getName(), c.getCity(), c.getState(), c.getZip(), c.getOwnership(), c.getId());
	}

	@Override
	public Contact get(final Integer id) {
		String sql = "SELECT * FROM  tracks WHERE id =" + id;

		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					String city = rs.getString("city");
					String state = rs.getString("state");
					String zip = rs.getString("zip");
					String ownership = rs.getString("ownership");

					return new Contact(id, name, city, state, zip, ownership);
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
	public List<Contact> list() {
		List<Contact> list = jdbcTemplate.query("SELECT * FROM TRACKS", new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact t = new Contact();

				t.setId(rs.getInt("id"));
				t.setName(rs.getString("name"));
				t.setCity(rs.getString("city"));
				t.setState(rs.getString("state"));
				t.setZip(rs.getString("zip"));
				t.setOwnership(rs.getString("ownership"));

				return t;
			}

		});

		return list;

	}

}
