package database;

public class Account {
	private int orderNo=0;
	private double subTotal=0.0;
			
	public Account(int orderNo, double subTotal){
		this.orderNo=orderNo;
		this.subTotal=subTotal;
	}
	
	public void calculateX(){
		double total=0.0;
		total+=subTotal;
		System.out.println(orderNo+"\t"+subTotal);
	}

}
