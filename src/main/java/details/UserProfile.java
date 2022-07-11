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
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	HttpSession session = request.getSession();
	String Name = (String) session.getAttribute("username");
	String Password = (String) session.getAttribute("password");
	String phno = request.getParameter("phno");
	String dob= request.getParameter("dob");
	String address = request.getParameter("address");
	String state= request.getParameter("state");
	String city= request.getParameter("city");
	String country= request.getParameter("country");
	boolean status = RegisterData.ProfileDetails(phno,dob,address,state,city,country);
	if (status) {
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/UserHome");
		requestDispatcher.forward(request,response);
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Profile is updated successfully');");
		out.println("</script>");
	}
	else
	{
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Error in Updating profile');");
		out.println("</script>");
		RequestDispatcher rd = request.getRequestDispatcher("UserProfile.html");
		rd.include(request, response);
		
	}
	
	
	
	
	
	
	
	
}
}