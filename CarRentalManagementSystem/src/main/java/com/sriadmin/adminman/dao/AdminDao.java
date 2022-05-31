package com.sriadmin.adminman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sriadmin.adminman.model.Admin;

public class AdminDao {
	static PreparedStatement pst = null;
	static Connection conn = null;
	static ResultSet rs = null;
	
	public static Connection get_connection(){
		conn = null;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Car","postgres","sriraj2001");
			if(conn != null) {		
				System.out.println("Connection ok");
			}
			else {
				System.out.println("Connection fail");
			}
		}catch(SQLException e) {
			System.out.println("Error in connecting Postgre");
			e.printStackTrace();
		}catch(Exception ex) {
			System.out.println(ex);
		}
		return conn;
	}
	
	public static Admin login(Admin a) {
		String admin_name = a.getAdmin_name();
		String passwd = a.getPasswd();
		String query = "SELECT * FROM AdminTable WHERE admin_name= ? AND passwd = ?";
		
		
		System.out.println("Admin name:" + admin_name);
		System.out.println("Password:" + passwd);
		System.out.println("Query:" + query);
		try {
			conn = get_connection();
			pst = conn.prepareStatement(query);
			pst.setString(1, admin_name);
			pst.setString(2, passwd);
			rs = pst.executeQuery();
			boolean more = rs.next();
			if(!more) {
				System.out.println("Invalid User");
				a.setValid(false);
			}
			else if(more){
				System.out.println("Welcome! Login Success! Adminname:"+admin_name);
				a.setValid(true);
			}
			conn.close();
		}catch(Exception ex) {
			System.out.println("Log in Failed! Exception occured "+ex);
		}
		
		return a;
	}
}
