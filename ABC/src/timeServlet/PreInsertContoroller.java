package timeServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import timeService.PreInsertEmp;

/**
 * Servlet implementation class InsertContoroller
 */
@WebServlet("/PreInsertContoroller")
public class PreInsertContoroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreInsertContoroller() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/kakunin.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String btn = request.getParameter("btn"); //押されたボタン情報
		String jsp = null;

		try {
			if(btn.equals("打刻する")) {
				//出勤ボタン押下時
				PreInsertEmp In = new PreInsertEmp();
				In.execute(request);
				jsp = "/kakunin.jsp";
			}

		}
		catch(SQLException e){
				e.printStackTrace();
				request.setAttribute("message", "データ管理に障害が発生しました。管理者にお問い合わせください。");
				jsp="/error.jsp";

		}catch(Exception e){
				e.printStackTrace();
				request.setAttribute("message", "予期せぬエラーが発生しました。管理者にお問い合わせください。");
				jsp="/error.jsp";

		}

		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher(jsp);
		rd.forward(request, response);
	}

}
