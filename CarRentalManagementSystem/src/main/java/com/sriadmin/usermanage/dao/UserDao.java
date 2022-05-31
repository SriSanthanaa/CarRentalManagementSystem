package com.sriadmin.usermanage.dao;

import java.sql.*;
import com.sriadmin.usermanage.model.User;
import com.sriadmin.usermanage.model.Member;

public class UserDao {
	static PreparedStatement pst = null,ps = null,pst1 = null,pst2 = null;
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
	
	//To check the login
	
	public static User login(User u) {
		
		String username = u.getUsername();
		String pwd = u.getPwd();
		String query = "SELECT * FROM UserTable WHERE username= ? AND pwd = ?";
		
		
		System.out.println("Username:" + username);
		System.out.println("Password:" + pwd);
		System.out.println("Query:" + query);
		try {
			conn = get_connection();
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			boolean more = rs.next();
			if(!more) {
				System.out.println("Invalid User");
				u.setValid(false);
			}
			else if(more){
				boolean member = rs.getBoolean("member");
				if(member == false) {
				System.out.println("Welcome! Login Success! Username:"+username);
				u.setValid(true);
				}
				else if(member == true) {
					System.out.println("Welcome! You are Member! Username: "+username);
					u.setMember(true);
				}
			}
			conn.close();
		}catch(Exception ex) {
			System.out.println("Log in Failed! Exception occured "+ex);
		}
		
		
		return u;
	}
	
	public static int memberRequest(String username) {
		int st = 0;
		int userid = 0;
		String pwd = null,fullname = null,email_id = null,address= null,ph_no = null;
		String query = "SELECT userid,pwd,fullname,email_id,address,ph_no FROM UserTable WHERE username = ?";
		try {
			conn = get_connection();
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			rs = pst.executeQuery();
			while(rs.next()) {
					userid = rs.getInt("userid");
					pwd = rs.getString("pwd");
					fullname = rs.getString("fullname");
					email_id = rs.getString("email_id");
					address = rs.getString("address");
					ph_no = rs.getString("ph_no");
					
			}
				String q = "INSERT INTO memberRequest(userid,username,pwd,fullname,email_id,address,ph_no) VALUES (?,?,?,?,?,?,?) ";
				ps = conn.prepareStatement(q);
				ps.setInt(1, userid);
				ps.setString(2, username);
				ps.setString(3, pwd);
				ps.setString(4, fullname);
				ps.setString(5, email_id);
				ps.setString(6, address);
				ps.setString(7, ph_no);
				st = ps.executeUpdate();
				if(st != 0) {
					System.out.println("User inserted into member request table");
				}
				else {
					System.out.println("Failed");
				}
			
			conn.close();
		}catch(Exception ex) {
			System.out.println("Insertion Failed! Exception occured "+ex);
		}
		return st;
	}
	
	public static int acceptMember(int requestid) {
		int st = 0;
		String q = "DELETE FROM memberRequest WHERE requestid = ?";
		String q1 = "SELECT * FROM memberRequest WHERE requestid = ?";
		String q2 = "INSERT INTO MemberTable(userid,username,pwd,fullname,email_id,address,ph_no) VALUES (?,?,?,?,?,?,?)";
		String q3 = "UPDATE UserTable SET member = ? WHERE userid = ?";
		String username=null,pwd=null,fullname=null,address=null,email_id=null,ph_no=null;
		int userid=0;
		try {
			conn = get_connection();
			pst = conn.prepareStatement(q1);
			pst.setInt(1, requestid);
			rs = pst.executeQuery();
			while(rs.next()) {
				userid = rs.getInt("userid");
				username = rs.getString("username");
				pwd = rs.getString("pwd");
				fullname = rs.getString("fullname");
				address = rs.getString("address");
				email_id = rs.getString("email_id");
				ph_no = rs.getString("ph_no");
			}
			//pst = null;
			ps = conn.prepareStatement(q2);
			ps.setInt(1, userid);
			ps.setString(2, username);
			ps.setString(3, pwd);
			ps.setString(4, fullname);
			ps.setString(5, address);
			ps.setString(6, email_id);
			ps.setString(7, ph_no);
			st = ps.executeUpdate();
			pst1 = conn.prepareStatement(q3);
			pst1.setBoolean(1,true);
			pst1.setInt(2, userid);
			int s = pst1.executeUpdate();
			if(st!=0 && s !=0) {
				System.out.println("Member request Accepted!!");
				pst2 = conn.prepareStatement(q);
				pst2.setInt(1, requestid);
				pst2.executeUpdate();
			}
			else {
				System.out.println("Member request Failed");
			}
			conn.close();
		}catch(Exception ex) {
			System.out.println("Insertion Failed! Exception occured "+ex);
		}
		return st;
	}
	
	public static int register (User u) {
		int st =0;
		String username = u.getUsername();
		String pwd = u.getPwd();
		String email_id = u.getEmail_id();
		String address = u.getAddress();
		String fullname = u.getFullname();
		String ph_no = u.getPh_no();
		String query = "INSERT INTO UserTable(fullname,username,pwd,email_id,address,ph_no) VALUES (?,?,?,?,?,?) ";
		
		try {
			conn = get_connection();
			pst = conn.prepareStatement(query);
			pst.setString(1, fullname);
			pst.setString(2, username);
			pst.setString(3, pwd);
			pst.setString(4, email_id);
			pst.setString(5, address);
			pst.setString(6, ph_no);
			st = pst.executeUpdate();
			if(st!=0) {
				System.out.println("Registered Successfully");
			}
			conn.close();
		}catch(Exception ex) {
			System.out.println("Registration Failed! Exception occured "+ex);
		}
		return st;
	}
	
	public static Member memberLogin(Member m) {
		String username = m.getUsername();
		String pwd = m.getPwd();
		String query = "SELECT * FROM MemberTable WHERE username= ? AND pwd = ?";
		
		
		System.out.println("Username:" + username);
		System.out.println("Password:" + pwd);
		System.out.println("Query:" + query);
		try {
			conn = get_connection();
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, pwd);
			rs = pst.executeQuery();
			boolean more = rs.next();
			if(!more) {
				System.out.println("Invalid User");
				m.setValid(false);
			}
			else if(more) {
				System.out.println("Successful login! Username: "+ username);
				m.setValid(true);
			}
			conn.close();
		}catch(Exception ex) {
			System.out.println("Log in Failed! Exception occured "+ex);
		}
		return m;
	}
	
}
