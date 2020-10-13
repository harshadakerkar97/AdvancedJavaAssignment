package jdbc_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD_PreparedStateQ9 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int id;
		String name,dob;
		double marks;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/jdbc_assignment","root","root");
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			int op;
			System.out.println("Enter option : "
					+ "\n1.Insert record"
					+ "\n2.Update record"
					+ "\n3.Delete record"
					+ "\n4.Search record"
					+ "\n5.Show all records"
					+ "\n6.Exit");
			op=sc.nextInt();
			switch(op) {
			case 1:
				System.out.println("Insert record : ");
				System.out.print("Enter id :");
				id=sc.nextInt();
				System.out.print("Enter name :");
				name=sc.next();
				System.out.print("Enter marks :");
				marks=sc.nextDouble();
				System.out.print("Enter DOB :");
				dob=sc.next();
				PreparedStatement s=con.prepareStatement("insert into student values(?,?,?,?)");
				s.setInt(1, id);
				s.setString(2,name);
				s.setDouble(3, marks);
				s.setString(4, dob);
				int i=s.executeUpdate();
				if(i>0) {
					System.out.println("Record added successfully");
				}
				System.out.println("=============================");
				break;
			case 2:
				System.out.print("Enter id to update record :");
				id=sc.nextInt();
				System.out.print("enter name : ");
				name=sc.next();
				System.out.print("enter marks : ");
				marks=sc.nextDouble();
				s=con.prepareStatement("update student set name=?,marks=?where rno=?");
				s.setString(1,name);
				s.setDouble(2,marks);
				s.setInt(3,id);
				i=s.executeUpdate();
				if(i>0) {
					System.out.println("Updated successfully!!");
				}
				System.out.println("===============================");
				break;
			case 3:
				System.out.print("Enter id to delete record : ");
				id=sc.nextInt();
				s=con.prepareStatement("delete from student where rno =?");
				s.setInt(1,id);
				boolean b=s.execute();
				if(b) {
					System.out.println("record deleted successfully");
				}
				System.out.println("===========================");
				break;
			case 4:
				System.out.println("Search the student record by id : ");
				System.out.print("Enter student roll no : ");
				String sql="SELECT * FROM student where rno=?";
				id=sc.nextInt();
				s=con.prepareStatement(sql);
				s.setInt(1, id);
				ResultSet rs=s.executeQuery();
				System.out.println("Student Record : ");
				System.out.println("-----------------");
				while(rs.next()) {
					System.out.println("Id : "+rs.getInt(1));
					System.out.println("Name : "+rs.getString(2));
					System.out.println("Marks : "+rs.getDouble(3));
					System.out.println("DOB : "+rs.getString(4));
					System.out.println("======================");
				}
				break;
			case 5:
				sql="SELECT * FROM student";
				s=con.prepareStatement(sql);
				rs=s.executeQuery();
				System.out.println("Student Record : ");
				System.out.println("-----------------");
				while(rs.next()) {
					System.out.println("Id : "+rs.getInt(1));
					System.out.println("Name : "+rs.getString(2));
					System.out.println("Marks : "+rs.getDouble(3));
					System.out.println("DOB : "+rs.getString(4));
					System.out.println("======================");
				}
				break;
			case 6:
				System.out.println("Byeeee!!!!!");
				con.close();
				System.exit(0);
			}	
		}
	}	
}
