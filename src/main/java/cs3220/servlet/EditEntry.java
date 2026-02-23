package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cs3220.model.GuestBookEntry;

@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	//takes care of warning
	private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        GuestBookEntry entryToEdit = null;
        
        
        for (GuestBookEntry entry : GuestBook.entries) {
            if (entry.getId() == id) {
                entryToEdit = entry;
                break;
            }
        }
        //calls HTML rendering 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Edit Comment</title></head><body>");
        out.println("<h1>Edit Comment</h1>");
        
        //calls doPost
        out.println("<form method='post' action='EditEntry'>");
        out.println("<input type='hidden' name='id' value='" + id + "'>");
        out.println("Name: <input type='text' name='name' value='" + entryToEdit.getName() + "'><br><br>");
        out.println("Message: <br><textarea name='message' rows='5' cols='40'>" + entryToEdit.getMessage() + "</textarea><br><br>");
        out.println("<input type='submit' value='Update'>");
        out.println("</form></body></html>");
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String message = request.getParameter("message");

        for (GuestBookEntry entry : GuestBook.entries) {
            if (entry.getId() == id) {
                entry.setName(name);
                entry.setMessage(message);
                break;
            }
        }
        response.sendRedirect("GuestBook");
    }
}