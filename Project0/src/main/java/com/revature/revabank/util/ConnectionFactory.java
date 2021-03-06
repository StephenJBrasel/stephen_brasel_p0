package com.revature.revabank.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.postgresql.Driver;

public class ConnectionFactory {
	private static ConnectionFactory connFactory = new ConnectionFactory();
	private Properties props = new Properties();

	private ConnectionFactory(){
		try {
			props.load(new FileReader("./src/main/resources/application.properties"));
			if(props.isEmpty()){
				props.load(new FileReader("./application.properties"));
			}
		} catch (IOException e) {
			System.out.println("Failed to load application properties. ");
//			e.printStackTrace();
		}
	}

	public static ConnectionFactory getInstance() {
		return connFactory;
	}

	public Connection getConnection(){
		Connection conn = null;
		try {
			// Force the JVM to load the PostGreSQL JDBC driver.
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("PostGreSQL class could not be found.");
			e.printStackTrace();
		}
		try{
			conn = DriverManager.getConnection(
					"jdbc:" +
							"postgresql://" +
							props.getProperty("url") +
							":5432" +
							"/postgres",
					props.getProperty("username"),
					props.getProperty("password")
			);
		} catch(SQLException e) {
			System.out.println("A connection could not be established.");
			e.printStackTrace();
		}
		if(conn == null){
			throw new RuntimeException("Failed to establish connection");
		}
		return conn;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Clone method not supported for singleton ConnectionFactory.");
	}
}
