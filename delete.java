package employeemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class delete {
	public static void main(String[] args) {
		Connection connection = connectionpool.getConnectionObject();
		String query = "delete from employeemanagement where id=?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			Scanner scanner=new Scanner(System.in);
			  System.out.println("Enter the id");
			  int id = scanner.nextInt();
			  statement.setInt(1, id);
			  statement.execute();
			  System.out.print("deleted successfull");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
