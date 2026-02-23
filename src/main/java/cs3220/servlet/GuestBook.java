package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;

@WebServlet(urlPatterns = "/GuestBook")

public class GuestBook extends HttpServlet{
	private static final long serialVersionUID = 1l;
	
	public static List<GuestBookEntry> entries = new ArrayList<>();
	
	public void init() {
		if(entries.isEmpty()) {
			entries.add(new GuestBookEntry(1, "John", "Hello!"));
			entries.add(new GuestBookEntry(2, "John", "Hello Again!"));
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>GuestBook</title></head><body>");
		out.println("<h1>Guest Book</h1>");
		
		out.println("<table style= 'border-collapse: collapse;' border='1'>");
		out.println("<tr><th>Name</th><th>Message</th><th>Edit | Delete</th></tr>");
		
		for(GuestBookEntry entry : entries) {
			out.println("<tr>");
			out.println("<td>" + entry.getName() + "</td>");
			out.println("<td>" + entry.getMessage() + "</td>");
			
			out.println("<td>");
			
			out.println("<a href='EditEntry?id=" + entry.getId() + "'>Edit</a> | ");
			out.println("<a href='DeleteEntry?id=" + entry.getId() + "'>Delete</a>");
            out.println("</td>");
            
            out.println("</tr>");
		}
		out.println("</table>");
		
		out.println("<br><a href='AddComment'>Add Comment</a>");
		out.println("</body></html>");
	}
	
}
