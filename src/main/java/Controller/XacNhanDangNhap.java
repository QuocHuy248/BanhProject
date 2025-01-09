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

@WebServlet("/xacNhanDangNhapController")
public class XacNhanDangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XacNhanDangNhap() {
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
			   String un = request.getParameter("txtun");
			   String pass = request.getParameter("txtpass");
			   
			   KhachHangBo khbo = new KhachHangBo();
				KhachHang kh = khbo.kiemTraDangNhap(un, pass);

				if (kh != null) {
			       session.setAttribute("dn", kh);
			       response.sendRedirect("banhUserController");
			       return;
			   }

			   session.setAttribute("error", "Vui lòng kiểm tra lại tên đăng nhập và mật khẩu");
			   response.sendRedirect("dangnhapController");
			   
			} catch (Exception e) {
			   HttpSession session = request.getSession();
			   e.printStackTrace();
			   session.setAttribute("error", "Đã xảy ra lỗi");
			   response.sendRedirect("dangnhapController");
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