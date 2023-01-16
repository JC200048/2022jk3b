package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		
		String strStudent_number = request.getParameter("student_number");								// 学籍番号の取得
		String strEnrollment_status = request.getParameter("enrollment_status");						// 在籍状態の取得
		String strEnrollment_confirmation_date = request.getParameter("enrollment_confirmation_date");	// 在籍状態確定日の取得
		String strStudent_name = request.getParameter("student_name");									// 学生氏名（漢字）の取得
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
		
		List<String> message = new ArrayList<String>(); //---メッセージ格納用配列
		
		//---エラーチェック　
		boolean errSw = false;		// 送信されたデータに誤りがあればtrueにする
		int student_number = -1; 				// ダミーの値をとりあえず入れておく
		//---番号が空か、および値が数値かを判断
		if (strStudent_number == null || strStudent_number == "") {
			message.add("学籍番号が入力されていません");
			errSw = true;
		} else {
			try {
				student_number = Integer.parseInt(strStudent_number);
			} catch(Exception e) {
				message.add("学籍番号が数字ではありません");
				errSw = true;
			}
		}

		//---在籍状態が空かどうか判断  
		if (strEnrollment_status == null || strEnrollment_status == "") {
			message.add("在籍状態が入力されていません");
			errSw = true;
		}
		
		//---在籍状態確定日が空かどうか判断
		if (strEnrollment_confirmation_date == null || strEnrollment_confirmation_date == "") {
			message.add("在籍状態確定日が入力されていません");
			errSw = true;
		}
		
		//---学生氏名（漢字）が空かどうか判断
		if (strStudent_name == null || strStudent_name == "") {
			message.add("学生氏名が入力されていません");
			errSw = true;
		}
		
		//---学生ふりがなが空かどうか判断
		if (strStudent_furigana == null || strStudent_furigana == "") {
			message.add("学生ふりがなが入力されていません");
			errSw = true;
		}
		
		//--- 生年月日が空かどうか判断
		if (strBirthday == null || strBirthday == "") {
			message.add("生年月日が入力されていません");
			errSw = true;
		}
		
		//---本人郵便番号が空かどうか判断
		if (strStudent_post_code == null || strStudent_post_code == "") {
			message.add("本人郵便番号が入力されていません");
			errSw = true;
		}
		
		//---本人郵便番号が正規表現かどうか判断
		String strPattern1 = "^[0-9]{7}$";				//正規表現文字列
		Pattern p1 = Pattern.compile(strPattern1);			//正規表現オブジェクトの準備
		Matcher m1 = p1.matcher(strStudent_post_code);		//正規表現をマッチさせる
		if (m1.find()) {										//findメソッドがtrueなら一致する
		} else { 
			message.add("本人郵便番号が正しく入力されていません");
			errSw = true;
		}
		
		//---本人住所が空かどうか判断
		if (strStudent_address == null || strStudent_address == "") {
			message.add("本人住所が入力されていません");
			errSw = true;
		}
		
		//---本人電話番号が空かどうか判断
		if (strStudent_phone_number == null || strStudent_phone_number == "") {
			message.add("本人電話番号が入力されていません");
			errSw = true;
		}
		
		//---本人電話番号が正規表現かどうか判断
		String strPattern2 = "^0[-0-9]{11,12}";				//正規表現文字列
		Pattern p2 = Pattern.compile(strPattern2);			//正規表現オブジェクトの準備
		Matcher m2 = p2.matcher(strStudent_phone_number);		//正規表現をマッチさせる
		if (m2.find()) {										//findメソッドがtrueなら一致する
		} else { 
			message.add("本人電話番号が正しく入力されていません");
			errSw = true;
		}
		
		//---保護者氏名（漢字）が空かどうか判断
		if (strParent_name == null || strParent_name == "") {
			message.add("保護者氏名（漢字）が入力されていません");
			errSw = true;
		}
		
		//---保護者ふりがなが空かどうか判断
		if (strParent_furigana == null || strParent_furigana == "") {
			message.add("保護者ふりがなが入力されていません");
			errSw = true;
		}
		
		//---本人郵便番号が正規表現かどうか判断
		String strPattern3 = "^[0-9]{7}$";					//正規表現文字列
		Pattern p3 = Pattern.compile(strPattern3);			//正規表現オブジェクトの準備
		Matcher m3 = p1.matcher(strStudent_post_code);		//正規表現をマッチさせる
		if (m3.find()) {									//findメソッドがtrueなら一致する
		} else { 
			message.add("本人郵便番号が正しく入力されていません");
			errSw = true;
		}
		
		//---保護者住所が空かどうか判断
		if (strParent_address == null || strStudent_address == "") {
			message.add("保護者住所が入力されていません");
			errSw = true;
		}
		
		//---保護者電話番号が正規表現かどうか判断
		String strPattern4 = "^0[-0-9]{11,12}";				//正規表現文字列
		Pattern p4 = Pattern.compile(strPattern4);			//正規表現オブジェクトの準備
		Matcher m4 = p4.matcher(strStudent_phone_number);	//正規表現をマッチさせる
		if (m4.find()) {									//findメソッドがtrueなら一致する
		} else { 
			message.add("保護者電話番号が正しく入力されていません");
			errSw = true;
		}
		
		//---エラーデータでなければ登録
		if (!errSw) {
			KadaiDAO dao = new KadaiDAO();
			KadaiDataBean bean = dao.getOneRec(strStudent_number);
			if (bean == null) {
				bean = new KadaiDataBean();
				bean.setStudent_number(student_number);
				bean.setEnrollment_status(strEnrollment_status);
				bean.setEnrollment_confirmation_date(strEnrollment_confirmation_date);
				bean.setStudent_name(strStudent_name);
				bean.setStudent_furigana(strStudent_furigana);
				bean.setBirthday(strBirthday);
				bean.setStudent_post_code(strStudent_post_code);
				bean.setStudent_address(strStudent_address);
				bean.setStudent_phone_number(strStudent_phone_number);
				bean.setStudent_mail_address(strStudent_mail_address);
				bean.setParent_name(strParent_name);
				bean.setParent_furigana(strParent_furigana);
				bean.setParent_post_code(strParent_post_code);
				bean.setParent_address(strParent_address);
				bean.setParent_phone_number(strParent_phone_number);
				bean.setParent_mail_address(strParent_mail_address);
				int result = dao.insertData(bean);
				//---insertDataは追加したレコード数を返すので0かどうかで成功かを判断する
				if (result == 0) {
					message.add("登録できませんでした。");
				} else {
					message.add("登録完了しました。");
				}
				
			} else {
				message.add("IDが重複しています。");
				}
			}
		
		//---メッセージ表示用のjspへ遷移
		request.setAttribute("message", message);
		request.getRequestDispatcher("kadaiInsert.jsp").forward(request, response);
	}
}

	
	
