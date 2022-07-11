package details;

import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ViewRoom")
public class ViewRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html"); 
		HttpSession session = request.getSession();
		String Name = (String) session.getAttribute("username");
		String Password = (String) session.getAttribute("password");
        out.println("<html><body>");  
        try 
        {  
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbooking", "root", "Damon123*");
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from RoomDetails");
        	out.println("<html><body><center><h1>Room Details</h1>");
            out.println("<table border=1 width=70% height=30%>");  
            out.println("<tr><th>Room Type</th><th>Room ID</th><th>People</th><th>Room fare</th><th>Room description</th><th>Room Title</th><th>Beds</th><th>Facilities</th><tr>");  
            while (rs.next()) 
            {  
                String roomtype= rs.getString("roomtype");  
                String roomid = rs.getString("roomid");  
                String people = rs.getString("people");  
                String roomfare = rs.getString("roomfare"); 
                String roomdescrp = rs.getString("roomdescrp");  
                String roomtitle = rs.getString("roomtitle"); 
                String Beds = rs.getString("noofbed");  
                String facilities = rs.getString("facility"); 
                out.println("<tr><td>" + roomtype + "</td><td>" + roomid + "</td><td>" + people + "</td><td>" + roomfare + "</td><td>" + roomdescrp + "</td><td>" + roomtitle +"</td><td>" + Beds +"</td><td>" + facilities +"</td></tr>");   
            }  
            out.println("</table>");  
            out.println("</html></body>");  
            con.close();  
           }  
            catch (Exception e) 
           {  
            out.println(e);  
        }  
    }  
}
