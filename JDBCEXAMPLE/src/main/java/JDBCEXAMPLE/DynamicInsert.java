package JDBCEXAMPLE;
import java.sql.*;
import java.io.*;

public class DynamicInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/jdbc_example";
			String username="root";
			String password="1234";
			
			
			
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
			String insertQuery="insert into emp(id,name,sal) values(?,?,?)";
			PreparedStatement pst=con.prepareStatement(insertQuery);
			
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter name");
			String name=br.readLine();
			
			System.out.println("Enter salary");
			String salary=br.readLine();
			
			pst.setInt(1,107);
			pst.setString(2,name);
			pst.setString(3,salary);
			
			pst.executeUpdate();
			System.out.println("inserted");
			con.close();
			
			
		}catch(Exception se) {
			se.printStackTrace();
		}
		
		finally {
			
		}

	}

}
