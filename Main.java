package database;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GUI gui=new GUI();
		gui.frame();
		
		Connection con=new Connection();
		con.getConnected();

	}

}
