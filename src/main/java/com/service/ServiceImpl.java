package com.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Dao;
import com.model.User;
import com.service.UserService;

@Service
public class ServiceImpl implements UserService {
	@Autowired
	private Dao dao;

	public int deleteUser(Integer id) throws SQLException  {
		int count = dao.deleteUser(id);
		return count;
	}

	public List<User> showAllUsers() {
		List<User> empList = dao.showAllUsers();
		return empList;
	}

	public Integer updateUser(User user) throws SQLException {
		int count = dao.updateUser(user);
		return count;
	}

	@Override
	public Integer insertUser(User user) {
		Integer id = dao.insertUser(user);
		return id;
	}

	@Override
	public User selectUser(Integer id) {
		User user = dao.selectUser(id);
		return user;
	}
}