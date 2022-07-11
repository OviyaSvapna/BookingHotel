package details;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/ViewBooked")
public class ViewBooked extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out = response.getWriter();  
    response.setContentType("text/html");  
	HttpSession session = request.getSession();
	String UName = (String) session.getAttribute("username");
	String Password = (String) session.getAttribute("password");
    out.println("<html><body>");  
    try 
    {  
    	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelbooking", "root", "Damon123*");
        Statement stmt = con.createStatement();  
        ResultSet rs = stmt.executeQuery("select * from BookedDetails"); 
		out.println("<html><body><center><h1>Booking Details</h1>");
        out.println("<table border=1 width=90% height=30%>");  
        out.println("<tr><th>User Name</th><th>Room Type</th><th>Room ID</th><th>People</th><th>Room fare</th><th>Room description</th><th>Room Title</th><th>Beds</th><th>Date</th><th>Facilities</th><th>Status</th><tr>");  
        while (rs.next()) 
        {  
        	String Name= rs.getString(1); 
            String roomtype= rs.getString(2);  
            String roomid = rs.getString(3);  
            String people = rs.getString(4);  
            String roomfare = rs.getString(5); 
            String roomdescrp = rs.getString(6);  
            String roomtitle = rs.getString(7); 
            String Beds = rs.getString(8);  
            String facilities = rs.getString(9); 
            String date = rs.getString(10); 
            String status = "Booked"; 
            out.println("<tr><td>"+ Name +"</td><td>" + roomtype + "</td><td>" + roomid + "</td><td>" + people + "</td><td>" + roomfare + "</td><td>" + roomdescrp + "</td><td>" + roomtitle +"</td><td>" + Beds +"</td><td>"+ date +"</td><td>" + facilities +"</td><td>"+ status +"</td></tr>");   
        }  
        out.println("</table>");  
        out.println("</html></body>");  
        con.close();  
       }  
        catch (Exception e) 
       {  
        out.println("error");  
    }
}
}
