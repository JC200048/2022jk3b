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

@WebServlet("/sousin")
public class KadaiZaiseki extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public KadaiZaiseki() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		try {
			String zaiseki = request.getParameter("zaiseki");
			List<KadaiDataBean> a = new ArrayList<KadaiDataBean>();
			KadaiDAO sa = new KadaiDAO();
			a = sa.getZaisekiData(zaiseki);
			for(KadaiDataBean x : a) {
				response.getWriter().print(x.getStudent_number() + "," + x.getStudent_name() + "<br>");
			}
		} catch(Exception e) {
			response.getWriter().print(e.getMessage());
			e.printStackTrace();
		}
	}
}
