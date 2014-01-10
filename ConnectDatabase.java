package database;

import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;
import java.sql.DriverManager;
import java.lang.ClassNotFoundException;
import java.sql.PreparedStatement;

public class ConnectDatabase {
	private String contactNo;
	private String name;
	private String address;

	/**
	 * @param args
	 */
	public ConnectDatabase(){
		
	}
	public ConnectDatabase(String contactNo,String name,String address){
		this.contactNo=contactNo;
		this.name=name;
		this.address=address;
	}
	
	public void getConnected() throws SQLException {
		java.sql.Connection connection=null;
		PreparedStatement ps=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ccc", "root", "root");
			Customer cs=new Customer(connection,ps);
			cs.addCustomer(connection, ps,contactNo, name, address);
		}
		catch(ClassNotFoundException error){
			System.out.println("Error:"+ error.getMessage());
		}
		/*catch(SQLException error){
			System.out.println("Error:"+ error.getMessage());
		}*/
		finally{
			if(connection!=null)
				try{connection.close();}
				catch(SQLException ignore){}
		}
		
		
	}
	
}
