package mydb;

import java.sql.*;

public class RegisterData {
	public static Connection checkconnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbooking", "root", "Damon123*");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public String RegisterDet(String FirstName, String LastName, String UserName, String Email, String Password) {
		try {
			Connection con = RegisterData.checkconnection();
			String sql = "INSERT INTO UserDetails(FirstName,LastName,UserName,Email,Password) VALUES(?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, FirstName);
			pstmt.setString(2, LastName);
			pstmt.setString(3, UserName);
			pstmt.setString(4, Email);
			pstmt.setString(5, Password);
			int result = pstmt.executeUpdate();
			System.out.println(result);
			if (result > 0) {
				return "Success";
			}
			return "Failed";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}

	public static boolean LoginCheck(String UserName, String Password) {
		boolean status=false;
		try {
			Connection con = RegisterData.checkconnection();
			PreparedStatement ps = con.prepareStatement("select * from UserDetails where UserName=? and Password=?");
			ps.setString(1, UserName);
			ps.setString(2, Password);
			ResultSet rs = ps.executeQuery();
			status=rs.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static boolean ProfileDetails(String phno,String dob,String address,String state,String city,String country)
	{
		boolean status = false;
		try {
			Connection con = RegisterData.checkconnection();			
			String sql = "INSERT INTO UserProfile(phno,dob,address,state,city,country) VALUES(?,?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,phno);
			pstmt.setString(2,dob);
			pstmt.setString(3,address);
			pstmt.setString(4,state);
			pstmt.setString(5,city);
			pstmt.setString(6,country);
			int result = pstmt.executeUpdate();
			System.out.println(result);
		    status=true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static boolean RoomDetails(String roomtype,String roomid,String people,String roomfare,String roomdescrp,String roomtitle,String noofbed,String facility)
	{
		boolean status = false;
		try {
			Connection con = RegisterData.checkconnection();			
			String sql = "INSERT INTO RoomDetails(roomtype,roomid,people,roomfare,roomdescrp,roomtitle,noofbed,facility) VALUES(?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,roomtype);
			pstmt.setString(2,roomid);
			pstmt.setString(3,people);
			pstmt.setString(4,roomfare);
			pstmt.setString(5,roomdescrp);
			pstmt.setString(6,roomtitle);
			pstmt.setString(7,noofbed);
			pstmt.setString(8,facility);
			int result = pstmt.executeUpdate();
			System.out.println(result);
		    status=true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static boolean BookedDetails(String username,String roomtype,String roomid,String people,String roomfare,String roomdescrp,String roomtitle,String noofbed,String facility,String  date,String paymentstatus)
	{
		boolean status = false;
		try {
			Connection con = RegisterData.checkconnection();			
			String sql = "INSERT INTO BookedDetails(username,roomtype,roomid,people,roomfare,roomdescrp,roomtitle,noofbed,facility,date,paymentstatus) VALUES(?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,roomtype);
			pstmt.setString(3,roomid);
			pstmt.setString(4,people);
			pstmt.setString(5,roomfare);
			pstmt.setString(6,roomdescrp);
			pstmt.setString(7,roomtitle);
			pstmt.setString(8,noofbed);
			pstmt.setString(9,facility);
			pstmt.setString(10,date);
			pstmt.setString(11,paymentstatus);
			int result = pstmt.executeUpdate();
		    status=true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static boolean CancelBooking(String username,String roomid)
	{
		boolean status=false;
		try {
			Connection con = RegisterData.checkconnection();			
			String sql = "DELETE from BookedDetails where username=? and roomid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,roomid);
			ps.executeUpdate();
			status=true;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

}
