package com.bits.cms.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CmsConnectToDB {
		// Connection instance
		private static Connection connection = null;

		// Opening connection with database
		public static Connection createConnection() throws ClassNotFoundException,
				SQLException {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root");
			DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver());
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "root");
			
			return connection;
		}

		// Closing connection
		public static void closeConnection() throws SQLException {
			connection.close();
		}
		
		
}
