package employeemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class upadate {
public static void main(String[] args) {
	Connection connection = connectionpool.getConnectionObject();
	String query = "update employeemanagement set age=25 where id =?";
	try {
		PreparedStatement statement = connection.prepareStatement(query);
		Scanner scanner=new Scanner(System.in);
		System.out.print("enter your id");
		int id=scanner.nextInt();
		statement.setInt(1, id);
		statement.execute();
		connectionpool.recieveConnection(connection);
		  System.out.print("delted");
		  System.out.println("all done");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
