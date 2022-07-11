package details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mydb.RegisterData;
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");  
    	HttpSession session = request.getSession();
		String Name = (String) session.getAttribute("username");
		String Password = (String) session.getAttribute("password");
        try 
        {  
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbooking", "root", "Damon123*");
    		String date=request.getParameter("date");
    	    String roomid = request.getParameter("roomid");
    	    System.out.println(roomid);
    		PreparedStatement ps = con.prepareStatement("select * from RoomDetails where roomid=?");
			ps.setString(1,roomid);
			ResultSet rs=ps.executeQuery();
    		String paystate="success";
    		out.println("<html><body><center><h1>Payment Details</h1>");
            while (rs.next()) {
            	
				out.println("<center><table width=30% height=10% border=1><tr><td> Username:" +Name+"</td></tr><tr><td>Room Type: " + rs.getString(1)+  "</td></tr><tr><td> Room name: " + rs.getString(2)+
						 "</td></tr><tr><td> Members: " + rs.getString(3) +"</td></tr><tr><td> Room fare: " + rs.getString(4) + "</td></tr><tr><td> Room Description: " + rs.getString(5)+
						 "</td></tr><tr><td> Room Title: "  +rs.getString(6) + "</td></tr><tr><td> No of Beds: " + rs.getString(7) + "</td></tr><tr><td> Facility: "+ rs.getString(8)+ "</td></tr><tr><td>Room booked date:"+date+"</td></tr><tr><td> Payment Status: Payment Successfull</td></tr>");
				RegisterData.BookedDetails(Name,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6), rs.getString(7),rs.getString(8),date,paystate);
			}
			out.println("</table></center>");
			out.println("</body></html>");
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println("error"+e);  
        }  
	}
}
