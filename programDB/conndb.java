package programDB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class conndb {
	
	public  Connection conn = null;
	public  Statement statmt = null;
	public  ResultSet resSet = null;
	
	
	public void Connect() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		
		
		// --------����������� � ���� ������--------
	Driver driver = (Driver)Class.forName("org.sqlite.JDBC").newInstance();
	
	String url = "jdbc:sqlite:d:\\sql\\Testdb";
	
	conn = DriverManager.getConnection(url);
	
	System.out.println("���� ����������!");
	}
	
	
	// --------�������� �������--------
		public void CreateDB() throws ClassNotFoundException, SQLException
		   {
			statmt = conn.createStatement();
			statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");
			
			System.out.println("������� ������� ��� ��� ����������.");
	}
		// --------���������� �������--------
		public void WriteDB() throws SQLException
		{
			   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
			   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
			   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");
			  
			   System.out.println("������� ���������");
	
		}
		
		public void ReadDB() throws ClassNotFoundException, SQLException
		   {
			resSet = statmt.executeQuery("SELECT * FROM users");
			
			while(resSet.next())
			{
				int id = resSet.getInt("id");
				String  name = resSet.getString("name");
				String  phone = resSet.getString("phone");
		         System.out.println( "ID = " + id );
		         System.out.println( "name = " + name );
		         System.out.println( "phone = " + phone );
		         System.out.println();
			}	
			
			System.out.println("������� ��������");
		    }
		
			// --------��������--------
			public void CloseDB() throws ClassNotFoundException, SQLException
			   {
				conn.close();
				statmt.close();
				resSet.close();
				
				System.out.println("���������� �������");
			   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	// --------����������� � ���� ������--------
	public static void Conn() throws ClassNotFoundException, SQLException 
	   {
		   conn = null;
		   Class.forName("org.sqlite.JDBC");
		   conn = DriverManager.getConnection("jdbc:sqlite:SQLite/DSA.s3db");
		   
		   System.out.println("���� ����������!");
	   }
	
	// --------�������� �������--------
	public static void CreateDB() throws ClassNotFoundException, SQLException
	   {
		statmt = conn.createStatement();
		statmt.execute("CREATE TABLE if not exists 'users' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");
		
		System.out.println("������� ������� ��� ��� ����������.");
	   }
	
	// --------���������� �������--------
	public static void WriteDB() throws SQLException
	{
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
		   statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");
		  
		   System.out.println("������� ���������");
	}
	
	// -------- ����� �������--------
	public static void ReadDB() throws ClassNotFoundException, SQLException
	   {
		resSet = statmt.executeQuery("SELECT * FROM users");
		
		while(resSet.next())
		{
			int id = resSet.getInt("id");
			String  name = resSet.getString("name");
			String  phone = resSet.getString("phone");
	         System.out.println( "ID = " + id );
	         System.out.println( "name = " + name );
	         System.out.println( "phone = " + phone );
	         System.out.println();
		}	
		
		System.out.println("������� ��������");
	    }
	
		// --------��������--------
		public static void CloseDB() throws ClassNotFoundException, SQLException
		   {
			conn.close();
			statmt.close();
			resSet.close();
			
			System.out.println("���������� �������");
		   }
*/
	}
