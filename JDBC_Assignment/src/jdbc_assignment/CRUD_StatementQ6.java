package jdbc_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD_StatementQ6 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		int id;
		String name,dob;
		double marks;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection
			("jdbc:mysql://localhost:3306/jdbc_assignment","root","root");
		Scanner sc=new Scanner(System.in);
		Statement s=con.createStatement();
		while(true) {
			int op;
			System.out.println("Enter option : "
					+ "\n1.Insert record"
					+ "\n2.Update record"
					+ "\n3.Delete record"
					+ "\n4.Exit");
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
				int i=s.executeUpdate("insert into student value("+id+",'"+name+"',"+
				marks+",'"+dob+"')");
				if(i>0) {
					System.out.println("Record added successfully");
				}
				break;
			case 2:
				System.out.print("Enter id to update record :");
				id=sc.nextInt();
				System.out.print("enter name : ");
				name=sc.next();
				System.out.print("enter marks : ");
				marks=sc.nextDouble();
				i=s.executeUpdate("update student set name='"+name+"',marks="+marks+"where rno="+id);
				if(i>0) {
					System.out.println("Updated successfully!!");
				}
				break;
			case 3:
				System.out.print("Enter id to delete record : ");
				id=sc.nextInt();
				boolean b=s.execute("delete from student where rno ="+id);
				if(b) {
					System.out.println("record deleted successfully");
				}
				break;
			case 4:
				System.out.println("Byeeee!!!!!");
				System.exit(0);
			}	
		}
	}	
}
