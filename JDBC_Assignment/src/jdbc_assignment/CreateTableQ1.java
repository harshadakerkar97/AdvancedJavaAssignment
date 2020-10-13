package jdbc_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTableQ1 {
	public static void main(String[] args) {
		try {
//			1. register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
//			2. get connection
			Connection con=DriverManager.getConnection
				("jdbc:mysql://localhost:3306/jdbc_assignment","root","root");
//			3. create statement object
			Statement s=con.createStatement();
//			4. execute query
			String sql="create table student(rno int(10),name varchar(20),marks double(4,2),dob date)";
			boolean bool=s.execute(sql);
			if(bool) {
				System.out.println("Table added successfully");
			}
//			5. close connection
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
