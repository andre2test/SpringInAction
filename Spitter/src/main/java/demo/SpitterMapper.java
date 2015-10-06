package demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SpitterMapper implements RowMapper<Spitter> {

	public Spitter mapRow(ResultSet rs, int rowNum) throws SQLException {
		Spitter spitter = new Spitter();
		spitter.setUsername(rs.getString("username"));
		spitter.setPassword(rs.getString("password"));
		spitter.setFullname(rs.getString("fullname"));
		return spitter;
	}

}
