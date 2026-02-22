package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.GuestBookEntry;
/**
 * Servlet implementation class AddComment
 */
@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static int idCounter = 3;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String boxStyle = "style='width: 100%; max-width: 500px; box-sizing: border-box;'";

		out.println("<html><head><title>Add Comment</title></head><body>");
		out.println("<h1>Add Comment</h1>");
		out.println("<form method ='post' action='AddComment'>");
		
		out.println("Name: <input type='text' name='name'><br><br>");
        out.println("Message: <br>");
        out.println("<textarea name='message' rows='5' cols='40'></textarea><br><br>");
        
        out.println("<input type='submit' value='Add Comment'>");
        out.println("</form></body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
        String message = request.getParameter("message");
        
        GuestBookEntry newEntry = new GuestBookEntry(idCounter++, name, message);
        GuestBook.entries.add(newEntry);
        response.sendRedirect("GuestBook");
	}

}
