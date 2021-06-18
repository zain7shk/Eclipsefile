package com.ibm;
import java.sql.*;
import java.io.*;

public class InserFile {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/jdbc_example";
			String username="root";
			String password="1234";
			
			
			
			Class.forName(driver);
			Connection con=DriverManager.getConnection(url,username,password);
			
			PreparedStatement pst=con.prepareStatement("insert into filedb values(?,?)");
			File f=new File("C:\\Users\\zain\\eclipse-workspace\\JDBCEXAMPLE\\src\\main\\resources\\textfile.txt"); //yaha pe (\\) ayyaega 
			
			FileReader fr=new FileReader(f);
			pst.setInt(1, 103);
			pst.setCharacterStream(2,fr,(int)f.length());
			
			
			int i=pst.executeUpdate();
			System.out.println(i+ " records updated");
			
			
			
			//for retrieve table
//PreparedStatement ps=con.prepareStatement("select * from filedb");
//			ResultSet rs=ps.executeQuery();
//		rs.next();
//		Clob c=rs.getClob(2);//gegt 2 charcter
//				Reader r=c.getCharacterStream();
//			
//			FileWriter fw=new FileWriter("C:\\Users\\zain\\eclipse-workspace\\JDBCEXAMPLE\\src\\main\\resources\\retrieve2.txt");
//				int i;
//				while((i=r.read())!=-1)
//					fw.write((char)i);
//			fw.close();
				
			System.out.println("Succeess");
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
			
			
	}

}
