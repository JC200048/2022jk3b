package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.KadaiDataBean;
import dao.KadaiDAO;

@WebServlet("/update")
public class KadaiUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KadaiUpdate() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		KadaiDataBean bean = null;
		boolean errflag = false;
		
		// ---送信された学籍番号を受け取る存在しなければdisplayallへ戻る
		String strStudent_number = request.getParameter("student_number");
		if (strStudent_number == null || strStudent_number== "") {
			errflag = true;
		} else {
			// ---データベースから該当するデータを取得する無ければdisplayallへ戻る
			KadaiDAO dao = new KadaiDAO();
			bean = dao.getOneRec(strStudent_number);
			if (bean == null) {
				errflag = true;
			}
		}
		
		
		/*
		// ---送信されたIDを受け取る存在しなければdisplayallへ戻る
		String strId = request.getParameter("id");
		if (strId == null || strId == "") {
			errflag = true;
		} else {
			// ---データベースから該当するデータを取得する無ければdisplayallへ戻る
			KadaiDAO dao = new KadaiDAO();
			bean = dao.getOneRec(strId);
			if (bean == null) {
				errflag = true;
			}
		}
		*/

		// ---エラーがあればdisplayall へ戻る
		if (errflag) {
			response.sendRedirect("displayall");
		} else {
			// ---更新用のフォームを呼び出す
			request.setAttribute("data", bean);
			request.getRequestDispatcher("kadaiUpdate.jsp").forward(request, response);
		}
	}
}

