package JDBCEXAMPLE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Insertupdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/jdbc_example";
			String username="root";
			String password="1234";
			
			
			
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
//			PreparedStatement pst=con.prepareStatement("update emp set name=? where id=?");
//			pst.setString(1, "Zain"); //specifies the first paramenter
//			pst.setInt(2, 107);
//			
//			int i=pst.executeUpdate();
//			System.out.println( i + " records updated");
//			con.close();
			
			
			PreparedStatement pst=con.prepareStatement("delete from emp  where id=?");
			pst.setInt(1, 108);
			int i=pst.executeUpdate();
			System.out.println( i + " records updated");
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
