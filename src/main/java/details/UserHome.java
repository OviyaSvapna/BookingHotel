package details;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserHome")
public class UserHome extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String Name = (String) session.getAttribute("username");
		String Password = (String) session.getAttribute("password");
		out.print("<h1>Welcome&ensp;" + Name + "</h1>");
		out.print("<a href='UserProfile.html'><button>User Profile</button></a></h1>");
		out.print("&ensp;<a href='/BookingHotel/UserBookedRoom'><button>Booked History&emsp;</button></a></h1>");
		out.print("&ensp;<a href='/BookingHotel/BookRoom'><button>Book Room&emsp;</button></a></h1>");
		out.print("&ensp;<a href='/BookingHotel/CancelBooking'><button>Cancel Booking&emsp;</button></a></h1>");
		out.print("&ensp;<a href='/BookingHotel/Logout'><button>Log out&emsp;</button></a></h1>");

	}	
}
