package JDBCEXAMPLE;
import java.sql.*;
public class Jdbcdemo {

	
		// jdbc driver name and databse 
		static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
		static final String DB_URL="jdbc:mysql://localhost:3306/world";
		
		//database credentials
		static final String USERNAME="root";
		static final String PASSWORD="1234";
		
		public static void main(String[] args) throws SQLException {
			Jdbcdemo jdbc=new Jdbcdemo();
			jdbc.getCityInformation();
		
	}
		
		public void getCityInformation() throws SQLException
		{
			Connection con=null;
			Statement stmt=null;
			
			try {
				//step 1: register the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Connecting to database");
				
				con=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
				stmt=con.createStatement();
				
				String sql="Select id,Name,Countrycode,District,Population from city where id<21";
				
				ResultSet rs=stmt.executeQuery(sql);
				
				while(rs.next()) {
					
					int id=rs.getInt("Id");
					String name=rs.getString("Name");
					String Countrycode=rs.getString("Countrycode");
					String  District=rs.getString("District");
					int population=rs.getInt("Population");
					
					//displaying values
					System.out.println("ID " +id);
					System.out.println("Name  " +name);
					System.out.println("Countrycode + " +Countrycode);
					System.out.println("District + " +District);
					System.out.println("Population  " +population);
			
				}
				
			}catch(SQLException se) {
				se.printStackTrace();
			}
			catch(ClassNotFoundException e) { //multiple catch blocks
				e.printStackTrace();
			}
			finally {
				con.close();
			}
		}
		

}
