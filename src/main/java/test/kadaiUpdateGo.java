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


@WebServlet("/updatego")
public class kadaiUpdateGo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public  kadaiUpdateGo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//---変更ボタンクリック以外は一覧へ戻す
		String submit = (String) request.getParameter("submit");
		if (submit == null || !submit.equals("1")) {
			response.sendRedirect("displayall");
			return;
		}
		
		//エラーメッセージを格納する配列
		List<String> list = new ArrayList();
		
		//---フォームデータの取得
		KadaiDataBean bean = new KadaiDataBean();
		String strStudent_number = request.getParameter("student_number");
		String strStudent_name = request.getParameter("student_name");
		String strStudent_furigana = request.getParameter("student_furigana");
		
		//---学籍番号の設定（エラーチェックもする）
		try {
			bean.setStudent_number(Integer.parseInt(strStudent_number));
		} catch(Exception e) {
			list.add("学籍番号が数値でありません。");
		}
		
		//---学生氏名（漢字）の設定（エラーチェックもする）
		if (strStudent_name.isEmpty()) {
			list.add("学生氏名（漢字）の値が未設定になっています");
		} else {
			bean.setStudent_name(strStudent_name);
		}
		
		//---学生ふりがなの設定（エラーチェックもする）
		if (strStudent_furigana.isEmpty()) {
			list.add("学生氏名（漢字）の値が未設定になっています");
		} else {
			bean.setStudent_furigana(strStudent_furigana);
		}
		
		
		/*
		//---エラーメッセージを格納する配列
		List<String> list = new ArrayList();
		//---フォームデータの取得
		KadaiDataBean bean = new KadaiDataBean();
		String strId = request.getParameter("id");
		String strSimei = request.getParameter("simei");
		//---IDの設定（エラーチェックもする）
		try {
			bean.setStudent_number(Integer.parseInt(strId));
		} catch(Exception e) {
			list.add("IDが数値でありません。");
		}
		//---氏名の設定（エラーチェックもする）
		if (strSimei.isEmpty()) {
			list.add("氏名の値が未設定になっています");
		} else {
			bean.setStudent_name(strSimei);
		}
		*/
		
		//---DAOのupdatedataを呼び出す。
		if (list.size()== 0) {
			KadaiDAO dao = new KadaiDAO();
			int result = dao.updateData(bean);
			if (result == 1) {
				list.add("修正完了しました。");
			} else {
				list.add("修正できませんでした。");
			}
		}
		
		//---結果表示のｊjspへ遷移
		request.setAttribute("message", list);
		request.getRequestDispatcher("kadaiUpdateGo.jsp").forward(request, response);
	}

}
