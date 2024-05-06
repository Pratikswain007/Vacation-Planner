package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public  class ImplementationDAO implements Dao {
	

	private static final String INSERT_USERS_SQL = "insert into user" + "  (name, location,modeoftravel,duration,email) VALUES "
			+ " (?, ?, ?,?,?);";

	private static final String SELECT_USER_BY_ID = "select id, location,modeoftravel,duration,email from user where id =?";
	private static final String SELECT_ALL_USERS = "select * from user";
	private static final String DELETE_USERS_SQL = "delete from user where id = ?;";
	private static final String UPDATE_USERS_SQL = "update user set name = ?,location= ?, modeoftravel =? ,duration=?,email=? where id = ?;";

	public ImplementationDAO() {
	}


	public Integer insertUser(User user) {
		System.out.println(INSERT_USERS_SQL);
		int out=0;
		try (Connection connection = DBconnector.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL,Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLocation());
			preparedStatement.setString(3, user.getModeoftravel());
			preparedStatement.setInt(4, user.getDuration());
			preparedStatement.setString(5, user.getEmail());
			System.out.println(preparedStatement);
			out=preparedStatement.executeUpdate();
			if(out>0) {
				try(ResultSet rs=preparedStatement.getGeneratedKeys()){
					if(rs.next()) {
						Integer id=rs.getInt(1);
						System.out.println("User added Successfully:"+ id);
						return id;
					}else {
						System.out.println("User not added");
						return out;
					}
				}
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return out;
	}

	public User selectUser(Integer id) {
		User user = null;
		try (Connection connection = DBconnector.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String location = rs.getString("location");
				String modeoftravel = rs.getString("modeoftravel");
				int duration = rs.getInt("duration");
				String email = rs.getString("email");
				
				user = new User(id,name, location,modeoftravel,duration,email);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> showAllUsers() {

		List<User> users = new ArrayList<>();
		try (Connection connection = DBconnector.getConnection();
			
			PreparedStatement psm = connection.prepareStatement("select * from user");) {
			
			ResultSet rs = psm.executeQuery();

			while (rs.next()) {
				User person =new User();
				person.setId(rs.getInt("id"));
				person.setName(rs.getString("name"));
				person.setLocation(rs.getString("location"));
				person.setModeoftravel(rs.getString("modeoftravel"));
				person.setDuration(rs.getInt("duration"));
				person.setEmail(rs.getString("email"));
				
				users.add(person);
				
				}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public int deleteUser(Integer id) throws SQLException {
		int  rowDeleted;
		try (Connection connection = DBconnector.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate();
		}
		return rowDeleted;
	}

	public int updateUser(User user) throws SQLException {
		int rowUpdated;
		try (Connection connection = DBconnector.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getLocation());
			statement.setString(3, user.getModeoftravel());
			statement.setInt(4, user.getDuration());
			statement.setString(5, user.getEmail());
			statement.setInt(6, user.getId());

			rowUpdated = statement.executeUpdate();
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}


	}
