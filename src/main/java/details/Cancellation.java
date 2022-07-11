package details;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mydb.RegisterData;
@WebServlet("/Cancellation")
public class Cancellation extends HttpServlet {
	static String roomid="";
	public static void RoomID(String id)
	{
		try {
			roomid=id;
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			String Name = (String) session.getAttribute("username");
			String Password = (String) session.getAttribute("password");
			boolean status=RegisterData.CancelBooking(Name,roomid);
			System.out.println(status);
			if(status)
			{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Booking cancellation Successfully');");
					out.println("</script>");
					out.print("<a href='/BookingHotel/UserBookedRoom'>Go back to home</a>");
					out.close();
				}else{
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Unable to cancel');");
					out.println("</script>");
					out.print("<a href='/BookingHotel/UserBookedRoom'>Go back to home</a>");
					out.close();
				}
			}
}
