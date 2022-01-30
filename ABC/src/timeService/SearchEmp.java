package timeService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import timeBean.timeBean;
import timeDao.timeDao;

public class SearchEmp {
	public void execute(HttpServletRequest request)throws Exception{
		timeDao daoTest = null;
		String empId = request.getParameter("paramId");
		String empYear = request.getParameter("paramYear");
		String empMonth = request.getParameter("paramMonth");

		try {
			if(empYear != null &&  empMonth != null && empMonth != null) {
				daoTest = new timeDao();
				int id1 = Integer.parseInt(empId);
				int year1 = Integer.parseInt(empYear);
				int month1 = Integer.parseInt(empMonth);
				ArrayList<timeBean> empList = daoTest.getEmpDateByDate(id1, year1,month1);

				if(empList.isEmpty()) {
					request.setAttribute("errormessage", "その期間に登録されたデータがありません。");
				}else {
					request.setAttribute("empList", empList);
				}
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
