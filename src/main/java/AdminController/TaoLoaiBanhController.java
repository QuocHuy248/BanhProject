package AdminController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import LoaiModal.Loai;
import LoaiModal.LoaiBo;
import banhmodal.Banh;
import banhmodal.BanhBo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/taoLoaiBanhController")
public class TaoLoaiBanhController extends HttpServlet {
	private static final long serialVerionUID = 1L;

	public TaoLoaiBanhController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session = req.getSession();
			String dnadmin = (String) session.getAttribute("dnadmin");

			// Nếu chưa đăng nhập hoặc không phải admin thì chuyển về trang đăng nhập
			if (dnadmin == null || !dnadmin.equals("admin")) {
				resp.sendRedirect("adminDangNhapController");
				return;
			}
			RequestDispatcher rd = req.getRequestDispatcher("TrangTaoLoaiBanh.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
