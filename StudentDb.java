package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentDb {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("enter your choice to select static-1 or dynamic-2");
		int choice=scanner.nextInt();
		
		if(choice==1) {
			
			System.out.println("enter your operation 1-for insertion,2-for deletion ,3-for upadate");
			int op=scanner.nextInt();
			if(op==1) {
				StaticInsert staticInsert=new StaticInsert();
				staticInsert.staticIn();
				System.out.println("data inserted succesfully");
				
			}else if(op==2) {
				StaticInsert.delete();
				System.out.println("deletion was succesfull");
			}else if(op==3) {
				StaticInsert.update();
				
			}
			else {
				System.out.println("choosen option is invalid");
			}
			
		}else if(choice==2) {
			System.out.println("enter your operation 1-for insertion,2-for deletion ,3-for upadate");
			int op=scanner.nextInt();
			if(op==1) {
			Insert insert=new Insert();
			insert.insert();
				System.out.println("data inserted succesfully");	
		}else if(op==2) {
			Insert.delete();
		}else if(op==3) {
			Insert.update();
		}else {
			System.out.println("choosen option is invalid");
		}
		
		}
		
	}
}
