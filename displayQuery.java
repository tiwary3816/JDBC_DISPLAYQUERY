package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Result;
public class studentDisplayController {
	public static void main(String[] args) {
		
		Connection connection =null;
		try {
			Driver driver =new Driver();
			DriverManager.registerDriver(driver);
			
			String url=("jdbc:mysql://localhost:3306/view");
			String user="root";
			String pass="root";
			
			connection=DriverManager.getConnection(url, user, pass);
			
			Statement statement =connection.createStatement();
			
			String displayQuery="select * from student";
			
			ResultSet resultSet=statement.executeQuery(displayQuery);
			
			System.out.println("student details");
			
			while(resultSet.next()) {
				System.out.println(":----------------------");
				System.out.println("student id="+resultSet.getInt("id"));

				System.out.println("student id="+resultSet.getString("name"));

				System.out.println("student id="+resultSet.getString("email"));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}finally {
			
			try {
				connection.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}

		}
	}
}
