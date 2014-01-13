package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
	private String contactNo;
	private String name;
	private String address;

	public Customer() {
	}

	public Customer(Connection connection, PreparedStatement ps,ResultSet resultSet) {
		connection = null;
		ps = null;
		resultSet=null;
	}

	public Customer(String custNum, String custName, String custAdd) {
		this.contactNo = custNum;
		this.name = custName;
		this.address = custAdd;
	}

	public void addCustomer(Connection connection, PreparedStatement ps,
			String contactNo, String name, String address) throws SQLException {
       
		ps = connection
				.prepareStatement("INSERT INTO Customer(Contact_No, Name, Address) VALUES (?,?,?)");
		ps.setString(1, contactNo);
		ps.setString(2, name);
		ps.setString(3, address);
		ps.executeUpdate();
       
      
	}

	public String getContactNo() {
        
		return contactNo;
	}
	

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
