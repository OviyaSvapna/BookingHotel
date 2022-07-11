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

import mydb.RegisterData;
@WebServlet("/CreateAccDetail")
public class CreateAccDetail extends HttpServlet {
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
