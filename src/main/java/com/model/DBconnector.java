package com.model;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBconnector {
	 private static BasicDataSource dataSource;

	    static {
	        dataSource = new BasicDataSource();
	        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/vacation");
	        dataSource.setUsername("root");
	        dataSource.setPassword("2001");
	    }

	    public static Connection getConnection() throws SQLException {
	        Connection connection = dataSource.getConnection();
	        return connection;
	    }

}