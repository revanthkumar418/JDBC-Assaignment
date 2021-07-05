package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.mysql.jdbc.Statement;

public class StaticInsert {

	public static void staticIn() {
		Connection connection=null;
		Statement statement=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=root");
			 statement=(Statement) connection.createStatement();
			int result =statement.executeUpdate("insert into student values(42,'vikas','ec')");
			if(result!=0) {
				System.out.println(result+"rows effected");
				System.out.println("data upload succesfully ");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(connection!=null) {
				
					connection.close();
				}
			if(statement!=null) {
				
					statement.close();
			}
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
	}public static void delete() {
		
		
		Connection connection=null;
		Statement statement =null;

		try {
			FileInputStream fileinputStream=new FileInputStream("sql.properties");
			Properties properties=new Properties();
			
			properties.load(fileinputStream);
			
			Class.forName(properties.getProperty("driverpath"));
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=root");
			 
			 statement=(Statement) connection.createStatement();
		int result=statement.executeUpdate(properties.getProperty("DELETE FROM student WHERE id=11;"));
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
}	
	public static void update() {
	Connection connection=null;
	Statement statement =null;

	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee?user=root&password=root");
		 statement=(Statement) connection.createStatement();
	int result=statement.executeUpdate("update student set id=100 ,name='karan',branch='eee' where id=6");
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
