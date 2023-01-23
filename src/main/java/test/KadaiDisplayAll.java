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

@WebServlet("/displayall")
public class KadaiDisplayAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KadaiDisplayAll() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//---キーワードを取得する
		String keyword = (String) request.getParameter("keyword");
		if (keyword == null) {
			keyword = "";
		}

		// SampleDAOのgetAllDataメソッドを呼び出して全データを取り出し、listへ格納
		List<KadaiDataBean> list = new ArrayList<KadaiDataBean>();
		KadaiDAO dao = new KadaiDAO();
		list = dao.getAllData(keyword);
		
		// listをjspへ送るための設定
		request.setAttribute("data", list);
		// キーワードを送る
		request.setAttribute("keyword", keyword);
		// jspへ遷移
		request.getRequestDispatcher("kadaiDisplay.jsp").forward(request, response);
		}
}
