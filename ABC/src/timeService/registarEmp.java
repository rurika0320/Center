package timeService;

import javax.servlet.http.HttpServletRequest;

import timeBean.timeBean;
import timeDao.timeDao;

public class registarEmp {
	public void execute(HttpServletRequest request)throws Exception{
		timeDao daoTest = null;
		String id = request.getParameter("newId");
		String pass = request.getParameter("newPass");
		try {
			if(id != null && !id.isEmpty()
				&& pass!= null && !pass.isEmpty()) {
				timeBean time = new timeBean();
				time.setId(Integer.parseInt(id));
				time.setPass(pass);
				daoTest = new timeDao();
				daoTest.registarEmpData(time);

			}else{//未入力かもしくは既に登録済みの場合
				request.setAttribute("jsp", "/error.jsp");
				}
		}finally {
			if(daoTest != null) {
					daoTest.close();
			}
		}
	}
}
