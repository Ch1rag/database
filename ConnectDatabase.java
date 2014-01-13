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
	public String findCustomer(String number) throws SQLException{
		String info=null;
		if(number!=null){
			statement=connection.createStatement();
			resultSet=statement.executeQuery("SELECT * from Customer"
					+" WHERE Contact_No  = "+number);
			while(resultSet.next()){
				String contactNo=resultSet.getString("Contact_No");
				String name=resultSet.getString("Name");
				String address=resultSet.getString("Address");
				info="Contact No:\t"+contactNo+"\n"+
						"Name:\t"+name+"\n"+
						"Address:\t"+address;
			}
		}
		return info;
	}
}
