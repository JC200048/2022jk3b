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
			String sql = "select * from sample";
			Statement st = con.createStatement(); 
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				//----ArrayListへデータを追加する
				KadaiDataBean b = new KadaiDataBean();
				b.setId(id);
				b.setName(name);
				data.add(b);
				}   
			} catch(Exception e) {
				data = null;
			}return data;
		}
	
	public List<KadaiDataBean> getData(String keyword) { 
		List<KadaiDataBean> data = new ArrayList<KadaiDataBean>();
		try {
			String sql = "select * from gakusei_master where name like ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + keyword + "%");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				//----ArrayListへデータを追加する
				KadaiDataBean b = new KadaiDataBean();
				b.setId(id);
				b.setName(name);
				data.add(b);
				}   
			} catch(Exception e) {
				e.printStackTrace();
				data = null;
			}
		return data;
		}

	}
