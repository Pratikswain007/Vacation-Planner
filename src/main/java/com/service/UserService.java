package com.service;
import java.sql.SQLException;
import java.util.List;
import com.model.User;
public interface  UserService {

		
		public Integer insertUser(User user);

		public  User selectUser(Integer id);

		public Integer updateUser(User user) throws SQLException;

		public int deleteUser(Integer id) throws SQLException;

		public List<User>showAllUsers();
	}

