package employeemanagement;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class fetch {
public static void main(String[] args) {
	Connection connection = connectionpool.getConnectionObject();
	String query=" select * from employeemanagement";
	try {
		PreparedStatement statement = connection.prepareStatement(query);
		Statement statement1 = connection.createStatement();
		ResultSet rs = statement1.executeQuery(query);
		while(rs.next()){
			int id = rs.getInt(1);
			int age = rs.getInt(2);
			String name = rs.getString(3);
			System.out.println(id);
			System.out.println(name);
			System.out.println(age);
			System.out.println("=============");
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
