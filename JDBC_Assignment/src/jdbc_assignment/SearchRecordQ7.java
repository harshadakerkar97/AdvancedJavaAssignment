package jdbc_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchRecordQ7 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/jdbc_assignment","root","root");
		System.out.print("Enter student roll no : ");
		String sql="SELECT * FROM student where rno=?";
		Scanner sc=new Scanner(System.in);
		int id=sc.nextInt();
		PreparedStatement p=con.prepareStatement(sql);
		p.setInt(1, id);
		ResultSet rs=p.executeQuery();
		System.out.println("Student Record : ");
		System.out.println("-----------------");
		while(rs.next()) {
			System.out.println("Id : "+rs.getInt(1));
			System.out.println("Name : "+rs.getString(2));
			System.out.println("Marks : "+rs.getDouble(3));
			System.out.println("DOB : "+rs.getString(4));
			System.out.println("======================");
		}
		con.close();
		sc.close();
	}
}
