package com.model;


import java.sql.SQLException;
import java.util.List;

public interface Dao {
	public Integer insertUser(User user) ;

	public User selectUser(Integer id);

	public int updateUser(User user) throws SQLException ;

	public int deleteUser(Integer id) throws SQLException;

	public List<User> showAllUsers();
}
