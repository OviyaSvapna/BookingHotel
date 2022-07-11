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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("passwrd");
		System.out.println("Hello "+username+" "+password+" Loginservlet");
		if(username.equals("admin")&&password.equals("hello123*"))
		{
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Welcome Admin');");
 			out.println("</script>");
			HttpSession session=request.getSession();  
	        session.setAttribute("username",username);  
	        session.setAttribute("password",password);  
			ServletContext servletContext = getServletContext();
			RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/AdminHome");
			requestDispatcher.forward(request,response);	
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User Login Successfully');");
			out.println("</script>");
			HttpSession session=request.getSession();  
	        session.setAttribute("username",username);  
	        session.setAttribute("password",password);  
	        RequestDispatcher rd = request.getRequestDispatcher("/UserHome");
			rd.forward(request, response);
		} 
	}
}
