package AdminController;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import nl.captcha.Captcha;

@WebServlet("/adminDangNhapController")
public class AdminDangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminDangNhapController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String un = request.getParameter("txtun");
			String pass = request.getParameter("txtpass");
			String tb = null;
			HttpSession session = request.getSession();

			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			request.setCharacterEncoding("UTF-8");
			String answer = request.getParameter("answer");

			if (session.getAttribute("dem") != null) {
				int dem = (int) session.getAttribute("dem");
				if (answer != null) {
					if (dem >= 3 && !captcha.isCorrect(answer)) {
						tb = "Mã xác nhận không đúng";
						request.setAttribute("error", tb);
						RequestDispatcher rd = request.getRequestDispatcher("DangNhapAdmin.jsp");
						rd.forward(request, response);
						return;
					}
				}
			}

			if (un != null && pass != null) {
				if (un.equals("admin") && pass.equals("admin")) {
					session.setAttribute("dnadmin", un);
					session.removeAttribute("dem");
					response.sendRedirect("banhAdminController");
					return;
				} else {
					if (session.getAttribute("dem") == null) {
						session.setAttribute("dem", 1);
					} else {
						int d = (int) session.getAttribute("dem");
						d++;
						session.setAttribute("dem", d);
					}
					tb = "Đăng nhập sai";
					request.setAttribute("error", tb);
				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("DangNhapAdmin.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}