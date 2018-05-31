package com.capgemini.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.model.User;
import com.capgemini.repository.util.UserRowMapper;

@Repository("rideRepository")
public class LoginRepositoryImpl implements LoginRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	@Override
//	public Ride createRide(Ride ride) {
//		// update() used for INSERT, UPDATE, & DELETE... but NOT SELECT
//		// jdbcTemplate.update("insert into ride (name, duration) values (?,?)", ride.getName(), ride.getDuration());
//		
////		KeyHolder keyHolder = new GeneratedKeyHolder();
////		jdbcTemplate.update(new PreparedStatementCreator() {
////			
////			@Override
////			public PreparedStatement createPreparedStatement(Connection con) 
////					throws SQLException {
////				PreparedStatement ps = con.prepareStatement("insert into ride (name, duration) values (?,?)", new String[] {"id"});
////				ps.setString(1, ride.getName());
////				ps.setInt(2, ride.getDuration());
////				return ps;
////			}
////			
////		}, keyHolder);
////		
////		Number id = keyHolder.getKey();
//		
//		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate);
//		
//		// getting auto generated/incremented key
//		insert.setGeneratedKeyName("id");
//		
//		Map<String, Object> data = new HashMap<>();
//		data.put("name", ride.getName());
//		data.put("duration", ride.getDuration());
//		
//		List<String> columns = new ArrayList<>();
//		columns.add("name");
//		columns.add("duration");
//		
//		insert.setTableName("ride");
//		insert.setColumnNames(columns);
//	
//		Number id = insert.executeAndReturnKey(data);
//		
//		return getRide(id.intValue());
//	}
	
	@Override
	public User getUser(Integer id) {
		User user = jdbcTemplate.queryForObject("select * from user where id = ?", new UserRowMapper(), id);
		
		return user;
	}
	
	
	@Override
	public List<User> getUsers() {
		
		List<User> rides = jdbcTemplate.query("select * from user", new UserRowMapper());
		
		return rides;
	}
	
	@Override
	public User findUser(User login_user) {
		User user = jdbcTemplate.queryForObject("select * from user where username = ?", new UserRowMapper(), login_user.getUsername());
		
		return user;
	}
}
