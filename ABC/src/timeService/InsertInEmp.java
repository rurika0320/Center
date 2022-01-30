package timeService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import timeBean.timeBean;
import timeDao.timeDao;



public class InsertInEmp {
	public void execute(HttpServletRequest request)throws Exception{
	timeDao daoTest = null;
	Calendar calendar =Calendar.getInstance();
	//メッセージ登録用
	HttpSession session = request.getSession();


		//日付情報初期設定
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DATE);
		String date = year +"/" + month + "/" + day;

		SimpleDateFormat sdfIn = new SimpleDateFormat("HH:mm");
		sdfIn.format(calendar.getTime());
		calendar.add(Calendar.MONTH, 3);
		String clockIn = sdfIn.format(calendar.getTime());

		try {
			if(clockIn!= null&& !clockIn.isEmpty()){
				daoTest = new timeDao();
				timeBean time = new timeBean();
				time.setDate(date);
				time.setYear(year);
				time.setMonth(month);
				time.setClockIn(clockIn);
				String id = request.getParameter("id");
				time.setId(Integer.parseInt(id));

				//jsp表示のために設定
				request.setAttribute("出勤時間", clockIn);

				//String In = "Clock In";
				//request.setAttribute("inout", In);

				daoTest.insertInEmpData(time);
				session.setAttribute("message","本日の出勤時刻を下記の通り登録しました。");

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

