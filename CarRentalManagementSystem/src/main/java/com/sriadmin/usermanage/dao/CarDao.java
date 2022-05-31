package com.sriadmin.usermanage.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.sriadmin.usermanage.model.*;

public class CarDao {
	static PreparedStatement pst = null,pst1 = null,stmt=null,ps = null,ps1 = null;
	static Connection conn = null;
	static ResultSet rs = null,rs1 = null,rs2 = null;
	static String date_Set = "2022-06-01";
	
	
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
	
	//To insert a new data
	public static int insertCar(Car c) {
		int st = 0;
		String carname = c.getCarname();
		String cartype = c.getCartype();
		String avail_from = c.getAvail_from();
		String query = "INSERT INTO CarTable(carname,cartype,avail_from,booked) VALUES"
				+ " (?,?,?,'0')";
		
		try {
			conn = get_connection();
			pst = conn.prepareStatement(query);
			pst.setString(1, carname);
			pst.setString(2, cartype);
			pst.setDate(3, java.sql.Date.valueOf(avail_from));
			st = pst.executeUpdate();
			conn.close();
		}catch (Exception ex) {
			System.out.println(ex);
			st = 0;
		}
		return st;
	}
	
	//To update the details
	public static int updateCar(Car c) {
		int status=0;
		
		int carid = c.getCarid();
		String carname = c.getCarname(),cartype = c.getCartype(), avail_from = c.getAvail_from();
		String query = "UPDATE CarTable set ";
		ArrayList<String> params = new ArrayList<>();
		
		boolean isAdded = false;
		if (carname != null) {
			params.add(carname);
			query += "carname = ?";
			isAdded = true;
		}
		if (cartype != null) {
			params.add(cartype);
			if (isAdded) query += ",";
			query += "cartype = ?";
			isAdded = true;
		}
		if (avail_from != null) {
			params.add(avail_from);
			if (isAdded) query += ",";
			query += "avail_from = ?";
		}
		
		query += " WHERE carid = ?";
		if (params.size() < 1) return -1;
		System.out.println(params);
		System.out.println(query);
		try{
			Connection connection = get_connection();
			pst = connection.prepareStatement(query); 
			for(int i = 0; i < params.size(); ++i) {
				pst.setString(i+1, params.get(i));
				
			}
			pst.setInt(params.size()+1, carid);
			status = pst.executeUpdate();
			connection.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return status;
	}
	
	public static List<Car> searchCar(Car c) {
		List<Car> list = new ArrayList<Car>();
		int carid = c.getCarid();
		String carname = c.getCarname(),cartype = c.getCartype(), avail_from = c.getAvail_from();
		String query = "SELECT carid,carname,cartype,avail_from FROM CarTable WHERE ";
		ArrayList<String> params = new ArrayList<>();
		
		
		boolean isAdded = false;
		if (carid != 0) {
			query += "carid = ?";
			isAdded = true;
		}
		if (carname != null) {
			params.add(carname);
			if (isAdded) query += " AND ";
			query += "carname = ?";
			isAdded = true;
		}
		if (cartype != null) {
			params.add(cartype);
			if (isAdded) query += " AND ";
			query += "cartype = ?";
			isAdded = true;
		}
		if (avail_from != null) {
			if (isAdded) query += " AND ";
			query += "avail_from::date >= ?";
		}
		
		//if (params.size() < 1) return null;
		System.out.println(params);
		System.out.println(query);
		try{
			Connection connection = get_connection();
			pst = connection.prepareStatement(query); 
			if(carid != 0) {
				pst.setInt(1, carid);
				
				//if(params.size()!=-1) {
					for(int i = 0; i < params.size(); ++i) {
						pst.setString(i+2, params.get(i));
					}
					if(avail_from != null) {
						pst.setDate(params.size()+2, java.sql.Date.valueOf(avail_from));
					}
			}
			else {
				for(int i = 0; i < params.size(); ++i) {
					pst.setString(i+1, params.get(i));
				}
				if(avail_from != null) {
					pst.setDate(params.size()+1, java.sql.Date.valueOf(avail_from));
				}
			}
			rs = pst.executeQuery();
			while(rs.next()) {
				Car a = new Car();
				a.setCarid(rs.getInt("carid"));
				a.setCarname(rs.getString("carname"));
				a.setCartype(rs.getString("cartype"));
				a.setAvail_from(rs.getString("avail_from"));
				list.add(a);
				
			}
			System.out.println(list.size());
			connection.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return list;
	}
	
	public static List<Car> searchCaruser(Car c) {
		long millis=System.currentTimeMillis();
		List<Car> list = new ArrayList<Car>();
		int carid = c.getCarid();
		String carname = c.getCarname(),cartype = c.getCartype();
		java.sql.Date avail_from = new java.sql.Date(millis);
		String query = "SELECT carid,carname,cartype,avail_from FROM CarTable WHERE ";
		ArrayList<String> params = new ArrayList<>();
		
		
		boolean isAdded = false;
		if (carid != 0) {
			query += "carid = ?";
			isAdded = true;
		}
		if (carname != null) {
			params.add(carname);
			if (isAdded) query += " AND ";
			query += "carname = ?";
			isAdded = true;
		}
		if (cartype != null) {
			params.add(cartype);
			if (isAdded) query += " AND ";
			query += "cartype = ?";
			isAdded = true;
		}
		if (avail_from != null) {
			if (isAdded) query += " AND ";
			query += "avail_from::date = ?";
		}

		System.out.println(params);
		System.out.println(query);
		try{
			Connection connection = get_connection();
			pst = connection.prepareStatement(query); 
			if(carid != 0) {
				pst.setInt(1, carid);
				for(int i = 0; i < params.size(); ++i) {
					pst.setString(i+2, params.get(i));
				}
				if(avail_from != null) {
					pst.setDate(params.size()+2, avail_from);
				}
			}
			else {
				for(int i = 0; i < params.size(); ++i) {
					pst.setString(i+1, params.get(i));
				}
				if(avail_from != null) {
					pst.setDate(params.size()+1, avail_from);
				}
			}
			rs = pst.executeQuery();
			while(rs.next()) {
				Car a = new Car();
				a.setCarid(rs.getInt("carid"));
				a.setCarname(rs.getString("carname"));
				a.setCartype(rs.getString("cartype"));
				a.setAvail_from(rs.getString("avail_from"));
				list.add(a);
				
			}
			System.out.println(list.size());
			connection.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return list;
	}
	
	//To book the car
	public static int bookCar(Car c,String book_till,String username,String avail_from) {
		int st = 0,in = 0,flag = 0,f=1;
		int carid = c.getCarid();
		String carname = c.getCarname();
		String cartype = c.getCartype();
		System.out.println(avail_from);
		System.out.println(book_till);
		int days;
		String text = "The username \""+ username + "\" has booked the car \"" + carname + "\" from \"" + avail_from + "\" till \"" + book_till +"\"";
		System.out.println(text);
		long daysBetween = ChronoUnit.DAYS.between(LocalDate.parse(avail_from),LocalDate.parse(book_till));
		days = (int) daysBetween;
		System.out.println(days);
		LocalDate date_from = LocalDate.parse(avail_from);
		LocalDate new_avail_from_date = date_from.plusDays(days+1);
		String new_avail_from = new_avail_from_date.toString();
		System.out.println(new_avail_from);
		boolean book_str = false;
		String book = null;
		try {
			FileWriter BookDetail = new FileWriter("bookingDetails.txt",true);
			BufferedWriter bw = new BufferedWriter(BookDetail);
			PrintWriter pw = new PrintWriter(bw);
			conn = get_connection();
			ps = conn.prepareStatement("SELECT booked FROM CarTable WHERE carid = ?");
			ps.setInt(1, carid);
			rs1 = ps.executeQuery();
			while(rs1.next()) {
				book_str = rs1.getBoolean("booked");
				System.out.println(book_str);
			}
			ps = null;
			ps1 = conn.prepareStatement("SELECT status FROM BookTable WHERE carid = ?");
			ps1.setInt(1, carid);
			rs2 = ps1.executeQuery();
			while(rs2.next()) {
				book = rs2.getString("status");
				System.out.println(book);
			}
			ps = null;
			if(book != null && book.equals("returned"))
			{
				f=1;
			}
			else if(book != null && book.equals("booked")) {
				f=0;
				st = 0;
			}
			if(f == 1) {
				if(book_str == false) {
					pst = conn.prepareStatement("UPDATE CarTable SET avail_from = ? WHERE carid = ?");
					pst.setDate(1, java.sql.Date.valueOf(new_avail_from));
					pst.setInt(2, carid);
					st = pst.executeUpdate();
					pst1 = conn.prepareStatement("INSERT INTO BookTable(username,carid,carname,cartype,book_date,booked_till,status) VALUES (?,?,?,?,?,?,?)");
					pst1.setString(1, username);
					pst1.setInt(2, carid);
					pst1.setString(3, carname);
					pst1.setString(4, cartype);
					pst1.setDate(5, java.sql.Date.valueOf(avail_from));
					pst1.setDate(6, java.sql.Date.valueOf(book_till));
					pst1.setString(7, "booked");
					in = pst1.executeUpdate();
					if(in !=0) {
						System.out.println("Insertion successful");
						pw.println(text);
					}
				}
				else {
					stmt = conn.prepareStatement("SELECT reserve_from,reserve_till FROM ReserveTable WHERE carid = ? AND status = ?");
					stmt.setInt(1, carid);
					stmt.setString(2, "reserved");
					rs = stmt.executeQuery();
					boolean more = rs.next();
					if(more) {
						java.sql.Date reserve_from = java.sql.Date.valueOf(rs.getString("reserve_from"));
						java.sql.Date reserve_till = java.sql.Date.valueOf(rs.getString("reserve_till"));
						java.sql.Date available_from = java.sql.Date.valueOf(avail_from);
						java.sql.Date booked_till = java.sql.Date.valueOf(book_till);
						if(available_from.compareTo(reserve_from)>=0) {
							if(available_from.compareTo(reserve_till)<=0) {
								flag = 1;
							}
						}
						if(booked_till.compareTo(reserve_from)>=0) {
							if(booked_till.compareTo(reserve_till)<=0) {
								flag = 1;
							}
						}
						if(flag == 1) {
							return -1;
						}
						else {
							pst = conn.prepareStatement("UPDATE CarTable SET avail_from = ? WHERE carid = ?");
							pst.setDate(1, java.sql.Date.valueOf(new_avail_from));
							pst.setInt(2, carid);
							st = pst.executeUpdate();
							pst1 = conn.prepareStatement("INSERT INTO BookTable(username,carid,carname,cartype,book_date,booked_till,status) VALUES (?,?,?,?,?,?,?)");
							pst1.setString(1, username);
							pst1.setInt(2, carid);
							pst1.setString(3, carname);
							pst1.setString(4, cartype);
							pst1.setDate(5, java.sql.Date.valueOf(avail_from));
							pst1.setDate(6, java.sql.Date.valueOf(book_till));
							pst1.setString(7, "booked");
							in = pst1.executeUpdate();
							if(in !=0) {
								System.out.println("Insertion successful");
								pw.println(text);
							}
						}
					}
				}
			}
			else if(f == 0) {
				st = 0;
				System.out.println("Booking Failed!!");
			}
			pw.flush();
			BookDetail.close();
			bw.close();
			pw.close();
			conn.close();
		}catch(SQLException e) {
			printSQLException(e);
		}catch(IOException ex) {
			System.out.println(ex);
		}
		return st;
	}
	
	//to reserve car
	public static int reserveCar(Car c,String reserve_from,String reserve_till,String username) {
		int st = 0,in=0;
		int carid = c.getCarid();
		String carname = c.getCarname();
		String cartype = c.getCartype();
		String text = "The username \""+ username + "\" has reserved the car \"" + carname + "\" from \"" + reserve_from + "\" till \"" + reserve_till +"\"";
		System.out.println(text);
		int days;
		long daysBetween = ChronoUnit.DAYS.between(LocalDate.parse(reserve_from),LocalDate.parse(reserve_till));
		days = (int) daysBetween;
		try {
			FileWriter BookDetail = new FileWriter("bookingDetails.txt",true);
			BufferedWriter bw = new BufferedWriter(BookDetail);
			PrintWriter pw = new PrintWriter(bw);
			conn = get_connection();
			pst = conn.prepareStatement("UPDATE CarTable SET booked = ? WHERE carid = ?");
			pst.setBoolean(1, true);
			pst.setInt(2, carid);
			st = pst.executeUpdate();
			pst1 = conn.prepareStatement("INSERT INTO ReserveTable(username,carid,carname,cartype,reserve_from,reserve_till,days,status) VALUES (?,?,?,?,?,?,?,?)");
			pst1.setString(1, username);
			pst1.setInt(2, carid);
			pst1.setString(3, carname);
			pst1.setString(4, cartype);
			pst1.setDate(5, java.sql.Date.valueOf(reserve_from));
			pst1.setDate(6, java.sql.Date.valueOf(reserve_till));
			pst1.setInt(7, days);
			pst1.setString(8, "reserved");
			in = pst1.executeUpdate();
			if(in !=0) {
				System.out.println("Insertion successful");
				pw.println(text);
			}
			pw.flush();
			BookDetail.close();
			bw.close();
			pw.close();
			conn.close();
		}catch(SQLException e) {
			printSQLException(e);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return st;
	}
	
	//To get the date
	public static String get_Date() {
		String date = null;
		Car car = new Car();
		car.setDate(date_Set);
		date = car.getDate();
		return date;
	}
	
	//To return the car
	public static int returnCar(int carid,String username) {
		int st = 0,f = 0;
		java.sql.Date d = java.sql.Date.valueOf(get_Date());
		String carname = null;
		java.sql.Date d1 = null,d2 = null;
		String query = "UPDATE BookTable SET status = ? WHERE carid = ? AND username = ? AND status = ?";
		String q1 = "SELECT book_date,booked_till FROM BookTable WHERE carid = ? AND username = ? AND status = ?";
		
		try {
			Car c= new Car();
			c = findCar1(carid);
			carname = c.getCarname();
			System.out.println(carname);
			String text = "The username \""+ username + "\" has returned the car \"" + carname + "\" on \"" + date_Set + "\"";
			FileWriter BookDetail = new FileWriter("bookingDetails.txt",true);
			BufferedWriter bw = new BufferedWriter(BookDetail);
			PrintWriter pw = new PrintWriter(bw);
			System.out.println("The text inserted to the file while returning the car: \n" + text);
			conn = get_connection();
			ps = conn.prepareStatement(q1);
			ps.setInt(1, carid);
			ps.setString(2, username);
			ps.setString(3, "booked");
			rs = ps.executeQuery();
			while(rs.next()) {
				d1 = java.sql.Date.valueOf(rs.getString("book_date"));
				d2 = java.sql.Date.valueOf(rs.getString("booked_till"));
			}
			if(d.compareTo(d2) == 0) {
				f = 1;
			}
			else if(d.compareTo(d2)<0 && d.compareTo(d1)>0) {
				pst1 = conn.prepareStatement("UPDATE CarTable SET avail_from = ? WHERE carid = ?");
				LocalDate date1 = d.toLocalDate();
				LocalDate new_d = date1.plusDays(1);
				pst1.setDate(1, java.sql.Date.valueOf(new_d));
				pst1.setInt(1, carid);
				int a = pst1.executeUpdate();
				if(a != 0) {
					f = 1;
				}
			}
			else if(d.compareTo(d1)>=0) {
				pst1 = conn.prepareStatement("UPDATE CarTable SET avail_from = ? WHERE carid = ?");
				pst1.setDate(1, d);
				pst1.setInt(2, carid);
				int a = pst1.executeUpdate();
				if(a != 0) {
					f = 1;
				}
			}
			else if(d.compareTo(d2)>0) {
				pst1 = conn.prepareStatement("UPDATE CarTable SET avail_from = ? WHERE carid = ?");
				pst1.setDate(1, d);
				pst1.setInt(2, carid);
				int a = pst1.executeUpdate();
				if(a != 0) {
					f = 1;
				}
			}
			else if(d.compareTo(d1)<0) {
				pst1 = conn.prepareStatement("UPDATE CarTable SET avail_from = ? WHERE carid = ?");
				pst1.setDate(1, d1);
				pst1.setInt(2, carid);
				int a = pst1.executeUpdate();
				if(a != 0) {
					f = 1;
				}
			}
			if(f == 1) {
				pst = conn.prepareStatement(query);
				pst.setString(1, "returned");
				pst.setInt(2, carid);
				pst.setString(3, username);
				pst.setString(4, "booked");
				st = pst.executeUpdate();
				if(st != 0) {
					System.out.println("Car has been returned successfully!!");
					pw.println(text);
				}
			}
			else {
				System.out.println("Return failed!!");
				st = 0;
			}
			pw.flush();
			BookDetail.close();
			bw.close();
			pw.close();
			conn.close();
		}catch(SQLException e) {
			printSQLException(e);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return st;
	}
	
	//To cancel Reservation!!
	public static int cancelReservation(int carid,String username) {
		int st = 0;
		String carname = null;
		String query = "UPDATE reserveTable SET status = ? WHERE carid = ? AND username = ? AND status = ?";
		//String q1 = "SELECT reserve_from,reserve_till FROM reserveTable WHERE carid = ? AND username = ? AND satus = ?";
		try {
			Car c= new Car();
			c = findCar1(carid);
			carname = c.getCarname();
			String text = "The username \""+ username + "\" has cancelled the car reservation for the car  \"" + carname + "\" on \"" + date_Set + "\"";
			FileWriter BookDetail = new FileWriter("bookingDetails.txt",true);
			BufferedWriter bw = new BufferedWriter(BookDetail);
			PrintWriter pw = new PrintWriter(bw);
			System.out.println("The text inserted to the file while cancelling the car reservation: \n" + text);
			conn = get_connection();
			pst = conn.prepareStatement(query);
			pst.setString(1, "cancelled");
			pst.setInt(2, carid);
			pst.setString(3, username);
			pst.setString(4, "reserved");
			st = pst.executeUpdate();
			if(st != 0) {
				System.out.println("Car reservation has been cancelled successfully!!");
				pw.println(text);
			}
			pw.flush();
			BookDetail.close();
			bw.close();
			pw.close();
			conn.close();
		}catch(SQLException e) {
			printSQLException(e);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return st;
	}
	
	
	public static int reservetobooking() {
		int st = 0;
		String username = null,carid = null,carname = null,cartype = null,avail_from = null,avail_till = null,status = null;
		String q1 = "UPDATE reserveTable SET status = ? WHERE reserve_from::date = ? AND status = ?";
		String query = "INSERT INTO BookTable (username,carid,carname,cartype,book_date,booked_till,status) VALUES (?,?,?,?,?,?,?)";
		String q = "SELECT username,carid,carname,cartype,reserve_from,reserve_till,status FROM reserveTable WHERE status = ? ";
		java.sql.Date d = java.sql.Date.valueOf(get_Date());
		try {
			conn = get_connection();
			pst = conn.prepareStatement(q1);
			pst.setString(1, "booked");
			pst.setDate(2, d);
			pst.setString(3, "reserved");
			int a = pst.executeUpdate();
			if(a != 0) {
				ps = conn.prepareStatement(q);
				ps.setString(1, "booked");
				rs = ps.executeQuery();
				System.out.println(query);
				while(rs.next()) {
					username = rs.getString("username");
					carid = rs.getString("carid");
					carname = rs.getString("carname");
					cartype = rs.getString("cartype");
					avail_from = rs.getString("reserve_from");
					avail_till = rs.getString("reserve_till");
					status = rs.getString("status");
					stmt = conn.prepareStatement(query);
					stmt.setString(1, username);
					stmt.setInt(2, Integer.parseInt(carid));
					stmt.setString(3, carname);
					stmt.setString(4, cartype);
					stmt.setDate(5, java.sql.Date.valueOf(avail_from));
					stmt.setDate(6, java.sql.Date.valueOf(avail_till));
					stmt.setString(7, status);
					st = stmt.executeUpdate();
				}
				
			}
			conn.close();
			
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	//To find the car name and car type when the car id is given
	public static Car findCar1(int carid) {
		Car c = new Car();
		String query = "SELECT carid,carname,cartype,avail_from FROM CarTable WHERE carid = ?";
		try {
			conn = get_connection();
			pst = conn.prepareStatement(query);
			pst.setInt(1, carid);
			rs = pst.executeQuery();
			boolean more = rs.next();
			if(!more) {
				System.out.println("Car not found");
			}
			else {
				int carid1 = rs.getInt("carid");
				String carname1 = rs.getString("carname");
				String cartype1 = rs.getString("cartype");
				String avail_from1 = rs.getString("avail_from");
				c.setCarid(carid1);
				c.setCarname(carname1);
				c.setCartype(cartype1);
				c.setAvail_from(avail_from1);
				
			}
			conn.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return c;
	}
	
	//To find the car
	public static int findCar() {
		int st = 0;
		Car c = new Car();
		int carid1=0;
		String cartype1 = null;
		String avail_from1 = null;
		String carname1=null;
		String query = "SELECT carid,carname,cartype,avail_from FROM CarTable WHERE avail_from::date = ?";
		try {
			/*String d = CarDao.get_Date();
			System.out.println(d);*/
			java.sql.Date date = java.sql.Date.valueOf(date_Set);
			
			System.out.println(date);
			conn = get_connection();
			pst = conn.prepareStatement(query);
			pst.setDate(1, date);
			rs = pst.executeQuery();
			boolean more = rs.next();
			if(!more) {
				System.out.println("Car not found");
				return 0;
			}
			else {
				while(rs.next()) {
					carid1 = rs.getInt("carid");
					carname1 = rs.getString("carname");
					cartype1 = rs.getString("cartype");
					avail_from1 = rs.getString("avail_from");				
				}
				st = 1;
			}
			
			c.setCarid(carid1);			
			c.setCarname(carname1);
			c.setCartype(cartype1);			
			c.setAvail_from(avail_from1);
			conn.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	//To delete the car
	public static int deleteCar(int carid) {
		int st = 0;
		try {
			conn = get_connection();
			pst = conn.prepareStatement("DELETE FROM CarTable WHERE carid = ?");
			pst.setInt(1, carid);
			st = pst.executeUpdate();
			conn.close();
		}catch(SQLException e) {
			printSQLException(e);
		}
		return st;
	}
	
	//To print the exception
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
