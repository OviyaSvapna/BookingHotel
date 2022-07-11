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
@WebServlet("/RoomDetails")
public class RoomDetails extends HttpServlet {
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
		 	HttpSession session = request.getSession();
			String Name = (String) session.getAttribute("username");
			String Password = (String) session.getAttribute("password");
			PrintWriter out = response.getWriter();
			String roomtype = request.getParameter("roomtype");
			String roomid = request.getParameter("roomid");
			String people = request.getParameter("people");
			String roomfare = request.getParameter("roomfare");
			String roomdescrp = request.getParameter("roomdescrp");
			String roomtitle = request.getParameter("roomtitle");
			String Beds = request.getParameter("noofbed");
			String facility[] = request.getParameterValues("facility");
			String facilities="";
			for(int i=0;i<facility.length;i++)
			{
				facilities+=facility[i]+" ";
			}
			boolean status = RegisterData.RoomDetails(roomtype,roomid,people,roomfare,roomdescrp,roomtitle,Beds,facilities);
			if (status) {
				ServletContext servletContext = getServletContext();
				RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/AdminHome");
				requestDispatcher.forward(request,response);
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Room Details inserted successfully');");
				out.println("</script>");
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Error in inserting room details');");
				out.println("</script>");
				RequestDispatcher rd = request.getRequestDispatcher("RoomDetail.html");
				rd.include(request, response);
				
			}
			
			
			
		
	}

}
