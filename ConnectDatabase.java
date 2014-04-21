package database;

import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.ResultSet;
import java.sql.DriverManager;
import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class ConnectDatabase {
	private String contactNo;
	private String name;
	private String address;
	private java.sql.Connection connection=null;
	private PreparedStatement ps=null;
	private ResultSet resultSet=null;
	private Statement statement=null;

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

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ccc", "root", "root");
		}
		catch(ClassNotFoundException error){
			System.out.println("Error:"+ error.getMessage());
		}
		catch(SQLException error){
			System.out.println("Error:"+ error.getMessage());
		}
		/*finally{
			if(connection!=null)
				try{connection.close();}
			catch(SQLException ignore){}
		}*/

	}
	public void addCustomer() throws SQLException {

		ps = connection
				.prepareStatement("INSERT INTO Customer(Contact_No, Name, Address) VALUES (?,?,?)");
		ps.setString(1, contactNo);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.executeUpdate();
		connection.close();
	}
	public ArrayList<String> findCustomer(String number) throws SQLException, EmptyStackException{
		ArrayList<String> info = new ArrayList<String>();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT * from Customer"
			+" WHERE Contact_No  = "+number);
			while(resultSet.next()){
				String contactNo=resultSet.getString("Contact_No");
				String name=resultSet.getString("Name");
				String address=resultSet.getString("Address");
				info.add(contactNo);
				info.add(name);
				info.add(address);		
			}	
		return info;
	}
	
	public ArrayList<String> newOrder(String type) throws SQLException, EmptyStackException{
		ArrayList<String> pack = new ArrayList<String>();
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT * from "+type);
			
			while(resultSet.next()){
				String name=resultSet.getString("Name");
				String price=resultSet.getString("Price");
				
				pack.add(name);
				pack.add(price);
			}		
		return pack;
	}
	
}
