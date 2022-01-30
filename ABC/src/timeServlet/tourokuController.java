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

import timeService.registarEmp;

/**
 * Servlet implementation class tourokuController
 */
@WebServlet("/tourokuController")
public class tourokuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public tourokuController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		RequestDispatcher rd = context.getRequestDispatcher("/registar.jsp");
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
			 if(btn.equals("新規登録")) {
				 //新規情報登録時
				registarEmp reg = new registarEmp();
				reg.execute(request);
				jsp ="/kanryou.jsp";
			}

		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("message","入力した情報では登録できません。規定ルールに則り再度入力してください。");
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
