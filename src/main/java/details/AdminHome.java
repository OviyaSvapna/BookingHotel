package details;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String Name = (String) session.getAttribute("username");
		String Password = (String) session.getAttribute("password");
		out.print("<h1>Welcome&ensp;Admin</h1>");
		out.print("<a href='RoomDetail.html'><button>Add Room Details</button></a></h1>");
		out.print("&ensp;<a href='/BookingHotel/ViewRoom'><button>View Room</button></a></h1>");
		out.print("&ensp;<a href='/BookingHotel/ViewBooked'><button>Booked rooms</button></a></h1>");
		out.print("&ensp;<a href='/BookingHotel/Logout'><button>Log out&emsp;</button></a></h1>");
	}
}
