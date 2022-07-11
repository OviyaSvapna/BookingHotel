package details;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mydb.RegisterData;

import java.io.*;

@WebServlet("/Record")
public class Record extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String status="";
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String UserName= request.getParameter("username");
		String Email = request.getParameter("email");
		String Password = request.getParameter("passwrd");
		String ConfirmPassword = request.getParameter("confirmpasswrd");
		if(Password.equals(ConfirmPassword)) 
		{
		RegisterData a = new RegisterData();
		status=a.RegisterDet(FirstName,LastName,UserName,Email,Password);
		if(status.equals("Success")) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Account is created Successfully');");
			out.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.forward(request, response);
		}
		else {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Unable to create account');");
			out.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("Register.html");
			rd.forward(request, response);
		}
		}
		else
		{
			System.out.println("Invalid password");
		}
		out.close();
	}
}
