package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		String strStudent_number = request.getParameter("student_number");								// 学籍番号の取得
		String strEnrollment_status = request.getParameter("enrollment_status");						// 在籍状態の取得
		String strEnrollment_confirmation_date = request.getParameter("enrollment_confirmation_date");	// 在籍状態確定日の取得
		String strStudent_name= request.getParameter("student_name");									// 学生氏名（漢字）の取得
		String strStudent_furigana = request.getParameter("student_furigana");							// 学生ふりがなの取得
		String strBirthday = request.getParameter("birthday");											// 生年月日の取得
		String strStudent_post_code = request.getParameter("student_post_code");						// 本人郵便番号の取得
		String strStudent_address = request.getParameter("student_address");							// 本人住所の取得
		String strStudent_phone_number = request.getParameter("student_phone_number");					// 本人電話番号の取得
		String strStudent_mail_address = request.getParameter("student_mail_address");					// 本人メールアドレスの取得
		String strParent_name = request.getParameter("parent_name");									// 保護者氏名（漢字）の取得
		String strParent_furigana = request.getParameter("parent_furigana");							// 保護者ふりがなの取得
		String strParent_post_code = request.getParameter("parent_post_code");							// 保護者郵便番号の取得
		String strParent_address = request.getParameter("parent_address");								// 保護者住所の取得
		String strParent_phone_number = request.getParameter("parent_phone_number");					// 保護者電話番号の取得
		String strParent_mail_address = request.getParameter("parent_mail_address");					// 保護者メールアドレスの取得
		
		//---エラーチェック
		boolean errSw = false;		// 送信されたデータに誤りがあればtrueにする
		int id = -1; 				// ダミーの値をとりあえず入れておく
		//---番号が空か、および値が数値かを判断
		if (strStudent_number == null || strStudent_number == "") {
			response.getWriter().println("<p>学籍番号が入力されていません</p>");
			errSw = true;
		} else {
			try {
				id = Integer.parseInt(strStudent_number);
			} catch(Exception e) {
				response.getWriter().println("<p>学籍番号が数字ではありません</p>");
				errSw = true;
			}
		}
		
		//---在籍状態が空かどうか判断
		if (strEnrollment_status == null || strEnrollment_status == "") {
			response.getWriter().println("<p>在籍状態が入力されていません</p>");
			errSw = true;
		}
		
		//---在籍状態確定日が空かどうか判断
		if (strEnrollment_confirmation_date == null || strEnrollment_confirmation_date == "") {
			response.getWriter().println("<p>在籍状態確定日が入力されていません</p>");
			errSw = true;
		}
		
		//---学生氏名（漢字）が空かどうか判断
		if (strStudent_name == null || strStudent_name == "") {
			response.getWriter().println("<p>学生氏名が入力されていません</p>");
			errSw = true;
		}
		
		//---学生ふりがなが空かどうか判断
		if (strStudent_furigana == null || strStudent_furigana == "") {
			response.getWriter().println("<p>学生ふりがなが入力されていません</p>");
			errSw = true;
		}
		
		//--- 生年月日が空かどうか判断
		if (strBirthday == null || strBirthday == "") {
			response.getWriter().println("<p>生年月日が入力されていません</p>");
			errSw = true;
		}
		
		//---本人郵便番号が空かどうか判断
		if (strStudent_post_code == null || strStudent_post_code == "") {
			response.getWriter().println("<p>本人郵便番号が入力されていません</p>");
			errSw = true;
		}
		
		//---本人住所が空かどうか判断
		if (strStudent_address == null || strStudent_address == "") {
			response.getWriter().println("<p>本人住所が入力されていません</p>");
			errSw = true;
		}
		
		//---本人電話番号が空かどうか判断
		if (strStudent_phone_number == null || strStudent_phone_number == "") {
			response.getWriter().println("<p>本人電話番号が入力されていません</p>");
			errSw = true;
		}
		
		//---保護者氏名（漢字）が空かどうか判断
		if (strParent_name == null || strParent_name == "") {
			response.getWriter().println("<p>保護者氏名（漢字）が入力されていません</p>");
			errSw = true;
		}
		
		//---保護者ふりがなが空かどうか判断
		if (strParent_furigana == null || strParent_furigana == "") {
			response.getWriter().println("<p>保護者ふりがなが入力されていません</p>");
			errSw = true;
		}
		
		//---保護者郵便番号が空かどうか判断
		if (strParent_post_code == null || strParent_post_code == "") {
			response.getWriter().println("<p>保護者郵便番号が入力されていません</p>");
			errSw = true;
		}
		
		//---保護者住所が空かどうか判断
		if (strParent_address == null || strStudent_address == "") {
			response.getWriter().println("<p>保護者住所が入力されていません</p>");
			errSw = true;
		}
		
		//---保護者電話番号が空かどうか判断
		if (strParent_phone_number == null || strParent_phone_number == "") {
			response.getWriter().println("<p>保護者電話番号が入力されていません</p>");
			errSw = true;
		}
		
		
		//---エラーデータでなければ登録
		if (!errSw) {
			//---すでに登録済みのidかを調べる。
			KadaiDAO dao = new KadaiDAO();
			int result = dao.insertData(strStudent_number, strEnrollment_status, strEnrollment_confirmation_date, strStudent_name, strStudent_furigana, strBirthday, strStudent_post_code, strStudent_address, strStudent_phone_number, strStudent_mail_address, strParent_name, strParent_furigana, strParent_post_code, strParent_address, strParent_phone_number, strParent_mail_address);
			//---insertDataは追加したレコード数を返すので0かどうかで成功かを判断する
			if (result == 0) {
				response.getWriter().println("<p>登録できませんでした</p>");
				} else {
					response.getWriter().println("<p>登録完了しました</p>");
				}
			}
		}
	}
