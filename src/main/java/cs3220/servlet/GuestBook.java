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
			entries.add(new GuestBookEntry(1, "John", "Hello Again!"));
		}
	}
	
	
}
