package org.sun.bootapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.sun.bootapp.entity.User;

@Component
public class UserJdbcDAOImpl implements UserJdbcDAO{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> getUsers() {
		logger.debug("===UserJdbcDAOImpl getUsers");
		String sql = "SELECT * FROM USERS";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}

	class UserRowMapper implements RowMapper<User> {

	    @Override
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	        User user = new User();
	        user.setId(rs.getInt("id"));
	        user.setName(rs.getString("name"));
	        user.setSex(rs.getString("sex"));
	        user.setAge(rs.getInt("age"));
	        user.setDate(rs.getDate("date"));
	        return user;
	    }

	}
}
