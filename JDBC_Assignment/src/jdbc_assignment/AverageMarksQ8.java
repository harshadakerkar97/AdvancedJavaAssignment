package jdbc_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AverageMarksQ8 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost/jdbc_assignment","root","root");
		String sql="SELECT AVG(MARKS) FROM STUDENT";
		PreparedStatement p=con.prepareStatement(sql);
		ResultSet rs=p.executeQuery();
		rs.next();
		System.out.println("Average of student marks : "+rs.getDouble(1));
		con.close();
	}

}
