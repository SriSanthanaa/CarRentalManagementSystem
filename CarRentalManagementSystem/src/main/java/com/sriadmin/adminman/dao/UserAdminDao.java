package com.sriadmin.adminman.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sriadmin.usermanage.model.*;

public class UserAdminDao {
	static PreparedStatement pst = null,ps = null;
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
	
/*	public static int searchid(int userid) {
		int st = 0;
		try {
			conn = get_connection();
			pst = conn.prepareStatement("SELECT * FROM UserTable WHERE userid = ?");
			pst.setInt(1, userid);
			rs = pst.executeQuery();
			boolean more = rs.next();
			if(!more) {
				st = 0;
				System.out.println("User not found");
			}
			else {
				st = 1;
				System.out.println("User found");
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	public static int searchusername (String username) {
		int st = 0;
		try {
			conn = get_connection();
			pst = conn.prepareStatement("SELECT * FROM UserTable WHERE username = ?");
			pst.setString(1, username);
			rs = pst.executeQuery();
			boolean more = rs.next();
			if(!more) {
				st = 0;
				System.out.println("User not found");
			}
			else {
				st = 1;
				System.out.println("User found");
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	public static int searchfullname (String fullname) {
		int st = 0;
		try {
			conn = get_connection();
			pst = conn.prepareStatement("SELECT * FROM UserTable WHERE fullname = ?");
			pst.setString(1, fullname);
			rs = pst.executeQuery();
			boolean more = rs.next();
			if(!more) {
				st = 0;
				System.out.println("User not found");
			}
			else {
				st = 1;
				System.out.println("User found");
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	public static int searchuseremail (String email_id) {
		int st = 0;
		try {
			conn = get_connection();
			pst = conn.prepareStatement("SELECT * FROM UserTable WHERE email_id = ?");
			pst.setString(1, email_id);
			rs = pst.executeQuery();
			boolean more = rs.next();
			if(!more) {
				st = 0;
				System.out.println("User not found");
			}
			else {
				st = 1;
				System.out.println("User found");
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	public static int searchuseraddres (String address) {
		int st = 0;
		try {
			conn = get_connection();
			pst = conn.prepareStatement("SELECT * FROM UserTable WHERE address = ?");
			pst.setString(1, address);
			rs = pst.executeQuery();
			boolean more = rs.next();
			if(!more) {
				st = 0;
				System.out.println("User not found");
			}
			else {
				st = 1;
				System.out.println("User found");
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	public static int searchuserphno (String ph_no) {
		int st = 0;
		try {
			conn = get_connection();
			pst = conn.prepareStatement("SELECT * FROM UserTable WHERE ph_no = ?");
			pst.setString(1, ph_no);
			rs = pst.executeQuery();
			boolean more = rs.next();
			if(!more) {
				st = 0;
				System.out.println("User not found");
			}
			else {
				st = 1;
				System.out.println("User found");
			}
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}*/
	
	public static List<User> searchUser(User u) {
		
		List<User> list = new ArrayList<User>();
		int userid = u.getUserid();
		String username = u.getUsername(),fullname = u.getFullname(), address = u.getAddress(), email_id = u.getEmail_id(), ph_no = u.getPh_no();
		String query = "SELECT * FROM UserTable WHERE ";
		ArrayList<String> params = new ArrayList<>();
		
		boolean isAdded = false;
		if(userid != 0) {
			query+= "userid = ?";
			isAdded = true;
		}
		if (username != null) {
			params.add(username);
			if (isAdded) query += " AND ";
			query += "username = ?";
			isAdded = true;
		}
		if (fullname != null) {
			params.add(fullname);
			if (isAdded) query += " AND ";
			query += "fullname = ?";
			isAdded = true;
		}
		if (address != null) {
			params.add(address);
			if (isAdded) query += " AND ";
			query += "address = ?";
			isAdded = true;
		}
		if (email_id != null) {
			params.add(email_id);
			if (isAdded) query += " AND ";
			query += "email_id = ?";
			isAdded = true;
		}
		if (ph_no != null) {
			params.add(ph_no);
			if (isAdded) query += " AND ";
			query += "ph_no = ?";
		}
		
		//if (params.size() < 1) return -1;
		System.out.println(params);
		System.out.println(query);
		try{
			Connection connection = get_connection();
			pst = connection.prepareStatement(query); 
			if(userid != 0) {
				pst.setInt(1, userid);
				for(int i = 0; i < params.size(); ++i) {
					pst.setString(i+2, params.get(i));
					
				}
			}
			else{
				for(int i = 0; i < params.size(); ++i) {
					pst.setString(i+1, params.get(i));
					
				}
			}
			rs = pst.executeQuery();
			
			while(rs.next()) {
				User c = new User();
				c.setUserid(rs.getInt("userid"));
				c.setPwd(rs.getString("pwd"));
				c.setUsername(rs.getString("username"));
				c.setFullname(rs.getString("fullname"));
				c.setAddress(rs.getString("address"));
				c.setEmail_id(rs.getString("email_id"));
				c.setPh_no(rs.getString("ph_no"));
				
				list.add(c);
				
			}
			System.out.println(list);
			if(list.size() == 0) {
				System.out.println("User not found!");
			}
			connection.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return list;
	}
	
public static List<User> searchMember(Member u) {
		
		List<User> list = new ArrayList<User>();
		int userid = u.getUserid(),memberid = u.getMemberid();
		String username = u.getUsername(),fullname = u.getFullname(), address = u.getAddress(), email_id = u.getEmail_id(), ph_no = u.getPh_no();
		String query = "SELECT * FROM UserTable WHERE ";
		ArrayList<String> params = new ArrayList<>();
		
		boolean isAdded = false;
		if(memberid != 0) {
			if (isAdded) query += " AND ";
			query+= "memberid = ?";
			isAdded = true;
		}
		if(userid != 0) {
			query+= "userid = ?";
			isAdded = true;
		}
		if (username != null) {
			params.add(username);
			if (isAdded) query += " AND ";
			query += "username = ?";
			isAdded = true;
		}
		if (fullname != null) {
			params.add(fullname);
			if (isAdded) query += " AND ";
			query += "fullname = ?";
			isAdded = true;
		}
		if (address != null) {
			params.add(address);
			if (isAdded) query += " AND ";
			query += "address = ?";
			isAdded = true;
		}
		if (email_id != null) {
			params.add(email_id);
			if (isAdded) query += " AND ";
			query += "email_id = ?";
			isAdded = true;
		}
		if (ph_no != null) {
			params.add(ph_no);
			if (isAdded) query += " AND ";
			query += "ph_no = ?";
		}
		
		//if (params.size() < 1) return -1;
		System.out.println(params);
		System.out.println(query);
		try{
			Connection connection = get_connection();
			pst = connection.prepareStatement(query); 
			if(memberid != 0) {
				pst.setInt(1,memberid);
				if(userid != 0) {
					pst.setInt(2, userid);
					for(int i = 0; i < params.size(); ++i) {
						pst.setString(i+3, params.get(i));
						
					}
				}
				else{
					for(int i = 0; i < params.size(); ++i) {
						pst.setString(i+2, params.get(i));
						
					}
				}
			}
			else{
				for(int i = 0; i < params.size(); ++i) {
					pst.setString(i+1, params.get(i));
					
				}
			}
				
			rs = pst.executeQuery();
			
			while(rs.next()) {
				User c = new User();
				c.setUserid(rs.getInt("userid"));
				c.setPwd(rs.getString("pwd"));
				c.setUsername(rs.getString("username"));
				c.setFullname(rs.getString("fullname"));
				c.setAddress(rs.getString("address"));
				c.setEmail_id(rs.getString("email_id"));
				c.setPh_no(rs.getString("ph_no"));
				
				list.add(c);
				
			}
			System.out.println(list);
			if(list.size() == 0) {
				System.out.println("User not found!");
			}
			connection.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return list;
	}
	
	public static int updateUser(User u) {
		int st=0;
		
		int userid = u.getUserid();
		String username = u.getUsername(),fullname = u.getFullname(), address = u.getAddress(), email_id = u.getEmail_id(), ph_no = u.getPh_no();
		String query = "UPDATE UserTable set ";
		ArrayList<String> params = new ArrayList<>();
		
		boolean isAdded = false;
		if (username != null) {
			params.add(username);
			query += "username = ?";
			isAdded = true;
		}
		if (fullname != null) {
			params.add(fullname);
			if (isAdded) query += ",";
			query += "fullname = ?";
			isAdded = true;
		}
		if (address != null) {
			params.add(address);
			if (isAdded) query += ",";
			query += "address = ?";
			isAdded = true;
		}
		if (email_id != null) {
			params.add(email_id);
			if (isAdded) query += ",";
			query += "email_id = ?";
			isAdded = true;
		}
		if (ph_no != null) {
			params.add(ph_no);
			if (isAdded) query += ",";
			query += "ph_no = ?";
		}
		
		query += " WHERE userid = ?";
		if (params.size() < 1) return -1;
		System.out.println(params);
		System.out.println(query);
		try{
			Connection connection = get_connection();
			pst = connection.prepareStatement(query); 
			for(int i = 0; i < params.size(); ++i) {
				pst.setString(i+1, params.get(i));
				
			}
			pst.setInt(params.size()+1, userid);
			st = pst.executeUpdate();
			connection.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	public static int updateMember(Member u) {
		int st=0;
		
		int userid = u.getUserid();
		String username = u.getUsername(),fullname = u.getFullname(), address = u.getAddress(), email_id = u.getEmail_id(), ph_no = u.getPh_no();
		String query = "UPDATE MemberTable set ";
		ArrayList<String> params = new ArrayList<>();
		
		boolean isAdded = false;
		if (username != null) {
			params.add(username);
			query += "username = ?";
			isAdded = true;
		}
		if (fullname != null) {
			params.add(fullname);
			if (isAdded) query += ",";
			query += "fullname = ?";
			isAdded = true;
		}
		if (address != null) {
			params.add(address);
			if (isAdded) query += ",";
			query += "address = ?";
			isAdded = true;
		}
		if (email_id != null) {
			params.add(email_id);
			if (isAdded) query += ",";
			query += "email_id = ?";
			isAdded = true;
		}
		if (ph_no != null) {
			params.add(ph_no);
			if (isAdded) query += ",";
			query += "ph_no = ?";
		}
		
		query += " WHERE userid = ?";
		if (params.size() < 1) return -1;
		System.out.println(params);
		System.out.println(query);
		try{
			Connection connection = get_connection();
			pst = connection.prepareStatement(query); 
			for(int i = 0; i < params.size(); ++i) {
				pst.setString(i+1, params.get(i));
				
			}
			pst.setInt(params.size()+1, userid);
			st = pst.executeUpdate();
			connection.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	public static int deleteUser(int userid) {
		int st = 0;
		try {
			conn = get_connection();
			pst = conn.prepareStatement("DELETE FROM UserTable WHERE userid = ?");
			pst.setInt(1, userid);
			st = pst.executeUpdate();
			conn.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	public static int deleteMember(int userid) {
		int st = 0;
		try {
			conn = get_connection();
			pst = conn.prepareStatement("DELETE FROM UserTable WHERE userid = ?");
			pst.setInt(1, userid);
			ps = conn.prepareStatement("UPDATE UserTable SET member = ? WHERE userid = ?");
			ps.setBoolean(1, false);
			ps.setInt(2, userid);
			int a = ps.executeUpdate();
			int b  = pst.executeUpdate();
			if(a != 0 && b != 0) {
				st = 1;
			}
			conn.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	private static void printSQLException(SQLException e) {
		for (Throwable ex : e) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
}
}
