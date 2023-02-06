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

@WebServlet("/displayzaiseki")
public class KadaiDisplayZaiseki extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KadaiDisplayZaiseki() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//---在籍状態を取得する
		String zaiseki = (String) request.getParameter("zaiseki");
		if (zaiseki == null) {
			zaiseki = "";
		}

		// KadaiDAOのgetZaisekiDataメソッドを呼び出して全データを取り出し、listへ格納
		List<KadaiDataBean> list2 = new ArrayList<KadaiDataBean>();
		KadaiDAO dao2 = new KadaiDAO();
		list2 = dao2.getZaisekiData(zaiseki);
		
		// listをjspへ送るための設定
		request.setAttribute("data2", list2);
		// 在籍状態を送る
		request.setAttribute("zaiseki", zaiseki);
		// jspへ遷移
		request.getRequestDispatcher("kadaiDisplayZaiseki.jsp").forward(request, response);
		}
}
