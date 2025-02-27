package Controller;

import java.io.IOException;

import KhachHangModal.KhachHang;
import KhachHangModal.KhachHangBo;
import KhachHangModal.KhachHangDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dangnhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhapController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			if (session.getAttribute("dn") != null) {
				session.setAttribute("error", "Đăng nhập thành công");
				response.sendRedirect("banhUserController");
				return;
			}
			request.getRequestDispatcher("TrangDangNhap.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			HttpSession session = request.getSession();
			session.setAttribute("error", "Đã xảy ra lỗi");
			response.sendRedirect("banhUserController");
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