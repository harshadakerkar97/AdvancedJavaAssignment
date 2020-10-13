package jdbc_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class No_of_ColumnsQ10 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/jdbc_assignment","root","root");
		String sql="select count(*) from information_schema.columns where table_name='student' and table_schema='jdbc_assignment';";
		PreparedStatement p=con.prepareStatement(sql);
		ResultSet rs=p.executeQuery();		
		rs.next();
		System.out.println("No of columns present in table is : "+rs.getInt(1));
		con.close();
	}
}
