package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.KadaiDataBean;
import dao.KadaiDAO;

@WebServlet("/Dbtest")
public class Dbtest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Dbtest() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		try {
			List<KadaiDataBean> b = new ArrayList<KadaiDataBean>();
			KadaiDAO sb = new KadaiDAO();
			b = sb.getAllData(null);
			for(KadaiDataBean x : b) {
				response.getWriter().print(x.getStudent_number() + "," + x.getStudent_name() + "<br>");
			}   
		} catch(Exception e) {
			response.getWriter().print(e.getMessage());
			e.printStackTrace();
		}
	}
}
	
