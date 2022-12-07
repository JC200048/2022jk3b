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
		con = conn();   //---スーパークラスのデータベース接続部分を呼び出す。conn という変数を利用して参照できる。
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
				String student_name = rs.getString("student_name");
				//----ArrayListへデータを追加する
				KadaiDataBean b = new KadaiDataBean();
				b.setStudent_number(student_number);
				b.setStudent_name(student_name);
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
				String student_name = rs.getString("student_name");
				//----ArrayListへデータを追加する
				KadaiDataBean b = new KadaiDataBean();
				b.setStudent_number(student_number);
				b.setStudent_name(student_name);
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
			String sql = "insert into gakusei_master(id, name) values(?, ?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1,bean.getStudent_number());
			st.setString(2, bean.getEnrollment_status());
			st.setString(3, bean.getEnrollment_confirmation_date());
			st.setString(4, bean.getStudent_name());
			st.setString(5, bean.getParent_furigana());
			st.setString(6, bean.getBirthday());
			st.setString(7, bean.getStudent_post_code());
			st.setString(8, bean.getStudent_address());
			st.setString(9, bean.getStudent_phone_number());
			st.setString(10, bean.getStudent_mail_address());
			st.setString(11, bean.getParent_name());
			st.setString(12, bean.getParent_furigana());
			st.setString(13, bean.getParent_post_code());
			st.setString(14, bean.getStudent_address());
			st.setString(15, bean.getParent_phone_number());
			st.setString(16, bean.getParent_mail_address());
			result = st.executeUpdate();	// 変更されたレコード数を受け取る
		} catch(Exception e) {
			e.printStackTrace();
			result = 0; 		// 失敗した時は変更されたレコード数を0にする
		}
		return result;		// 変更されたレコード数を返す
	}
}
