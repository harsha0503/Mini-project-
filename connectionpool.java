package employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class connectionpool {
	static int pool_size =4;
	static String url="jdbc:postgresql://localhost:5432/employeemanagement?user=postgres&password=root";
	static List<Connection> connectionPool = new ArrayList<Connection>();
	static {
		try {
			Class.forName("org.postgresql.Driver");
			for(int i=0;i<pool_size;i++) {
				Connection connection =createConnection();
				connectionPool.add(connection);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection createConnection(){
	Connection connection = null;
	try {
		connection=DriverManager.getConnection(url);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
	}
	public static Connection getConnectionObject() {
		if(!connectionPool.isEmpty())
	{
			return connectionPool.remove(0);
			
		}
		else {
			return createConnection();
		}	
	}
	public static void recieveConnection(Connection connection) {
		if(connectionPool.size()<pool_size) {
			connectionPool.add(connection);
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
