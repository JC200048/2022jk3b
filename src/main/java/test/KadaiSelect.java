package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/select")
public class KadaiSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KadaiSelect() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String proc = request.getParameter("submit");
		if (proc != null) {
			if (proc.equals("insert")) {
				response.sendRedirect("kadaiInsert.html");
				return;
			} else if (proc.equals("update")) {
				request.getRequestDispatcher("update").forward(request, response);
				return;
			} else if (proc.equals("search")) {
				request.getRequestDispatcher("displayall").forward(request, response);
				return;
			} else if (proc.equals("sousin")) {
				request.getRequestDispatcher("displayzaiseki").forward(request, response);
				return;
			}
		}
		response.sendRedirect("displayall");
	}
}
