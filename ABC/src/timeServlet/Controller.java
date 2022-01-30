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
import javax.servlet.http.HttpSession;

import timeService.loginSearch;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");
				HttpSession session = request.getSession();
				String btn = request.getParameter("btn");
				String jsp = null;

				try {
					//従業員ID検索の場合
					if(btn.equals("ログイン")) {
					loginSearch log = new loginSearch();
					log.execute(request);
					jsp = (String) session.getAttribute("jsp");
					}
					//ログアウト
					if(btn.equals("ログアウト")) {
					request.logout();
					jsp="/logout.jsp";
					}
				}catch(SQLException e){
						e.printStackTrace();
						request.setAttribute("message", "予期せぬエラーが発生しました。管理者にお問い合わせください。");
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
