package org.sun.bootapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.sun.bootapp.dao.UserJdbcDAO;
import org.sun.bootapp.entity.User;

@Component
public class UserJdbcDAOImpl implements UserJdbcDAO {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<User> queryUsers() {
		logger.debug("===UserJdbcDAOImpl queryUsers");
		final String sql = "SELECT * FROM USERS";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}

	@Override
	public int insertUser(User user) {
		final String sql = "INSERT INTO USERS(name,sex,age,date) VALUES(?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getName());
				ps.setString(2, user.getSex());
				ps.setInt(3, user.getAge());
				ps.setTimestamp(4, new Timestamp((user.getDate()).getTime()) );
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue(); 
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
