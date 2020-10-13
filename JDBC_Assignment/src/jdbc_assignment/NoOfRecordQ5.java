package jdbc_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NoOfRecordQ5 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/jdbc_assignment","root","root");
		String sql="SELECT COUNT(*) FROM STUDENT";
		PreparedStatement p=con.prepareStatement(sql);
		ResultSet rs=p.executeQuery();
		rs.next();
		System.out.println("Number of Student Record : "+rs.getInt(1));
		con.close();		
	}
}
