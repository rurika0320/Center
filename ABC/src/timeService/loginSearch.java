package timeService;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import timeBean.timeBean;
import timeDao.timeDao;

public class loginSearch {
	public void execute(HttpServletRequest request)throws Exception{
		timeDao daoTest = null;
		String empId = request.getParameter("paramId");
		String empPass = request.getParameter("paramPass");
		HttpSession session = request.getSession();
	    session.setAttribute("id", empId);

		try {
			if(empId != null && !empId.isEmpty()
					&& empPass != null && !empPass.isEmpty()) {
				daoTest = new timeDao();
				int Id1 = Integer.parseInt(empId);
				//daoで確認
				ArrayList<timeBean> empList = daoTest.getEmpDateByLogin(Id1, empPass);

				if(empList.isEmpty()) {
					//daoで情報と照合できなかったら
					session.setAttribute("jsp", "/error.jsp");
					request.setAttribute("message", "登録情報がありません。");
				}
				else {
					session.setAttribute("jsp", "/top.jsp");
				}
			}else{
					//情報入れていない場合もエラーページ
				session.setAttribute("jsp", "/error.jsp");
			}
		}finally {
			if(daoTest != null) {
			daoTest.close();
			}
		}
	}
}
