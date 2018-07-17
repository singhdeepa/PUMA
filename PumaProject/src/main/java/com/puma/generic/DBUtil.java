package com.puma.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public final class DBUtil {
	
	private DBUtil(){
		
	}
		
	public static String getDatafromDB(String query){	
		
		Connection con=null;
		String price=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery(query);  
			while(rs.next()){ 
				price=String.valueOf(rs.getDouble(1));
			
			}
		}catch (SQLException e) {
			e.printStackTrace();			
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();			
		}
		finally{
			try{
				if(!con.isClosed()){
					con.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return price;
		
	}

}
