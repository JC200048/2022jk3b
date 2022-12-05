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

@WebServlet("/insert")
public class KadaiInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public KadaiInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String strId = request.getParameter("id");			// IDの取得
		String strSimei = request.getParameter("simei");	// 氏名の取得
		
		List<String> message = new ArrayList<String>(); //---メッセージ格納用配列
		
		//---エラーチェック
		boolean errSw = false;		// 送信されたデータに誤りがあればtrueにする
		int id = -1; 				// ダミーの値をとりあえず入れておく
		//---番号が空か、および値が数値かを判断
		if (strId == null || strId == "") {
			response.getWriter().println("<p>番号が入力されていません</p>");
			errSw = true;
		} else {
			try {
				id = Integer.parseInt(strId);
			} catch(Exception e) {
				response.getWriter().println("<p>番号が数字ではありません</p>");
				errSw = true;
				}
			}
		//---氏名が空かどうか判断
		if (strSimei == null || strSimei == "") {
			response.getWriter().println("<p>名前が入力されていません</p>");
			errSw = true;
		}
		
		//---エラーデータでなければ登録
		if (!errSw) {
			//---すでに登録済みのidかを調べる。
			KadaiDAO dao = new KadaiDAO();
			if (!dao.isExists(strId)) {
				KadaiDataBean bean = new KadaiDataBean();
				bean.setStudent_number(id)
				bean.setName(strSimei);
				int result = dao.insertData(bean);
				if (result == 0) {
					message.add("登録できませんでした。");
				} else {
					message.add("登録完了しました。");
				}
			} else {
				message.add("IDが重複しています。");
			}
		}//---メッセージ表示用のjspへ遷移
		request.setAttribute("message", message);
		request.getRequestDispatcher("sampleInsert.jsp").forward(request, response);
		}
	}
