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

import timeService.SearchEmp;

/**
 * Servlet implementation class kakuninController
 */
@WebServlet("/kakuninController")
public class kakuninController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public kakuninController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/past.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
			String btn = request.getParameter("btn");
			String jsp = null;

			try {
				 if(btn.equals("確認する")){
					 //過去の登録情報検索時
					SearchEmp search = new SearchEmp();
					search.execute(request);
					jsp ="/list.jsp";
				}


			}catch(SQLException e){
					e.printStackTrace();
					request.setAttribute("message", "その期間に登録されたデータがありません。");
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
