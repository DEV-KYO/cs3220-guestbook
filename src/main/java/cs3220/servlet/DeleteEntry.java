package cs3220.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Get the ID from the URL (Correctly placed INSIDE doGet)
        String idString = request.getParameter("id");
        
        if (idString != null) {
            // 2. Convert text to a number
            int id = Integer.parseInt(idString);
            
            // 3. Remove the entry where the ID matches
            GuestBook.entries.removeIf(entry -> entry.getId() == id);
        }
        
        // 4. Send them back to the main list
        response.sendRedirect("GuestBook");
    }
}