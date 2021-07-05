package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
public class Insert {

	public static void insert() {
		Scanner scanner=new Scanner(System.in);
	
		System.out.println("enter id ");
		int id=scanner.nextInt();
		System.out.println("enter name");
		String name=scanner.next();
		System.out.println("enter branch");
		String branch=scanner.next();
		Connection connection=null;
		PreparedStatement prepare=null;
		 String dbUrl="jdbc:mysql://localhost:3306/employee?user=root&password=root";
		String query="insert into student values(?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection=DriverManager.getConnection(dbUrl);
			
		prepare=connection.prepareStatement(query);
		prepare.setInt(1, id);
		prepare.setString(2,name);
		prepare.setString(3,branch);
		int result=prepare.executeUpdate();
//		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(connection!= null) {
					connection.close();
				}
				if(prepare!=null) {
					prepare.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
}public static void delete() {
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter id for delete operation");
	int id=scanner.nextInt();
	
	Connection connection=null;
	Statement statement =null;

	try {
		FileInputStream fileinputStream=new FileInputStream("sql.properties");
		Properties properties=new Properties();
		
		properties.load(fileinputStream);
		
		Class.forName(properties.getProperty("driverpath"));
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=root");
		 
		 statement=(Statement) connection.createStatement();
	int result=statement.executeUpdate("DELETE FROM student WHERE id='" + id +"' ;");
		if(result!=0) {
			System.out.println(result+"rows effected");
			System.out.println("data deletion is succesfull");
		}
	
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	finally {
		try {
			if(connection!=null)
		{		
			
				connection.close();
			}
			if(statement!=null) {
				statement.close();
			}
		}catch (Exception e) {
				
				e.printStackTrace();
			}
		
		}
}	public static void update() {
	Scanner scanner=new Scanner(System.in);
	PreparedStatement prepare=null;
	Connection connection=null;
	Statement statement =null;
	System.out.println("enter id ");
	int id=scanner.nextInt();
	System.out.println("enter name");
	String name=scanner.next();
	System.out.println("enter branch");
	String branch=scanner.next();
	System.out.println("enter id which you want to  update ");
	int refid=scanner.nextInt();
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=root");
		 statement=(Statement) connection.createStatement();
		 String query="update student set id=? ,name=?,branch= ? where id='" + refid +"'";
//	int result=statement.executeUpdate("update student set id=? ,name=?,branch= ?,where id='"+refid+"'");
	prepare=connection.prepareStatement(query);
	prepare.setInt(1, id);
	prepare.setString(2,name);
	prepare.setString(3,branch);
	int result=prepare.executeUpdate();
		if(result!=0) {
			System.out.println(result+"rows effected");
			System.out.println("data update is succesfull");
		}else {
			System.out.println("data update is not succesfull");
		}
	
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	finally {
		try {
			if(connection!=null)
		{		
			
				connection.close();
			}
			if(statement!=null) {
				statement.close();
			}
		}catch (Exception e) {
				
				e.printStackTrace();
			}
		
		}
}
}
