package details;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import mydb.RegisterData;

import javax.servlet.http.*;
@WebFilter("/LoginServlet")
//,"/AdminHome","/BookRoom","/CancelBooking","/Cancellation","/Payment","/RoomDetails","/UserBookedRoom","/UserHome","/UserProfile","/ViewBooked","/ViewRoom"})
public class FilterDemo extends HttpFilter implements Filter {	
	public void doFilter(HttpServletRequest request,HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("passwrd");
		System.out.println("Hello "+username+" "+password+" Filter");
		boolean status = RegisterData.LoginCheck(username, password);
		System.out.println("Log"+status);
		
		if(username==null&&password==null)
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Invalid Username and Password');");
			out.println("</script>");
		}
		else
		{
			if(status)
			{chain.doFilter(request, response);
			}
			else
			{
				System.out.println("Invalid");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Invalid Username and Password');");
				out.println("</script>");
			}
		}
	}
}
