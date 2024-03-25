package employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.postgresql.jdbc2.optional.ConnectionPool;

public class insertemployeedetails {
	public static void main(String[] args) {
	Connection connection = connectionpool.getConnectionObject();
	 String query="insert into employeemanagement values(?,?,?,?,?)";
	 
	 try {
		PreparedStatement statement = connection.prepareStatement(query);
		Scanner scanner=new Scanner(System.in);
		
		System.out.print("enter ur id");
		int id = scanner.nextInt();
		statement.setInt(1, id);
		
		System.out.print("Enter ur age");
		int age= scanner.nextInt();
		statement.setInt(2, age);
		
		System.out.print("enter ur name");
		String name= scanner.next();
		statement.setString(3, name)
		;
		System.out.print("enter ur salary");
		int salary = scanner.nextInt();
		statement.setInt(4, salary);
		
		System.out.print("enter ur gender");
		String gender = scanner.next();
		statement.setString(5, gender);
		
		statement.execute();
		connectionpool.recieveConnection(connection);
		System.out.print("all done");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
