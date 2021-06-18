package JDBCEXAMPLE;
import java.sql.*;

public class FirstJDBC {
	
	public static void main(String[] args) throws SQLException{
		String username="root";
		String password="1234";
		
		Connection con=null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Creating the connection");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_example",username,password);
			
			PreparedStatement pst=con.prepareStatement("insert into emp values(?,?,?)");
			pst.setInt(1,101);
			pst.setString(2,"Adam");
			pst.setString(3,"1200");
			pst.executeUpdate();
			System.out.println("inserted");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		
	}
	

}
