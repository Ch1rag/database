package database;
import java.sql.*;
import java.sql.PreparedStatement;

public class Customer {
private String contactNo;
private String name;
private String address;

public Customer(){
	
}
public void addCustomer(){
	
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
