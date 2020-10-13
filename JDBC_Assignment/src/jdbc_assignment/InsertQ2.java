package jdbc_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertQ2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/jdbc_assignment","root","root");
		PreparedStatement p=con.prepareStatement("insert into student values(?,?,?,?)");
		p.setInt(1,104);
		p.setString(2,"ravan");
		p.setDouble(3,40);
		p.setString(4,"1969/04/15");
		int i=p.executeUpdate();
		if(i>0) {
			System.out.println("Record added Successfully!!!");
		}
		con.close();
	}
}
