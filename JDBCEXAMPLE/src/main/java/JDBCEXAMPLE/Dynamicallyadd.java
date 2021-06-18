package JDBCEXAMPLE;
import java.sql.*;
import java.io.*;

public class Dynamicallyadd {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/jdbc_example";
			String username="root";
			String password="1234";
			
			
			
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement pst=con.prepareStatement("insert into emp values(?,?,?)");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			do {
				System.out.println("Enter id");
				int id=Integer.parseInt(br.readLine());
				
				System.out.println("Enter name");
				String name=br.readLine();
				
				System.out.println("Enter sal");
				String sal=br.readLine();
				pst.setInt(1,108);
				pst.setString(2,"AASD");
				pst.setString(3,"12000");
				int i=pst.executeUpdate();
				System.out.println(i+ " records Affected");
				
				System.out.println( "Do you eant to continue");
				String s=br.readLine();
				if(s.startsWith("n")) {
					break;
				}
				
			}while(true);
	}catch(Exception e) {
		System.out.print(e);
	}

}
}
