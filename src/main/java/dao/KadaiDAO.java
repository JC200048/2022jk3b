package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.KadaiDataBean;
import conn.KadaiConn;

public class KadaiDAO extends KadaiConn implements Serializable{
	private static final long serialVersionUID = 1L;
	
	Connection con;
	
	public KadaiDAO() {
		con = conn();   //-ー--スーパークラスのデータベース接続部分を呼び出す。conn という変数を利用して参照できる。
	}
	
	//ｰｰｰｰsampleテーブルから取り出したデータをArrayListに格納する。
	public List<KadaiDataBean> getAllData() { 
		List<KadaiDataBean> data = new ArrayList<KadaiDataBean>();
		try {
			String sql = "select * from gakusei_master";
			Statement st = con.createStatement(); 
			ResultSet rs = st.executeQuery(sql);
			System.out.println(rs.toString());
			while(rs.next()) {
				int student_number = rs.getInt("student_number");
				String enrollment_status =  rs.getString("enrollment_status");
				String enrollment_confirmation_date = rs.getString("enrollment_confirmation_date");
				String student_name = rs.getString("student_name");
				String student_furigana = rs.getString("student_furigana");
				String birthday = rs.getString("birthday");
				String student_post_code = rs.getString("student_post_code");
				String student_address = rs.getString("student_address");
				String student_phone_number = rs.getString("student_phone_number");
				String student_mail_address = rs.getString("student_mail_address");
				String parent_name = rs.getString("parent_name");
				String parent_furigana = rs.getString("parent_furigana");
				String parent_post_code = rs.getString("parent_post_code");
				String parent_address = rs.getString("parent_address");
				String parent_phone_number = rs.getString("parent_phone_number");
				String parent_mail_address = rs.getString("parent_mail_address");
				//----ArrayListへデータを追加する
				KadaiDataBean b = new KadaiDataBean();
				b.setStudent_number(student_number);
				b.setEnrollment_status(enrollment_status);
				b.setEnrollment_confirmation_date(enrollment_confirmation_date);
				b.setStudent_name(student_name);
				b.setStudent_furigana(student_furigana);
				b.setBirthday(birthday);
				b.setStudent_post_code(student_post_code);
				b.setStudent_address(student_address);
				b.setStudent_phone_number(student_phone_number);
				b.setStudent_mail_address(student_mail_address);
				b.setParent_name(parent_name);
				b.setParent_furigana(parent_furigana);
				b.setParent_post_code(parent_post_code);
				b.setParent_address(parent_address);
				b.setParent_phone_number(parent_phone_number);
				b.setParent_mail_address(parent_mail_address);
				data.add(b);
			}   
		} catch(Exception e) {
				data = null;
				e.printStackTrace();
		}
		return data;
	}
	
	public List<KadaiDataBean> getData(String keyword) { 
		List<KadaiDataBean> data = new ArrayList<KadaiDataBean>();
		try {
			String sql = "select * from gakusei_master where 学生氏名（漢字） like ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + keyword + "%");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int student_number = rs.getInt("student_number");
				String enrollment_status =  rs.getString("enrollment_status");
				String enrollment_confirmation_date = rs.getString("enrollment_confirmation_date");
				String student_name = rs.getString("student_name");
				String student_furigana = rs.getString("student_furigana");
				String birthday = rs.getString("birthday");
				String student_post_code = rs.getString("student_post_code");
				String student_address = rs.getString("student_address");
				String student_phone_number = rs.getString("student_phone_number");
				String student_mail_address = rs.getString("student_mail_address");
				String parent_name = rs.getString("parent_name");
				String parent_furigana = rs.getString("parent_furigana");
				String parent_post_code = rs.getString("parent_post_code");
				String parent_address = rs.getString("parent_address");
				String parent_phone_number = rs.getString("parent_phone_number");
				String parent_mail_address = rs.getString("parent_mail_address");
				
	
				//----ArrayListへデータを追加する
				KadaiDataBean b = new KadaiDataBean();
				b.setStudent_number(student_number);
				b.setEnrollment_status(enrollment_status);
				b.setEnrollment_confirmation_date(enrollment_confirmation_date);
				b.setStudent_name(student_name);
				b.setStudent_furigana(student_furigana);
				b.setBirthday(birthday);
				b.setStudent_post_code(student_post_code);
				b.setStudent_address(student_address);
				b.setStudent_phone_number(student_phone_number);
				b.setStudent_mail_address(student_mail_address);
				b.setParent_name(parent_name);
				b.setParent_furigana(parent_furigana);
				b.setParent_post_code(parent_post_code);
				b.setParent_address(parent_address);
				b.setParent_phone_number(parent_phone_number);
				b.setParent_mail_address(parent_mail_address);
				
				
				data.add(b);
				}   
			} catch(Exception e) {
				e.printStackTrace();
				data = null;
			}
		return data;
		}
	
	public int insertData(KadaiDataBean bean) {
		int result = -1; // 返却値（変更したレコード数）にダミーの値をとりあえず入れておく
		try {

			String sql = "insert into gakusei_master(student_number, enrollment_status, enrollment_confirmation_date, student_name, "
					+ "student_furigana, birthday, student_post_code, student_address, "
					+ "student_phone_number, student_mail_address, parent_name, parent_furigana, "
					+ "parent_post_code, parent_address, parent_phone_number, parent_mail_address) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, bean.getStudent_number());
			st.setString(2, bean.getEnrollment_status());
			st.setString(3, bean.getEnrollment_confirmation_date());
			st.setString(4, bean.getStudent_name());
			st.setString(5, bean.getStudent_furigana());
			st.setString(6, bean.getBirthday());
			st.setString(7, bean.getStudent_post_code());
			st.setString(8, bean.getStudent_address());
			st.setString(9, bean.getStudent_phone_number());
			st.setString(10, bean.getStudent_mail_address());
			st.setString(11, bean.getParent_name());
			st.setString(12, bean.getParent_furigana());
			st.setString(13, bean.getParent_post_code());
			st.setString(14, bean.getParent_address());
			st.setString(15, bean.getParent_phone_number());
			st.setString(16, bean.getParent_mail_address());

			result = st.executeUpdate();	// 変更されたレコード数を受け取る
		} catch(Exception e) {
			e.printStackTrace();
			result = 0; 		// 失敗した時は変更されたレコード数を0にする
		}
		return result;		// 変更されたレコード数を返す
	}
	
	//-----1レコードを取得取得したレコードを返す（失敗はnull)
	public KadaiDataBean getOneRec(String strStudent_number) {
		KadaiDataBean data = new KadaiDataBean();	// 返却するデータ
		try {
			String sql = "select * from gakusei_master where student_number=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(strStudent_number));
			ResultSet rs = st.executeQuery();
			rs.next();		// 最初のレコードの取り出し
			data.setStudent_number(rs.getInt("student_number"));			//番号（id）のセット
			data.setEnrollment_status(rs.getString("enrollment_status"));
			data.setEnrollment_confirmation_date(rs.getString("enrollment_confirmation_date"));
			data.setStudent_name(rs.getString("student_name"));
			data.setStudent_furigana(rs.getString("student_furigana"));
			data.setBirthday(rs.getString("birthday"));
			data.setStudent_post_code(rs.getString("student_post_code"));
			data.setStudent_address(rs.getString("student_address"));
			data.setStudent_phone_number(rs.getString("student_phone_number"));
			data.setStudent_mail_address(rs.getString("student_mail_address"));
			data.setParent_name(rs.getString("parent_name"));
			data.setParent_furigana(rs.getString("parent_furigana"));
			data.setParent_post_code(rs.getString("parent_post_code"));
			data.setParent_address(rs.getString("parent_address"));
			data.setParent_phone_number(rs.getString("parent_phone_number"));
			data.setParent_mail_address(rs.getString("parent_mail_address"));
		} catch(Exception e) {
				e.printStackTrace();	// しくじった時は念のためトレース表示
				data = null;
		}
			return data;
	}
	
	//----- 引数のidが存在すればtrue、存在しなければfalseを返す
	public boolean isExists(String student_number) {
		boolean result = false;      // 結果を返却する変数(存在しない)
		try {
			String sql = " select count(*) from gakusei_master where student_number=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, Integer.parseInt(student_number));
			ResultSet rs = st.executeQuery();
			rs.next();                   // 最初のレコードの位置へ移動
			//--- 結果を取り出して判断する
			if (rs.getInt(1) == 1) {
				result = true;  // データが存在するのでtrueを返却
			}
		} catch (Exception e) {
			e.printStackTrace(); 	// しくじった時は念のためトレース表示
			result = true;  		// 何かのエラーがあったので登録できないようにtrue返す
		}
		return result;
	}
	
	public int updateData(KadaiDataBean bean) {
		int result = -1;
		try {
			String sql = "update gakusei_master set enrollment_status=?, enrollment_confirmation_date=?,"
					+ "student_name =?, student_furigana =?,"
					+ "birthday =?, student_post_code =?,"
					+ "student_address =?, student_phone_number=?,"
					+ "student_mail_address =?, parent_name =?,"
					+ "parent_furigana =?, parent_post_code =?,"
					+ "parent_address =?, parent_phone_number =?,"
					+ "parent_mail_address =? where student_number=?";// SQL文
			PreparedStatement st = con.prepareStatement(sql);// プリペアドステートメント
			st.setInt(1, bean.getStudent_number());
			st.setString(2, bean.getEnrollment_status());
			st.setString(3, bean.getEnrollment_confirmation_date());
			st.setString(4, bean.getStudent_name());
			st.setString(5, bean.getStudent_furigana());
			st.setString(6, bean.getBirthday());
			st.setString(7, bean.getStudent_post_code());
			st.setString(8, bean.getStudent_address());
			st.setString(9, bean.getStudent_phone_number());
			st.setString(10, bean.getStudent_mail_address());
			st.setString(11, bean.getParent_name());
			st.setString(12, bean.getParent_furigana());
			st.setString(13, bean.getParent_post_code());
			st.setString(14, bean.getParent_address());
			st.setString(15, bean.getParent_phone_number());
			st.setString(16, bean.getParent_mail_address());
			result = st.executeUpdate();	//更新の実行
		}catch(Exception e) {
			e.printStackTrace();// エラーなので、とりあえずスタックトレースを表示する
			result = 0;
		}
		return result;
		}
	}