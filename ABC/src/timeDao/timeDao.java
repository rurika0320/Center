package timeDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import timeBean.timeBean;


public class timeDao {
		private Connection connection;

	//コンストラクター
	//java_web_systemデータベースとの接続を行う
	public timeDao() throws ClassNotFoundException,SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/java_web_system?useSSL=false";
		String user = "root";
		String password = "a16maysa";
		connection = DriverManager.getConnection(url,user,password);

	}

	//java_web_systemデータベースとの接続するメソッド
	public void close() {
		try {
			if(connection != null) {
				connection.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	//①ログイン確認
	public ArrayList<timeBean> getEmpDateByLogin(int Id1,String empPass)throws SQLException{
		ArrayList<timeBean> empData = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM fltrsettei WHERE fltr_id=? AND fltr_Pass=?";
			pstatement = connection.prepareStatement(sql);
			//INパラメーターの設定
			pstatement.setInt(1, Id1);
			pstatement.setString(2, empPass);
			rs = pstatement.executeQuery();
			empData = new ArrayList<timeBean>();

			while(rs.next()) {
				timeBean bean = new timeBean();
				bean.setId(rs.getInt("fltr_id"));
				bean.setPass(rs.getString("fltr_pass"));
				empData.add(bean);
				}rs.close();
		}finally {
				pstatement.close();
			}
		return empData;
	}

	//②新規登録
	public int registarEmpData(timeBean time) throws SQLException{
			int numRow = 0;
			PreparedStatement pstatement = null;
			try {
				connection.setAutoCommit(false);
				String sql = "INSERT INTO fltrsettei(fltr_id,fltr_pass)"
						+ "VALUES(?,?)";
				pstatement = connection.prepareStatement(sql);
				pstatement.setInt(1, time.getId());
				pstatement.setString(2, time.getPass());
				numRow = pstatement.executeUpdate();
			}finally {
				if(numRow > 0) {
					//登録成功時はコミット
					connection.commit();
				}else {
					connection.rollback();
			}//preparedStatementオブジェクトの解放
			pstatement.close();
			}
			return numRow;
		}

	//③過去の記録を確認
	public ArrayList<timeBean> getEmpDateByDate(int id1,int year1,int month1) throws SQLException{
		ArrayList<timeBean> timeDate = null;
		PreparedStatement pstatement = null;
		ResultSet rs = null;
		try {
			String sql = "SELECT * FROM fltrkintai WHERE fltr_id = ?  and fltr_year = ? and fltr_month = ?";
			pstatement = connection.prepareStatement(sql);
			pstatement.setInt(1, id1);
			pstatement.setInt(2, year1);
			pstatement.setInt(3, month1);
			rs = pstatement.executeQuery();
			timeDate = new ArrayList<timeBean>();
			while(rs.next()) {
				timeBean bean = new timeBean();
				bean.setId(rs.getInt("fltr_id"));
				bean.setDate(rs.getString("fltr_date"));
				bean.setClockIn(rs.getString("fltr_clockIn"));
				bean.setClockOut(rs.getString("fltr_clockOut"));
				bean.setWorkingHours(rs.getString("fltr_workingHours"));
				timeDate.add(bean);
			}rs.close();
		}finally {
			pstatement.close();
			}
	return timeDate;

	}
	//④出勤時間の登録
	public int insertInEmpData(timeBean time) throws SQLException{
		int numRow = 0;
		PreparedStatement pstatement = null;
		try {
			connection.setAutoCommit(false);
			String sql = "INSERT INTO fltrkintai(fltr_id,fltr_date,fltr_year,fltr_month,fltr_clockIn)"
					+ "VALUE(?,?,?,?,?)";
			pstatement = connection.prepareStatement(sql);
			pstatement.setInt(1, time.getId());
			pstatement.setString(2, time.getDate());
			pstatement.setInt(3, time.getYear());
			pstatement.setInt(4, time.getMonth());
			pstatement.setString(5, time.getClockIn());
			numRow = pstatement.executeUpdate();
		}finally {
			if(numRow > 0) {
				//登録成功時はコミット
				connection.commit();
			}else {
				connection.rollback();
		}
		pstatement.close();
		}
	return numRow;

	}

	 //⑤退勤時間の登録
		public int insertOutEmpData(timeBean time) throws SQLException{
			int numRow = 0;
			PreparedStatement pstatement = null;
			try {
				connection.setAutoCommit(false);
				String sql = "UPDATE fltrkintai SET fltr_clockOut = ?"
				+ "WHERE fltr_id = ? and fltr_date = ?";
				pstatement = connection.prepareStatement(sql);
				pstatement.setString(1, time.getClockOut());
				pstatement.setInt(2, time.getId());
				pstatement.setString(3, time.getDate());
				numRow = pstatement.executeUpdate();
			}finally {
				if(numRow > 0) {
					connection.commit();
				}else {
					connection.rollback();

			}//preparedStatementオブジェクトの解放
			pstatement.close();
			}
		return numRow;

		}
	//⑥実労働時間の算出
		public int keisanEmpData(timeBean time) throws SQLException{
			int numRow = 0;
			PreparedStatement pstatement = null;
			try {
				connection.setAutoCommit(false);

				String sql = "UPDATE fltrkintai SET fltr_workingHours = TIMEDIFF(fltr_clockOut, fltr_clockIn)";

				pstatement = connection.prepareStatement(sql);
				pstatement.executeUpdate();
				numRow = pstatement.executeUpdate();
				timeBean bean = new timeBean();

			}finally {
				if(numRow > 0) {
					connection.commit();
				}else {
					connection.rollback();
			}//preparedStatementオブジェクトの解放
			pstatement.close();
			}
		return numRow;
	}
}
