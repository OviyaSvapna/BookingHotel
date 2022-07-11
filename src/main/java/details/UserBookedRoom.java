package details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserBookedRoom")
public class UserBookedRoom extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");out.print("&ensp;<a href='/BookingHotel/Logout'><button>Log out&emsp;</button></a></h1>");
     	out.println("<html><body><center><h1>Room Details</h1>");
		HttpSession session = request.getSession();
		String UName = (String) session.getAttribute("username");
		String Password = (String) session.getAttribute("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbooking", "root",
					"Damon123*");
			PreparedStatement ps = con.prepareStatement("select * from BookedDetails where username=?");
			ps.setString(1,UName);
			ResultSet rs = ps.executeQuery();
			out.println("<html><body><center><h1>History of Booking</h1>");
			out.println("<table border=1 width=70% height=30%>");
			out.println(
					"<tr><th>User Name</th><th>Room Type</th><th>Room Name</th><th>People</th><th>Room fare</th><th>Room description</th><th>Room Title</th><th>Beds</th><th>Facilities</th><tr>");
			while (rs.next()) {
				String Name = rs.getString(1);
				String roomtype = rs.getString(2);
				String roomname = rs.getString(3);
				String adults = rs.getString(4);
				String roomfare = rs.getString(5);
				String roomdescrp = rs.getString(6);
				String roomtitle = rs.getString(7);
				String Beds = rs.getString(8);
				String facilities = rs.getString(9);
				String status = "Booked";
				out.println("<tr><td>" + UName + "</td><td>" + roomtype + "</td><td>" + roomname + "</td><td>" + adults
						+ "</td><td>" + roomfare + "</td><td>" + roomdescrp + "</td><td>" + roomtitle + "</td><td>"
						+ Beds + "</td><td>" + facilities + "</td><td>" + status + "</td></tr>");
			}
			out.println("</table>");
			out.println("</html></body>");
			con.close();
		} catch (Exception e) {
			out.println("error");
		}
	}
}
