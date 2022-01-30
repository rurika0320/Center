package timeService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import timeBean.timeBean;
import timeDao.timeDao;


public class InsertOutEmp {
	public void execute(HttpServletRequest request)throws Exception{
		timeDao daoTest = null;
		Calendar calendar =Calendar.getInstance();
		//日付情報初期設定
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DATE);
		String date = year +"/" + month + "/" + day;
		SimpleDateFormat sdfOut = new SimpleDateFormat("HH:mm");
		sdfOut.format(calendar.getTime());
		String clockOut = sdfOut.format(calendar.getTime());
		//メッセージ登録とjspの分岐用
		HttpSession session = request.getSession();

		try {
			if(clockOut != null && !clockOut.isEmpty()){
				daoTest = new timeDao();
				timeBean time = new timeBean();
				time.setDate(date);
				time.setClockOut(clockOut);
				//IDはjspから取得
				String id = request.getParameter("id");
				time.setId(Integer.parseInt(id));

				//jsp表示のために設定
				request.setAttribute("退勤時間", clockOut);

				//String Out = "Clock Out";
				//request.setAttribute("inout", Out);

				//daoで退勤時間登録

				int No = daoTest.insertOutEmpData(time);
				if(No > 0) {
					session.setAttribute("jsp", "/inout.jsp");
					session.setAttribute("message", "本日の退勤時刻を下記の通り登録しました。");
				}if(No == 0) {
					session.setAttribute("jsp", "/error.jsp");
					session.setAttribute("message", "本日の出勤記録がありません。");
				}
				//daoで実労働時間登録s
				daoTest.keisanEmpData(time);
				//daoで超過勤務時間登録
				//daoTest.overEmpDate(time);
			}else{
				request.setAttribute("message", "予期せぬエラーが発生しました。管理者にお問い合わせください。");
				}
		}finally {
			if(daoTest != null) {
				daoTest.close();
			}
		}
	}
}