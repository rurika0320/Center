package timeService;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class PreInsertEmp {
	public void execute(HttpServletRequest request)throws Exception{
		Calendar calendar =Calendar.getInstance();

		//表示用日付
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH)+1;
		int day = calendar.get(Calendar.DATE);
		String date = year +"/" + month + "/" + day;

		SimpleDateFormat sdfIn = new SimpleDateFormat("HH:mm");
		String time = sdfIn.format(calendar.getTime());
		//jsp表示のためにセッションに登録しておく
		HttpSession session = request.getSession();
		session.setAttribute("date", date);
		session.setAttribute("time", time);
	}
}
