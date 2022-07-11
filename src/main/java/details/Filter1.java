package details;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mydb.RegisterData;

@WebFilter({"/AdminHome","/BookRoom","/CancelBooking","/Cancellation","/Payment","/RoomDetails","/UserBookedRoom","/UserHome","/UserProfile","/ViewBooked","/ViewRoom"})
public class Filter1 extends HttpFilter implements Filter 
{
	public void doFilter(HttpServletRequest request,HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String password = (String) session.getAttribute("password");
		System.out.println("Hello "+username+" "+password+" Filter");

		if(username==null&&password==null)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Your session logged out');");
			out.println("</script>");
		}
		else
		{
			chain.doFilter(request, response);
		}
	}

}
