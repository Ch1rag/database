package database;

import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;
import java.sql.DriverManager;
import java.lang.ClassNotFoundException;

public class Connection {

	/**
	 * @param args
	 */
	
	public void getConnected() {
		java.sql.Connection connection=null;
		//Statement statement=null;
		//ResultSet resultSet=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ccc", "root", "root");
			/*statement=connection.createStatement();
			statement.execute("CREATE TABLE Customer(Contact_No INT(10) NOT NULL PRIMARY KEY,Name VARCHAR(20),Address VARCHAR(100) NOT NULL)");
		    statement.execute("INSERT INTO Customer (Contact_No,Name,Address) VALUES ('0430865350','Chirag','107 Madeline st Preston 3072')");
			resultSet=statement.executeQuery("SELECT * FROM Customer");
			
			while(resultSet.next()){
				Long Contact_No=resultSet.getLong("Contact_No");
				String Name=resultSet.getString("Name");
				String Address=resultSet.getString("Address");
				
				System.out.printf("Contact_No %s\tName: %s\tAddress: %s\n", Contact_No, Name, Address);
			}*/
		}
		catch(ClassNotFoundException error){
			System.out.println("Error:"+ error.getMessage());
		}
		catch(SQLException error){
			System.out.println("Error:"+ error.getMessage());
		}
		finally{
			if(connection!=null)
				try{connection.close();}
				catch(SQLException ignore){}
			
			/*if(statement!=null){
				try{statement.close();}
				catch(SQLException ignore){}
			}
			if(resultSet!=null){
				try{resultSet.close();}
				catch(SQLException ignore){}
			}*/
		}
		
		
	}
	
}
